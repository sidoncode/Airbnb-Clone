package com.AirbnbClone.AirbnbClone.Controller;

import com.AirbnbClone.AirbnbClone.Entity.Booking;
import com.AirbnbClone.AirbnbClone.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    /**
     *
     *
     * createBooking:
     * Takes the property ID, start date, and end date as parameters.
     * Fetches the Property from the repository.
     * Creates a new Booking object, sets its properties, and saves it in the repository.
     * getBookingById:
     * Retrieves a booking by its ID from the repository.
     * getAllBookings:
     * Returns a list of all bookings.
     * getBookingsByProperty:
     * Retrieves all bookings associated with a specific property.
     * deleteBooking:
     * Deletes a booking by its ID after verifying its existence.
     *
     * @param propertyId
     * @param startDate
     * @param endDate
     * @return
     */

    // posting a new booking in - association with a propertyID
    @PostMapping
    public Booking createBooking(@RequestParam Long propertyId,
                                 @RequestParam LocalDate startDate,
                                 @RequestParam LocalDate endDate){

        return bookingService.createBooking(propertyId,startDate,endDate);
    }


    @GetMapping("/{id}")
    public Booking getBookingbyId(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }


    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/property/{propertyId}")
    public List<Booking> getBookingByProperty(@PathVariable Long propertyId){
        return bookingService.getBookingsByProperty(propertyId);

    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }


}
