package com.example.supriya.androlife1;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.example.supriya.androlife1.R.id.Civ;

/**
 * Created by Supriya on 12/28/2017.
 */

public class VersionAdapter extends BaseAdapter{

    String[] name;
    int[] images;

    private Context context;

    public VersionAdapter(Context context, String[] name, int[] images) {
        this.context = context;
        this.name = name;
        this.images = images;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public App getItem(int i) //i is position of element
    {
        //Object return type or change it to name of xml file else you need to typecast it.
        return null;
        //currentStudent=get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) //converts xml file into a view class
    {
        //LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); or next statement
        LayoutInflater li = LayoutInflater.from(context);
        Log.e(TAG, "getView: +view" );
        final View inflatedView;//we can efficiently reuse those views which have gone out of scope
        if(view==null)
            inflatedView = li.inflate(R.layout.itemrow,viewGroup,false);
        else
            inflatedView=view;
        TextView tv=inflatedView.findViewById(R.id.textView);
        ImageView img=inflatedView.findViewById(R.id.Civ);
        //third parameter is false if you want to replace default frame layout with our own custom created layout and second parameter viewGroup is created by every row by defaualt
        //Also if we are the ones handling the addition of a view to the viewGroup, add true here otherwise add true and O.S takes csre of it
        tv.setText(name[i]);
        img.setImageResource(images[i]);
        return inflatedView;
    }

}
