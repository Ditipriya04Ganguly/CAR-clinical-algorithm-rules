package com.optum.car.controller;

import com.optum.car.model.ListOfPatient;
import com.optum.car.model.Patient;
import com.optum.car.model.PatientDetails;
import com.optum.car.service.PatientDisease;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController

public class CarController {



    //@Autowired

    private KieSession ksession;
    @Autowired
    KieContainer kieContainer;


    @PostMapping("/patient")
    public List<PatientDetails>  addPatient(@RequestBody ListOfPatient listOfPatient){
        ksession= kieContainer.newKieSession();

        PatientDisease patientDisease= new PatientDisease();

        for (Patient patient: listOfPatient.getListofpatient()){
            ksession.insert(patient);
        }


        System.out.println("abc");
        ksession.insert(LocalDate.now());
        ksession.insert(patientDisease);
        ksession.fireAllRules();
        ksession.dispose();


        /*for(Patient p1: patientDisease.getMaplist().keySet())
        {
            System.out.print("patient with id "+p1.getId()+" has disease ");
            System.out.println(patientDisease.getMaplist().get(p1));
            System.out.println("Prefill value: "+ p1.getPreFill());
            System.out.println("Multiple value: "+p1.getMultiple());
            System.out.println("Multiple Risk prefill: "+p1.getMultipleG());
            System.out.println("Risk Factor: "+p1.getRisk());
        }*/

        //System.out.println(patientDisease.searchPatientById(patient.getId()));
        //System.out.println(patientDisease.getMaplist().get(patient));
        List<PatientDetails> patientDetails= new ArrayList<>();
        for (Patient patient:listOfPatient.getListofpatient()) {
            PatientDetails patientdetails = new PatientDetails(patientDisease.searchPatientById(patient.getId()), patientDisease.getMaplist().get(patient));
            patientDetails.add(patientdetails);
        }
        return patientDetails;
    }

    @GetMapping("/patient/{id}")
    public ListOfPatient getPatient(@PathVariable(name = "id") int id){
        Patient p= new Patient(1,"R13.1", "Active",LocalDate.of(2022,06,30), LocalDate.of(2000,9,04));
        List<Patient> plist= new ArrayList<>();
        plist.add(p);
        ListOfPatient list= new ListOfPatient(plist);
        return list;
    }

}
