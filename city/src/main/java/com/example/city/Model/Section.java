package com.example.city.Model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

//A , B , C , ...
@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    @JsonIgnore
    private Floor floor;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ParkingSpot> spots;

    public long getId() {
        return id;
    }

    public Floor getFloor() {
        return floor;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public String getLabel() {
        return label;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }
}
