package com.sr7d.ToDoAssistance;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView toDoRecyclerView;
    ToDoAdapter toDoAdapter;

    FloatingActionButton toDoAddBtn;
    List<ToDo> allTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        getAllTodos();
//        setupRecyclerView();
    }

    private void bindViews() {
        toDoRecyclerView = findViewById(R.id.recycler_view_todo);
        toDoAddBtn = findViewById(R.id.todo_add_btn);
        toDoAddBtn.setOnClickListener(this);
    }

    private void setupRecyclerView() {
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "ToDo").build();

        toDoAdapter = new ToDoAdapter(this, allTask);
        toDoRecyclerView.setAdapter(toDoAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        toDoRecyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "ToDo").build();

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                ToDo td = new ToDo();
                td.setTitle("Learn Aptitude");
                td.setDate("25-feb, 2019");
                db.toDoDao().insert(td);

                allTask = db.toDoDao().getAll();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                toDoAdapter.notifyDataSetChanged();
            }
        }
//        Date date = new Date("DD/MM/YYYY");

        Toast.makeText(this, "ToDO Added", Toast.LENGTH_SHORT).show();
        SaveTask st = new SaveTask();
        st.execute();
    }

    public void getAllTodos(){
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "ToDo").build();

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                allTask = db.toDoDao().getAll();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                setupRecyclerView();
//                toDoAdapter.notifyDataSetChanged();

            }
        }

        SaveTask st = new SaveTask();
        st.execute();

    }

}