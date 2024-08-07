package com.example.login1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Activity_digestive extends AppCompatActivity {

    RecyclerView diogrec;
    FirebaseFirestore db;

    List<Disease> diseaseList;
    DiseaseAdapter diseaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_digestive);

        getWindow().setStatusBarColor(ContextCompat.getColor(Activity_digestive.this, R.color.black));
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#39a9e87c"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle("Digestive Disease");

        db = FirebaseFirestore.getInstance();
        diogrec = findViewById(R.id.drecyclerView);
        diogrec.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        diseaseList = new ArrayList<>();
        diseaseAdapter = new DiseaseAdapter(this, diseaseList);
        diogrec.setAdapter(diseaseAdapter);
        db.collection("Skin")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Disease disease = document.toObject(Disease.class);
                                diseaseList.add(disease);
                                diseaseAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(Activity_digestive.this, "Error" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

