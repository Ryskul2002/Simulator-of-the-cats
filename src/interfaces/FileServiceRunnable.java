package interfaces;

import model.Cat;

import java.util.List;

public interface FileServiceRunnable {

    void run();

    List<Cat> getCats(List<Cat> list);

    List<Cat> sorted(List<Cat> list);

    List<Cat> addCat(List<Cat> list);

    void playWithTheCat(List<Cat> list);

    void feedTheCat(List<Cat> list);

    void goToVet(List<Cat> list);

    Cat getTheCat(List<Cat> list, int number);

    void userChoice(List<Cat> list);

    void showCats(List<Cat> list);

    void print(String message);

    void theNextDay(List<Cat> list);

}
