package com.example.city.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//A7 , B12 , ...
@Entity
@Table(name = "parking_spot")
public class ParkingSpot {

    @Id
    @Column(name = "parking_spot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "spotNumber")
    private int spotNumber;

    @Column(name = "occupied")
    private boolean occupied;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private Section section;


    public long getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Section getSection() {
        return section;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getSpotCode() {
        return section.getLabel() + spotNumber;
    }
}
