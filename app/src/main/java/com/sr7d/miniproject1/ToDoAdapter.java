package com.sr7d.miniproject1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {
    Context context;
    public ToDoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(context).inflate(R.layout.todo_item_layout,viewGroup,false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder toDoViewHolder, int i) {
        toDoViewHolder.textViewTodoTitle.setText("New ToDo");
        toDoViewHolder.textViewToDoDate.setText("23-Feb-2019");

    }

    @Override
    public int getItemCount() {
        return 1;
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
