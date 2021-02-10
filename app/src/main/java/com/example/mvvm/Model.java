package com.example.mvvm;

import android.util.Log;

public class Model {

    String userPass;
    String userEmail;

    public String getUserPass() {
        return userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
