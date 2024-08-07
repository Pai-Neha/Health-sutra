package com.example.login1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login1.products.ProductAdapter;
import com.example.login1.products.ProductModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Activity_hair extends AppCompatActivity {

    RecyclerView diogrec;
    FirebaseFirestore db;

    List<Disease> diseaseList;
    DiseaseAdapter diseaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_hair);

        getWindow().setStatusBarColor(ContextCompat.getColor(Activity_hair.this, R.color.black));
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#39a9e87c"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle("Hair Disease");

        db = FirebaseFirestore.getInstance();
        diogrec = findViewById(R.id.hrecyclerView);
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
                            Toast.makeText(Activity_hair.this, "Error" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

