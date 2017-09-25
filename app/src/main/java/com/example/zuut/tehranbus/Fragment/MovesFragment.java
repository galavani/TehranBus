package com.example.zuut.tehranbus.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/*import com.p30droid.tehranbus.Adapter.MovesListAdapter;
import com.p30droid.tehranbus.Database.MovesDBAdapter;
import com.p30droid.tehranbus.Model.Moves;
import com.p30droid.tehranbus.R;
import com.p30droid.tehranbus.Setting.Default_Station;*/

import com.example.zuut.tehranbus.Adapter.AdapterListviewFragment;
import com.example.zuut.tehranbus.Adapter.AdapterListviewMoves;
import com.example.zuut.tehranbus.Database.MoveDbAdapter;
import com.example.zuut.tehranbus.Model.Moves;
import com.example.zuut.tehranbus.Model.Station;
import com.example.zuut.tehranbus.R;
import com.example.zuut.tehranbus.Settign.Default_setting;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovesFragment extends Fragment {

    TextView txt_time, txt_day;
    Default_setting default_setting;
    AdapterListviewMoves adapterListviewMoves;
    MoveDbAdapter moveDbAdapter;
    ListView lst_data;

    public MovesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_moves, container, false);


        lst_data = (ListView) rootview.findViewById(R.id.lst_data);
        moveDbAdapter = new MoveDbAdapter(getActivity());

        default_setting = new Default_setting(getActivity());

        //   id_station=default_station.getId();

        ArrayList<Moves> arrayList = moveDbAdapter.getdata(Integer.parseInt(default_setting.getId()));

        AdapterListviewMoves adapterListviewMoves = new AdapterListviewMoves(getActivity(), R.layout.movew_list_item, arrayList);

        lst_data.setAdapter(adapterListviewMoves);
return  rootview;

    }
}
