package com.example.city.Service;

import com.example.city.GenerateSpotsRequest;
import com.example.city.Model.Floor;
import com.example.city.Model.ParkingSpot;
import com.example.city.Model.Section;
import com.example.city.Repository.FloorRepository;
import com.example.city.Repository.ParkingSpotRepository;
import com.example.city.Repository.SectionRepository;
import com.example.city.Service.Strategy.SpotGenerationStrategy;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotR;
    private final FloorRepository floorRepository;
    private final SectionService sectionService;
    private final SpotGenerationStrategy spotGenerationStrategy;

    public ParkingSpotService(ParkingSpotRepository parkingSpotR, FloorRepository floorRepository,
                              SectionService sectionService,
                              SpotGenerationStrategy spotGenerationStrategy) {
        this.parkingSpotR = parkingSpotR;
        this.floorRepository = floorRepository;
        this.sectionService = sectionService;
        this.spotGenerationStrategy = spotGenerationStrategy;
    }

    public ParkingSpot createSpot(ParkingSpot spot){
        return parkingSpotR.save(spot);
    }

    public List<ParkingSpot> getAllSpots() {
        return parkingSpotR.findAll();
    }

    @Transactional
    public void generateSpots(int floorNum, GenerateSpotsRequest request) {

        //Find the floor
        Floor floor = floorRepository.findByLevelNum(floorNum)
                .orElseThrow(() -> new RuntimeException("Floor not found"));

        //Loop through sections
        for (GenerateSpotsRequest.SectionRequest sectionReq : request.getSections()) {

            //Get or create section
            Section section = sectionService.getOrCreateSection(floor, sectionReq.getLabel());

            //Delegate spot generation to strategy
            spotGenerationStrategy.generateSpots(floor, section, sectionReq.getSpotCount());
        }
    }
}
