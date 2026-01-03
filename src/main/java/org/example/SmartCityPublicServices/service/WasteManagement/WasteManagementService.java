package org.example.SmartCityPublicServices.service.WasteManagement;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.WasteManagement;
import org.example.SmartCityPublicServices.service.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WasteManagementService implements Service {

    private List<Citizen> citizens = new ArrayList<>();
    private List<WasteManagement> wasteManagement = new ArrayList<>();


    public void addWasteManagement(int id) {
        wasteManagement.add(new WasteManagement(id));
    }

    public WasteManagement getWasteManagement(int id) {
        for (WasteManagement wms : wasteManagement) {
            if (wms.getId() == id) {
                return wms;
            }
        }
        return null;
    }

    public List<Citizen> getSubscribers() {
        for (Citizen c : citizens) {
            return this.getCitizens();
        }
        return null;
    }

    public void subscribeCitizenToCleanup(Citizen c, int wmid) {
        for (WasteManagement wm : wasteManagement) {
            if (wmid == wm.getId()) {
                citizens.add(c);
            }
        }
    }

    @Override
    public void execute() {
        LocalDate date = LocalDate.now();
        boolean weekend = date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
        if (weekend) {
            System.out.println("Waste Management is closed on weekends");
        } else {
            System.out.println("The Waste Management Service is going around to retrieve community waste.");
        }
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

}
