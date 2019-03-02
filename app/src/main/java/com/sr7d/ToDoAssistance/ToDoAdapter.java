package com.sr7d.ToDoAssistance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {
    Context context;
    List<ToDo> todos;
    public ToDoAdapter(Context context, List<ToDo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(context).inflate(R.layout.todo_item_layout,viewGroup,false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder toDoViewHolder, int i) {
        toDoViewHolder.textViewTodoTitle.setText(todos.get(i).getTitle());
        toDoViewHolder.textViewToDoDate.setText(todos.get(i).getDate());

    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTodoTitle, textViewToDoDate;
        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTodoTitle = itemView.findViewById(R.id.text_view_todo_title);
            textViewToDoDate = itemView.findViewById(R.id.text_view_todo_date);

        }
    }
}
