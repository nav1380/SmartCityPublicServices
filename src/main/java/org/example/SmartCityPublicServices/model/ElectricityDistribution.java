package org.example.SmartCityPublicServices.model;

public class ElectricityDistribution {

    private String company;

    public ElectricityDistribution(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "ElectricityDistribution{" +
                "company='" + company + '\'' +
                '}';
    }
}
