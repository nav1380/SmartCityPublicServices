package org.example.SmartCityPublicServices.service.Emergency;

import org.example.SmartCityPublicServices.model.Citizen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmergencyServices implements CallForEmergency {

    private Map<String, List<Citizen>> emergency;

    public EmergencyServices() {
        emergency = new HashMap<>();
    }

    public void addEmergencyService(String type, List<Citizen> citizens) {
        emergency.put(type, citizens);
    }

    public void getCitizens(String type) {
        List<Citizen> citizens = emergency.get(type);

        if (citizens == null) {
            System.out.println("There are no citizens in this type of emergency");
            return;
        }

        for (Citizen c : citizens) {
            System.out.println(c);
        }
    }

    public Citizen getCitizen(int id) {
        for (Map.Entry<String, List<Citizen>> entry : emergency.entrySet()) {
            for (Citizen c : entry.getValue()) {
                if (c.getId() == id) {
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public void callForEmergency(int id, String type) {
        Citizen c = getCitizen(id);

        if (c == null) {
            System.out.println("Citizen is not found");
            return;
        }

        String result = switch (type) {
            case "Hospital" -> "Paremedics are on their way";
            case "Fire Station" -> "The Fire Station is notified";
            default -> "Unexpected value: " + type;
        };
        System.out.println(result);
    }
}
