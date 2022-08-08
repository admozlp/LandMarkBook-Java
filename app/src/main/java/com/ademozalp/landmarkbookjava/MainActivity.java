package com.ademozalp.landmarkbookjava;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.ademozalp.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Landmark> landmarks;
    private ActivityMainBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());// inflate -> xml ile kodu bir birine bağlamak demektir.
        View view = binding.getRoot();
        setContentView(view);


        landmarks = new ArrayList<>();

        // Data intialize
        Landmark pisa = new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark london = new Landmark("London Bridge","UK",R.drawable.londonbridge);
        Landmark eiffel = new Landmark("Eiffel","France",R.drawable.eiffel);
        Landmark colosseum = new Landmark("Colosseum","Italy",R.drawable.colosseum);

        landmarks.add(pisa);
        landmarks.add(london);
        landmarks.add(eiffel);
        landmarks.add(colosseum);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarks);
        binding.recyclerView.setAdapter(landmarkAdapter);

       /* ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarks.stream().map(landmark -> landmark.name).collect(Collectors.toList())//mapping işlemi -> bir veriyi başa bir veri türüne çevirmek
        );
        binding.listview.setAdapter(arrayAdapter);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Details.class);
                intent.putExtra("lendmark",landmarks.get(i));
                startActivity(intent);
            }
        });*/



    }
}