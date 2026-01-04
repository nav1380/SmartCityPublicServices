package org.example.SmartCityPublicServices.service.Water;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.WaterSupply;
import org.example.SmartCityPublicServices.service.Citizen.CitizenService;
import org.example.SmartCityPublicServices.service.Service;

import java.util.*;

public class WaterSupplyService implements OrderWater, Service {

    private Map<String, List<Citizen>> subscribers;
    private List<Citizen> orders;

    public WaterSupplyService() {
        orders = new ArrayList<>();
        subscribers = new HashMap<>();
    }

    public void addWaterSupply(int id, String name, List<Citizen> citizens) {
        subscribers.put(name, citizens);
    }

    public void addWaterSupply(int id, String name) {
        subscribers.put(name, CitizenService.getCitizens());
    }

    public void getSubscribers(String name) {
        for (Map.Entry<String, List<Citizen>> entry : subscribers.entrySet()) {
            if (entry.getKey().equals(name)) {
                for (Citizen c : entry.getValue()) {
                    System.out.println(c);
                }
            }
        }
    }

    public Citizen getSubscriber(int id) {
        for (Map.Entry<String, List<Citizen>> entry : subscribers.entrySet()) {
            for (Citizen c : entry.getValue()) {
                if (c.getId() == id) {
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public void orderWater(int id) {
        orders.add(getSubscriber(id));

    }

    public void getOrders() {
        int count = 0;
        for (Citizen c : orders) {
            count++;
            System.out.println("OrderCount " + count + ": " + c);
        }
    }

    @Override
    public void execute() {
        for (Citizen c : orders) {
            if (c.getBalance() >= 30) {
                c.deductBalance(30);
            }
        }
        orders.clear();
    }
}
