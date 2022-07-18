package com.bxl.javatym.hotel.models;

import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "r_get_all", query = "SELECT r FROM Room r"),
        @NamedQuery(name = "r_remove_one", query = "DELETE FROM Room r WHERE r.id = :id")
})
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int id;

    @Column(name = "available")
    private boolean available = true;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "price", columnDefinition = "DECIMAL(7,2)")
    private double price;

    @Column(name = "img")
    private String img;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;


    public boolean availableOrNot (LocalDate date) {
        long daysBetween = ChronoUnit.DAYS.between(date, date);
        return available;

    }
    public Room(boolean available, TypeEnum type, int capacity, double price, List<Booking> bookings, String img) {
        this.available = available;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.bookings = bookings;
        this.img = img;
    }
}

