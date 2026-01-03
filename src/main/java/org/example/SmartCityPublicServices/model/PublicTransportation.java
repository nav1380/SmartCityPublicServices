package org.example.SmartCityPublicServices.model;

public class PublicTransportation{

    private String id;
    private String type;

    public PublicTransportation(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
