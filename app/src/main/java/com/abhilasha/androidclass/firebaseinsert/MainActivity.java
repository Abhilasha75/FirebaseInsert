package com.abhilasha.androidclass.firebaseinsert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name,email,phn,pass;
    Button submit;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phn=findViewById(R.id.phone);
        pass=findViewById(R.id.password);
        submit=findViewById(R.id.Submit);

        firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference ref=firebaseDatabase.getReference("data");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString().trim();
                String Email=email.getText().toString().trim();
                String Phone=phn.getText().toString().trim();
                String Pass=pass.getText().toString().trim();

                String ID=ref.push().getKey();                               //getting id

                data d=new data(Name, Email, Phone, Pass);                  //set data to model class named data

               ref.child(ID).setValue(d).addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       if (task.isSuccessful())
                       {
                           Toast.makeText(MainActivity.this, "Database Updated Successfully", Toast.LENGTH_SHORT).show();
                       }

                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e)
                       {
                           Toast.makeText(MainActivity.this, "Error to Update : "+e.getMessage(), Toast.LENGTH_SHORT).show();
                       }

               });

            }
        });
    }

    public void ShowData(View view) {

        startActivity(new Intent(MainActivity.this,GetDataActivity.class));
    }
}