package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Update the class definition of Job to extend AbstractEntity
// Remove the redundant fields from Job.
// Replace the type of the field employer to be of type Employer
// You will also need to refactor the affected constructor and getter and setter that use this field
// Add the @ManyToOne annotation on the field employer

@Entity
public class Job extends AbstractEntity {

/*    @Id
    @GeneratedValue
    private int id;

    private String name;*/

    @ManyToOne
    private Employer employer;
    @ManyToMany//(mappedBy = "jobs")
    private List<Skill> skills = new ArrayList<>();

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Job() {
    }

    public Job(Employer employer, List someSkills) {
        super();
        this.employer = employer;
        this.skills = someSkills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
// Getters and setters.

/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
*/

 /*   public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
*/

}
