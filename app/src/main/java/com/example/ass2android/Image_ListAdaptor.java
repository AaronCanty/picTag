package com.example.ass2android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Image_ListAdaptor extends ArrayAdapter<ImageModel> {

    private Activity context;
    private List<ImageModel> imageModelList;

    public Image_ListAdaptor(Activity context, List<ImageModel> imageModelList)
    {
        super(context, R.layout.image_list, imageModelList);
        this.context = context;
        this.imageModelList = imageModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View ListItem = inflater.inflate(R.layout.image_list, null, true);
        TextView tagTV = ListItem.findViewById(R.id.tag_tv);
        TextView descripTV = ListItem.findViewById(R.id.description_tv);
        TextView locTV = ListItem.findViewById(R.id.location_tv);

        ImageModel imageModel = imageModelList.get(position);

        tagTV.setText("Tag" +
                imageModel.getTag());
        descripTV.setText("Description" +
                imageModel.getDescription());
        locTV.setText("Location" +
                imageModel.getLocation());

        return ListItem;


    }
}
