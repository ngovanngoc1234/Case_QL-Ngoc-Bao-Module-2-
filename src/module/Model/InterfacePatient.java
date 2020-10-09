package module.Model;
import java.io.IOException;
import java.util.List;

public interface InterfacePatient extends InterfaceBoss {
    List<Patient> readFile() throws IOException, ClassNotFoundException;
    void writeToFile() throws IOException;
}
