package com.completedtasks.airline.data.planes;


import com.completedtasks.airline.data.components.Engine;

public class CargoPlane extends Plane {

    private int passengerCapacity;
    private int cargoCapacity;
    private int crew;

    private Engine engineModel;

    public CargoPlane(int serialNumber, String modelName, int crew,
                      int passengerCapacity, int cargoCapacity, Engine engineModel) {

        super(modelName, serialNumber);
        this.crew=crew;
        this.passengerCapacity=passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.engineModel = engineModel;
    }

    @Override
    public double getFuelConsumption() {
        return engineModel.getFuelConsumption();
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }
}
