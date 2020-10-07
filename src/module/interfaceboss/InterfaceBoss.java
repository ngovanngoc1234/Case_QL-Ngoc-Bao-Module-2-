package module.interfaceboss;
import java.io.IOException;

public interface InterfaceBoss {
    void addInfos() throws IOException, ClassNotFoundException;
    void show() throws IOException, ClassNotFoundException;
    void search(String regex);
    void edit();
    void delete();
    void writeToFile() throws IOException;

}
