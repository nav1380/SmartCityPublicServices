package org.example.SmartCityPublicServices;

import org.example.SmartCityPublicServices.service.Citizen.CitizenService;
import org.example.SmartCityPublicServices.service.Emergency.EmergencyServices;
import org.example.SmartCityPublicServices.service.Water.WaterSupplyService;

public class Main {
    public static void main(String[] args) {
        //creating citizens and public transportation objects
        CitizenService c = new CitizenService();
        c.addCitizen(1, "Godwynne", 23, 10000);
        c.addCitizen(2, "Joshua", 23, 10000);

        WaterSupplyService ws = new WaterSupplyService();
        ws.addWaterSupply(1, "Hydro Care", c.getCitizens());
        ws.orderWater(1);
        ws.orderWater(1);
        ws.orderWater(2);
        ws.orderWater(2);
        ws.execute();

        c.getAllCitizens();

    }
}
