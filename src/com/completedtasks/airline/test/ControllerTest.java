package com.completedtasks.airline.test;

import com.completedtasks.airline.entity.comparators.CompareType;
import com.completedtasks.airline.exceptions.FileParsingException;
import com.completedtasks.airline.exceptions.PlaneParseException;
import com.completedtasks.airline.entity.AirlineCompany;
import com.completedtasks.airline.entity.components.Engine;
import com.completedtasks.airline.entity.planes.Plane;
import com.completedtasks.airline.util.Controller;
import com.completedtasks.airline.util.FileHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

//TODO: add tests for new features

public class ControllerTest {
    private Controller control;
    private AirlineCompany sortedBySerialNumber;
    private AirlineCompany sortedByCargoCapacity;
    private AirlineCompany sortedByPassengerCapacity;
    private AirlineCompany sortedByModelName;
    private AirlineCompany sortedBySerialNumberAndModelName;

    private boolean isCollectionsEquals(List<Plane> list1, List<Plane> list2) {
        for (int index = 0; index < list1.size() & index < list2.size(); index++) {
            if (!list1.get(index).equals(list2.get(index))) {
                return false;
            }
        }
        return true;
    }

    @Before
    public void initializeTest() {
        control = new Controller("Test", true); // true - not from file
        //plane type, serial number, model name, crew, cargo capacity, passenger capacity, engine
        control.addPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D);
        control.addPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90);
        control.addPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D);
       //sorted by serial number
        sortedBySerialNumber = new AirlineCompany("Test");
        sortedBySerialNumber.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        sortedBySerialNumber.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedBySerialNumber.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        //sorted by cargo capacity
        sortedByCargoCapacity = new AirlineCompany("Test");
        sortedByCargoCapacity.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedByCargoCapacity.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        sortedByCargoCapacity.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        //sorted by passenger capacity
        sortedByPassengerCapacity = new AirlineCompany("Test");
        sortedByPassengerCapacity.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        sortedByPassengerCapacity.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedByPassengerCapacity.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        //sorted by model name
        sortedByModelName = new AirlineCompany("Test");
        sortedByModelName.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedByModelName.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        sortedByModelName.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        //sorted by serial number and model name
        sortedBySerialNumberAndModelName = new AirlineCompany("Test");
        sortedBySerialNumberAndModelName.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedBySerialNumberAndModelName.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        sortedBySerialNumberAndModelName.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));

    }

    @Test
    public void createCompany() {
        control.createCompany("New test company");
        Assert.assertEquals("New test company", control.getCompanyName());
    }

    @Test
    public void getCompanyName() {
        Assert.assertEquals("Test", control.getCompanyName());
    }

    @Test
    public void totalPassengerCapacity() {
        Assert.assertEquals(115, control.totalCargoCapacity());
    }

    @Test
    public void totalCargoCapacity() {
        Assert.assertEquals(630, control.totalPassengerCapacity());
    }

    @Test
    public void getPlaneByFuelConsumption() {
        Assert.assertEquals(control.getPlane("C-130 HERCULES"),
                control.getPlaneByFuelConsumption(control.getPlanesList(),0.49));
    }

    @Test(expected = NoSuchElementException.class)
    public void getPlaneByFuelConsumption_EXCEPTION() {
        Assert.assertEquals(control.getPlane("C-130 HERCULES"),
                control.getPlaneByFuelConsumption(control.getPlanesList(),0.9999));
    }

    @Test
    public void sortPlanesList_DEFAULT() {
        control.sortPlanesList();
        Assert.assertTrue(isCollectionsEquals(sortedBySerialNumber.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_CARGO_CAPACITY() {
        control.sortPlanesList(CompareType.BY_CARGO_CAPACITY);
        Assert.assertTrue(isCollectionsEquals(sortedByCargoCapacity.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_PASSENGER_CAPACITY() {
        control.sortPlanesList(CompareType.BY_PASSENGER_CAPACITY);
        Assert.assertTrue(isCollectionsEquals(sortedByPassengerCapacity.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_MODEL_NAME() {
        control.sortPlanesList(CompareType.BY_MODEL_NAME);
        Assert.assertTrue(isCollectionsEquals(sortedByModelName.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_SERIAL_NUMBER_AND_MODEL_NAME() {
        control.sortPlanesList(CompareType.BY_SERIAL_NUM_AND_MODEL);
        Assert.assertTrue(isCollectionsEquals(sortedBySerialNumberAndModelName.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void writeAndParseCompany() {
        File file = new File("src/com/completedtasks/airline/data/Test.txt");
        FileHandler.writeCompany(sortedBySerialNumber, file.getPath());
        AirlineCompany testParsedCompany=null;
        try {
            testParsedCompany = FileHandler.parseFileAndConstructCompany(file.getPath());
        } catch (FileParsingException e) {
            System.out.println("Do what must be done. Do not hesitate, show no mercy.");
            //e.printStackTrace();
        }
        file.delete();
        Assert.assertEquals(testParsedCompany, sortedBySerialNumber);
    }

    @Test
    /**File parsing shell not be stopped.
     *
     */
    public void isFileParsingBeenStopped(){
        File file = new File("src/com/completedtasks/airline/test/testfiles/stop test.txt");
        AirlineCompany testParsedCompany=null;
        sortedBySerialNumber.deletePlane(0);
        try {
            testParsedCompany = FileHandler.parseFileAndConstructCompany(file.getPath(),true);
        } catch (FileParsingException e) {
            System.out.println("Do what must be done. Do not hesitate, show no mercy.");
        }
        Assert.assertEquals(testParsedCompany, sortedBySerialNumber);
    }

    @Test
    public void parsePlaneExceptionTest_WRONG_PLANE_TYPE_MESSAGE() {
        try {
            FileHandler.parseAndConstructPlane("null|1|C-130 HERCULES|50|50|4|GE_GE90");
        } catch (PlaneParseException e) {
            Assert.assertEquals("Unknown plane type before the first | symbol", e.getCustomMessage());
        }
    }

    @Test
    public void parsePlaneExceptionTest_STRING_TO_INT_MESSAGE() {
        try {
            FileHandler.parseAndConstructPlane("Cargo|1|C-130 HERCULES|abc|50|4|GE_GE90");
        } catch (PlaneParseException e) {
            Assert.assertEquals("Cannot convert String to Integer", e.getCustomMessage());
        }
    }

    @Test(expected = PlaneParseException.class)
    public void parsePlaneExceptionTest_WRONG_PLANE_TYPE() throws PlaneParseException {
        FileHandler.parseAndConstructPlane("null|1|C-130 HERCULES|50|50|4|GE_GE90");
    }

    @Test(expected = PlaneParseException.class)
    public void parsePlaneExceptionTest_STRING_TO_INT() throws PlaneParseException {
        FileHandler.parseAndConstructPlane("Cargo|1|C-130 HERCULES|abc|50|4|GE_GE90");
    }

    @Test(expected = FileParsingException.class)
    public void fileParsingExceptionTest_FILE_NOT_FOUND() throws FileParsingException {
        FileHandler.parseFileAndConstructCompany("src/com/completedtasks/airline/data/Test1.txt");
    }

    @Test
    public void fileParsingExceptionTest_FILE_NOT_FOUND_MESSAGE() {
        String filePath="src/com/completedtasks/airline/data/Test1.txt";
        try {
            FileHandler.parseFileAndConstructCompany(filePath);
        }catch(FileParsingException e){
            Assert.assertEquals("No such file by given pass: "+filePath, e.getCustomMessage());
        }
    }
}