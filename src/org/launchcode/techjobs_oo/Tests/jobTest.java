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

        assertEquals(testJobThree.getId(), testJobThree.getId());

        assertEquals("Product tester", testJobThree.getName());

        assertEquals("ACME", testJobThree.getEmployer().getValue());
        assertTrue(testJobThree.getEmployer() instanceof Employer);

        assertEquals("Desert", testJobThree.getLocation().getValue());
        assertTrue(testJobThree.getLocation() instanceof Location);

        assertEquals("Quality control", testJobThree.getPositionType().getValue());
        assertTrue(testJobThree.getPositionType() instanceof PositionType);

        assertEquals("Persistence", testJobThree.getCoreCompetency().getValue());
        assertTrue(testJobThree.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobFive = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJobFour.getId() == testJobFive.getId());
    }

}
