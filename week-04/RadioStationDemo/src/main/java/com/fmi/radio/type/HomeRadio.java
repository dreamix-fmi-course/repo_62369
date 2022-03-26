package com.fmi.radio.type;

import com.fmi.radio.station.RadioStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HomeRadio {
    @Autowired
    @Qualifier("radioStationNews")
    private RadioStation radioStation;

    public void listenToRadioAtHome() {
        radioStation.playStation();
    }
}
