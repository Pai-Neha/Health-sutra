package com.example.login1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

public class GeneralActivity extends AppCompatActivity implements OnDiseaseClickListener,SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private DiseaseAdapter adapter;
    private ArrayList<Disease> diseaseList;
    private SearchView searchView;
    private ArrayList<Disease> filteredList;


    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_general);

        searchView = findViewById(R.id.gsearchView);
        recyclerView = findViewById(R.id.grecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        diseaseList = new ArrayList<>();
        filteredList = new ArrayList<>();

        diseaseList.add(new Disease("Disease 1", "Symptoms 1", "Remedies 1", "Do's and Don'ts 1"));
        diseaseList.add(new Disease("Disease 2", "Symptoms 2", "Remedies 2", "Do's and Don'ts 2"));

        adapter = new DiseaseAdapter(diseaseList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search here");

        diseaseList = new ArrayList<>(diseaseList);
        filteredList.addAll(diseaseList);
    }

    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    public boolean onQueryTextChange(String newText) {
        filteredList.clear();
        if (newText.isEmpty()) {
            filteredList.addAll(diseaseList);
        } else {
            String searchQuery = newText.toLowerCase();
            for (Disease disease:diseaseList){
                if (disease.getName().toLowerCase().contains(searchQuery)) {
                    filteredList.add(disease);
                }
            }
        }

        adapter.setFilteredList(filteredList);
        return true;
    }

    public void onDiseaseClick(Disease disease) {
        DiseaseDetailActivity.start(this, disease);
    }
}
