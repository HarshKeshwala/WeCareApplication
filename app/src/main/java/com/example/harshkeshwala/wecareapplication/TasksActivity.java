package com.example.harshkeshwala.wecareapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TasksActivity extends AppCompatActivity {


    private TextView taskHeader;
    private ListView tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        taskHeader = (TextView) findViewById(R.id.tasksHeader);
        taskHeader.setText("Today's Tasks");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tasks, android.R.layout.simple_list_item_1);

        tasksList = (ListView) findViewById(R.id.tasksList);
        tasksList.setAdapter(adapter);

    }
}
