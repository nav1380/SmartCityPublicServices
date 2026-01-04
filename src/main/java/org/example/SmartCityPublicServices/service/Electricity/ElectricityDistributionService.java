package org.example.SmartCityPublicServices.service.Electricity;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.ElectricityDistribution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectricityDistributionService implements BillCitizens {

//    private List<ElectricityDistribution> ETS = new ArrayList<>();
//    private List<Citizen> citizens = new ArrayList<>();
    private Map<String, List<Citizen>> electricity;
    private List<Citizen> paidCitizens;

    public ElectricityDistributionService() {
        electricity = new HashMap<>();
        paidCitizens = new ArrayList<>();
    }

    public void addElectricityCompany(String company) {
        electricity.put(company, new ArrayList<>());
    }

    public void getElectricityCompanies() {
        for (Map.Entry<String, List<Citizen>> entry : electricity.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void getCustomers(String company) {
        for (Map.Entry<String, List<Citizen>> entry : electricity.entrySet()) {
            if (entry.getKey().equals(company)) {
                for (Citizen c : entry.getValue()) {
                    System.out.println(c);
                }
            }
        }
    }

    public void subscribeCustomerToElectricity(Citizen c, String company) {
        electricity.get(company).add(c);
    }

    public Citizen getCustomer(int id) {
        for (Map.Entry<String, List<Citizen>> entry : electricity.entrySet()) {
            for (Citizen c : entry.getValue()) {
                if (c.getId() == id) {
                    return c;
                }
            }
        }
        return null;
    }

    public void getCustomerElectricity(int id) {
        for (Map.Entry<String, List<Citizen>> entry : electricity.entrySet()) {
            for (Citizen c : entry.getValue()) {
                if (c.getId() == id) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
    public List<Citizen> getPaidCitizens() {
        List<Citizen> paid = new ArrayList<>();

        paid.addAll(paidCitizens);

        return paid;
    }

    public void outputPaidCitizens() {
        for (Citizen c : getPaidCitizens()) {
            System.out.println(c);
        }
    }

    public double billing() {
        LocalDate date = LocalDate.now();
        if (date.getDayOfMonth() <= 12) {
            return  1500;
        } else {
            return  2000;
        }
    }

    public void clearPaidCitizens() {
        LocalDate today = LocalDate.now();
        if (today.getDayOfMonth() == 7) {
            paidCitizens.clear();
        }
    }

    @Override
    public void payElectricity(int id) {
        clearPaidCitizens();

        Citizen cf = getCustomer(id);
        if (!paidCitizens.contains(cf)){
            cf.deductBalance(billing());
            paidCitizens.add(cf);
        } else {
            System.out.println("The customer has already paid his dues");
        }
    }
}
