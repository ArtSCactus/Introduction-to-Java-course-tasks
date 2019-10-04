package com.completedtasks.airline.data.components;

public enum Engine {

    PW_JT8D("Pratt & Whitney ", "JT8D", 0.744),
    PW_JT9D("Pratt & Whitney ", "JT9D", 0.646),
    GE_GE90("General Electric", "GE90",0.49 );
    private String model;
    private String manufacturer;
    private double fuelConsumption;

    Engine(String manufacturer, String model, double fuelConsumption){
        this.model=model;
        this.manufacturer=manufacturer;
        this.fuelConsumption=fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
