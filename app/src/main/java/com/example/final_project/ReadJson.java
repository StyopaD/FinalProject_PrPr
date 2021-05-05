package com.example.final_project;

import android.content.Context;
import android.util.JsonReader;

import com.example.final_project.Discover.DiscoverEvent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class ReadJson {

    public DiscoverEvent ReadJson(int i, Context context){
        Gson gson = new Gson();

        Type listEType = new TypeToken<List<User>>() { }.getType();

        //JsonReader reader = new JsonReader(new FileReader("assets/json"+i+".json"));

        DiscoverEvent event = gson.fromJson(getJsonFromAssets(context,"json"+i+".json"), DiscoverEvent.class);
        return  event;
        //Saving the values of the Json file in the attributes of each of the corresponding classes.
    }

    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
}
