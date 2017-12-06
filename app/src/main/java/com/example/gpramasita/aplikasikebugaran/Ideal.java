package com.example.gpramasita.aplikasikebugaran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by alfintaufiq on 06/12/17.
 */

public class Ideal extends AppCompatActivity implements View.OnClickListener {
    private EditText height;
    private TextView result;
    private String idealLabel = "";
    private Button calc;
    private RadioButton rbPria;
    private RadioButton rbWanita;
    private RadioGroup rgGender;
    private RadioButton rbTerpilih;
    private String gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ideal);

        height = (EditText) findViewById(R.id.height);
        result = (TextView) findViewById(R.id.result);
        calc = (Button) findViewById(R.id.calc);
        rbPria = (RadioButton) findViewById(R.id.rbpria);
        rbWanita = (RadioButton) findViewById(R.id.rbWanita);
        rgGender = (RadioGroup) findViewById(R.id.rgGender);

        calc.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent dariMain = getIntent();
        float bmi = dariMain.getFloatExtra("bmi", 0);

        String heightStr = height.getText().toString();
        if (heightStr != null && !"".equals(heightStr)
                && bmi != 0  &&  !"".equals(bmi)) {
            float heightValue = Float.parseFloat(heightStr);
            float bmii = bmi;
            float ideal = 0;
            int selectedId = rgGender.getCheckedRadioButtonId();

                this.rbTerpilih = (RadioButton) findViewById(selectedId);
//            gender = this.rbTerpilih.getText().toString();

            if (rbPria.isChecked()){
                ideal = (heightValue - 100) - (((heightValue - 100)/100) * 10);
            }else if(rbWanita.isChecked()){
                ideal = (heightValue - 100) - (((heightValue - 100)/100) * 15);
            }
            Intent i = new Intent(this, HasilIdeal.class);

            i.putExtra("ideal", ideal);


            startActivity(i);


//            float ideal = (heightValue - 100) - (((heightValue - 100)/100) * 10);
//
//            idealLabel = "berat ideal anda adalah " + ideal + " kg";
//            result.setText(idealLabel);
        }
    }

//    public void calculateIdeal(View v) {
//        String nama = intentDariInput.getStringExtra("nama");
//        String heightStr = height.getText().toString();
//        String weightStr = weight.getText().toString();
//
//        if (heightStr != null && !"".equals(heightStr)
//                && weightStr != null  &&  !"".equals(weightStr)) {
//            float heightValue = Float.parseFloat(heightStr) / 100;
//            float weightValue = Float.parseFloat(weightStr);
//
//            float ideal = weightValue / (heightValue * heightValue);
//
//            displayIdeal(ideal);
//        }
//    }



//        private void displayIdeal(float ideal) {
//            String bmiLabel = "";
//
//            if (Float.compare(ideal, 15f) <= 0) {
//                bmiLabel = "Sangat Sangat Kurus \n\n Rekomendasi: Perbanyak konsumsi protein hewani dan serat";
//            } else if (Float.compare(ideal, 15f) > 0  &&  Float.compare(ideal, 16f) <= 0) {
//                bmiLabel = "Sangat Kurus \n\n Rekomendasi: Perbanyak konsumsi protein hewani dan serat";
//            } else if (Float.compare(ideal, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
//                bmiLabel = "Kurus \n\n Rekomendasi: Perbanyak konsumsi protein hewani dan serat";
//            } else if (Float.compare(ideal, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
//                bmiLabel = "Normal \n\n Rekomendasi: Pertahankan konsumsi protein hewani dan serat";
//            } else if (Float.compare(ideal, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
//                bmiLabel = "Gemuk \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
//            } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
//                bmiLabel = "Obesitas Tingkat I \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
//            } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
//                bmiLabel = "Obesitas Tingkat II \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
//            } else {
//                bmiLabel = "Obesitas Tingkat III \n\n Rekomendasi: Kurangi konsumsi protein hewani dan perbanyak serat";
//            }

//            bmiLabel = "berat ideal anda adalah "ideal+ " kg";
//            result.setText(bmiLabel);
//        }
}
