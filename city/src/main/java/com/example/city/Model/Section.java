package com.example.city.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    private Floor floor;
    private List<ParkingSpot> spots;
}
