package module.interfaceboss;
import java.io.IOException;

public interface InterfaceBoss {
    void addInfos() throws IOException, ClassNotFoundException;
    void show() throws IOException, ClassNotFoundException;
    void search(String regex);
    void edit(int number);
    void delete(String id);
    void writeToFile() throws IOException;

}
