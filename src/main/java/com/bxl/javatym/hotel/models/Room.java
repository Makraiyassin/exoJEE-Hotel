package com.bxl.javatym.hotel.models;

import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
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
    private String type;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "price", columnDefinition = "DECIMAL(7,2)")
    private double price;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;
}
