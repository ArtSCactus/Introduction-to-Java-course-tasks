package com.completedtasks.airline.entity.planes;


public abstract class Plane {
    /**Serial number for current plane.
     *
     */
    private final int SERIAL_NUMBER;
    /**Amount of crew crew members for current plane.
     *
     */
    private int crew;
    /**Name of this plane model.
     *
     */
    private String modelName;

    /**Constructs the base of plane.
     *
     * @param modelName - name of model
     * @param serialNumber - serial number
     * @param crew - amount of crew members
     */
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
