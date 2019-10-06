package com.completedtasks.airline.entity.planes;

import com.completedtasks.airline.entity.components.Engine;

public abstract class Plane {

    private final int SERIAL_NUMBER;

    private int crew;

    private String modelName;


    public Plane(String modelName, int serialNumber, int crew) {
        this.modelName = modelName;
        this.SERIAL_NUMBER = serialNumber;
        this.crew = crew;
    }

    public String getModelName() {
        return modelName;
    }

    public int getSerialNumber() {
        return SERIAL_NUMBER;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }


    public abstract int getPassengerCapacity();

    public abstract int getCargoCapacity();

    public abstract double getFuelConsumption();

    public abstract String toString();

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}
