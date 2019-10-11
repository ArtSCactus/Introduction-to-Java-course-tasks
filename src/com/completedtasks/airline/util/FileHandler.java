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
     * @return airline company object
     * @throws PlaneParseException - if
     */
    public static Plane parseAndConstructPlane(String row) throws PlaneParseException {//поменять название
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
        //checking file on existance. If it not exists, it will be created.
        if (!textFile.exists()) {
            try {
                textFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Writing company to the file
            try (FileWriter fileOutput = new FileWriter(textFile)){
               // FileWriter fileOutput = new FileWriter(textFile);
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
     * Modified version of {@code parseFileAndConstructCompany} method. If skipBrokenLineMode is true,
     * the lines, where was met {@code PlaneParseException} will be skipped and information about it will be printed to
     * log by logger. Otherwise, the method will work as default variant.
     *
     * @param filePath - path to the file.
     * @return AirlineCompany obj.
     * @see PlaneParseException for more information about PlaneParseException
     * @throws FileParsingException - if FileNotFoundException, PlaneParseException, IOException, are caught.
     * In each case will be returned message of caught exceptions.
     */
    public static AirlineCompany parseFileAndConstructCompany(String filePath, boolean skipBrokenLineMode) throws FileParsingException {// переимновать
        AirlineCompany company;
        try (FileReader fileInput = new FileReader(filePath)){
            Scanner input = new Scanner(fileInput);
            company = new AirlineCompany(input.nextLine());
            while (input.hasNextLine()) {
                try{
                company.addPlane(FileHandler.parseAndConstructPlane(input.nextLine()));
            } catch(PlaneParseException e) {
                    if (skipBrokenLineMode) {
                        //logger.info will be here
                    } else {
                        throw new FileParsingException("An error occurred while parsing string row as Plane object. Message: " + e.getMessage());
                    }
            }
            }
            fileInput.close();
            return company;
        } catch (FileNotFoundException e) {
            throw new FileParsingException("No such file by given pass: " + filePath);
        } catch (IOException e) {
           throw new FileParsingException("An error with Input/Output stream. Message: "+e.getMessage());
        }
    }
    /**
     * Reads file and creates AirlineCompany obj.
     * <p>
     * Reads first row of file and installing it as name of the company.
     * Then reads all lines below and parsing rows to Plane objects.
     * This is a default realization of method{@code parseFileAndConstructCompany()}.
     * If in the process of file parsing and object constructing will be met any exception, the method will be stopped
     * and will be thrown FileParsingException with message, that describes the situation.
     *
     * @param filePath - path to the file.
     * @return AirlineCompany obj.
     * @throws FileParsingException - if FileNotFoundException, PlaneParseException, IOException, are caught.
     * In each case will be returned message of caught exceptions.
     */
    public static AirlineCompany parseFileAndConstructCompany(String filePath) throws FileParsingException {// переимновать
        AirlineCompany company;
        try (FileReader fileInput = new FileReader(filePath)){
            // FileReader fileInput = new FileReader(filePath);
            Scanner input = new Scanner(fileInput);
            company = new AirlineCompany(input.nextLine());
            while (input.hasNextLine()) {
                try{
                    company.addPlane(FileHandler.parseAndConstructPlane(input.nextLine()));
                } catch(PlaneParseException e) {
                        throw new FileParsingException("An error occurred while parsing string row as Plane object. Message: " + e.getMessage());
                    }
                }
            fileInput.close();
            return company;
        } catch (FileNotFoundException e) {
            throw new FileParsingException("No such file by given pass: " + filePath);
        } catch (IOException e) {
            throw new FileParsingException("An error with Input/Output stream. Message: "+e.getMessage());
        }
    }
}
