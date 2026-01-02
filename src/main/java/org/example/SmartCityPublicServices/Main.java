package org.example.SmartCityPublicServices;

import org.example.SmartCityPublicServices.service.CitizenService;
import org.example.SmartCityPublicServices.service.PublicTransportationService;

public class Main {
    public static void main(String[] args) {
        //creating citizens and public transportation objects
        CitizenService c = new CitizenService();
        c.addCitizen(1, "Godwynne", 23, 100);
        c.addCitizen(2, "Josh", 23, 100);
        c.addCitizen(3, "Wynne", 23, 100);


        PublicTransportationService pts = new PublicTransportationService();
        pts.addPublicTransportation(1, "Bus");
        pts.ridePublicTransportation(c.getCitizen(1), pts.getPublicTransportation(1));
        pts.ridePublicTransportation(c.getCitizen(2), pts.getPublicTransportation(1));
        pts.ridePublicTransportation(c.getCitizen(3), pts.getPublicTransportation(1));

        pts.Pay(1, "Bus");
        pts.getPassengers();

    }
}
