package module.Controller;
import module.Model.Patient;

import java.util.Comparator;

public class SortPatientByName implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
