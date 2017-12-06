package com.example.gpramasita.aplikasikebugaran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alfintaufiq on 07/12/17.
 */

public class HasilIdeal extends AppCompatActivity implements View.OnClickListener {
    private TextView result;
    private String idealLabel = "";
    private Button btHome;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_ideal);
        Intent dariIdeal = getIntent();
        float ideal = dariIdeal.getFloatExtra("ideal", 0);

        result = (TextView) findViewById(R.id.result);

        idealLabel = "Berat ideal anda adalah " + ideal + " kg";
        result.setText(idealLabel);

        btHome = (Button) this.findViewById(R.id.btHome);

        btHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);

        startActivity(i);
    }
}
