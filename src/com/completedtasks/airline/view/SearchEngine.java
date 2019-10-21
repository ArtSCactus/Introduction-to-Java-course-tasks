package com.completedtasks.airline.view;

import com.completedtasks.airline.entity.planes.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
//TODO decide, maybe just do all searches in one method, but with Enum type parameters?

public class SearchEngine {
    private static final Logger LOGGER = LogManager.getLogger(SearchEngine.class);
    /**
     * Print all planes in airline company to console.
     * <p>
     * Prints information about each plane in airline company to console.
     */
    public static void printPlanes(List<Plane> planes) {
        if(planes.size()==0){
            System.out.println("Airline company does not have any plane.");
            return;
        }
        for (Plane plane : planes) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "Plane: " + plane.getModelName() +
                    "\nSerial number: " + plane.getSerialNumber() +
                    "\nModel name: " + plane.getModelName() +
                    "\nFuel consumption: " + plane.getFuelConsumption() +
                    "\nCrew: " + plane.getCrew() +
                    "\nPassenger capacity: " + plane.getPassengerCapacity()
                    + "\nCargo capacity: " + plane.getCargoCapacity()+
                    "\n~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    /**Prints information about given plane to console.
     *
     * @param plane plane, that will be printed to console.
     */
    public static void printPlane(Plane plane) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Plane: " + plane.getModelName() +
                "\nSerial number: " + plane.getSerialNumber() +
                "\nModel name: " + plane.getModelName() +
                "\nFuel consumption: " + plane.getFuelConsumption() +
                "\nCrew: " + plane.getCrew() +
                "\nPassenger capacity: " + plane.getPassengerCapacity()
                + "\nCargo capacity: " + plane.getCargoCapacity()+
                "\n~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    /**Prints all planes with given model name.
     *
     * @param modelName (String) type row with model name
     */
    public static void printPlanesByModel(List<Plane> planes, String modelName) {
        for (Plane plane : planes) {
            if (plane.getModelName().equalsIgnoreCase(modelName)) {
                printPlane(plane);
            }
        }
    }

    /**Prints max console planes by serial number.
     *
     * Prints max console planes with serial number, that placed between min and max values.
     * If min value will be bigger than max value, values of min and max will be swapped.
     *
     * @param planes {@code List<Plane>}
     * @param min minimal value of serial number
     * @param max maximal value of serial number
     */
    public static void printPlanesBySerialNumber(List<Plane> planes,int min, int max){
        if (min<0 || max<0){
            LOGGER.debug("Min: "+min+" Max: "+max);
            LOGGER.error("Min or max (or both) came as <0 ");
            throw new IllegalArgumentException("Minimal or maximal serial number cannot be less than 0");
        }
        if (min>max){
            min=min+max;
            max=min-max;
            min=min-max;
            LOGGER.warn("Min and max variables came as min>max. Variables has been swapped.");
            LOGGER.debug("min>max. min: "+min+" max: "+max);
        }
        boolean noMatches=true;
        for (Plane plane : planes){
            if (plane.getSerialNumber()>=min & plane.getSerialNumber()<=max){
                printPlane(plane);
                noMatches=false;
            }
        }
        if (noMatches){
            System.out.println("No match found");
        }
    }

    /**Prints to console plane with given fuel consumption.
     *
     * @param planes {@code List<Plane>}
     * @param fuelConsumption (double) value of fuel consumption
     */
    public static void printPlanesByFuelConsumption(List<Plane> planes, double fuelConsumption){
        if (fuelConsumption<0){
            LOGGER.debug("Fuel consumption is <0: "+fuelConsumption);
            LOGGER.error("Fuel consumption is less than 0.");
            throw new IllegalArgumentException("Fuel consumption cannot be less than 0");
        }
        boolean noMatches=true;
        for (Plane plane : planes){
            if (plane.getFuelConsumption()==fuelConsumption){
                printPlane(plane);
                noMatches=false;
            }
        }
        if (noMatches){
            System.out.println("No match found");
        }
    }

    /**Prints to console plane with given fuel consumption.
     *
     * @param planes {@code List<Plane>}
     * @param min (double) minimal value of fuel consumption
     * @param max (double) maximal value of fuel consumption
     * */
    public static void printPlanesByFuelConsumption(List<Plane> planes, double min, double max){
        if (min<0 || max<0){
            LOGGER.debug("Min: "+min+" Max: "+max);
            LOGGER.error("Min or max (or both) came as <0.");
            throw new IllegalArgumentException("Minimal or maximal fuel consumption cannot be less than 0");
        }
        if (min>max){
            min=min+max;
            max=min-max;
            min=min-max;
        }
        boolean noMatches=true;
        for (Plane plane : planes){
            if (plane.getFuelConsumption()>=min & plane.getFuelConsumption()<=max){
                printPlane(plane);
                noMatches=false;
            }
        }
        if (noMatches){
            System.out.println("No match found");
        }
    }
    /**Prints to console plane with given fuel consumption.
     *
     * @param planes {@code List<Plane>}
     * @param min (double) minimal value of cargo capacity
     * @param max (double) maximal value of cargo capacity
     * */
    public static void printPlanesByCargoCapacity(List<Plane> planes, int min, int max){
        if (min<0 || max<0){
            LOGGER.debug("Min: "+min+" Max: "+max);
            LOGGER.error("Min or max (or both) came as <0 ");
            throw new IllegalArgumentException("Minimal or maximal cargo capacity cannot be less than 0");
        }
        if (min>max){
            min=min+max;
            max=min-max;
            min=min-max;
        }
        boolean noMatches=true;
        for (Plane plane : planes){
            if (plane.getCargoCapacity()>=min & plane.getCargoCapacity()<=max){
                printPlane(plane);
                noMatches=false;
            }
        }
        if (noMatches){
            System.out.println("No match found");
        }
    }
}
