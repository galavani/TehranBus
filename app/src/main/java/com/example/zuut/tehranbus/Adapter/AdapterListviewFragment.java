package com.example.zuut.tehranbus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zuut.tehranbus.R;

import java.util.List;

import com.example.zuut.tehranbus.Model.Station;

/**
 * Created by z.uut on 12/20/2016.
 */

public class AdapterListviewFragment extends ArrayAdapter<Station> {

    Context mcontext;

    public AdapterListviewFragment(Context context, int resource, List<Station> item) {

        super(context, resource,item);

      mcontext=context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


       Station rowitem=getItem(position);
        View view;

       // LayoutInflater inflater=(LayoutInflater.from(mcontext);

        LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){

            view=inflater.inflate(R.layout.list_data_item,null);

        }
        else
        {   view=convertView;}

        TextView perstioan_name= (TextView)view.findViewById(R.id.perstioan_name);
        TextView english_name= (TextView)view.findViewById(R.id.english_name);
        TextView id= (TextView)view.findViewById(R.id.id);

        perstioan_name.setText(rowitem.getTitle());
        english_name.setText(rowitem.getEnglishTitle());
        id.setText(rowitem.getId()+"");


        return view;







    }
}
