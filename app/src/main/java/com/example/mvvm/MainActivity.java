package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.text.AttributedString;

public class MainActivity extends AppCompatActivity implements com.example.mvvm.View.view {

    public EditText email , password;
    public Button login;


    String getEmail, getPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmail = email.getText().toString();
                getPass = password.getText().toString();

                checkInfo(getEmail , getPass);
            }
        });
    }

    @Override
    public void onError(String error) {

        createToast(error);
    }

    @Override
    public void onSuccess(String message) {

        createToast(message);
    }

    public void checkInfo(String userEmail, String userPass){

        if (userEmail.equals("") || userPass.equals("")){
            onError("Fill the Empty field(s)");
        }else {
            if (userEmail.length() > 8 && userPass.length() > 8){
                onSuccess("WELCOME ...");
                Vm vm = new Vm(userPass , userEmail);
                syncModel(vm);
            }else {
                onError("Email & Password Must Be More Than 8 Characters");
            }
        }
    }

    public void createToast(String message){

        Toast.makeText(this , message , Toast.LENGTH_LONG).show();
    }

    private void syncModel(Vm vm) {

        vm.sendData();
        vm.getData();
    }

}