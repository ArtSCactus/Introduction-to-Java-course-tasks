package com.completedtasks.airline.data;


import com.completedtasks.airline.data.comparators.CompareType;
import com.completedtasks.airline.data.planes.Plane;

import java.util.ArrayList;
import java.util.List;

public class AirlineCompany {

    private String name;

    private List<Plane> planesList;

    public AirlineCompany(String name) {
        this.name = name;
        planesList = new ArrayList<>();
    }

    public AirlineCompany(String name, List<Plane> planesList) {
        this.name = name;
        this.planesList = planesList;
    }

    public void addPlane(Plane newPlane) {
        planesList.add(newPlane);
    }

    public void deletePlane(int index) {
        planesList.remove(index);
    }

    public void deletePlane(String modelName) {
        for (int index = 0; index < planesList.size(); index++) {
            if (planesList.get(index).getModelName().equals(modelName)) {
                planesList.remove(index);
                break;
            }
        }
    }

    public int amountOfPlanes(){
        return planesList.size();
    }

    public Plane getPlane(int index){
        return planesList.get(index);
    }

    public Plane getPlane(String modelName){
        for (Plane plane : planesList){
            if (plane.getModelName().equals(modelName)){
                return plane;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sortPlanes(CompareType sortMode){
        planesList.sort(sortMode);
    }

}
