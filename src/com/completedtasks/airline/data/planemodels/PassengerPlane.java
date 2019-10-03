package com.completedtasks.airline.data.planemodels;


import com.completedtasks.airline.data.components.Engine;

public class PassengerPlane extends Plane {

    private int passengerCapacity;
    private Engine engineModel;

    public PassengerPlane(String modelName, int passengerCapacity, Engine engineModel) {
        super(modelName);
        this.passengerCapacity = passengerCapacity;
        this.engineModel=engineModel;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
