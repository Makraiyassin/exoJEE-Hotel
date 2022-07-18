package com.bxl.javatym.hotel.servlet.room;

import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetOneRoomServlet", value = "/room/getOne")
public class GetOneRoomServlet extends HttpServlet {
    private final RoomService roomService = RoomService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Room room = roomService.getOne(id);
        request.setAttribute("room", room);
        request.getRequestDispatcher("/room.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
