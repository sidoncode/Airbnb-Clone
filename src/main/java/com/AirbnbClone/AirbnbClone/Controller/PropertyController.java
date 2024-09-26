package com.AirbnbClone.AirbnbClone.Controller;


import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;


    /**
     * Endpoints:
     *
     * createProperty:
     * Handles POST requests to create a new property.
     * Expects a Property object in the request body and a userId as a request parameter.
     * getPropertyById:
     * Handles GET requests to retrieve a property by ID.
     * Returns a 404 response if the property is not found.
     * getAllProperties:
     * Handles GET requests to retrieve all properties
     *
     * @param property
     * @param UserId
     * @return
     */

    // create a post Mapping

    @PostMapping
    public Property createProperty(@RequestBody Property property,
                                   @RequestParam Long UserId){
        return propertyService.createProperty(property,UserId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(property);
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

}
