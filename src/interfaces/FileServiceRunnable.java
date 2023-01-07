package interfaces;

import model.Cat;

import java.util.List;

public interface FileServiceRunnable {

    void run();

    List<Cat> getCats(List<Cat> list);


}
