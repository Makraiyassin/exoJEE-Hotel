package com.bxl.javatym.hotel.servlet;

import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomsServlet", value = "/")
public class RoomsServlet extends HttpServlet {
    private final RoomService roomService = RoomService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> roomList = roomService.getAll();
        request.setAttribute("roomList", roomList);
        request.getRequestDispatcher("/acceuil.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
