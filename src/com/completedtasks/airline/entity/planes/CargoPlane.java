package com.completedtasks.airline.entity.planes;


import com.completedtasks.airline.entity.components.Engine;

import java.util.Objects;

public class CargoPlane extends Plane {

    private int passengerCapacity;
    private int cargoCapacity;
    private Engine engineModel;

    public CargoPlane(int serialNumber, String modelName, int crew, int cargoCapacity,
                      int passengerCapacity, Engine engineModel) {

        super(modelName, serialNumber, crew);
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
        this.engineModel = engineModel;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoPlane)) return false;
        CargoPlane that = (CargoPlane) o;
        return getPassengerCapacity() == that.getPassengerCapacity() &&
                getCargoCapacity() == that.getCargoCapacity() &&
                engineModel == that.engineModel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassengerCapacity(), getCargoCapacity(), engineModel);
    }

    @Override
    public String toString() {
        return "Cargo|"+
                getSerialNumber() + "|"
                + getModelName() + "|"
                + passengerCapacity + "|"
                + cargoCapacity + "|"
                + getCrew() + "|"
                + engineModel.getCodeName();
    }
}
