package com.fmi.radio.configuration;

import com.fmi.radio.station.RadioStation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigurations {
    @Bean
    public RadioStation radioStation(){
        return new RadioStation();
    }

    @Bean
    public RadioStation radioStationNews() {
        return new RadioStation("Btv Radio", "News");
    }

    @Bean
    public RadioStation radioStationRock() {
        return new RadioStation("Radio 1 Rock", "It's My Life");
    }
}
