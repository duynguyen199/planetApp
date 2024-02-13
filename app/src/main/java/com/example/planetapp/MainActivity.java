package com.example.planetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet>planetArrayList;
    private static MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Adapter view: a list view
        listView = findViewById(R.id.listView);
        //Data source
        planetArrayList=new ArrayList<>();

        Planet planet1 = new Planet("Earth","1",R.drawable.earth);
        Planet planet2 = new Planet("Jupiter","2",R.drawable.jupiter);
        Planet planet3 = new Planet("Mars","3",R.drawable.mars);
        Planet planet4 = new Planet("Mercury","4",R.drawable.mercury);
        Planet planet5 = new Planet("Neptune","5",R.drawable.neptune);
        Planet planet6 = new Planet("Pluto","6",R.drawable.pluto);
        Planet planet7 = new Planet("Saturn","7",R.drawable.saturn);
        Planet planet8 = new Planet("Uranus","8",R.drawable.uranus);
        Planet planet9 = new Planet("Venus","9",R.drawable.venus);


        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);
        planetArrayList.add(planet9);

        //adapter
        adapter = new MyAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(adapter);

        //handling click event
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Plantet Name: " + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}