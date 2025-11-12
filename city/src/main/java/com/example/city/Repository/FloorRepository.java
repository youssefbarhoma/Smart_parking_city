package com.example.city.Repository;

import com.example.city.Model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FloorRepository extends JpaRepository<Floor, Long> {
    Optional<Floor> findByLevelNumber(int levelNumber);
}
