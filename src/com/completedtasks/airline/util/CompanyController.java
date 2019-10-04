package com.completedtasks.airline.util;

import com.completedtasks.airline.data.AirlineCompany;
import com.completedtasks.airline.data.planes.Plane;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.NoSuchElementException;

public class CompanyController {

    private AirlineCompany company;
    private FileReader dataReader;
    private FileWriter dataWriter;

    CompanyController(AirlineCompany company){
        this.company=company;
    }

    CompanyController(String companyName){
        company = new AirlineCompany(companyName);
    }

    CompanyController(){
        company = new AirlineCompany("Unnamed company");
    }

    public void createCompany(String name){
        if (name==null){
            throw new NullPointerException("Company name cannot be null.");
        }
        if (name.length()==0){
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        company = new AirlineCompany("name");
    }

    public int totalPassengerCapacity(){
        int totalCapacity=0;
        for (int index=0; index<company.amountOfPlanes(); index++){
            totalCapacity+=company.getPlane(index).getPassengerCapacity();
        }
        return totalCapacity;
    }

    public int totalCargoCapacity(){
        int totalCapacity=0;
        for (int index=0; index<company.amountOfPlanes(); index++){
            totalCapacity+=company.getPlane(index).getCargoCapacity();
        }
        return totalCapacity;
    }

    public Plane getPlaneByFuelConsuption(double fuelConsumption) throws NoSuchElementException{
        for (int index=0; index<company.amountOfPlanes(); index++){
            if (company.getPlane(index).getFuelConsumption()==fuelConsumption){
                return company.getPlane(index);
            }
        }
        throw new NoSuchElementException("No such plane found");
    }


}
