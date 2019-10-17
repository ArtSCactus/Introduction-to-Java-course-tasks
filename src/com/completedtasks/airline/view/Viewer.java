package com.completedtasks.airline.view;

import com.completedtasks.airline.entity.components.Engine;
import com.completedtasks.airline.entity.planes.Plane;
import com.completedtasks.airline.util.Controller;

import java.util.List;
import java.util.Scanner;

/**User interface
 * Realized through console.
 */
public class Viewer {
    //TODO Omg, write already this documentation and finish viewer
    private Controller controller;

    /**
     * Main menu on entrance to application.
     */
    public void mainMenu() {
        System.out.println("Hello, welcome to our airline company." +
                "\nPlease, select command:" +
                "\n1-Create company." +
                "\n2-Load company from txt file");
        int choice = inputInt();
        switch (choice) {
            case (1):
                createCompany();
                break;
            default:
                System.out.println("No such command");
        }
    }

    /**
     * Initializes airline company through console.
     * <p>
     * Asks user to input company name and then calls method {@code createCompany()} from controller.
     *
     * @see Controller#createCompany(String) more information about createCompany()
     */
    private void createCompany() {
        System.out.print("Please, choose the company name: ");
        String companyName = inputString();
        System.out.println("Company " + companyName + " has been successfully created.");
        controller.createCompany(companyName);
    }

    /**
     * Module, that carries out entering plane from console.
     * <p>
     * Contains console interface.
     * Reads from console and validates every field of Plane object.
     * After successful reading from console adds new plane to current airline company.
     *
     * @see Viewer#inputIntWithValidation(int, int) more information about {@code inputIntWithValidation(int, int)}
     * @see Viewer#inputIntWithValidation(int, boolean) more information about {@code inputIntWithValidation(key boolean)}
     * @see Viewer#inputInt() more information about {@code inputInt()}
     * @see Viewer#inputEngine() more information about {@code inputEngine()}
     */
    private void inputPlane() {
        System.out.print("Please, choose plane type:" +
                "\n1-Cargo plane" +
                "\n2-Passenger plane" +
                "\n==>");
        int planeTypeCode = inputIntWithValidation(1, 2); //1- minimal value, 2 - maximal value, includes 1 and 2
        switch (planeTypeCode) {
            //Passenger plane construction
            case (1):
                System.out.print("Input serial number more, than 0:\n==>");
                int serialNumber = inputIntWithValidation(1, false); //false fo more than mode
                System.out.print("\nInput model name:\n==>");
                String modelName = inputString();
                System.out.print("\nInput amount of crew members more than 0:\n==>");
                int crew = inputIntWithValidation(1, false); //false for more than mode
                System.out.print("\nInput cargo capacity more than 0: \n==>");
                int cargoCapacity = inputIntWithValidation(1, false);//false for more than mode
                System.out.print("\nInput passenger capacity more than 0:\n==>");
                int passengerCapacity = inputIntWithValidation(1, false);//false for more than mode
                Engine engine = inputEngine();
                controller.addPlane(Plane.constructPlane(planeTypeCode, serialNumber, modelName,
                        crew, cargoCapacity, passengerCapacity, engine));
                break;
            //Cargo plane construction
            case (2):
                System.out.print("Input serial number more, than 0:\n==>");
                serialNumber = inputIntWithValidation(1, false); //false fo more than mode
                System.out.print("\nInput model name:\n==>");
                modelName = inputString();
                System.out.print("\nInput amount of crew members more than 0:\n==>");
                crew = inputIntWithValidation(1, false); //false for more than mode
                System.out.print("\nInput cargo capacity more than 0: \n==>");
                cargoCapacity = inputIntWithValidation(1, false);//false for more than mode
                System.out.print("\nInput passenger capacity more than 0:\n==>");
                passengerCapacity = inputIntWithValidation(1, false);//false for more than mode
                engine = inputEngine();
                controller.addPlane(Plane.constructPlane(planeTypeCode, serialNumber, modelName,
                        crew, cargoCapacity, passengerCapacity, engine));
                break;
        }
    }

    /**
     * Main menu after airline company initialization.
     * Contains console interface.
     */
    private void inCompanyMenu() {
        //TODO create a while(true) wrapper in inCompanyMenu() method
        System.out.println("You are owner of company " + controller.getCompanyName() + "." +
                "\nWhat do you want to do?" +
                "\n1-Take a look at planes list" +
                "\n2-Add new plane" +
                "\n3-Change company name" +
                "\n4-Find plane");
        int choice = inputInt();
        switch (choice) {
            case (1):
                SearchEngine.printPlanes(controller.getPlanesList());
                break;
            case (2):
                inputPlane();
                break;
            case (3):
                System.out.print("Enter new company name: ");
                String newCompanyName = inputString();
                controller.setCompanyName(newCompanyName);
                System.out.println("Company name successfully changed on " + newCompanyName);
                break;
            case (4):
                //TODO create a search engine in viewer
                break;
        }
    }

    /**
     * Reads int value from console without any validation.
     *
     * @return (int) value
     */
    private int inputInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    /**
     * Reading integer number from console.
     * <p>
     * Reading from console integer number and validating is it number
     * (catching NumberFormatException) and is it between from and to (includes from and to).
     *
     * @param from minimal value
     * @param to   maximal value
     * @return (int) value
     */
    private int inputIntWithValidation(int from, int to) {
        int number = inputInt();
        while (number < from & number > to) {
            System.out.print("Please, choose between " + from + " and " + to);
            try {
                number = inputInt();
            } catch (NumberFormatException ex) {
                System.out.println("Please, type an INTEGER number. You entered something else");
            }
        }
        return number;
    }

    /**
     * Reads from console int number and validating it, depends on mode.
     * <p>
     * Depends on mode and key, reading from console int number and validating it.
     * Set notBigger true to set validation by "is number >k".
     * Set notBigger false to set mode "is number <k".
     *
     * @param key       number, regarding which will be validation bigger or less.
     * @param notBigger true to set validation by "is number >k". Otherwise will be mode "is number <k"
     * @return (int) value
     */
    private int inputIntWithValidation(int key, boolean notBigger) {
        int number = inputInt();
        if (notBigger) {
            while (number > key) {
                System.out.print("Please, choose number below " + key);
                try {
                    number = inputInt();
                } catch (NumberFormatException ex) {
                    System.out.println("Please, type an INTEGER number. You entered something else");
                }
            }
        } else {
            while (number < key) {
                System.out.print("Please, choose number below " + key);
                try {
                    number = inputInt();
                } catch (NumberFormatException ex) {
                    System.out.println("Please, type the number. You entered something else");
                }
            }
        }
        return number;
    }

    /**
     * Reading String row from console.
     *
     * @return
     */
    private String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * Reads engine code name from console.
     * <p>
     * Reads from console string line and calls with it {@code Engine.valueOf()}.
     * If such element wasn't found catching exception and printing to console all engine,
     * to show user available engines.
     *
     * @return Engine object
     * @see Engine more information about Engine
     */
    private Engine inputEngine() {
        Scanner input = new Scanner(System.in);
        String engineModelName = input.nextLine();
        while (true) {
            try {
                engineModelName = input.nextLine().toUpperCase();
                return Engine.valueOf(engineModelName);
            } catch (IllegalArgumentException ex) {
                System.out.println("No such engine found. Here's all available engines: ");
                printEnginesList(controller.getEnginesList());
                System.out.print("Input code name here==>");
            }
        }
    }

    /**
     * Prints list of engines to console.
     * <p>
     * Used while catching exception when such engine wasn't found.
     *
     * @param engines {@code List<Engine>} with all available engines
     * @see Viewer#inputEngine() more information about inputEngine()
     */
    private void printEnginesList(List<Engine> engines) {
        for (Engine engine : engines) {
            System.out.println("Model: " + engine.getModel() + " by " + engine.getManufacturer()
                    + "\nFuel consumption: " + engine.getFuelConsumption() + " kg/(kg-n/hour)"//kilogram of fuel per kilogram-force per hour
                    + "\nCode name: " + engine.getCodeName());
        }
    }
}
