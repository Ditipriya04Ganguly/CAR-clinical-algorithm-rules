package com.optum.car.optum;

import com.optum.car.model.Patient;


import java.util.List;

public class Patientd {
    List<Patient> pt;
    MapCreator dismp;
    MapCreator riskmp;


    public Patientd(List<Patient> pt, MapCreator dismp, MapCreator riskmp) {
        this.pt = pt;
        this.dismp = dismp;
        this.riskmp = riskmp;
    }
}
