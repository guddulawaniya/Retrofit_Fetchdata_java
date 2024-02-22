package com.example.retrofit_fetchdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.viewholder> {
    List<Mymodule> list;
    Context context;

    public myadapter(List<Mymodule> list) {
        this.list = list;
    }





    @NonNull
    @Override
    public myadapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.viewholder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView name,email;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nametext);
            email = itemView.findViewById(R.id.emailtext);
        }
    }
}
