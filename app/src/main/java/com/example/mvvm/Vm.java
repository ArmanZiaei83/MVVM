package com.example.mvvm;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.Display;

import androidx.room.Dao;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

public class Vm implements View.ViewModel {

    String password;
    String email;
    Model model = new Model();
    public Vm (String password, String email) {
        this.password = password;
        this.email = email;
    }

    @Override
    public void operate() {

        String [] userInfo = {};

        userInfo[0] = email;
        userInfo[1] = password;

    }

    @Override
    public void sendData() {

        model.setUserEmail(email);
        model.setUserPass(password);
        System.out.println("Sent To Model");

    }

    @Override
    public void getData() {

        System.out.println("Password : " + model.getUserPass());
        System.out.println("Email : " + model.getUserEmail());

    }
}
