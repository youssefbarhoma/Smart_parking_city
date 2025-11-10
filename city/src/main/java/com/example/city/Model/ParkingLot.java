package com.example.city.Model;

import jakarta.persistence.*;

import java.util.List;

//parking mall of egypt
@Entity
@Table(name="parkingLot")
public class ParkingLot {

    @Id
    @Column(name="parking_lot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Floor> floors;

    public long getId() {
        return id;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }
}
