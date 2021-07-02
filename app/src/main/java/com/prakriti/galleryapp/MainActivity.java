package com.prakriti.galleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery myGallery = findViewById(R.id.myGallery);

        GalleryAdapter adapter = new GalleryAdapter(this);
        myGallery.setAdapter(adapter);

        // Horizontal Scrollview
        LinearLayout llHorizontal = findViewById(R.id.llHorizontal);
        ImageView imgAnimal = findViewById(R.id.imgAnimal);

        for(int i = 0 ; i < Animal.images.length; i++) {
            // create new image view -> to put inside horizontal scrollview
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(Animal.images[i]);
            imgAnimal.setLayoutParams(new LinearLayout.LayoutParams(1000, 1000)); // since linear layout is the parent for the image
            imageView.setPadding(50,50,50,50);
            int final_index = i; // for anon inner class
            imageView.setOnClickListener(v -> {
                // on clicking image in scrollview, it should appear in image view outside the scrollview
                imgAnimal.setImageResource(Animal.images[final_index]);
                imgAnimal.setLayoutParams(new LinearLayout.LayoutParams(800,800));
                Toast.makeText(MainActivity.this, Animal.animals[final_index], Toast.LENGTH_SHORT).show();
            });
            llHorizontal.addView(imageView);
        }
    }
}