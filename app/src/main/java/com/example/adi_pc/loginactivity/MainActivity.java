package com.example.adi_pc.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {
    EditText et_username;
    EditText et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(new Parse.Configuration.Builder(MainActivity.this).
                applicationId("whnZVHgGsZXUf03SzsMUrVF7AlHY9flfywCEEl7Q").
                clientKey("JzEi7BuNIzB9oQhz3lUqYwIb4r6sDoqZR4oNNVkq").
                server("https://parseapi.back4app.com/").build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_login = (Button) findViewById(R.id.btn_login);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    @Override
    protected void onResume() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(String.valueOf(et_username.getText()),String.valueOf(et_password.getText()), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}



