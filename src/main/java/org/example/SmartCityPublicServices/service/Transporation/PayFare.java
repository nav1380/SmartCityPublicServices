package org.example.SmartCityPublicServices.service.Transporation;

import org.example.SmartCityPublicServices.model.Citizen;
import org.example.SmartCityPublicServices.model.PublicTransportation;

public interface PayFare {
    void Pay(Citizen c, PublicTransportation pt);
}
