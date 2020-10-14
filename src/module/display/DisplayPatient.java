package module.display;
import module.Model.Patient;

import java.io.IOException;
import java.util.List;

public interface DisplayPatient extends DisplayCalculate {
    List<Patient> readFile() throws IOException, ClassNotFoundException;
    void writeToFile() throws IOException;
}
