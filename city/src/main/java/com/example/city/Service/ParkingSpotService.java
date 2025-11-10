package com.example.city.Service;

import com.example.city.Model.ParkingSpot;
import com.example.city.Repository.ParkingSpotRepository;
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

    public void generateSpots(GenerateSpotsRequest request) {
        request.getSections().forEach(sectionConfig -> {

            for (int i = 1; i <= sectionConfig.getSpotCount(); i++) {
                ParkingSpot spot = new ParkingSpot();
                spot.setSection(sectionConfig.getSectionName());
                spot.setSpotNumber(i);
                spot.setAvailable(true);

                parkingSpotRepository.save(spot);
            }
        });
    }
}
