package org.example.SmartCityPublicServices.service.Transporation;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.PublicTransportation;

import java.util.*;

public class PublicTransportationService implements PayFare {

    private Map<String, List<Citizen>> transport;
    private List<PublicTransportation> pt;

    public PublicTransportationService() {
        transport = new HashMap<>();
        pt = new ArrayList<>();
    }

    public void addPublicTransportation(String id, String type) {
        pt.add(new PublicTransportation(id, type));
        transport.put(id, new ArrayList<>());
    }

    public void ridePublicTransportation(Citizen c, String id) {
        PublicTransportation pt = getPublicTransportation(id);

        if (pt == null) {
            System.out.println(id + " was not found in the system");
            return;
        }

        transport.get(id).add(c);
        Pay(c,pt);
    }

    public PublicTransportation getPublicTransportation(String id) {
        for (PublicTransportation pts : pt) {
            if (pts.getId().equals(id)) {
                return pts;
            }
        }
        return null;
    }

    public void getCitizensPerTransport(String id) {
        for (Map.Entry<String, List<Citizen>> entry : transport.entrySet()) {
            if (entry.getKey().equals(id)) {
                for (Citizen c : entry.getValue()) {
                    System.out.println(c);
                }
            }
        }
    }

    @Override
    public void Pay(Citizen c, PublicTransportation pt) {
        double fare = switch (pt.getType()) {
            case "Bus" -> 15;
            case "Jeep" -> 10;
            default -> 0;
        };
        c.deductBalance(fare);
        System.out.println("The passenger has reached his destination");
    }
}
