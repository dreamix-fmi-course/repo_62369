package com.fmi.radio.station;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RadioStation {
    private String stationName = "Default Radio";
    private String currentPlaying = "Default Song";

    public void playStation() {
        System.out.println("Listening to \"" + stationName + "\" and currently playing \"" + currentPlaying + "\"");
    }
}
