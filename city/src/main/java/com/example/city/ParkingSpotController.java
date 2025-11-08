package com.example.city;

import com.example.city.Model.ParkingSpot;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spots")
public class ParkingSpotController {
    private final ParkingSpotService ParkingSpotS;

    public ParkingSpotController(ParkingSpotService parkingSpotS) {
        this.ParkingSpotS = parkingSpotS;
    }

    @PostMapping
    public ParkingSpot createSpot(@RequestBody ParkingSpot spot) {
        return ParkingSpotS.createSpot(spot);
    }

    @GetMapping("/spots")
    public List<ParkingSpot> getAllSpots() {
        return ParkingSpotS.getAllSpots();
    }
}
