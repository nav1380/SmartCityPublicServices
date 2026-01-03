package org.example.SmartCityPublicServices.model;

public class EmergencyService {

    private String type;

    public EmergencyService(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
