package com.example.harshkeshwala.wecareapplication;

import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PatientReportActivity extends AppCompatActivity {

    private Button saveReport;
    private TextInputLayout q1, q2, q3, q4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_report);

        saveReport = (Button) findViewById(R.id.buttonSave);
        saveReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                q1 = findViewById(R.id.q1);
                q2 = findViewById(R.id.q2);
                q3 = findViewById(R.id.q3);
                q4 = findViewById(R.id.q4);


                if (!validateQ1()|!validateQ2()|!validateQ3()|!validateQ4()) {
                    return;
                }

                Toast.makeText(PatientReportActivity.this, "Report Saved.", Toast.LENGTH_LONG).show();
                saveReport.setEnabled(false);
                saveReport.setBackgroundColor(Color.GRAY);
            }


            private boolean validateQ1(){

                String first = q1.getEditText().getText().toString().trim();

                if(first.isEmpty()){
                    q1.setError("Please answer this question!");
                    return false;
                } else {
                    q1.setError(null);
                    return true;
                }
            }

            private boolean validateQ2(){

                String second = q2.getEditText().getText().toString().trim();

                if(second.isEmpty()){
                    q2.setError("Please answer this question!");
                    return false;
                } else {
                    q2.setError(null);
                    return true;
                }
            }

            private boolean validateQ3(){

                String third = q3.getEditText().getText().toString().trim();

                if(third.isEmpty()){
                    q3.setError("Please answer this question!");
                    return false;
                } else {
                    q3.setError(null);
                    return true;
                }
            }

            private boolean validateQ4(){

                String forth = q4.getEditText().getText().toString().trim();

                if(forth.isEmpty()){
                    q4.setError("Please answer this question!");
                    return false;
                } else {
                    q4.setError(null);
                    return true;
                }
            }
        });
    }
}
