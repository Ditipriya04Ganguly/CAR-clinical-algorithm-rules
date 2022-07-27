package com.optum.car.model;

import java.util.List;

public class ListOfPatient {

     List<Patient> listofpatient;

    public ListOfPatient(){

    }

    public ListOfPatient(List<Patient> listofpatient) {
        this.listofpatient = listofpatient;
    }

    public List<Patient> getListofpatient() {
        return listofpatient;
    }

    public void setListofpatient(List<Patient> listofpatient) {
        this.listofpatient = listofpatient;
    }

    @Override
    public String toString() {
        return "ListOfPatient{" +
                "listofpatient=" + listofpatient +
                '}';
    }
}
