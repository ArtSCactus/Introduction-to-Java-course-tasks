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


public class ControllerTest {
    private Controller control;
    private AirlineCompany sortedPlanes;

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
        sortedPlanes = new AirlineCompany("Test");
        sortedPlanes.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        sortedPlanes.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedPlanes.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
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
        Assert.assertEquals(control.getPlane("C-130 HERCULES"), control.getPlaneByFuelConsumption(0.49));
    }

    @Test
    public void sortPlanesList() {
        control.sortPlanesList();
        Assert.assertTrue(isCollectionsEquals(sortedPlanes.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_CARGO_CAPACITY() {
        sortedPlanes = new AirlineCompany("Test");
        sortedPlanes.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedPlanes.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        sortedPlanes.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        control.sortPlanesList(CompareType.BY_CARGO_CAPACITY);
        Assert.assertTrue(isCollectionsEquals(sortedPlanes.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_PASSENGER_CAPACITY() {
        sortedPlanes = new AirlineCompany("Test");
        sortedPlanes.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        sortedPlanes.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedPlanes.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        control.sortPlanesList(CompareType.BY_PASSENGER_CAPACITY);
        Assert.assertTrue(isCollectionsEquals(sortedPlanes.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_MODEL_NAME() {
        sortedPlanes = new AirlineCompany("Test");
        sortedPlanes.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedPlanes.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        sortedPlanes.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        control.sortPlanesList(CompareType.BY_MODEL_NAME);
        Assert.assertTrue(isCollectionsEquals(sortedPlanes.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void sortPlanesList_BY_SERIAL_NUMBER_AND_MODEL_NAME() {
        sortedPlanes = new AirlineCompany("Test");
        sortedPlanes.addPlane(Plane.constructPlane(1, 2, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedPlanes.addPlane(Plane.constructPlane(2, 1, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        sortedPlanes.addPlane(Plane.constructPlane(1, 3, "A380", 10, 40, 300, Engine.PW_JT9D));
        control.sortPlanesList(CompareType.BY_SERIAL_NUM_AND_MODEL);
        Assert.assertTrue(isCollectionsEquals(sortedPlanes.getPlanesList(), control.getPlanesList()));
    }

    @Test
    public void writeAndParseCompany() {
        File file = new File("src/com/completedtasks/airline/data/Test.txt");
        FileHandler.writeCompany(sortedPlanes, file.getPath());
        AirlineCompany testParsedCompany = null;
        try {
            testParsedCompany = FileHandler.parseFile(file.getPath());
        } catch (FileParsingException e) {
            e.printStackTrace();
        }
        file.delete();
        Assert.assertEquals(testParsedCompany, sortedPlanes);
    }

    @Test
    public void parsePlaneExceptionTest_WRONG_PLANE_TYPE_MESSAGE() {
        try {
            FileHandler.parsePlane("null|1|C-130 HERCULES|50|50|4|GE_GE90");
        } catch (PlaneParseException e) {
            Assert.assertEquals("Unknown plane type before the first | symbol", e.getCustomMessage());
        }
    }

    @Test
    public void parsePlaneExceptionTest_STRING_TO_INT_MESSAGE() {
        try {
            FileHandler.parsePlane("Cargo|1|C-130 HERCULES|abc|50|4|GE_GE90");
        } catch (PlaneParseException e) {
            Assert.assertEquals("Cannot convert String to Integer", e.getCustomMessage());
        }
    }

    @Test(expected = PlaneParseException.class)
    public void parsePlaneExceptionTest_WRONG_PLANE_TYPE() throws PlaneParseException {
        FileHandler.parsePlane("null|1|C-130 HERCULES|50|50|4|GE_GE90");
    }

    @Test(expected = PlaneParseException.class)
    public void parsePlaneExceptionTest_STRING_TO_INT() throws PlaneParseException {
        FileHandler.parsePlane("Cargo|1|C-130 HERCULES|abc|50|4|GE_GE90");
    }

    @Test(expected = FileParsingException.class)
    public void fileParsingExceptionTest_FILE_NOT_FOUND() throws FileParsingException {
        FileHandler.parseFile("src/com/completedtasks/airline/data/Test1.txt");
    }

    @Test
    public void fileParsingExceptionTest_FILE_NOT_FOUND_MESSAGE() {
        String filePath="src/com/completedtasks/airline/data/Test1.txt";
        try {
            FileHandler.parseFile(filePath);
        }catch(FileParsingException e){
            Assert.assertEquals("No such file by given pass: "+filePath, e.getCustomMessage());
        }
    }
}