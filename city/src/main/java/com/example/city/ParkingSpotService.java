package com.example.city;

import com.example.city.Model.ParkingSpot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotR;
    
    public ParkingSpotService(ParkingSpotRepository parkingSpotR){
        this.parkingSpotR = parkingSpotR;
    }

    public ParkingSpot createSpot(ParkingSpot spot){
        return parkingSpotR.save(spot);
    }

    public List<ParkingSpot> getAllSpots() {
        return parkingSpotR.findAll();
    }
}
