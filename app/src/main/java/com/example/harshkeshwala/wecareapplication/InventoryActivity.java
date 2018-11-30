package com.example.harshkeshwala.wecareapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InventoryActivity extends AppCompatActivity {

    private Button request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);


        request = (Button) findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InventoryActivity.this, "Requested to prepare an order.", Toast.LENGTH_LONG).show();
                request.setEnabled(false);
                request.setBackgroundColor(Color.GRAY);
            }
        });
    }
}
