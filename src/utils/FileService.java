package utils;

import interfaces.FileServiceRunnable;
import model.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileService implements FileServiceRunnable {

    private static final Random RMD = new Random();
    private static final String line = "--+--------+-------+---------+---------+-------------+------------------+";

    public void run() {
        getCats();
        getAverage();
        print();
    }

    public List<Cat> getCats() {
        List<Cat> list = new ArrayList<>();
        list.add(new Cat("Whiskers", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        list.add(new Cat("Felix", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        list.add(new Cat("Oscar", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        list.add(new Cat("Smudge", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        return list;
    }

    public void getAverage() {
        for (int i = 0; i < getCats().size(); i++) {
            getCats().get(i).setAverageNumber(getCats().get(i).getHealth() + getCats().get(i).getSentiment() + getCats().get(i).getSatiety());
        }
    }

    public void print() {
        System.out.println(line);
        System.out.println("# |  name  |  age  |  health  |  mood  |  fullness   |  average number  |");
        System.out.println(line);
        for (int i = 0; i < getCats().size(); i++) {
            System.out.printf("%s|%9s|%7s|%9s|%9s|%13s|%17s|%n", i + 1, getCats().get(i).getName(), getCats().get(i).getAge(), getCats().get(i).getHealth(), getCats().get(i).getSentiment(), getCats().get(i).getSatiety(), getCats().get(i).getAverageNumber());
        }
    }
}
