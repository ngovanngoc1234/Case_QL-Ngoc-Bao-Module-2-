package module.Model;
import java.io.IOException;
import java.util.List;


public interface InterfaceUser extends InterfaceBoss {
    List<User> readFile() throws IOException, ClassNotFoundException;
    void writeToFile() throws IOException;

}
