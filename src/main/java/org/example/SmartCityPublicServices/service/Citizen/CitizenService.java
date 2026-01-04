package org.example.SmartCityPublicServices.service.Citizen;

import org.example.SmartCityPublicServices.model.Citizen;

import java.util.ArrayList;
import java.util.List;

public class CitizenService{

    private static List<Citizen> citizens = new ArrayList<>();

    public void addCitizen(int id, String name, int age, double balance) {
        citizens.add(new Citizen(id, name, age, balance));
    }

    public Citizen getCitizen(int id) {
        for (Citizen c : citizens) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void getAllCitizens() {
        for (Citizen c : citizens) {
            System.out.println(c);
        }
    }

    public static List<Citizen> getCitizens() {
        return citizens;
    }
}
