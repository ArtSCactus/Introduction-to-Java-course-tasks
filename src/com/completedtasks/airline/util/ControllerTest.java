package com.completedtasks.airline.util;

import com.completedtasks.airline.entity.AirlineCompany;
import com.completedtasks.airline.entity.components.Engine;
import com.completedtasks.airline.entity.planes.Plane;
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
        control = new Controller("Test", true);
        //plane type, serial number, model name, crew, cargo capacity, passenger capacity, engine
        control.addPlane(1, 000003, "A380", 10, 40, 300, Engine.PW_JT9D);
        control.addPlane(1, 000002, "A340", 6, 25, 280, Engine.PW_JT8D);
        control.addPlane(2, 000001, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90);
        sortedPlanes = new AirlineCompany("Test");
        sortedPlanes.addPlane(FileHandler.constructPlane(2, 000001, "C-130 HERCULES", 4, 50, 50, Engine.GE_GE90));
        sortedPlanes.addPlane(FileHandler.constructPlane(1, 000002, "A340", 6, 25, 280, Engine.PW_JT8D));
        sortedPlanes.addPlane(FileHandler.constructPlane(1, 000003, "A380", 10, 40, 300, Engine.PW_JT9D));
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
    public void writeAndParseCompany() {
        File file = new File("src/com/completedtasks/airline/data/Test.txt");
        FileHandler.writeCompany(sortedPlanes, file.getPath());
        AirlineCompany testParsedCompany = FileHandler.parseFile(file.getPath());
        file.delete();
        Assert.assertEquals(testParsedCompany, sortedPlanes);
    }

}