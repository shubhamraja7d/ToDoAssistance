package com.sr7d.miniproject1;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView toDoRecyclerView;
    ToDoAdapter toDoAdapter;

    FloatingActionButton toDoAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupRecyclerView();
    }

    private void bindViews() {
        toDoRecyclerView = findViewById(R.id.recycler_view_todo);
        toDoAddBtn = findViewById(R.id.todo_add_btn);
        toDoAddBtn.setOnClickListener(this);
    }

    private void setupRecyclerView() {
        toDoAdapter = new ToDoAdapter(this);
        toDoRecyclerView.setAdapter(toDoAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        toDoRecyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onClick(View v) {

    }
}