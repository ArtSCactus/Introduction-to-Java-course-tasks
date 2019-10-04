package com.completedtasks.airline.data.comparators;

import com.completedtasks.airline.data.planes.Plane;

import java.util.Comparator;

public enum CompareType implements Comparator<Plane> {

    BY_PASSENGER_CAPACITY(){
        @Override
        public int compare (Plane ob1, Plane ob2){
            if (ob1.getPassengerCapacity() == ob2.getPassengerCapacity()) {
                return 0;
            }
            if (ob1.getPassengerCapacity() > ob2.getPassengerCapacity()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    },

    BY_CARGO_CAPACITY(){
        @Override
        public int compare (Plane ob1, Plane ob2){
            if (ob1.getCargoCapacity() == ob2.getCargoCapacity()) {
                return 0;
            }
            if (ob1.getCargoCapacity() > ob2.getCargoCapacity()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    },

    BY_SERIAL_NUMBER(){
        @Override
        public int compare (Plane ob1, Plane ob2){
            if (ob1.getSerialNumber() == ob2.getSerialNumber()) {
                return 0;
            }
            if (ob1.getSerialNumber() > ob2.getSerialNumber()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    },

    BY_MODEL_NAME(){
        @Override
        public int compare (Plane ob1, Plane ob2) {
           return (ob1.getModelName().compareTo(ob2.getModelName()));
        }
    }

}
