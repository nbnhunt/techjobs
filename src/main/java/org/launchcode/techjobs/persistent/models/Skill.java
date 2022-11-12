package org.launchcode.techjobs.persistent.models;

/*  In the model class Skill, add a named description, with public accessor methods.
    ?? Some hiring managers like to have more information available about the nature of a given programming language or framework.
    As with Employer, give this class the @Entity annotation
    and be sure it contains a no-arg constructor.
*/

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    // 15.2 Validation Annotations
    @NotBlank(message = "Description is required")
    @Size(min = 1, max = 100, message = "Descriptions are between 1 and 100 characters")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // no arg-constructor
    public Skill() {

    }
}