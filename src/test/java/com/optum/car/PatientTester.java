package com.optum.car;

import com.optum.car.model.Patient;
import com.optum.car.service.PatientDisease;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class PatientTester extends  ClinicalAlgorithmRulesApplicationTests {
    @Autowired
    KieContainer kieContainer;
    static Map<Integer, Patientd> map= new HashMap<>();

    static  {
        //Variable for Timeframe
        LocalDate validDate = LocalDate.of(2022, 06, 30);
        //Variable for DOB
        LocalDate DOB = LocalDate.of(2000, 9, 04);

        map.put(1,new Patientd(Arrays.asList(
                new Patient(1,"R13.1", "Active", validDate, DOB),
                new Patient(3,"R63.4", "Active", validDate, DOB),
                new Patient(2,"R68.81", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(1, "Dysphagia"),new Pair(3,"Weight Loss"),new Pair(2,"Early Satiety"))),
                new MapCreator(Arrays.asList(new Pair(1),new Pair(3),new Pair(2)))));

        map.put(2,new Patientd(Arrays.asList(
                new Patient(4,"R63.4", "Active", validDate, DOB),
                new Patient(2,"K21.0", "Active", validDate, DOB),
                new Patient(2,"R13.1", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(4, "Weight Loss"),new Pair(2, "GERD","Dysphagia"))),
                new MapCreator(Arrays.asList(new Pair(4),new Pair(2)))));

        /*map.put(3,new Patientd(Arrays.asList(
                new Patient(3,"R68.81", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(3, "Early Satiety"))),
                new MapCreator(Arrays.asList(new Pair(3)))));

        map.put(4,new Patientd(Arrays.asList(
                new Patient(4,"K21.0", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(4,"GERD"))),
                new MapCreator(Arrays.asList(new Pair(4)))));

        map.put(5,new Patientd(Arrays.asList(
                new Patient(5,"D50.8", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(5, "Iron Deficiency"))),
                new MapCreator(Arrays.asList(new Pair(5)))));

        map.put(6,new Patientd(Arrays.asList(
                new Patient(6,"T85.521A", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(6, "Chronic Heartburn"))),
                new MapCreator(Arrays.asList(new Pair(6)))));

        map.put(7,new Patientd(Arrays.asList(
                new Patient(7,"R68.81", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(7, "Early Satiety"))),
                new MapCreator(Arrays.asList(new Pair(7)))));

        map.put(8,new Patientd(Arrays.asList(
                new Patient(8,"R68.81", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(8, "Early Satiety"))),
                new MapCreator(Arrays.asList(new Pair(8)))));

        map.put(9,new Patientd(Arrays.asList(
                new Patient(9,"R13.1", "Inactive", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(9, null))),
                new MapCreator(Arrays.asList(new Pair(9)))));

        map.put(10,new Patientd(Arrays.asList(
                new Patient(10,"R13.1", "Active", LocalDate.of(2021, 06, 30), DOB)),
                new MapCreator(Arrays.asList(new Pair(10, null))),
                new MapCreator(Arrays.asList(new Pair(10)))));

        map.put(11,new Patientd(Arrays.asList(
                new Patient(11,"R63.4", "Active", LocalDate.of(2021, 06, 30), DOB)),
                new MapCreator(Arrays.asList(new Pair(11, null))),
                new MapCreator(Arrays.asList(new Pair(11)))));

        map.put(12,new Patientd(Arrays.asList(
                new Patient(12,"R63.4", "Inactive", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(12, null))),
                new MapCreator(Arrays.asList(new Pair(12)))));

        map.put(13,new Patientd(Arrays.asList(
                new Patient(12,"R68.81", "Inactive", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(13, null))),
                new MapCreator(Arrays.asList(new Pair(13)))));

        map.put(14,new Patientd(Arrays.asList(
                new Patient(14,"R68.81", "Active", LocalDate.of(2021, 06, 30), DOB)),
                new MapCreator(Arrays.asList(new Pair(14, null))),
                new MapCreator(Arrays.asList(new Pair(14)))));

        map.put(15,new Patientd(Arrays.asList(
                new Patient(15,"D50.8", "Active", LocalDate.of(2021, 06, 30), DOB)),
                new MapCreator(Arrays.asList(new Pair(15, null))),
                new MapCreator(Arrays.asList(new Pair(15)))));

        map.put(16,new Patientd(Arrays.asList(
                new Patient(16,"D50.8", "Inactive", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(16, null))),
                new MapCreator(Arrays.asList(new Pair(16)))));

        map.put(17,new Patientd(Arrays.asList(
                new Patient(17,"K21.0", "Active", LocalDate.of(2021, 06, 30), DOB)),
                new MapCreator(Arrays.asList(new Pair(17, null))),
                new MapCreator(Arrays.asList(new Pair(17)))));

        map.put(18,new Patientd(Arrays.asList(
                new Patient(18,"K21.0", "Inactive", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(18, null))),
                new MapCreator(Arrays.asList(new Pair(18)))));

        map.put(19,new Patientd(Arrays.asList(
                new Patient(19,"T85.521A", "Active", LocalDate.of(2021, 06, 30), DOB)),
                new MapCreator(Arrays.asList(new Pair(19, null))),
                new MapCreator(Arrays.asList(new Pair(19)))));

        map.put(20,new Patientd(Arrays.asList(
                new Patient(20,"T85.521A", "Inactive", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(20, null))),
                new MapCreator(Arrays.asList(new Pair(20)))));

        map.put(21,new Patientd(Arrays.asList(
                new Patient(21,"T85.521A", "Active", validDate, DOB),
                new Patient(21,"K21.0", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(21, "Chronic Heartburn", "GERD"))),
                new MapCreator(Arrays.asList(new Pair(21)))));

        map.put(22,new Patientd(Arrays.asList(
                new Patient(22,"K40", "Active", validDate, DOB),
                new Patient(22,"K21.0", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(22,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(22, "Hiatal Hernia")))));

        map.put(23,new Patientd(Arrays.asList(
                new Patient(23,"K40", "Active", validDate, DOB),
                new Patient(23,"K21.0", "Inactive", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(23,  null))),
                new MapCreator(Arrays.asList(new Pair(23, null)))));

        map.put(24,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(24,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(24,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(24,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(24, "Hiatal Hernia")))));
        map.put(25,new Patientd(Arrays.asList(
                new Patient(25,"K21.0", "Active", validDate, DOB),
                new Patient(25,"K40", "Active", validDate, DOB),
                new Patient(25,"R68.81", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(25,  "GERD","Early Satiety"))),
                new MapCreator(Arrays.asList(new Pair(25, "Hiatal Hernia")))));

        map.put(26,new Patientd(Arrays.asList(
                new Patient(26,"K21.0", "Active", validDate, DOB),
                new Patient(26,"K40", "Active", validDate, DOB),
                new Patient(26,"E44.0", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(26,  "GERD","Weight Loss"))),
                new MapCreator(Arrays.asList(new Pair(26, "Hiatal Hernia")))));

        map.put(27,new Patientd(Arrays.asList(
                new Patient(27,"K21.0", "Active", validDate, DOB),
                new Patient(27,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(27,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(27, "Hiatal Hernia")))));

        map.put(28,new Patientd(Arrays.asList(
                new Patient(28,"K21.0", "Active", validDate, DOB),
                new Patient(28,"K40", "Active", validDate, DOB),
                new Patient(28,"R13.1", "Active", validDate, DOB),
                new Patient(28,"E66.9", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(28,  "GERD","Dysphagia"))),
                new MapCreator(Arrays.asList(new Pair(28, "Hiatal Hernia","Elevated BMI")))));

        map.put(29,new Patientd(Arrays.asList(
                new Patient(29,"K21.0", "Active", validDate, DOB),
                new Patient(29,"K40", "Active", validDate, DOB),
                new Patient(29,"Z72.0", "Active", validDate, DOB,"Positive"),
                new Patient(29,"D50.8", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(29,  "GERD","Iron Deficiency"))),
                new MapCreator(Arrays.asList(new Pair(29, "Hiatal Hernia","Tobacco Usage")))));

        map.put(30,new Patientd(Arrays.asList(
                new Patient(30,"K21.0", "Active", validDate, DOB),
                new Patient(30,"E66", "Active", LocalDate.of(2021, 06, 30), DOB),
                new Patient(30,"K40", "Active", validDate, DOB),
                new Patient(30,"R13.1", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(30,  "GERD","Dysphagia"))),
                new MapCreator(Arrays.asList(new Pair(30, "Hiatal Hernia")))));

        map.put(31,new Patientd(Arrays.asList(
                new Patient(31,"K21.0", "Active", validDate, DOB),
                new Patient(31,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(31,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(31, "Hiatal Hernia")))));

        map.put(32,new Patientd(Arrays.asList(
                new Patient(32,"K21.0", "Active", LocalDate.of(2021, 06, 30), DOB),
                new Patient(32,"K40", "Active", validDate, DOB),
                new Patient(32,"K66.9", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(32,  null))),
                new MapCreator(Arrays.asList(new Pair(32, null)))));

        map.put(33,new Patientd(Arrays.asList(
                new Patient(33,"K21.0", "Active", validDate, DOB),
                new Patient(33,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(33,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(33, "Hiatal Hernia")))));

        map.put(34,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(34,"K21.0", "Active", validDate, DOB),
                new Patient(34,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(34,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(34, "Hiatal Hernia")))));

        map.put(35,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(35,"K21.0", "Active", validDate, DOB),
                new Patient(35,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(35,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(35, "Hiatal Hernia")))));

        map.put(36,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(36,"K21.0", "Active", validDate, DOB),
                new Patient(36,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(36,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(36, "Hiatal Hernia")))));

        map.put(37,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(37,"K21.0", "Active", validDate, DOB),
                new Patient(37,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(37,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(37, "Hiatal Hernia")))));

        map.put(38,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(38,"K21.0", "Active", validDate, DOB),
                new Patient(38,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(38,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(38, "Hiatal Hernia")))));

        map.put(39,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(39,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(39,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(39,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(39, "Hiatal Hernia")))));

        map.put(40,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(40,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(40,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(40,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(40, "Hiatal Hernia")))));

        map.put(41,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(41,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(41,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(41,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(41, "Hiatal Hernia")))));

        map.put(42,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(42,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(42,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(42,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(42, "Hiatal Hernia")))));

        map.put(43,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(43,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(43,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(43,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(43, "Hiatal Hernia")))));

        map.put(44,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(44,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(44,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(44,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(44, "Hiatal Hernia")))));

        map.put(45,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(45,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(45,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(45,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(45, "Hiatal Hernia")))));

        map.put(46,new Patientd(Arrays.asList(
                new Patient(46,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(46,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(46,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(46, "Hiatal Hernia")))));

        map.put(47,new Patientd(Arrays.asList(
                new Patient(47,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(47,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(47,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(47, "Hiatal Hernia")))));

        map.put(48,new Patientd(Arrays.asList(
                //new Patient(24,"K40", "Active", validDate, DOB),
                new Patient(48,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(48,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(48,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(48, "Hiatal Hernia")))));

        map.put(49,new Patientd(Arrays.asList(
                new Patient(49,"K21.0", "Active", LocalDate.of(2022, 06, 30), DOB),
                new Patient(49,"K40", "Active", validDate, DOB)),
                new MapCreator(Arrays.asList(new Pair(49,  "GERD"))),
                new MapCreator(Arrays.asList(new Pair(49, "Hiatal Hernia")))));

        map.put(50,new Patientd(Arrays.asList(
                new Patient(50,"K21.0", "Active",validDate, LocalDate.of(1960,9,8)),
                new Patient(50,"E61.1", "Active",validDate, LocalDate.of(1960,9,8)),
                new Patient(50,"R12", "Active",validDate, LocalDate.of(1960,9,8)),
                new Patient(50,"F17.220", "Active", validDate, LocalDate.of(1960,9,8),"White", "Male","Positive")),
                new MapCreator(Arrays.asList(new Pair(50,  "GERD","Iron Deficiency","Chronic Heartburn"))),
                new MapCreator(Arrays.asList(new Pair(50, "Age more than 50", "Tobacco Usage","White Male")))));*/
    }

    @Test
    public void testForPatientDisease() {
        PatientTester pt= new PatientTester();


        for (int tid : map.keySet()) {
            PatientDisease patientDisease = new PatientDisease();
            KieSession ksession= kieContainer.newKieSession();
            for(Patient p:map.get(tid).pt) {
                ksession.insert(p);

            }
            ksession.insert(LocalDate.now());
            ksession.insert(patientDisease);
            ksession.fireAllRules();
            ksession.dispose();
            pt.validatorDisease(patientDisease, map.get(tid).dismp, map.get(tid).riskmp);
        }


        /*for(int tid:map.keySet())
        {

        }*/


    }


    public void validatorDisease(PatientDisease pd, MapCreator disease, MapCreator risk){

        for(int pid:disease.map.keySet())
        {
            if (pd.getMaplist().get(pd.getPatient(pid))==null){
                assertEquals(0,disease.map.get(pid).size());
            }
            else {
                assertEquals(pd.getMaplist().get(pd.getPatient(pid)), (disease.map.get(pid)));
                System.out.println("Patient with id "+pd.getPatient(pid).getId()+" has disease "+pd.getMaplist().get(pd.getPatient(pid))+" and");
                if (pd.getPatient(pid).getRisk().size()!=0) {
                    System.out.println("Risk Factor "+pd.getPatient(pid).getRisk());
                }
            }
        }

        for(int pid:risk.map.keySet()) {
            if (pd.getPatient(pid) == null) {
                assertEquals(0, risk.map.get(pid).size());
            } else {
                if (pd.getPatient(pid).getRisk().size() == 0) {
                    assertEquals(0, risk.map.get(pid).size());
                } else {
                    Assertions.assertEquals(pd.getPatient(pid).getRisk(), risk.map.get(pid));
                    //system.out.println("Patient with id has disease "+pd.getPatient(pid).getId()+" has risk "+pd.getPatient(pid).getRisk());
                }
            }
        }

    }
}
