package com.example.zuut.tehranbus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zuut.tehranbus.Database.MoveDbAdapter;
import com.example.zuut.tehranbus.Database.StationAdapter;
import com.example.zuut.tehranbus.Model.Moves;
import com.example.zuut.tehranbus.Model.Station;
import com.example.zuut.tehranbus.R;

import java.util.List;

/**
 * Created by z.uut on 12/25/2016.
 */

public class AdapterListviewMoves extends ArrayAdapter<Moves> {
    Context mcontext;

    public AdapterListviewMoves(Context context, int resource, List<Moves> item) {

        super(context, resource,item);

        mcontext=context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Moves rowitem=getItem(position);
        View view;

        // LayoutInflater inflater=(LayoutInflater.from(mcontext);

        LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){

            view=inflater.inflate(R.layout.movew_list_item,null);

        }
        else
        {   view=convertView;}

        TextView txt_time= (TextView)view.findViewById(R.id.txt_time);
        TextView txt_day= (TextView)view.findViewById(R.id.txt_day);
        TextView id= (TextView)view.findViewById(R.id.id);

        txt_time.setText(rowitem.getTime());
        txt_day.setText(rowitem.getDay());
     //   id.setText(rowitem.getId());


        return view;


    }
}
