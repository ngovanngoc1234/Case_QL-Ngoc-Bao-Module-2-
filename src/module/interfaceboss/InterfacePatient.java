package module.interfaceboss;

import module.Module.Patient;

import java.io.IOException;
import java.util.List;

public interface InterfacePatient extends InterfaceBoss {
    List<Patient> readFile() throws IOException, ClassNotFoundException;
}
