package com.bxl.javatym.hotel.servlet.booking;

import com.bxl.javatym.hotel.models.Booking;
import com.bxl.javatym.hotel.models.Customer;
import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.service.BookingService;
import com.bxl.javatym.hotel.service.CustomerService;
import com.bxl.javatym.hotel.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "bookingServlet", value = "/booking/insert")
public class InsertBookingServlet extends HttpServlet {
    private final BookingService bookingService = BookingService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = CustomerService.getInstance().getOne(Integer.parseInt(request.getParameter("customerId")));
        Room room  = RoomService.getInstance().getOne(Integer.parseInt(request.getParameter("roomId")));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dateBeginString = request.getParameter("dateBegin");
        String dateEndString = request.getParameter("dateEnd");

        LocalDate dateBegin = LocalDate.parse(dateBeginString, formatter);
        LocalDate dateEnd = LocalDate.parse(dateEndString, formatter);


        Booking toInsert = new Booking(customer,room,dateBegin,dateEnd);
        System.out.println(toInsert);
        bookingService.insert(toInsert);
        response.sendRedirect(request.getContextPath());
    }
}
