package com.completedtasks.airline.util;

import com.completedtasks.airline.entity.AirlineCompany;
import com.completedtasks.airline.entity.components.Engine;
import com.completedtasks.airline.entity.planes.CargoPlane;
import com.completedtasks.airline.entity.planes.PassengerPlane;
import com.completedtasks.airline.entity.planes.Plane;

import java.io.*;
import java.util.Scanner;

/**A class, that carries out I/O to/from file.
 *
 */
public class FileHandler {

    /**Parses given row and returns Plane object.
     *
     * Reading the row and parsing from it parameters for new plane.
     * Then constructs it and returns.
     *
     * @param row
     * @return
     */
    public static Plane parsePlane(String row) {
        String[] parameters = row.split("\\|");
        switch (parameters[0]) {
            case ("Passenger"):
                int serialNumber = Integer.parseInt(parameters[1]);
                String modelName = parameters[2];
                int passengerCapacity = Integer.parseInt(parameters[3]);
                int cargoCapacity = Integer.parseInt(parameters[4]);
                int crew = Integer.parseInt((parameters[5]));
                Engine engine = Engine.valueOf(parameters[6]);
                return new PassengerPlane(serialNumber, modelName, crew, cargoCapacity, passengerCapacity, engine);

            case ("Cargo"):
                serialNumber = Integer.parseInt(parameters[1]);
                modelName = parameters[2];
                passengerCapacity = Integer.parseInt(parameters[3]);
                cargoCapacity = Integer.parseInt(parameters[4]);
                crew = Integer.parseInt((parameters[5]));
                engine = Engine.valueOf(parameters[6]);
                return new CargoPlane(serialNumber, modelName, crew, cargoCapacity, passengerCapacity, engine);

            default:
                //here will be custom Exception
        }
        return null;
    }

    /**
     * Constructs and returns plane.
     * <p>
     * Plane factory. Constructs and Returns plane by given parameters.
     * If (int) plane type would be less than 1 and bigger than 2 will be returned null.
     *
     * @param planeType         1 - for PassengerPlane object, 2 - for CargoPlane object
     * @param serialNumber      - (int) plane serial number
     * @param modelName         - (String) model name
     * @param crew              - amount of crew members
     * @param cargoCapacity     - total capacity for cargo
     * @param passengerCapacity - total capacity for passengers
     * @param engineModel       - Engine(enum class) object
     * @return CargoPlane/PassengerPlane object
     */
    public static Plane constructPlane(int planeType, int serialNumber, String modelName, int crew, int cargoCapacity,
                                       int passengerCapacity, Engine engineModel) {
        switch (planeType) {
            case (1):
                return new PassengerPlane(serialNumber, modelName,
                        crew, cargoCapacity, passengerCapacity, engineModel);
            case (2):
                return new CargoPlane(serialNumber, modelName,
                        crew, cargoCapacity, passengerCapacity, engineModel);
            default:
                return null;
        }
    }

    /**Writes given information about company and it's planes list to the file.
     *
     * In the first row will be placed name of the company.
     * All lines below will be the result of method {@code toString} from class PassengerPlane/CargoPlane.
     *
     * @see PassengerPlane#toString() PassengerPlane toString method.
     * @see CargoPlane#toString() CargoPlane toString method.
     * @param company AirlineCompany obj.
     * @param filePath - path to file. If it not exists, it will be created.
     */
    public static void writeCompany(AirlineCompany company, String filePath) {
        File textFile = new File(filePath);
        if (!textFile.exists()) {
            try {
                textFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileWriter fileOutput = new FileWriter(textFile);
                fileOutput.write(company.getName() + "\n");
                for (Plane plane : company.getPlanesList()) {
                    fileOutput.write(plane.toString() + "\n");
                }
                fileOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**Reads file and creates AirlineCompany obj.
     *
     * Reads first row of file and installing it as name of the company.
     * Then reads all lines below and parsing from it planes.
     *
     * @param filePath - path to the file.
     * @return AirlineCompany obj.
     */
    public static AirlineCompany parseFile(String filePath){
        AirlineCompany company;
        try{
            FileReader fileInput = new FileReader(filePath);
            Scanner input = new Scanner(fileInput);
            company = new AirlineCompany(input.nextLine());
            while (input.hasNextLine()) {
                    company.addPlane(FileHandler.parsePlane(input.nextLine()));
            }
            fileInput.close();
            return company;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AirlineCompany("Unnamed");
    }

}
