package com.example.city.Service.Strategy;

import com.example.city.Model.Floor;
import com.example.city.Model.Section;

public interface SpotGenerationStrategy {
    void generateSpots(Floor floor, Section section, int count);
}
