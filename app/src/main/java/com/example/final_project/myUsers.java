package com.example.final_project;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class myUsers {
    //public static myUsers sUsers;
    private List<User> myUsers;

    private myUsers (Context context){
        myUsers = new ArrayList<>();
    }


    public List<User> getMyUsers() {
        return myUsers;
    }

}

