package com.example.city.Service.Strategy;

import com.example.city.Factory.ParkingSpotFactory;
import com.example.city.Model.Floor;
import com.example.city.Model.ParkingSpot;
import com.example.city.Model.Section;
import com.example.city.Repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSpotGenerationStrategy implements SpotGenerationStrategy {

    private final ParkingSpotRepository spotRepository;

    public DefaultSpotGenerationStrategy(ParkingSpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public void generateSpots(Floor floor, Section section, int count) {
        List<ParkingSpot> spotsToSave = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            spotsToSave.add(ParkingSpotFactory.createSpot(i, section));
        }
        spotRepository.saveAll(spotsToSave);
    }
}