package org.launchcode.techjobs.persistent.models;

// fields inherited from AbstractEntity
// Employer should have a string field for location
// Add the field for location with validation that ensures it is not empty
// and has a reasonable length
// add public accessor methods to Employer.
// For the purposes of this application, an employer can only have one location.

// Make sure the class has the @Entity annotation,
// as well as the no-arg constructor required for Hibernate to create an object.

// add a private property jobs of type List<Job> and initialize it to an empty ArrayList
// Use the @OneToMany and @JoinColumn annotations on the jobs list
// Recall that this annotation needs a name parameter.
// What should its value be... ? there is a name parameter in Job?
// when you're making a one to many relationship the name of the join is the onwer or one: employer, not name, since you just commented that out

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

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
