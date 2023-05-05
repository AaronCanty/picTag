package com.example.ass2android;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import javax.security.auth.Destroyable;

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
        if (imageModelArrayList.get(position) != null) {
            Glide
                    .with(context)
                    .load(imageModelArrayList.get(position).getImage())
                    .into(holder.imageView);

            holder.descriptionView.setText(imageModelArrayList.get(position).getDescription());
            holder.textView.setText(imageModelArrayList.get(position).getName());
            holder.tagView.setText(imageModelArrayList.get(position).getTags());

            holder.imageView.setOnClickListener(view -> {
                Toast.makeText(context, imageModelArrayList.get(position).getDescription(), Toast.LENGTH_LONG).show();
            });
        }
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView tagView;
        TextView descriptionView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.logo);
            textView = itemView.findViewById(R.id.imgName);
            tagView = itemView.findViewById(R.id.imgTags);
            descriptionView = itemView.findViewById(R.id.imgDescription);
        }
    }

}