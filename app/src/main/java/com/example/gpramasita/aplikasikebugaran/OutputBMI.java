package com.example.gpramasita.aplikasikebugaran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alfintaufiq on 06/12/17.
 */

public class OutputBMI extends AppCompatActivity implements View.OnClickListener {
    private TextView result;
    private Button btHome;
    float bmi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_bmi);

        result = (TextView) findViewById(R.id.result);

        Intent intentDariInput = getIntent();

        String height = intentDariInput.getStringExtra("height");
        String weight = intentDariInput.getStringExtra("weight");

        String weightStr = weight;
        String heightStr = height;

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);

        }

        btHome = (Button) this.findViewById(R.id.btHome);

        btHome.setOnClickListener(this);
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "Sangat Sangat Kurus \n\n Rekomendasi: Perbanyak konsumsi protein hewani dan serat";
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "Sangat Kurus \n\n Rekomendasi: Perbanyak konsumsi protein hewani dan serat";
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "Kurus \n\n Rekomendasi: Perbanyak konsumsi protein hewani dan serat";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "Normal \n\n Rekomendasi: Pertahankan konsumsi protein hewani dan serat";
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "Gemuk \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "Obesitas Tingkat I \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "Obesitas Tingkat II \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
        } else {
            bmiLabel = "Obesitas Tingkat III \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
        }
        bmiLabel = bmi+ "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("bmi", bmi);
        startActivity(i);
    }
}
