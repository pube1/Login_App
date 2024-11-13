package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Integer rights=6;
    EditText usernameTxt;
    EditText passwordTxt;

    String username="Admin";
    String password="1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        usernameTxt=findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
    }


    public void btnClick(View view) {
        
        if (rights<=0)
        {
            rights=0;
            Toast.makeText(this, "Unfortunately, you have no rights left and cannot log in.", Toast.LENGTH_SHORT).show();
        }

        else {
            if (username.equals(usernameTxt.getText().toString()) && password.equals(passwordTxt.getText().toString()))
            {
                Toast.makeText(this, "You are logged successful", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getBaseContext(), mainMenu.class);
                startActivity(intent);
            }

            else
            {

                rights--;
                Toast.makeText(this, "Your username or password is incorrect, your remaining rights are:" + rights, Toast.LENGTH_SHORT).show();
            }
        }

        
    }
}