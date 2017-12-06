package com.example.gpramasita.aplikasikebugaran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ideal;
    private Button bbmi;
    float bmi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bbmi = (Button) findViewById(R.id.bmi);
        ideal = (Button) findViewById(R.id.ideal);

        bbmi.setOnClickListener(this);
        ideal.setOnClickListener(this);

        Intent intentBMI = this.getIntent();
        bmi = intentBMI.getFloatExtra("bmi", 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bmi:
                Intent b = new Intent(this, InputBMI.class);
                startActivity(b);
                break;
            case R.id.ideal:
                Intent i = new Intent(this, Ideal.class);
                i.putExtra("bmi", bmi);
                startActivity(i);
                break;
        }
    }
}