package com.example.zuut.tehranbus.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zuut.tehranbus.Adapter.AdapterListviewFragment;


import com.example.zuut.tehranbus.InformationActivity;
import com.example.zuut.tehranbus.R;

import java.util.ArrayList;

import com.example.zuut.tehranbus.Database.StationAdapter;
import com.example.zuut.tehranbus.Model.Station;
import com.example.zuut.tehranbus.Settign.Default_setting;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class Stationfragment extends Fragment {

   ListView lst_data;
  // TextView lst_data;
    StationAdapter stationAdapter;
    AdapterListviewFragment adapterListviewFragment;
    Default_setting default_setting;

    public Stationfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View Rootview = inflater.inflate(R.layout.fragment_stationfragment, container, false);
        lst_data = (ListView) Rootview.findViewById(R.id.lst_data);
        //creat object from station adapter  for read information
       stationAdapter=new StationAdapter(getActivity());


       filldata();


        lst_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

            startActivity(new Intent(getActivity(), InformationActivity.class));

                String txt_id=((TextView)view.findViewById(R.id.id)).getText().toString();

                default_setting=new Default_setting(getActivity());
                default_setting.SaveID(txt_id);





            }
        });





        return Rootview;


    }

    private void  filldata(){

     ArrayList<Station> stationArrayList=stationAdapter.getdata();

     adapterListviewFragment=new AdapterListviewFragment(getActivity(),R.layout.list_data_item,stationArrayList);

     lst_data.setAdapter(adapterListviewFragment);



    }






}
