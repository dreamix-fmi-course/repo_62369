package com.fmi;

import com.fmi.radio.type.CarRadio;
import com.fmi.radio.type.HomeRadio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RadioStationDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RadioStationDemoApplication.class, args);
    }

    @Autowired
    CarRadio carRadio;

    @Autowired
    HomeRadio homeRadio;

    @Override
    public void run(String... args) {
        System.out.println("Hello Spring");
//        {
//            RadioStation rockRadioStation = new RadioStation();
//            rockRadioStation.setStationName("Radio 1 Rock");
//            rockRadioStation.setCurrentSong("It's My Life");
//
//            CarRadio carRadioOrdinary = new CarRadio();
//            carRadioOrdinary.setRadioStation(rockRadioStation);
//
//            carRadioOrdinary.listenToRadio();
//        }

        carRadio.listenToRadioInCar();
        homeRadio.listenToRadioAtHome();
    }
}
