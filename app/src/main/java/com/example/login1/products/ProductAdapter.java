package com.example.login1.products;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.login1.R;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;

import java.util.List;

//this class is only for the 1st slider recycler view
//for each catogery ( hair , skin etc) different adapter class should be created
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<ProductModel>productModelList;

    public ProductAdapter(Context context, List<ProductModel> productModelList) {
        this.context = context;
        this.productModelList = productModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(productModelList.get(position).getImg_url()).into(holder.prodImg);
        holder.name.setText(productModelList.get(position).getName());
       // holder.rating.setText(productModelList.get(position).getRating());
        holder.description.setText(productModelList.get(position).getDescription());
       // holder.price.setText(productModelList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, displayProduct.class);
                intent.putExtra("detail",productModelList.get(position));
                context.startActivity(intent);
            }
        });

        /*ViewAllAdapter.setOnItemClickListener(new ViewAllAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String type = ViewAllModelList.get(position).getType();
                Intent intent = new Intent(ViewGeneral.this, ViewGeneral.class);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView prodImg;
        TextView name,description,rating,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prodImg=itemView.findViewById(R.id.prod_img);
            name=itemView.findViewById(R.id.pro_name);
            description=itemView.findViewById(R.id.pro_des);
            //rating=itemView.findViewById(R.id.pro_ratings);
            //price=itemView.findViewById(R.id.price);
        }
    }
}
