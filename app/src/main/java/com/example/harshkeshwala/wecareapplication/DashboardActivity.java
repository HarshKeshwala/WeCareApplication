package com.example.harshkeshwala.wecareapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DashboardActivity extends AppCompatActivity {

    private TextView userTextView;
    private TextView dateTextView;

    private Button buttonTasks, buttonSchedule, buttonInventory, buttonReport;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_settings was selected
            case R.id.action_signout:

                Intent i = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(this, "Signed out!", Toast.LENGTH_LONG).show();
                break;
            default:
        }

        return true;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //final Intent i = getIntent();

        //String user = i.getStringExtra("name");

        SharedPreferences prefs = getSharedPreferences("Name", MODE_PRIVATE);
        String user = prefs.getString("uname", "");

        userTextView = (TextView) findViewById(R.id.userTextView);
        userTextView.setText("Hello, "+user+"!");


        dateTextView = (TextView) findViewById(R.id.dateTextView);
        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String date = df.format(c.getTime());

        dateTextView.setText("Date: "+date);


        buttonTasks = (Button) findViewById(R.id.buttonTasks);

        buttonTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this, TasksActivity.class);
                startActivity(intent);
            }
        });

        buttonSchedule = (Button) findViewById(R.id.buttonSchedule);
        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });


        buttonInventory = (Button) findViewById(R.id.buttonInventory);
        buttonInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                startActivity(intent);
            }
        });

        buttonReport = (Button) findViewById(R.id.buttonReport);
        buttonReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this, PatientReportActivity.class);
                startActivity(intent);
            }
        });
    }
}
