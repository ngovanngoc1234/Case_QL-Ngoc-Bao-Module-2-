package module.Model;

import java.util.*;

public class ListPatient {
    private List<Patient> patientList;
    public List<Patient> getPatientList() {
        return patientList;
    }
    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
    public ListPatient(List<Patient> patients) {
        patientList = patients;
    }
    public ListPatient() {}

}
