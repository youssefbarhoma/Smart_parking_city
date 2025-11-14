package com.example.city.Controller;

import com.example.city.Model.ParkingLot;
import com.example.city.Service.ParkingLotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lots")
public class ParkingLotController {

    private final ParkingLotService parkingLotS;

    public ParkingLotController(ParkingLotService parkingLotS) {
        this.parkingLotS = parkingLotS;
    }

    @PostMapping
    public ResponseEntity<ParkingLot> createLot(@RequestBody ParkingLot lot) {
        ParkingLot saved = parkingLotS.createLot(lot);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<ParkingLot>> getAllLots() {
        return ResponseEntity.ok(parkingLotS.getAllLots());
    }
}
