package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class herb2 extends AppCompatActivity {

    TextView p_name,p_des;
    ImageView my_img;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herb2);

        p_name=findViewById(R.id.pname);
        p_des=findViewById(R.id.des);
        my_img=findViewById(R.id.img);


        p_name.setText(getIntent().getExtras().getString("Plant_Name"));
        p_des.setText(getIntent().getExtras().getString("P_des"));

        int my_int_img=getIntent().getIntExtra("Image",0);
        my_img.setImageResource(my_int_img);
    }
}