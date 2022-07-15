package com.bxl.javatym.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "booking")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "get_all", query = "SELECT b FROM Booking b"),
        @NamedQuery(name = "remove_one", query = "DELETE FROM Booking b WHERE b.id = :id")
})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int id;

    @Column(name = "booking_id")
    private Customer customer;
    @Column(name = "booking_id")
    private Room room;

}
