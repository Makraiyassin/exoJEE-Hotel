package com.bxl.javatym.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "get_all", query = "SELECT r FROM Room r"),
        @NamedQuery(name = "remove_one", query = "DELETE FROM Room r WHERE r.id = :id")
})
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int id;
    @Column(name = "available")
    private boolean available;
    @Column(name = "type")
    private String type;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "price", columnDefinition = "DECIMAL(7,2)")
    private double price;
}
