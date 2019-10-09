package com.completedtasks.airline.util;

import com.completedtasks.airline.exceptions.FileParsingException;
import com.completedtasks.airline.exceptions.PlaneParseException;
import com.completedtasks.airline.entity.AirlineCompany;
import com.completedtasks.airline.entity.components.Engine;
import com.completedtasks.airline.entity.planes.CargoPlane;
import com.completedtasks.airline.entity.planes.PassengerPlane;
import com.completedtasks.airline.entity.planes.Plane;

import java.io.*;
import java.util.Scanner;

/**
 * A class, that carries out I/O to/from file.
 */
public class FileHandler {

    /**
     * Parses given row and returns Plane object.
     * <p>
     * Reading the row and parsing from it parameters for new plane.
     * Then constructs it and returns.
     *
     * @param row
     * @return
     * @throws PlaneParseException - if
     */
    public static Plane parsePlane(String row) throws PlaneParseException {
        String[] parameters = row.split("\\|");
        try {
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
                    throw new PlaneParseException("Unknown plane type before the first | symbol");
            }
        } catch (NumberFormatException e) {
            throw new PlaneParseException("Cannot convert String to Integer");
        }
    }

    /**
     * Writes given information about company and it's planes list to the file.
     * <p>
     * In the first row will be placed name of the company.
     * All lines below will be the result of method {@code toString} from class PassengerPlane/CargoPlane.
     *
     * @param company  AirlineCompany obj.
     * @param filePath - path to file. If it not exists, it will be created.
     * @throws IOException - if got problems with file location or access.
     * @see PassengerPlane#toString() PassengerPlane toString method.
     * @see CargoPlane#toString() CargoPlane toString method.
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

    /**
     * Reads file and creates AirlineCompany obj.
     * <p>
     * Reads first row of file and installing it as name of the company.
     * Then reads all lines below and parsing rows to Plane objects.
     *
     * @param filePath - path to the file.
     * @return AirlineCompany obj.
     * @throws FileParsingException - if FileNotFoundException, PlaneParseException, IOException, are caught.
     * In each case will be returned message of caught exceptions.
     */
    public static AirlineCompany parseFile(String filePath) throws FileParsingException {
        AirlineCompany company;
        try {
            FileReader fileInput = new FileReader(filePath);
            Scanner input = new Scanner(fileInput);
            company = new AirlineCompany(input.nextLine());
            while (input.hasNextLine()) {
                company.addPlane(FileHandler.parsePlane(input.nextLine()));
            }
            fileInput.close();
            return company;
        } catch (FileNotFoundException e) {
           throw new FileParsingException("No such file by given pass: "+filePath);
        } catch(PlaneParseException e) {
            throw new FileParsingException("An error occurred while parsing string row as Plane object. Message: "+e.getMessage());
        }catch (IOException e) {
           throw new FileParsingException("An error with Input/Output stream. Message: "+e.getMessage());
        }
    }

}
