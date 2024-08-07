package com.example.login1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class table extends AppCompatActivity {

    RecyclerView myrecycler_view;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herb_book);

        //status bar
        getWindow().setStatusBarColor(ContextCompat.getColor(table.this, R.color.black));

//action bar color d4f0b6   0d6941
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#176639"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'><b><i>HealthSutra</i></b> </font>"));

        //model
        table_model[]my_data=new table_model[]{
                new table_model("Ashoka Tree","Its parts are used in pain for local applications.\nIt is usefull in diarrhoea(taken its stem bark juice).\nIt is useful in strengthning uterus muscels,Its delocation decreases the pain in mensus.\n"
                        ,"अशोक (Ashoka)","ಅಶೋಕ,Ashoka","Saraca indica",
                        "Caesalpinacea","Stem bark, Seeds, Flowers",R.drawable.ashoka_tree),

                new table_model("Black Pepper","Application of pepper paste reduces pain.\nStimulates digestive juice, increase appetite.\nPepper given with honey and ghee cures cough\n",
                        "मरीच (Maricha)","ಕಾಳುಮೆಣಸು(ಕರಿಮೆಣಸು,ಒಳ್ಳೆಮೆಣಸು),Balck pepper,काली मिर्ची(Kali mirch)",
                        " Piper nigrum","Piperaceae","Fruit ",R.drawable.balck_pepper),

                new table_model("Cardamom","Oil of cardamom seeds used in tooth ache.\nActs as mouth freshner.\nWhole cardamom burnt in charcol- Increases appetite.\n",
                        "एला (Ela)","ಏಲಕ್ಕಿ,Cardamom,इलायची"," Elettaria cardamomum",
                        "Scitaminea","Seeds ",R.drawable.cardamom),

                new table_model("Garlic","Garlic paste applied cures swelling.\n" +
                        "Intake og garlic increases digestion." +
                        "\nIntake of garlic reduces fever.\n",
                        "लशुन (Leshuna)","ೆಳ್ಳುಳ್ಳಿ,Garlic,लहसुन(Lahsun)"," Allium satium",
                        "Liliaceae"," Rhizome ",R.drawable.garlic),

                new table_model("Ginger","Ginger with milk cures rhinitis.\n" +
                        "Extract of ginger given with honey cures cold." +
                        "\nPaste of ginger if applied to the forehead cures headache.\n",
                        " शुण्ठी /आर्द्रक  (Shunti/Ardraka)","Ginger, ಶುಂಠಿ, सोंठ(Sonth)","Zinziber officinale",
                        "Zinziberaceae"," Rhizome ",R.drawable.ginger),

                new table_model("Indian Basil","Paste of leaves application cures Chronic ulcers.\n" +
                        "Juice intake increase appetite." +
                        "\nGood home remedy for fever, cold, cough.\n",
                        " तुलसी (Tulasi)","ತುಳಸಿ,Holy Basil,Indian Basil"," Ocimum sanctum",
                        "Ocimum sanctum ","Leaf, Seed, Whole palnt ",R.drawable.indian_basil),

                new table_model("Indian Gooseberry","Juice of Indian Gooseberry increases immunity.\n" +
                        "Its powder boiled with milk and taken with ghee cures cough." +
                        "\nIts paste when applied locally cures burning sensation.\n",
                        " आमलकी (Amalaki)","ನೆಲ್ಲಿಕಾಯಿ, Indian Gooseberry, आंवला(Avala)"," Phyllanthus emblica/Emblica officinalis",
                        "Euphorbiaceae ","Fruit/Fruit pulp ",R.drawable.indian_gooseberry),


                /*







                new

                new Data_Model_herb("Indian Pennywort","Sanskrit name:मण्डूकपर्णी (Mandukaparni )\n"+"\n"+
                        "Vernacular Names:ಒಂದೆಲಗ ,Indian pennywoetब्राह्मी (Brahmi)\n"+"\n"+
                        "Botanical Name:Centella asiatica \n"+"\n"+
                        "Family:Umbelliferae  \n"+"\n"+
                        "Part Used: Whole plant \n"+"\n"+
                        "Therapeutic Uses:  \n" +
                        "\t\t\t\t-\t\tIt is beneficial to intellect ,enhances memory\n"+
                        "\t\t\t\t-\t\t It increases appetite\n"+
                        "\t\t\t\t-\t\tIt has wound cleaning and healing property and it's part can be applied externally in wound\n",R.drawable.indian_pennywort),

                new Data_Model_herb("Long Pepper","Sanskrit name:पिप्पलि(pippali)\n"+"\n"+
                        "Vernacular Names:ಹಿಪ್ಪಲಿ,long pepper,पिपली(pipali)\n"+"\n"+
                        "Botanical Name:Piper Longum\n"+"\n"+
                        "Family:Piperaceae   \n"+"\n"+
                        "Part Used:Fruit,root \n \n"+"\n"+
                        "Therapeutic Uses:  \n" +
                        "\t\t\t\t-\t\tCures swelling and pain when applied externally\n\n"+
                        "\t\t\t\t-\t\tIncreases appetite and cures anemia \n"+
                        "\t\t\t\t-\t\tCures fever when given with jaggery\n",R.drawable.long_pepper),

                new Data_Model_herb("Maragosa Tree","Sanskrit name:निम्बा(Nimba)\n\n"+"\n"+
                        "Vernacular Names:ಕಹಿಬೇವು,Margosa ,नीम्(Neem)\n"+"\n"+
                        "Botanical Name:Azardichta indica\n"+"\n"+
                        "Family:Meliaceae \n"+"\n"+
                        "Part Used:Leaves ,bark ,seed,oil \n"+"\n"+
                        "Therapeutic Uses:  \n" +
                        "\t\t\t\t-\t\tExternal application of paste of leaves cures burning sensation and itchy \n"+
                        "\t\t\t\t-\t\tIntake of leaves - cures intestinal worms \n"+
                        "\t\t\t\t-\t\tBark decoction with honey cures vomiting,anorexio\n",R.drawable.margosa_tree),

                new Data_Model_herb("Pomogranet","Sanskrit name:दाडिम(Dadima)\n"+"\n"+
                        "Vernacular Names:ದಾಳಿಂಬೆ, pomogranate,अनार(Anār)\n"+"\n"+
                        "Botanical Name:Punica granatum\n"+"\n"+
                        "Family:Punicaceae\n"+"\n"+
                        "Part Used:Fruit,fruit rind,root,bark ,floral bud\n"+"\n"+
                        "Therapeutic Uses:  \n" +
                        "\t\t\t\t-\t\tDecoction of bark used to gargle in oral diseases and ulcers\n"+
                        "\t\t\t\t-\t\tFruit cures anemia\n"+
                        "\t\t\t\t-\t\tFruit decreases mental debility \n"+
                        "\t\t\t\t-\t\tFruit increases appetite , decreases thirst \n"+
                        "\t\t\t\t-\t\tRoot bark decoction can be used to cure diarrhoea\n",R.drawable.pomegranate),

                new Data_Model_herb("Sandalwood","Sanskrit name:चन्दन (chandana)\n"+"\n"+
                        "Vernacular Names:ಗಂಧ, sandalwood,सफ़ेद हल्दी (safed haldi)\n"+"\n"+
                        "Botanical Name:Sanralum album \n"+"\n"+
                        "Family:Santalaceae\n"+"\n"+
                        "Part Used:Heart wood ,volatile oil\n"+"\n"+
                        "Therapeutic Uses:  \n" +
                        "\t\t\t\t-\t\tIts paste application enhances complexion\n"+
                        "\t\t\t\t-\t\tBurning sensation decreases by application of its paste \n"+
                        "\t\t\t\t-\t\tIts oil can be used for application in fever associated with burning sensation\n",R.drawable.sandalwood),

                new Data_Model_herb("Sweet Flag","Sanskrit name:वाच (Vacha)\n"+"\n"+
                        "Vernacular Names:ಬಜೆ,sweet flag ,वाच(vacha)\n"+"\n"+
                        "Botanical Name:Acorns calamus \n"+"\n"+
                        "Family:Araceae\n"+"\n"+
                        "Part Used:Leaves, rhizomes and stems\n"+"\n"+
                        "Therapeutic Uses:  \n" +
                        "\t\t\t\t-\t\tApplication of its paste decreases pain\n"+
                        "\t\t\t\t-\t\tReduces abdominal pain - if internally given\n"+
                        "\t\t\t\t-\t\tExtensively used in cough ,asthama\n",R.drawable.sweet_flag),

                new Data_Model_herb("Turmeric","Sanskrit name:हरिद्रा(Haridara)\n"+"\n"+
                        "Vernacular Names:ಅರಿಶಿನ,Turmeric ,हल्दी(haldi)\n"+"\n"+
                        "Botanical Name:Curcuma longa\n"+"\n"+
                        "Family:Zinzeberaceae\n"+"\n"+
                        "Part Used:Rhizome \n"+"\n"+
                        "Therapeutic Uses:  \n" +
                        "\t\t\t\t-\t\tTurmeric with milk is applied to face , enhances complexion\n"+
                        "\t\t\t\t-\t\tTurmeric paste when applied to insect bite area act as antidote\n"+
                        "\t\t\t\t-\t\tTurmeric with milk cures cough throat infection\n",R.drawable.turmeric),*/


        };
        myrecycler_view=findViewById(R.id.recycler_view);
        table_Adapter myadapter=new table_Adapter(my_data);

        myrecycler_view.setLayoutManager(new LinearLayoutManager(this));
        myrecycler_view.setAdapter(myadapter);
    }

    private void filter(String newText) {
        List<table_model> filteredList=new ArrayList<>();
    }




}
