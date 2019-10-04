package com.completedtasks.airline.data.planes;


import com.completedtasks.airline.data.components.Engine;

public class PassengerPlane extends Plane {

    private int passengerCapacity;
    private int cargoCapacity;
    private Engine engineModel;

    public PassengerPlane(int serialNumber, String modelName, int passengerCapacity, Engine engineModel) {
        super(modelName, serialNumber);
        this.passengerCapacity = passengerCapacity;
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

    public int getCargoCapacity(){
        return cargoCapacity;
    }
    public void setCarryingCapacity(int cargoCapacity){
        this.cargoCapacity=cargoCapacity;
    }

}
