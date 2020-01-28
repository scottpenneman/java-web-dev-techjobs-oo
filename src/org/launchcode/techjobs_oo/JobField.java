package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {

    //    Employer, CoreCompetency, Location, and PositionType all share these fields:
    private int id;
    private static int nextId = 1;
    private String value;

    //    They all share two of the same constructors:
    //    1:
    public JobField() {
        id = nextId;
        nextId++;
    }

    //    2:
    public JobField(String value) {
        this();
        this.value = value;
    }

//  They share the equals and hashCode method:
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

//  They share these getters and setters:
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //    The toString method is identical in the classes
    public String toString() { return value; }

}
