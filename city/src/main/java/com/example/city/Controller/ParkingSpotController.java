package com.example.city.Controller;

import com.example.city.GenerateSpotsRequest;
import com.example.city.Model.ParkingSpot;
import com.example.city.Service.ParkingSpotService;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/{floorNum}/sections/generate-spots")
    public ResponseEntity<String> generateSpots(
            @PathVariable int floorNum,
            @RequestBody GenerateSpotsRequest request
    ) {
        ParkingSpotS.generateSpots(floorNum, request);
        return ResponseEntity.ok("Parking spots generated successfully for Floor " + floorNum);
    }

    @GetMapping
    public List<ParkingSpot> getAllSpots() {
        return ParkingSpotS.getAllSpots();
    }
}
