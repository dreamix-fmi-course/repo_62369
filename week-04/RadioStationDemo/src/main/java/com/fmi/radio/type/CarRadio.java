package com.fmi.radio.type;

import com.fmi.radio.station.RadioStation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Setter
public class CarRadio {
    @Autowired
    @Qualifier("radioStationRock")
    private RadioStation radioStation;

    public void listenToRadioInCar() {
        radioStation.playStation();
    }
}
