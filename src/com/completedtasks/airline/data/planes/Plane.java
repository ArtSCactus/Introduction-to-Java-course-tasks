package com.completedtasks.airline.data.planes;

public abstract class Plane {

    private final int SERIAL_NUMBER;
    private String modelName;

    public Plane(String modelName, int serialNumber) {
        this.modelName = modelName;
        this.SERIAL_NUMBER=serialNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public int getSerialNumber(){
        return SERIAL_NUMBER;
    }

    public abstract int getPassengerCapacity();

    public abstract int getCargoCapacity();

    public abstract double getFuelConsumption();
}
