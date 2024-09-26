package com.AirbnbClone.AirbnbClone.Service;

import com.AirbnbClone.AirbnbClone.Entity.Booking;
import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Repository.BookingRepository;
import com.AirbnbClone.AirbnbClone.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * params propertyID
     * params StartDate
     * params endDate
     * return param booking object
     */

    public Booking createBooking(Long propertyId, LocalDate starDate,LocalDate endDate){

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        Booking booking = new Booking();
        booking.setProperty(property);
        booking.setStartDate(starDate);
        booking.setEndDate(endDate);
        // save the booking

        return bookingRepository.save(booking);
    }


    // get all bookings.

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }


    // get booking by PropertyID.
    public List<Booking> getBookingByProperty(Long propertyId){
        return bookingRepository.findByPropertyId(propertyId);
    }


    public void deleteBooking(Long id) {
         bookingRepository.deleteById(id);
    }

}
