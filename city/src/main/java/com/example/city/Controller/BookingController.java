package com.example.city.Controller;

import com.example.city.Model.Booking;
import com.example.city.Model.Payment;
import com.example.city.Service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    // Standard Constructor
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<Booking> reserveSpot(@RequestBody BookingRequestDTO request) {
        Booking newBooking = bookingService.bookSpot(request);
        return ResponseEntity.ok(newBooking);
    }

    @PostMapping("/{bookingId}/checkout")
    public ResponseEntity<Payment> checkoutSpot(@PathVariable Long bookingId) {
        Payment receipt = bookingService.checkout(bookingId);
        return ResponseEntity.ok(receipt);
    }
}