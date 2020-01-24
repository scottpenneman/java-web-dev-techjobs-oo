package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public String toString() {
        int id = this.getId();
        String name;
        String employer;
        String location;
        String positionType;
        String coreCompetency;
        String dataNa = "Data not available";

        if (this.getName().equals("")) {
            name = dataNa;
        } else {
            name = this.getName();
        }

        if (this.getEmployer().getValue().equals("")) {
            employer = dataNa;
        } else {
            employer = this.getEmployer().getValue();
        }

        if (this.getLocation().getValue().equals("")) {
            location = dataNa;
        } else {
            location = this.getLocation().getValue();
        }

        if (this.getPositionType().getValue().equals("")) {
            positionType = dataNa;
        } else {
            positionType = this.getPositionType().getValue();
        }

        if (this.getCoreCompetency().getValue().equals("")) {
            coreCompetency = dataNa;
        } else {
            coreCompetency = this.getCoreCompetency().getValue();
        }

        if (name.equals(dataNa) && employer.equals(dataNa) && location.equals(dataNa) && positionType.equals(dataNa) && coreCompetency.equals(dataNa)) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return "\nID: " + id
                    + "\nName: " + name
                    + "\nEmployer: " + employer
                    + "\nLocation: " + location
                    + "\nPosition Type: " + positionType
                    + "\nCore Competency: " + coreCompetency
                    + "\n";
        }
    }
}
