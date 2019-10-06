package com.completedtasks.airline.util;

import com.completedtasks.airline.entity.AirlineCompany;
import com.completedtasks.airline.entity.comparators.CompareType;
import com.completedtasks.airline.entity.components.Engine;
import com.completedtasks.airline.entity.planes.Plane;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.NoSuchElementException;

public class Controller {
    /**
     * Main AirlineCompany (planes list) storage.
     */
    private AirlineCompany company;
    /**
     * Object to initialize planes list from .txt file.
     */
    private FileReader fileInput;
    /**
     * Object to save current planes list to the file.
     */
    private FileWriter fileOutput;

    Controller(String filePath) {
       FileHandler.parseFile(filePath);
    }

    Controller (String companyName, boolean notFromFile){
        company= new AirlineCompany(companyName);
    }

    /**
     * Constructs empty airline company controller.
     * <p>
     * Name of the company will be installed as "Unnamed company".
     * List of planes will be installed as empty, but not null.
     */
    Controller() {
        company = new AirlineCompany("Unnamed company");
    }

    /**
     * Constructs airline company controller, that based on already exists object.
     * <p>
     * Initializes controller with already built AirlineCompany object.
     *
     * @param company - already exists object or object, that was built before
     */
    Controller(AirlineCompany company) {
        this.company = company;
    }

    /**
     * Constructs custom airline company controller.
     * <p>
     * Constructs airline company object with custom name and custom planes list realization.
     *
     * @param companyName     - String type row with company name
     * @param listRealization - custom realization of List interface or already built list of planes.
     */
    Controller(String companyName, List<Plane> listRealization) {
        company = new AirlineCompany(companyName, listRealization);
    }

    /**
     * Returns name of airline company.
     *
     * @return {@code company.getName()}
     */
    public String getCompanyName() {
        return company.getName();
    }

    public List<Plane> getPlanesList() {
        return company.getPlanesList();
    }

    public Plane getPlane(int index) {
        return company.getPlane(index);
    }

    public Plane getPlane(String modelName) {
        if (modelName == null) {
            throw new NullPointerException("Model name cannot be null");
        }
        return company.getPlane(modelName);
    }

    /**
     * Appropriation new empty object of AirlineCompany.
     *
     * @param name - name of new company
     */
    public void createCompany(String name) {
        if (name == null) {
            throw new NullPointerException("Company name cannot be null.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        company = new AirlineCompany(name);
    }

    /**
     * Counts total passenger capacity for current company.
     *
     * @return (int) total passenger capacity
     */
    public int totalPassengerCapacity() {
        int totalCapacity = 0;
        for (int index = 0; index < company.amountOfPlanes(); index++) {
            totalCapacity += company.getPlane(index).getPassengerCapacity();
        }
        return totalCapacity;
    }

    /**
     * Counts total cargo capacity for current company.
     *
     * @return (int) total cargo capacity
     */
    public int totalCargoCapacity() {
        int totalCapacity = 0;
        for (int index = 0; index < company.amountOfPlanes(); index++) {
            totalCapacity += company.getPlane(index).getCargoCapacity();
        }
        return totalCapacity;
    }

    public void addPlane(Plane plane) {
        company.addPlane(plane);
    }

    public void addPlane(int planeType, int serialNumber, String modelName, int crew, int cargoCapacity,
                         int passengerCapacity, Engine engineModel) {

        company.addPlane(FileHandler.constructPlane(planeType, serialNumber, modelName, crew, cargoCapacity,
                passengerCapacity, engineModel));
    }

    /**
     * Returns Plane object by given fuel consumption.
     * <p>
     * Returns first met plane with given fuel consumption.
     *
     * @param fuelConsumption - (double) value,
     * @return Plane type object from list of planes
     * @throws NoSuchElementException if plane with such parameters wasn't found
     * @see AirlineCompany more information about list of planes
     * @see com.completedtasks.airline.entity.components.Engine more information about fuel consumption
     */
    public Plane getPlaneByFuelConsumption(double fuelConsumption) throws NoSuchElementException {
        for (int index = 0; index < company.amountOfPlanes(); index++) {
            if (company.getPlane(index).getFuelConsumption() == fuelConsumption) {
                return company.getPlane(index);
            }
        }
        throw new NoSuchElementException("No such plane found");
    }

    /**
     * Sorts planes list.
     * <p>
     * Sorts planes list, that placed in AirlineCompany with given mode.
     *
     * @param mode - CompareType object.
     * @see CompareType for more information about available mods.
     */
    public void sortPlanesList(CompareType mode) {
        company.sortPlanes(mode);
    }

    /**
     * Sorts planes list with default mode.
     * <p>
     * Sorts planes list by serial number.
     *
     * @see CompareType#BY_SERIAL_NUMBER for more information about BY_SERIAL_NUMBER mode
     */
    public void sortPlanesList() {
        company.sortPlanes(CompareType.BY_SERIAL_NUMBER);
    }


}
