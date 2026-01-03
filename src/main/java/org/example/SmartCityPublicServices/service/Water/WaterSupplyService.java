package org.example.SmartCityPublicServices.service.Water;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.WaterSupply;
import org.example.SmartCityPublicServices.service.Service;

import java.util.*;

public class WaterSupplyService implements OrderWater, Service {

    private Map<String, List<Citizen>> subscribers;
    private List<WaterSupply> waterSupply;
    private List<Citizen> orders;

    public WaterSupplyService() {
        orders = new ArrayList<>();
        subscribers = new HashMap<>();
        waterSupply = new ArrayList<>();
    }

    public void addWaterSupply(int id, String name) {
        waterSupply.add(new WaterSupply(id, name));
        subscribers.put(name, new ArrayList<>());
    }

    public WaterSupply getWaterSupply(String name) {
        for (WaterSupply ws : waterSupply) {
            if (ws.getName().equals(name)) {
                return ws;
            }
        }
        return null;
    }

    public void subscribeCitizenToWaterSupply(Citizen c, String name) {
        WaterSupply ws = getWaterSupply(name);

        if (ws == null) {
            System.out.println(ws.getName() + " was not found");
        }

        subscribers.get(name).add(c);
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
        orders.add(getSubscriber(1));

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
