package com.example.final_project.Discover;

import android.content.Context;

import com.example.final_project.ReadJson;

import java.util.ArrayList;

public class DiscoverLab {

    private static final String[] arrayEvents =
            {"ART", "BASKETBALL", "CINEMA", "BEACH", "CONCERT", "COOKING", "CYCLING", "DINER",
                    "PARTY", "GYM", "HIKING", "STAND-UP", "KAYAK", "MARTIAL ART", "MUSIC", "PICNIC",
                    "READING", "RUNNING", "SHOPPING", "SOCIALIZE", "TOURISM"};
    private static DiscoverLab discoverLab;
    private final ArrayList<DiscoverEvent> discoverList = new ArrayList<DiscoverEvent>();


    public static DiscoverLab getInstance(Context context){
        if(discoverLab == null){
            discoverLab = new DiscoverLab(context);
        }
        return discoverLab;
    }
    private DiscoverLab(Context context){
        for(int j = 0; j< 35;j++) {

            for (int i = 4; i < 6; i++) {
                //DiscoverEvent dE = new ReadJson().ReadJson(1);
                DiscoverEvent dE = new DiscoverEvent(arrayEvents[i]);
                discoverList.add(dE);
            }
            for (int i = 6; i < 21; i++) {
                //DiscoverEvent dE = new ReadJson().ReadJson(1);
                DiscoverEvent dE = new DiscoverEvent(arrayEvents[i]);
                discoverList.add(dE);
            }/*
            for (int i = 0; i < 21; i++) {
                //DiscoverEvent dE = new ReadJson().ReadJson(1);
                DiscoverEvent dE = new DiscoverEvent(arrayEvents[1]);
                discoverList.add(dE);
            }
            for (int i = 0; i < 21; i++) {
                //DiscoverEvent dE = new ReadJson().ReadJson(1);
                DiscoverEvent dE = new DiscoverEvent(arrayEvents[0]);
                discoverList.add(dE);
            }*/
        }
    }

    public ArrayList<DiscoverEvent> getDiscoverList() {
        return discoverList;
    }
}
