package org.example.SmartCityPublicServices;

import org.example.SmartCityPublicServices.service.Citizen.CitizenService;
import org.example.SmartCityPublicServices.service.Citizen.ExistingCitizenException;
import org.example.SmartCityPublicServices.service.Electricity.ElectricityDistributionService;
import org.example.SmartCityPublicServices.service.Electricity.ExistingElectricityCompanyException;
import org.example.SmartCityPublicServices.service.Emergency.EmergencyServices;
import org.example.SmartCityPublicServices.service.Water.WaterSupplyService;

public class Main {
    public static void main(String[] args) {
        try {
            ElectricityDistributionService eds = new ElectricityDistributionService();
            eds.addElectricityCompany("Batelec");
            eds.addElectricityCompany("Batelec");
        } catch (ExistingElectricityCompanyException e) {
            System.out.println(e.getMessage());
        }
    }
}
