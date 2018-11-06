package com.abisayuti.resep_rahasia.Main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abisayuti.resep_rahasia.Main.Activity.model.RecipesItem;
import com.abisayuti.resep_rahasia.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    Context context;
    List<RecipesItem> recipesItems;

    public MainAdapter(Context context, List<RecipesItem> data) {
        this.context = context;
        this.recipesItems = data;
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.main_item, viewGroup, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder mainViewHolder, int i) {
        RecipesItem resep = recipesItems.get(i);
        mainViewHolder.Namaproduk.setText(resep.getTitle());
        mainViewHolder.publisher.setText(resep.getPublisher());
        Glide.with(context)
                .load(recipesItems.get(i).getImageUrl())
                .into(mainViewHolder.imgMain);


    }

    @Override
    public int getItemCount() {
        return recipesItems.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView Namaproduk, publisher;
        ImageView imgMain;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMain = itemView.findViewById(R.id.imageNews);
            Namaproduk = itemView.findViewById(R.id.TextTittle);
            publisher = itemView.findViewById(R.id.TextPublisher);
        }
    }
}
