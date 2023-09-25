package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText email_login,password_login;

    Button login_btn;
    int counter=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_login= (EditText) findViewById(R.id.login_Email);
        password_login=(EditText) findViewById(R.id.login_password);
        login_btn = (Button) findViewById(R.id.login_btn);

        String regEmail=getIntent().getStringExtra("email");
        String regPasswd=getIntent().getStringExtra("password");

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email_login.getText().toString();
                String password=password_login.getText().toString();

                if(regEmail.equals(email) && regPasswd.equals(password))
                {
                    Intent intent=new Intent(loginActivity.this,loginSucessfull.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(loginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
                counter--;

                if(counter==0)
                {
                    Toast.makeText(getBaseContext(),"failed to login",Toast.LENGTH_SHORT).show();
                    login_btn.setEnabled(false);
                }
            }
        });
    }
}