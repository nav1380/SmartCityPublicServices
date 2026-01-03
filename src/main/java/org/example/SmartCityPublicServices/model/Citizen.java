package org.example.SmartCityPublicServices.model;

public class Citizen {

    private int id;
    private String name;
    private int age;
    private double balance;

    public Citizen(int id, String name, int age, double balance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Citizen: " +
                "id=" + id +
                ", name=" + name  +
                ", age=" + age + "]";
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

    public void deductBalance(double amount) {
        this.balance -= amount;
    }

}
