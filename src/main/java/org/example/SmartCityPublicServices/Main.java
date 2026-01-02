package org.example.SmartCityPublicServices;

import org.example.SmartCityPublicServices.service.CitizenService;
import org.example.SmartCityPublicServices.service.ElectricityDistributionService;
import org.example.SmartCityPublicServices.service.PublicTransportationService;

public class Main {
    public static void main(String[] args) {
        //creating citizens and public transportation objects
        CitizenService c = new CitizenService();
        c.addCitizen(1, "Godwynne", 23, 10000);
        c.addCitizen(2, "Godwynne", 23, 10000);

//        ElectricityDistributionService eds = new ElectricityDistributionService();
//        eds.addElectricityCompany("Batelec");
//        eds.citizensAvailingElectricity(c.getCitizen(1), "Batelec");
//        eds.getCitizens();
//
//        System.out.println();
//        eds.billCitizens();
//        eds.getCitizens();

        PublicTransportationService pts = new PublicTransportationService();
        pts.addPublicTransportation(1, "Bus");
        pts.addPublicTransportation(2, "Jeep");
        pts.ridePublicTransportation(c.getCitizen(1), 1);
        pts.Pay(1, 1);
        pts.ridePublicTransportation(c.getCitizen(1), 2);
        pts.Pay(1, 2);
        System.out.println();
        pts.getPassengers();

    }
}
