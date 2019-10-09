package com.completedtasks.airline.entity;


import com.completedtasks.airline.entity.comparators.CompareType;
import com.completedtasks.airline.entity.planes.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void setPlanesList(List<Plane> planesList){
        this.planesList=planesList;
    }

    public List<Plane> getPlanesList(){
        return planesList;
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

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sortPlanes(CompareType sortMode){
        planesList.sort(sortMode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirlineCompany)) return false;
        AirlineCompany that = (AirlineCompany) o;
        return getName().equals(that.getName()) &&
                getPlanesList().equals(that.getPlanesList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPlanesList());
    }

    private String toStringPlanes(){
        String planesRow="";
        for (Plane plane : planesList){
            planesRow+=plane.toString()+"\n";
        }
        return planesRow;
    }

    @Override
    public String toString() {
        return "AirlineCompany: " +
                "name = " + name  +
                " planes list:\n" + toStringPlanes();
    }
}
