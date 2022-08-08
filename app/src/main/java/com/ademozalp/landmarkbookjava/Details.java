package com.ademozalp.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ademozalp.landmarkbookjava.databinding.ActivityDetailsBinding;
import com.ademozalp.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Details extends AppCompatActivity
{
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());// inflate -> xml ile kodu bir birine bağlamak demektir.
        View view = binding.getRoot();
        setContentView(view);// findviewbyid verimsiz işlemler gerçekleştirdiği için view binding teknolojisi geliştirildi görünümleri kolayva bulmamızı sağlar, jetpackin bir parçasıdır.

        // intent ile veriyi aldık
       /* Intent intent = getIntent();
        Landmark selectedlendmark = (Landmark) intent.getSerializableExtra("landmark");*/

        //Singleton ile gönderilen veriyi aldık
        Singleton singleton = Singleton.getInstance();
        Landmark selectedlendmark = singleton.getSentLandmark();

        binding.imageView.setImageResource(selectedlendmark.image);
        binding.nametxt.setText(selectedlendmark.name);
        binding.countrytxt.setText(selectedlendmark.country);
    }
}