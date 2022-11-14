package org.launchcode.techjobs.persistent.models;


import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


// give AbstractEntity the @MappedSuperclass annotation.
// add the @Id and @GeneratedValue annotations to the field id.
// Add appropriate validation annotations
// user cannot leave this field blank when creating an object
// there are reasonable limitations on the size of the name string.
// Some employer names might be longer than 50 characters

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    private int id;

    // 15.2
    @NotBlank(message = "Please enter a name")
    @Size(min = 1, max = 100, message = "Name requirements are between 1 and 100 characters")
    private String name;

    public int getId() {
        return id;
    }

/*    public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}