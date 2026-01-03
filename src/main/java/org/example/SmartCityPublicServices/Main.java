package org.example.SmartCityPublicServices;

import org.example.SmartCityPublicServices.service.CitizenService;
import org.example.SmartCityPublicServices.service.ElectricityDistributionService;
import org.example.SmartCityPublicServices.service.PublicTransportationService;

public class Main {
    public static void main(String[] args) {
        //creating citizens and public transportation objects
        CitizenService c = new CitizenService();
        c.addCitizen(1, "Godwynne", 23, 10000);
        c.addCitizen(2, "Joshua", 23, 10000);


        ElectricityDistributionService eds = new ElectricityDistributionService();
        eds.addElectricityCompany("Batelec");
        eds.citizensAvailingElectricity(c.getCitizen(1), "Batelec");
        eds.citizensAvailingElectricity(c.getCitizen(2), "Batelec");
        eds.billCitizens();
        System.out.println();
        System.out.println("Checking if the paid citizens will not be billed anymore:");
        eds.billCitizens();
        System.out.println();
        c.getAllCitizens();
    }
}
