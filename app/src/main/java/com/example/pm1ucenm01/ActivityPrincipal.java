package com.example.pm1ucenm01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityPrincipal extends AppCompatActivity {

    Button btnadd, btnspinner, btnlista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnspinner = (Button) findViewById(R.id.btnspinner);
        btnlista  = (Button) findViewById(R.id.btnlista);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        btnspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ActivitySpinner.class);
                startActivity(intent);

            }
        });


        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intent);

            }
        });
    }
}