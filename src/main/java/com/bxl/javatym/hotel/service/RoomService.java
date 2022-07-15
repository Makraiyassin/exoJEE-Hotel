package com.bxl.javatym.hotel.service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private static RoomService instance;
    public static RoomService getInstance(){
        System.out.println("recup de l'instance du service");
        return instance == null ? instance = new RoomService() : instance;
    }
    private RoomService() {}

    private final List<Room> roomList = new ArrayList<>();

}
