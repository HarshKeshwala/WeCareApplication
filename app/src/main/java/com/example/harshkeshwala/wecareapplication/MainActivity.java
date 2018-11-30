package com.example.harshkeshwala.wecareapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;

    private EditText userNameEditText;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textInputUsername = findViewById(R.id.editTextUsername);
                textInputPassword = findViewById(R.id.editTextPassword);


                if (!validateUsername() | !validatePassword()) {
                    return;
                }

                userNameEditText = (EditText) findViewById(R.id.userNameEditText);
                String name = userNameEditText.getText().toString();


                SharedPreferences.Editor editor = getSharedPreferences("Name", MODE_PRIVATE).edit();
                editor.putString("uname", name);
                editor.apply();

                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
               // i.putExtra("name",name);
                startActivity(i);
            }
        });
    }

    private boolean validateUsername(){

        String inputUsername = textInputUsername.getEditText().getText().toString().trim();

        if(inputUsername.isEmpty()){
            textInputUsername.setError("Please enter email!");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){

        String inputUsername = textInputPassword.getEditText().getText().toString().trim();

        if(inputUsername.isEmpty()){
            textInputPassword.setError("Please enter password!");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }
}
