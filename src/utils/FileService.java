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
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getHealth() > 100 || list.get(i).getSentiment() > 100 || list.get(i).getSatiety() > 100) {
                    list.get(i).setHealth(100);
                    list.get(i).setSatiety(100);
                    list.get(i).setSentiment(100);
                }
            }
            showCats(list);
            userChoice(list);
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

    public void playWithTheCat(List<Cat> list) {
        print("You need to choose one of the cat from 1 to 4: ");
        int answer = new Scanner(System.in).nextInt();
        Cat cat = getTheCat(list, answer);
        if (cat.getAge() >= 1 || cat.getAge() < 5) {
            cat.setHealth(cat.getHealth() + 7);
            cat.setSentiment(cat.getSentiment() + 7);
            cat.setSatiety(cat.getSatiety() - 3);
        } else if (cat.getAge() >= 6 || cat.getAge() < 10) {
            cat.setHealth(cat.getHealth() + 5);
            cat.setSentiment(cat.getSentiment() + 5);
            cat.setSatiety(cat.getSatiety() - 5);
        } else if (cat.getAge() >= 7) {
            cat.setHealth(cat.getHealth() + 4);
            cat.setSentiment(cat.getSentiment() + 4);
            cat.setSatiety(cat.getSatiety() - 6);
        }
        print("You played with the cat " + cat.getName() + ", " + cat.getAge() + "years old\n");
    }

    public void feedTheCat(List<Cat> list) {
        print("You need to choose one of the cat from 1 to 4");
        int answer = new Scanner(System.in).nextInt();
        Cat cat = getTheCat(list, answer);
        if (cat.getAge() >= 1 || cat.getAge() < 5) {
            cat.setSentiment(cat.getSentiment() + 7);
            cat.setSatiety(cat.getSatiety() + 7);
        } else if (cat.getAge() >= 6 || cat.getAge() < 10) {
            cat.setSentiment(cat.getSentiment() + 5);
            cat.setSatiety(cat.getSatiety() + 5);
        } else if (cat.getAge() >= 7) {
            cat.setSentiment(cat.getSentiment() + 4);
            cat.setSatiety(cat.getSatiety() + 4);
        }
        print("You fed the cat " + cat.getName() + ", " + cat.getAge() + "years old\n");
    }

    public void goToVet(List<Cat> list) {
        print("You need to choose one of the cat from 1 to 4: ");
        int answer = new Scanner(System.in).nextInt();
        Cat cat = getTheCat(list, answer);
        if (cat.getAge() >= 1 || cat.getAge() < 5) {
            cat.setHealth(cat.getHealth() + 7);
            cat.setSentiment(cat.getSentiment() - 3);
            cat.setSatiety(cat.getSatiety() - 3);
        } else if (cat.getAge() >= 6 || cat.getAge() < 10) {
            cat.setHealth(cat.getHealth() + 5);
            cat.setSentiment(cat.getSentiment() - 5);
            cat.setSatiety(cat.getSatiety() - 5);
        } else if (cat.getAge() >= 7) {
            cat.setHealth(cat.getHealth() + 4);
            cat.setSentiment(cat.getSentiment() - 6);
            cat.setSatiety(cat.getSatiety() - 6);
        }
        print("You went to the Vet with " + cat.getName() + ", " + cat.getAge() + "years old\n");
    }

    public void theNextDay(List<Cat> list) {
        for (int i = 0; i < list.size(); i++) {
            int satiety = RMD.nextInt(1,6);
            list.get(i).setSatiety(list.get(i).getSatiety() - satiety);
            int mood = RMD.nextInt(-3, 3);
            list.get(i).setSentiment(list.get(i).getSentiment() - mood);
            int health = RMD.nextInt(-3, 3);
            list.get(i).setHealth(list.get(i).getHealth() - health);
        }
    }

    public Cat getTheCat(List<Cat> list, int number) {
        number--;
        return sorted(list).get(number);
    }

    public void userChoice(List<Cat> list) {
        print("You need to choose one of the versions \n 1 -> feed the cat \n 2 -> play with the cat \n 3 -> go to Vet \n 4 -> add new cat \n 5 -> choose the next day: ");
        int userChoice = new Scanner(System.in).nextInt();
        switch (userChoice) {
            case 1:
                feedTheCat(list);
                break;
            case 2:
                playWithTheCat(list);
                break;
            case 3:
                goToVet(list);
                break;
            case 4:
                addCat(list);
                break;
            case 5:
                theNextDay(list);
                break;
            default:
        }
    }

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
