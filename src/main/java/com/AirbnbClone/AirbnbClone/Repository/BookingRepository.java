package com.AirbnbClone.AirbnbClone.Repository;

import com.AirbnbClone.AirbnbClone.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByPropertyId(Long propertyId);

}
