package com.example.city.Service;

import com.example.city.Controller.BookingRequestDTO;
import com.example.city.Model.*;
import com.example.city.Repository.BookingRepository;
import com.example.city.Repository.ParkingSpotRepository;
import com.example.city.Repository.PaymentRepository;
import com.example.city.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final PaymentRepository paymentRepository; // Added PaymentRepository

    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          ParkingSpotRepository parkingSpotRepository,
                          PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Booking bookSpot(BookingRequestDTO request) {
        //Find the User
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        //Find the Parking Spot
        ParkingSpot spot = parkingSpotRepository.findById(request.getSpotId())
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));

        //Check if the spot is already taken
        if (spot.isOccupied()) {
            throw new RuntimeException("Spot is already occupied!");
        }

        //Change the spot to occupied
        spot.setOccupied(true);
        parkingSpotRepository.save(spot);

        //Create the Booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSpot(spot);
        booking.setStartTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.ACTIVE);

        //Save and return the booking
        return bookingRepository.save(booking);
    }
    @Transactional
    public Payment checkout(Long bookingId) {
        // 1. Find the active booking
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.ACTIVE) {
            throw new RuntimeException("This booking is already completed or cancelled!");
        }

        // 2. Stop the clock
        booking.setEndTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.COMPLETED);

        // 3. Free the parking spot!
        ParkingSpot spot = booking.getSpot();
        spot.setOccupied(false);
        parkingSpotRepository.save(spot);

        // 4. Calculate Time and Cost (Assuming it costs 20 per hour)
        Duration duration = Duration.between(booking.getStartTime(), booking.getEndTime());
        long hours = duration.toHours();
        if (hours == 0) { hours = 1; } // Minimum charge is 1 hour

        BigDecimal totalCost = BigDecimal.valueOf(hours * 20);

        // 5. Generate the Payment Receipt
        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(totalCost);
        payment.setStatus(PaymentStatus.SUCCESS); // Assuming they pay at the gate/app
        payment.setPaymentMethod("CREDIT_CARD");

        // 6. Save both changes to the database
        bookingRepository.save(booking);
        return paymentRepository.save(payment);
    }
}