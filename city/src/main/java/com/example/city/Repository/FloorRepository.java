package com.example.city.Repository;

import com.example.city.Model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {
    Optional<Floor> findByLevelNum(int levelNum);
}
