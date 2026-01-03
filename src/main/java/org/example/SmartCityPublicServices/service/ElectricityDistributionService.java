package org.example.SmartCityPublicServices.service;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.ElectricityDistribution;

import java.util.ArrayList;
import java.util.List;

public class ElectricityDistributionService implements BillCitizens {

    private List<ElectricityDistribution> ETS = new ArrayList<>();
    private List<Citizen> citizens = new ArrayList<>();
    private List<Citizen> paidCitizens = new ArrayList<>();

    public void addElectricityCompany(String company) {
        ETS.add(new ElectricityDistribution(company));
    }

    public void getElectricityCompanies() {
        for (ElectricityDistribution e : ETS) {
            System.out.println(e);
        }
    }

    public void citizensAvailingElectricity(Citizen c, String company) {
        for (ElectricityDistribution e : ETS) {
            if (e.getCompany().equals(company)) {
                citizens.add(c);
            }
        }
    }

    public void getCitizens() {
        for (Citizen c : citizens) {
            System.out.println(c);
        }
    }



    public void clearPaidList() {
        for (Citizen c : citizens) {
            paidCitizens.remove(c);
        }
    }

    @Override
    public void billCitizens() {
        int paid = 0;
        int notpaid = 0;
        paidCitizens.clear();
        for (Citizen c : citizens) {
            if (!paidCitizens.contains(c)) {
                if (c.getBalance() >= 1300) {
                    paidCitizens.add(c);
                    c.deductBalance(1300);
                    paid++;
                } else {
                    System.out.println(c.getName() + " did not have sufficient balance");
                    notpaid++;
                }
            } else {
                System.out.println(c.getName() + " has already paid his dues");
            }
        }
        System.out.println("Citizens that have paid electricity: " + paid);
        System.out.println("Citizens that have not paid electricity: " + notpaid);
    }
}
