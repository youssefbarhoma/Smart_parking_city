package com.example.city.Factory;

import com.example.city.Model.ParkingSpot;
import com.example.city.Model.Section;

public class ParkingSpotFactory {

    public static ParkingSpot createSpot(int number, Section section) {
        ParkingSpot spot = new ParkingSpot();
        spot.setSpotNumber(number);
        spot.setOccupied(false);
        spot.setSection(section);
        return spot;
    }
}