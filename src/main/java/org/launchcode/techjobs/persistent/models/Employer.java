package org.launchcode.techjobs.persistent.models;

// fields inherited from AbstractEntity
// Employer should have a string field for location
// Add the field for location with validation that ensures it is not empty
// and has a reasonable length
// add public accessor methods to Employer.
// For the purposes of this application, an employer can only have one location.

// Make sure the class has the @Entity annotation,
// as well as the no-arg constructor required for Hibernate to create an object.

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Please enter a location")
    @Size(min = 1, max = 100, message = "Location requirements are between 1 and 100 characters")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
