package com.example.login1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DiseaseDetailActivity extends AppCompatActivity {
    private static final String EXTRA_DISEASE = "extra_disease";
    private TextView nameTextView;
    private TextView symptomsTextView;
    private TextView remediesTextView;
    private TextView dosAndDontsTextView;


    public static void start(Context context, Disease disease) {
        Intent intent = new Intent(context, DiseaseDetailActivity.class);
        intent.putExtra(EXTRA_DISEASE, disease);
        context.startActivity(intent);
    }

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagnosis_result);

        nameTextView = findViewById(R.id.textViewDiseaseName);
        symptomsTextView = findViewById(R.id.txtsym);
        remediesTextView = findViewById(R.id.txtrmd);
        dosAndDontsTextView = findViewById(R.id.txtdd);


        Disease disease = getIntent().getParcelableExtra(EXTRA_DISEASE);
        if (disease != null) {
            nameTextView.setText(disease.getName());
            symptomsTextView.setText(disease.getSymptoms());
            remediesTextView.setText(disease.getRemedies());
            dosAndDontsTextView.setText(disease.getDosAndDonts());
        }

    }
}

