package org.example.SmartCityPublicServices;

import org.example.SmartCityPublicServices.service.Citizen.CitizenService;
import org.example.SmartCityPublicServices.service.Electricity.ElectricityDistributionService;
import org.example.SmartCityPublicServices.service.Emergency.EmergencyServices;
import org.example.SmartCityPublicServices.service.Water.WaterSupplyService;

public class Main {
    public static void main(String[] args) {
        //creating citizens and public transportation objects
        CitizenService c = new CitizenService();
        c.addCitizen(1, "Godwynne", 23, 10000);
        c.addCitizen(2, "Joshua", 23, 10000);

        ElectricityDistributionService eds = new ElectricityDistributionService();
        eds.addElectricityCompany("Batelec");
        eds.addElectricityCompany("Meralco");
        eds.subscribeCustomerToElectricity(c.getCitizen(1), "Batelec");
        eds.subscribeCustomerToElectricity(c.getCitizen(2), "Batelec");
        eds.payElectricity(1);
        eds.payElectricity(2);

        System.out.println("Payed their dues: ");
        eds.outputPaidCitizens();
    }
}
