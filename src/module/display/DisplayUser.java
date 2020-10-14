package module.display;
import module.Model.User;

import java.io.IOException;
import java.util.List;


public interface DisplayUser extends DisplayCalculate {
    List<User> readFile() throws IOException, ClassNotFoundException;
    void writeToFile() throws IOException;

}
