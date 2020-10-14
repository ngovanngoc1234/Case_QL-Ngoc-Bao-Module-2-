package module.display;
import java.io.IOException;

public interface DisplayCalculate {
    void addInfos() throws IOException, ClassNotFoundException;
    void show() throws IOException, ClassNotFoundException;
    void search();
    void edit();
    void delete();

}
