package com.example.city.Repository;

import com.example.city.Model.Floor;
import com.example.city.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Long> {

    Optional<Section> findByFloorAndLabel(Floor floor, String label);
}
