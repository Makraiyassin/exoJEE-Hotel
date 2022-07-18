package com.bxl.javatym.hotel.service;

import com.bxl.javatym.hotel.listeners.EMFWebListener;
import com.bxl.javatym.hotel.models.Booking;
import com.bxl.javatym.hotel.models.Booking;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.awt.print.Book;
import java.util.List;

public class BookingService {
    private static BookingService instance;
    public static BookingService getInstance(){
        System.out.println("recup de l'instance du service");
        return instance == null ? instance = new BookingService() : instance;
    }
    private BookingService() {}
    private final EntityManager manager = EMFWebListener.createEntityManager();
    public List<Booking> getAll(){
        return manager.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
    }

    public Booking getOne(int id){
        return manager.find(Booking.class, id);
    }
    public void insert(Booking toInsert){
        manager.getTransaction().begin();
        manager.persist(toInsert);
        manager.getTransaction().commit();
    }
    public void update(Booking booking) {
        if( booking == null ) throw new IllegalArgumentException("Booking cannot be null");
        if( !existsById(booking.getId()) ) throw new EntityNotFoundException("Entity not found");
        manager.getTransaction().begin();
        manager.merge(booking);
        manager.getTransaction().commit();
    }
    public void delette(int id) {
        manager.getTransaction().begin();
        Booking bookingToDelette = getOne(id);
        manager.remove(bookingToDelette);
        manager.getTransaction().commit();
    }
    public boolean existsById(int id){
        return getOne(id) != null;
    }

}