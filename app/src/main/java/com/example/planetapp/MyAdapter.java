package com.example.planetapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyAdapter( ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.item_list_layout,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView plantetImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Planet planet = getItem(position);

        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            myViewHolder.planetName=(TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount=(TextView) convertView.findViewById((R.id.moonCount));
            myViewHolder.plantetImg= (ImageView) convertView.findViewById(R.id.imageView);
            result = convertView;
            convertView.setTag(myViewHolder);
        }else{
            //the view is recycled
            myViewHolder= (MyViewHolder) convertView.getTag();
            result=convertView;
        }

        //Getting data from modal class
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.plantetImg.setImageResource(planet.getPlanetImage());

        return result;
    }
}
