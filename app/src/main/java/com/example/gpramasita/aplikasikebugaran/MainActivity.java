package com.example.gpramasita.aplikasikebugaran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText height;
    private EditText weight;
    private Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        hitung = (Button) findViewById(R.id.calc);

        hitung.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, OutputBMI.class);

        i.putExtra("height", height.getText().toString());
        i.putExtra("weight", weight.getText().toString());

        startActivity(i);
    }
}