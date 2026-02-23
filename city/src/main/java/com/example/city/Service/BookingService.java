package com.example.city.Service;

import com.example.city.Controller.BookingRequestDTO;
import com.example.city.Model.Booking;
import com.example.city.Model.BookingStatus;
import com.example.city.Model.ParkingSpot;
import com.example.city.Model.User;
import com.example.city.Repository.BookingRepository;
import com.example.city.Repository.ParkingSpotRepository;
import com.example.city.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ParkingSpotRepository parkingSpotRepository;

    // Standard Constructor for Dependency Injection
    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          ParkingSpotRepository parkingSpotRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public Booking bookSpot(BookingRequestDTO request) {
        // 1. Find the User
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Find the Parking Spot
        ParkingSpot spot = parkingSpotRepository.findById(request.getSpotId())
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));

        // 3. Check if the spot is already taken
        if (spot.isOccupied()) {
            throw new RuntimeException("Spot is already occupied!");
        }

        // 4. Change the spot to occupied and save it
        spot.setOccupied(true);
        parkingSpotRepository.save(spot);

        // 5. Create the Booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSpot(spot);
        booking.setStartTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.ACTIVE);

        // 6. Save and return the booking
        return bookingRepository.save(booking);
    }
}