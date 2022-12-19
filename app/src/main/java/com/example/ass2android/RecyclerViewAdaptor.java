package com.example.ass2android;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {
private Context context;
private ArrayList<ImageModel> imageModelArrayList;

    public RecyclerViewAdaptor(Context context, ArrayList<ImageModel> imageModelArrayList) {
        this.context = context;
        this.imageModelArrayList = imageModelArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdaptor.ViewHolder holder, int position) {
        Glide
                .with(context)
                .load(imageModelArrayList.get(position).getImageUrl())
                .into(holder.imageView);

        holder.textView.setText(imageModelArrayList.get(position).getName());

        holder.imageView.setOnClickListener(view -> {
            Intent intent = new Intent(context, NewActivity.class);
            intent.putExtra("images@#", imageModelArrayList.get(position).getImageUrl());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });

//        holder.imageView.setOnClickListener(view -> {
//            Intent intent = new Intent(context, NewActivity.class);
//            intent.putExtra("images@#", imageModelArrayList.get(position).getImageUrl());
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.imgName);
        }
    }
}