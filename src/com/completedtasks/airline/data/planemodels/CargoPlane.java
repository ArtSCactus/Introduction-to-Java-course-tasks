package com.completedtasks.airline.data.planemodels;


import com.completedtasks.airline.data.components.Engine;

public class CargoPlane extends Plane {

    private int carryingCapacity;
    private Engine engineModel;

    public CargoPlane(String modelName, int carryingCapacity, Engine engineModel) {
        super(modelName);
        this.carryingCapacity = carryingCapacity;
        this.engineModel=engineModel;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

}
