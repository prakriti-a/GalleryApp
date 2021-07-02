package com.prakriti.galleryapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter {

    private Context context;

    public GalleryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Animal.animals.length;
    }

    @Override
    public Object getItem(int position) {
        return Animal.images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(Animal.images[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(800, 800));
        imageView.setPadding(80,80,80,80);

        return imageView;
    }
}
