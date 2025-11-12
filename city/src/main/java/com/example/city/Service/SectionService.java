package com.example.city.Service;

import com.example.city.Factory.SectionFactory;
import com.example.city.Model.Floor;
import com.example.city.Model.Section;
import com.example.city.Repository.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section getOrCreateSection(Floor floor, String label) {
        return sectionRepository.findByFloorAndLabel(floor, label)
                .orElseGet(() -> sectionRepository.save(SectionFactory.createSection(floor, label)));
    }
}
