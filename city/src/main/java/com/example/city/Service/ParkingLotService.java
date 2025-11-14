package com.example.city.Service;

import com.example.city.Model.ParkingLot;
import com.example.city.Repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    private final ParkingLotRepository parkingLotR;

    public ParkingLotService(ParkingLotRepository parkingLotR){
        this.parkingLotR = parkingLotR;
    }

    public ParkingLot createLot(ParkingLot lot) {
        return parkingLotR.save(lot);
    }

    public List<ParkingLot> getAllLots(){
        return parkingLotR.findAll();
    }

    public ParkingLot getLotById(Long id) {
        return parkingLotR.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking Lot not found"));
    }

}
