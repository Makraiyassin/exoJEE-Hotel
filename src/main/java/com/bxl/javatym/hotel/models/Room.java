package com.bxl.javatym.hotel.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;


    public boolean isAvailable(LocalDate checkinDate, LocalDate checkoutDate) {
        // The check-out date cannot be earlier than or equals to the check-in date.
        if ( checkoutDate.compareTo(checkinDate) <= 0 ){
            throw new IllegalArgumentException("The check-out date cannot be earlier than or equals to the check-in date.");
        }

        // The check-in date cannot be set in the past.
        if (checkinDate.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("The check-in date cannot be set in the past.");
        }

        if (!available){
            return false;
        }

        for (Booking booking : bookings) {
            // If the booking is already over we skip it.
            if (booking.getEndDate().compareTo(LocalDate.now()) < 0){
                continue;
            }

            // If the checkin happens before the end date of the previously booked booking AND the checkout happens after the beginning of that previously booked booking
            if(checkinDate.compareTo(booking.getEndDate()) < 0 && checkoutDate.compareTo(booking.getBeginDate()) > 0){
                return false;
            }
        }

        return true;
    }


    public Room(boolean available, TypeEnum type, int capacity, double price, List<Booking> bookings) {
        this.available = available;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.bookings = bookings;
    }
}

