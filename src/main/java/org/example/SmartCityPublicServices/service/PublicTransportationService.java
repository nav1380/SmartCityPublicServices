package org.example.SmartCityPublicServices.service;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.PublicTransportation;

import java.util.ArrayList;
import java.util.List;

public class PublicTransportationService implements PayFare {

    private List<Citizen> citizens = new ArrayList<>();
    private List<PublicTransportation> pt = new ArrayList<>();

    public void addPublicTransportation(int id, String type) {
        pt.add(new PublicTransportation(id, type));
    }

    public void ridePublicTransportation(Citizen c, PublicTransportation pt) {
        citizens.add(c);
    }

    public PublicTransportation getPublicTransportation(int id) {
        for (PublicTransportation ptf : pt) {
            if (ptf.getId() == id) {
                return ptf;
            }
        }
        return null;
    }

    public void getPassengers() {
        for (PublicTransportation ptf : pt) {
            for (Citizen c : citizens) {
                System.out.println(c);
            }
        }
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public List<PublicTransportation> getPt() {
        return pt;
    }

    @Override
    public void Pay(int id, String type) {
        for (PublicTransportation ptf : pt) {
            for (Citizen c : citizens) {
                if (c.getId() == id) {
                    double fare = switch (type) {
                        case "Bus" -> 15;
                        case "Jeep" -> 10;
                        default -> 0;
                    };
                    c.deductBalance(fare);
                    System.out.println("The passenger has reached his destination");
                }
            }
        }
    }
}
