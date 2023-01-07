package model;

import utils.FileService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cat {
    private String name;
    private int age;
    private int satiety;
    private int sentiment;
    private int health;
    private int averageNumber;
    private int amount;


    public Cat(String name, int age, int satiety, int sentiment, int health) {
        this.name = name;
        this.age = age;
        this.satiety = satiety;
        this.sentiment = sentiment;
        this.health = health;
        this.averageNumber = (satiety + sentiment + health) / 3;
        this.amount += 1;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getSentiment() {
        return sentiment;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAverageNumber() {
        return averageNumber;
    }

    public void setAverageNumber(int averageNumber) {
        this.averageNumber = averageNumber;
    }

}
