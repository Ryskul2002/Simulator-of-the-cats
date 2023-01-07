package utils;

import interfaces.FileServiceRunnable;
import model.Cat;

import java.util.*;

public class FileService implements FileServiceRunnable {

    private static final Random RMD = new Random();
    private static final String LINE = "--+--------+-------+---------+---------+-------------+------------------+";

    public void run() {
        List<Cat> list = new ArrayList<>();
        getCats(list);
        while (true) {
            showCats(list);
            addCat(list);
        }
    }

    public List<Cat> getCats(List<Cat> list) {
        list.add(new Cat("Whiskers", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        list.add(new Cat("Felix", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        list.add(new Cat("Oscar", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        list.add(new Cat("Smudge", RMD.nextInt(1, 19), RMD.nextInt(101), RMD.nextInt(101), RMD.nextInt(101)));
        return list;
    }

    public List<Cat> sorted(List<Cat> list) {
        return list.stream()
                .sorted(Comparator.comparing(Cat::getAverageNumber).reversed())
                .toList();
    }

    public List<Cat> addCat(List<Cat> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to add cat? Y/N: ");
        String choice1 = scanner.nextLine();
        if (choice1.toLowerCase().charAt(0) == 'y') {
            try {
                print("You need to choose future cat's name: ");
                String name = scanner.nextLine();
                if (name.length() > 9) {
                    print("You must enter name of the cat less than 10 letter! \n");
                } else {
                    print("You need to choose future cat's age from 1 to 18: ");
                    int age = scanner.nextInt();
                    if (age < 1 || age > 18) {
                        print("You must enter age of the cat from 1 to 18! \n");
                    } else {
                        list.add(new Cat(name, age, RMD.nextInt(20, 81), RMD.nextInt(20, 81), RMD.nextInt(20, 81)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void

    public void showCats(List<Cat> list) {
        print(LINE + "\n");
        print("# |  name  |  age  |  health  |  mood  |  fullness   |  average number  |\n");
        print(LINE + "\n");
        for (int i = 0; i < sorted(list).size(); i++) {
            System.out.printf("%s|%9s|%7s|%9s|%9s|%13s|%18s|%n", i + 1, sorted(list).get(i).getName(), sorted(list).get(i).getAge(), sorted(list).get(i).getHealth(), sorted(list).get(i).getSentiment(), sorted(list).get(i).getSatiety(), sorted(list).get(i).getAverageNumber());
        }
    }

    public void print(String message) {
        System.out.print(message);
    }
}
