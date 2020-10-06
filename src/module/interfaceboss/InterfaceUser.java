package module.interfaceboss;
import module.Module.User;

import java.io.IOException;
import java.util.List;


public interface InterfaceUser extends InterfaceBoss {
    List<User> readFile() throws IOException, ClassNotFoundException;

}
