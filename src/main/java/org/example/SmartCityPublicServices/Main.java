package org.example.SmartCityPublicServices;

import org.example.SmartCityPublicServices.service.Citizen.CitizenService;
import org.example.SmartCityPublicServices.service.Emergency.EmergencyServices;

public class Main {
    public static void main(String[] args) {
        //creating citizens and public transportation objects
        CitizenService c = new CitizenService();
        c.addCitizen(1, "Godwynne", 23, 10000);
        c.addCitizen(2, "Joshua", 23, 10000);

        EmergencyServices es = new EmergencyServices();
        es.addEmergencyService("Hospital", c.getCitizens());
        es.getCitizens("Hospital");
        es.callForEmergency(1, "Hospital");

    }
}
