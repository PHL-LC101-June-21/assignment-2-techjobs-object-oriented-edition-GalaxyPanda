package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {



    @Test
    public void testSettingJobId(){
         Job job1 = new Job();
         Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job;
        job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobStr = job.getName() + job.getEmployer() + job.getLocation() + job.getPositionType() + job.getCoreCompetency();


        assertTrue(job.getEmployer() != null);
        assertTrue(job.getLocation() != null);
        assertTrue(job.getPositionType() != null);
        assertTrue(job.getCoreCompetency() != null);
        assertTrue(job.getName() != null);

        assertEquals("ACME" , job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue() );
        assertEquals("Quality control" ,  job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency() .getValue());
        assertEquals("Product tester", job.getName());


    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(Objects.equals(job1, job2));
    }

    @Test
    public void  testToStringStartsAndEndsWithNewLine(){

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toString = job.toString();
        String output = "\n"  +
                "ID:" + " " + job.getId() + '\n' +
                "Name:" + " " + job.getName() + '\n' +
                "Employer:" + " " + job.getEmployer() + '\n' +
                "Location:" + " " + job.getLocation() + '\n' +
                "Position Type:" + " " + job.getPositionType() + '\n' +
                "Core Competency:" + " " + job.getCoreCompetency() +"\n";


        assertEquals(toString.charAt(0), output.charAt(0));
        assertEquals(toString.charAt(toString.length() - 1), output.charAt(toString.length() - 1));



    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    String output = "\n"  +
            "ID:" + " " +job.getId() + '\n' +
            "Name:" + " " + job.getName() + '\n' +
            "Employer:" + " " + job.getEmployer() + '\n' +
            "Location:" + " " + job.getLocation() + '\n' +
            "Position Type:" + " " + job.getPositionType() + '\n' +
            "Core Competency:" + " " + job.getCoreCompetency() +"\n";
    assertEquals(output, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField (){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toString = job.toString();
        String emptyName = job.getName().equals("") ? " Data not available": job.getName();
        String emptyEmployer = job.getEmployer().getValue().equals("") ? "Data not available": job.getEmployer().toString();
        String emptyLocation = job.getLocation().getValue().equals("") ? "Data not available": job.getLocation().toString();
        String emptyPosition = job.getPositionType().getValue().equals("") ? "Data not available": job.getPositionType().toString();
        String emptyCore = job.getCoreCompetency().getValue().equals("") ? "Data not available": job.getCoreCompetency().toString();
        String output = "\n"  +
                "ID:" + " " + job.getId() + '\n' +
                "Name:" + " " + emptyName + '\n' +
                "Employer:" + " " + emptyEmployer + '\n' +
                "Location:" + " " + emptyLocation + '\n' +
                "Position Type:" + " " + emptyPosition + '\n' +
                "Core Competency:" + " " + emptyCore + '\n';




        assertEquals(output.toString(), job.toString());
    }

}
