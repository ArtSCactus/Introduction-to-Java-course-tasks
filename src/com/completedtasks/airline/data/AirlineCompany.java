package com.completedtasks.airline.data;


import com.completedtasks.airline.data.planemodels.Plane;

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

    public void setName(String name) {
        this.name = name;
    }

}
