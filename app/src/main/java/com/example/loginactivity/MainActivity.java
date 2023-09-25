package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText email_signup, password_signup;
    Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email_signup= (EditText) findViewById(R.id.signup_Email);
        password_signup=(EditText) findViewById(R.id.signup_password);
        signup_btn=(Button) findViewById(R.id.signup_btn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email_signup.getText().toString();
                String password=password_signup.getText().toString();

                if(!isValidPassword(password))
                {
                    Toast.makeText(MainActivity.this,"Password dosen't match!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(MainActivity.this, loginActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });

    }
    Pattern lowerCase = Pattern.compile("^.*[a-z].*$");
    Pattern UpperCase = Pattern.compile("^.*[A-Z].*$");
    Pattern numbers = Pattern.compile("^.*[0-9].*$");
    Pattern spcl_char = Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private Boolean isValidPassword(String password)
    {
        if(password.length()<8)
        {
            return false;
        }
        if(!lowerCase.matcher(password).matches())
        {
            return false;
        }
        if(!UpperCase.matcher(password).matches())
        {
            return false;
        }
        if(!numbers.matcher(password).matches())
        {
            return false;
        }
        if(!spcl_char.matcher(password).matches())
        {
            return false;
        }
        return true;
    }

}