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

public class SkinActivity extends AppCompatActivity implements OnDiseaseClickListener,SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private DiseaseAdapter adapter;
    private ArrayList<Disease> diseaseList;
    private SearchView searchView;
    private ArrayList<Disease> filteredList;

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_skin);

        searchView = findViewById(R.id.ssearchView);
        recyclerView = findViewById(R.id.srecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        diseaseList = new ArrayList<>();
        filteredList = new ArrayList<>();

        diseaseList.add(new Disease("Acne-यौवनपीड़का(Yauvanapidika)", "-In young adults, Blackheads to puss filled pimples or large, red, tender bumps.", "-Apply the paste of turmeric with milk over acne, wash your face after 20min.\n-Apply the paste of Red Sandalwood over acne, wash after 20min.\n-Application of Maragosa leaves paste over acne, wash it after 20min.\n-Apply the pulp of Alovera all over the face before sleeping, wash it off in the morning.", "Do's:-\n-Take light food.\n-Have lots of fruits and salads.\n-Drink plenty of water.\n-Wash face frequently with warm water.\n-Adequate sleep.\nDon'ts:-\n-Avoid non-vegetarian and junk foods.\n-Avoid oil and fried food.\n-Avoid touching the pimple.\n-Reduce stress.\n-Decrease the use of Black gram.\n\n\nNOTE:- If condition is severe, frequent and many lesions over the face, with extreme pain and pus filled requires medical consultation"));
        diseaseList.add(new Disease("Atopic dermatitis-विचर्चिका(Vichaechika),Eczema", "-Lesions which are associated with itching, swelling,exudation.\n-Skin changes its color and cracks.\n-Can be caused by allergens, irritants.", "-Apply the paste of Maragosa over lesions, wash it after 10min\n-Washing the lesions with water boiled with Maragosa leaves\n-Application of Alovera gel\n-Intake of Maragosa leaves", "Do's:-\n-Take light food\n-Intake Ghee and Butter\nEat Green gram, wheat\nEat Bitter vegetables\nDon't:-\n-Peeling garlic and onion\n-Cutting lady's finger\n-Avoid alcohol intake\n-Don't use Milk or Fermented Milk products or Fermented food\n-Avoid eating salt and sour items, oily and fried food\n\n\nNOTE:-Usually needs medical diagnosis and needs medical assistance even in initial stages."));
        diseaseList.add(new Disease("Contact dermatitis-उदर्द(Udarda)", "-Allergic reaction of skin towards certain allergens that come in direct contact with it(like detergents,lotions,preservative...)\n-Pricky and rashes,itching, burning sensation\n-Sking become dry or rough or turns red.", "-Apply paste of Maragosa leaves over rashes, wash it after 20min\n-Washing the lesions with water boiled with Maragosa leaves\n-Take 3 pinch of turmeric with hot water daily.", "Do's:-\n-Maintain personal hygiene\n-Identify the allergens and avoid the exposure\nAdequate sleep\nTake easily digestable food\nVegetarian dite will less oil.\nDon'ts:-\n-Avoid egg, red chilly, oily food\n-Avoid using chemical based lotions,soups\nAvoid day sleep\nAvoid fermented foods.\n\n\nNOTE:-Requires medical diagnosis and assistance even in initial stages."));
        diseaseList.add(new Disease("Ringworm-दद्रु(Dadru), Tinea", "-Skin dryness, itching,scaly(skin may peel like flakes)\n-Lesions are round, reddish, elevated in borders, spreads easily\n-Lesions are common in armpits,groin area,abdomen(Usually in swetting areas)\n", "-Apply the juice of Holy Basil mixed with 1 pinch of salt and wash it after 10-15min\n-Apply the paste of Maragosa leaves over the lesion and wash it after 15-20min\n-Intake the leaves or jiuce of Maragosa daily\n-Use Maragosa leaves boild water for bathing.", "Do's:-\n--Maintain personal hygiene\n-Wash cloths with dettol and hot water\n-Use loose fitting,dried cloths\n-Drink warm water and take light food\nDon'ts:-\n-Avoid milk, fish, curd, sweet, excessive salty items\nAvoid fermented or oily or fried food\nDon't suppress urges\nAvoid sleeping in day.\n\n\nNOTE:-Requires medical diagnosis and assistance even in initial stages."));
        diseaseList.add(new Disease("Candidiasis Rosacea-चर्मदाल(Charmadala)", "-Small,pus filled, swollen bumps over skin\n-Tender, hot facial skin\n-Redness especially in central part of face\n-Dry,irritated swollen eyelids.", "-Apply Alovera pulp over the affected area\nApply Sandalwood paste over skin and wash it off after 20min\nApply Ghee over affected area", "Do's:-\n-Light vegetarian food\n-Follow personal hygine\n-Drink plenty of water\n-Low carbohydrates\n-Wash face oftenly.\n\n\nDon't:-\n-Avoid exposure to sun\n-Avoid extreme weather,wind\n-Avoid yogurt,curd,fermented food\n-Avoid jaggery,chocolates\n-Avoid non-veg food especially fish,Oily food.\n\n\nNOTE:-Requires medical diagnosis and assistance even in initial stages."));
        diseaseList.add(new Disease("Urticaria-शीतपित्त(Sheetapitta)", "-Skin rash triggered by a reaction to food,medicine or other irritants\n-Itching\n-Reddish rashes,swelling", "-Wash it with hot water\n-1 tsp turmeric with 1 tsp of Durva juice mix and apply over the lesions, wash it off after 10min\n-Intake 1 tsp of turmeric with hot water(1 cup)-Daily once\n-Apply the paste of margosa over lesions, wash it after 20min.", "Do's:-\n-Consume old grains\n-Use bitter gourd, gooseberry, green gram\n-Drink hot water\n-Bath daily with hot water\n-Daily exercise,sleep adequate\n\n\nDon'ts:--Don't consume oily,fried,fermented food\n-Avoid excess sour or spicy food\n-Avoid dairy products\n-Avoid alcohol,cold beverages.\n\n\nNOTE:-Requires medical diagnosis and assistance even in initial stages."));

        adapter = new DiseaseAdapter(diseaseList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search here");

        diseaseList = new ArrayList<>(diseaseList);
        filteredList.addAll(diseaseList);
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
            for (Disease disease:diseaseList){
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
