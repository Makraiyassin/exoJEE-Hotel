package com.bxl.javatym.hotel.service;

import com.bxl.javatym.hotel.listeners.EMFWebListener;
import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.models.TypeEnum;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private static RoomService instance;

    public static RoomService getInstance(){
        System.out.println("recup de l'instance du service");
        return instance == null ? instance = new RoomService() : instance;
    }

    private RoomService() {

    }

    private final EntityManager manager = EMFWebListener.createEntityManager();


    public List<Room> getAll(){
        return manager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
    }

    public Room getOne(int id){
        return manager.find(Room.class, id);
    }

    public void insert(Room toInsert){
        manager.getTransaction().begin();
        manager.persist(toInsert);
        manager.getTransaction().commit();
    }

    public void update(Room room) {
        if( room == null ) throw new IllegalArgumentException("Room cannot be null");
        if( !existsById(room.getId()) ) throw new EntityNotFoundException("Entity not found");
        manager.getTransaction().begin();
        manager.merge(room);
        manager.getTransaction().commit();
    }

    public List<Room> search (int capacity, TypeEnum type, LocalDateTime checkin, LocalDateTime checkout, int price ) {
        List<Room> listroom = new ArrayList<>();
        manager.getTransaction().begin();

        manager.createQuery("SELECT booking FROM Booking booking INNER JOIN Room room WHERE room.capacity = ?1 AND room.type = ?2 AND booking.beginDate = ?3 AND booking.endDate = ?4 AND room.price = ?5" );

        manager.getTransaction().commit();

        return listroom;
    }

    public void delette(int id) {
        manager.getTransaction().begin();
        Room roomToDelette = getOne(id);
        manager.remove(roomToDelette);
        manager.getTransaction().commit();
    }

    public boolean existsById(int id){
        return getOne(id) != null;
    }

}
