package com.example.login1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//userlist to show in recycler view

public class DigestiveActivity extends AppCompatActivity implements OnDiseaseClickListener,SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private DiseaseAdapter adapter;
    private ArrayList<Disease> diseaseList;
    private SearchView searchView;
    private ArrayList<Disease> filteredList;

    //inside - after recycler view click
    String selectedCategory = "general";
    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference().child(selectedCategory);

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_digestive);

        searchView = findViewById(R.id.dsearchView);
        recyclerView = findViewById(R.id.drecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        diseaseList = new ArrayList<>();
        filteredList = new ArrayList<>();

      //  diseaseList.add(new Disease("Digestive 1", "Symptoms 1", "Remedies 1", "Do's and Don'ts 1"));
        //diseaseList.add(new Disease("Digestive 2", "Symptoms 2", "Remedies 2", "Do's and Don'ts 2"));

        adapter = new DiseaseAdapter(diseaseList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search here");

        diseaseList = new ArrayList<>(diseaseList);
        filteredList.addAll(diseaseList);

        /*databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Disease> categoryList = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Disease category = snapshot.getValue(Disease.class);
                    categoryList.add(category);
                }

                // Pass the categoryList to your adapter and notify the adapter that the data has changed
               DiseaseAdapter.setData(categoryList);
            }*/

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        filteredList.clear();
        if (newText.isEmpty()) {
            filteredList.addAll(diseaseList);
        } else {
            String searchQuery = newText.toLowerCase();
            for(Disease disease:diseaseList){
                if (disease.getName().toLowerCase().contains(searchQuery)) {
                    filteredList.add(disease);
                }
            }
        }

        adapter.setFilteredList(filteredList);
        return true;
    }



    @Override
    public void onDiseaseClick(Disease disease) {
        DiseaseDetailActivity.start(this, disease);
    }
}

