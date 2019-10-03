package com.completedtasks.airline.data.planemodels;

public abstract class Plane {

    private String modelName;

    public Plane(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

}
