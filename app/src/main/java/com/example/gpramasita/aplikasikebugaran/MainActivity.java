package com.example.gpramasita.aplikasikebugaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }

    public void calculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
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
}