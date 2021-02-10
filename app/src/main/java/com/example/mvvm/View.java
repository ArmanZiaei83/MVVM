package com.example.mvvm;

public interface View {

    interface view{

        void onError(String error);
        void onSuccess(String message);
    }

    interface ViewModel{

        void operate();
        void sendData();
        void getData();
    }
}
