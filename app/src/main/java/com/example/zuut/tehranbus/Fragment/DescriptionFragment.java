package com.example.zuut.tehranbus.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zuut.tehranbus.Database.StationAdapter;
import com.example.zuut.tehranbus.Model.Station;
import com.example.zuut.tehranbus.R;
import com.example.zuut.tehranbus.Settign.Default_setting;

/*import com.p30droid.tehranbus.Database.StationsDBAdapter;
import com.p30droid.tehranbus.Model.Stations;
import com.p30droid.tehranbus.R;
import com.p30droid.tehranbus.Setting.Default_Station;*/

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {

TextView txt_description,txt_title;
Default_setting default_setting;
    StationAdapter stationAdapter;

    Station station;
    public DescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview=inflater.inflate(R.layout.fragment_description,container,false);

        txt_description=(TextView)rootview.findViewById(R.id.txt_description);
        txt_title=(TextView)rootview.findViewById(R.id.txt_title);

        default_setting=new Default_setting(getActivity());
        default_setting.getId();

        stationAdapter=new StationAdapter(getActivity());

        station=new Station();

        station=stationAdapter.getstationdetail(Integer.parseInt(default_setting.getId()));

        if(station!=null)
        {

            txt_title.setText(station.getTitle());
            txt_description.setText(station.getDescription());
        }






        return  rootview;
    }


}
