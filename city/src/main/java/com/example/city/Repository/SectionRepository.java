package com.example.city.Repository;

import com.example.city.Model.Floor;
import com.example.city.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    Optional<Section> findByFloorAndLabel(Floor floor, String label);
}
