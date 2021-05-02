package com.abhilasha.androidclass.firebaseinsert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GetDataActivity extends AppCompatActivity {

    RecyclerView rv_data;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<data> list;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        rv_data=(RecyclerView)findViewById(R.id.rv_data);
        list= new ArrayList<>();

        rv_data.setLayoutManager(new LinearLayoutManager(this));


        firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference ref=firebaseDatabase.getReference("data");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    data d = dataSnapshot.getValue(data.class);
                    list.add(d);
                }
                recyclerViewAdapter=new RecyclerViewAdapter(list, GetDataActivity.this);
                rv_data.setAdapter(recyclerViewAdapter);
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(GetDataActivity.this, "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}