package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class jobTest {

    Job testJobOne;
    Job testJobTwo;

    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, testJobTwo.getId() - testJobOne.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // Testing Id
        assertEquals(testJobThree.getId(), testJobThree.getId());
        // Testing name
        assertEquals("Product tester", testJobThree.getName());
        // Testing Employer
        assertEquals("ACME", testJobThree.getEmployer().getValue());
        assertTrue(testJobThree.getEmployer() instanceof Employer);
        // Testing Location
        assertEquals("Desert", testJobThree.getLocation().getValue());
        assertTrue(testJobThree.getLocation() instanceof Location);
        // Testing PositionType
        assertEquals("Quality control", testJobThree.getPositionType().getValue());
        assertTrue(testJobThree.getPositionType() instanceof PositionType);
        //Testing CoreCompetency
        assertEquals("Persistence", testJobThree.getCoreCompetency().getValue());
        assertTrue(testJobThree.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobFive = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJobFour.getId() == testJobFive.getId());
    }

    // Declared a Job object and variable needed for testing toString()
    Job testJobSix = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    String testJobString = testJobSix.toString();

    @Test
    public void testToStringEnclosedByBlankLines() {
        int testJobStringLength = testJobString.length();

        // Testing that the first two characters returned are "\n"
        assertEquals("\n", testJobString.substring(0, 1));
        // Testing that the last two characters returned are "\n"
        assertEquals("\n", testJobString.substring(testJobStringLength - 1, testJobStringLength));
    }

    @Test
    public void testToStringContainsLabelsAndValues() {
        assertTrue(testJobString.contains("\nID: " + testJobSix.getId()));
        assertTrue(testJobString.contains("\nEmployer: " + testJobSix.getEmployer().getValue()));
        assertTrue(testJobString.contains("\nLocation: " + testJobSix.getLocation().getValue()));
        assertTrue(testJobString.contains("\nPosition Type: " + testJobSix.getPositionType().getValue()));
        assertTrue(testJobString.contains("\nCore Competency: " + testJobSix.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringOutputsDataNotAvailable() {
        Job testJobSeven = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        assertTrue(testJobSeven.toString().contains("Employer: Data not available"));
        assertTrue(testJobSeven.toString().contains("Core Competency: Data not available"));
    }

    @Test
    public void testToStringOutputsJobDoesntExist() {
        Job testJobEight = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.", testJobEight.toString());
    }

}
