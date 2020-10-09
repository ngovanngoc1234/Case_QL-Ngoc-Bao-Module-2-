package module.Model;
import java.io.IOException;

public interface InterfaceBoss {
    void addInfos() throws IOException, ClassNotFoundException;
    void show() throws IOException, ClassNotFoundException;
    void search();
    void edit();
    void delete();

}
