package org.example.SmartCityPublicServices.model;

public class PublicTransportation{

    private int id;
    private String type;

    public PublicTransportation(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
