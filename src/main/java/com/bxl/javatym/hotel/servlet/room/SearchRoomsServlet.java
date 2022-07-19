package com.bxl.javatym.hotel.servlet.room;

import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.models.TypeEnum;
import com.bxl.javatym.hotel.service.RoomService;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "SearchRoomsServlet", value = "/room/search")
public class SearchRoomsServlet extends HttpServlet {
    private final RoomService roomService = RoomService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int capacity = Integer.parseInt(request.getParameter("capacity"));

        TypeEnum type = TypeEnum.valueOf(request.getParameter("type").replaceAll("\\s+","").toUpperCase());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
        LocalDate checkin = LocalDate.parse(request.getParameter("checkin"), formatter);
        LocalDate checkout = LocalDate.parse(request.getParameter("checkout"), formatter);
        int priceMax = Integer.parseInt(request.getParameter("maxprice"));

        List<Room> rooms = roomService.search(capacity, type, checkin, checkout, priceMax);

        request.setAttribute("roomList", rooms);
        request.getRequestDispatcher("/roomsSearchResult.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
