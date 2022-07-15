package com.bxl.javatym.hotel.service;

import com.bxl.javatym.hotel.listeners.EMFWebListener;
import com.bxl.javatym.hotel.models.Room;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private static RoomService instance;
    public static RoomService getInstance(){
        System.out.println("recup de l'instance du service");
        return instance == null ? instance = new RoomService() : instance;
    }
    private RoomService() {}
    private final EntityManager manager = EMFWebListener.createEntityManager();
    private final List<Room> roomList = new ArrayList<>();

    public List<Room> getAll(){
        return manager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
    }

    public Room getOne(int id){
        return roomList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow( () -> new EntityNotFoundException("room non trouver = "+id) );
    }

    public long insert(Room toInsert){
        roomList.add(toInsert);
        return toInsert.getId();
    }


}
