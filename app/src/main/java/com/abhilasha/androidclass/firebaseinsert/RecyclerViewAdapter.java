package com.abhilasha.androidclass.firebaseinsert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    ArrayList<data> list;
    Context context;

    public RecyclerViewAdapter(ArrayList<data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());
        holder.phn.setText(list.get(position).getPhn());
        holder.pass.setText(list.get(position).getPassword());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView name,email,phn,pass;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.cs_name);
            email=itemView.findViewById(R.id.cs_mail);
            phn=itemView.findViewById(R.id.cs_phn);
            pass=itemView.findViewById(R.id.cs_pass);
        }
    }
}
