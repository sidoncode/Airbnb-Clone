package com.AirbnbClone.AirbnbClone.Service;

import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Entity.User;
import com.AirbnbClone.AirbnbClone.Repository.PropertyRepository;
import com.AirbnbClone.AirbnbClone.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    public Property createProperty(Property property, Long userId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        property.setOwner(owner);
        return propertyRepository.save(property);
    }

    // get property by user Id


    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }
}
