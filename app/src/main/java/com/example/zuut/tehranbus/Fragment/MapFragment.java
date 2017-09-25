package com.example.zuut.tehranbus.Fragment;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/*import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.p30droid.tehranbus.R;
import com.p30droid.tehranbus.Utils.GPSTracker;*/

import com.example.zuut.tehranbus.R;
import com.example.zuut.tehranbus.Utils.GPSTracker;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {


    String name, country, country_code,subadminaria,adminaria;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.fragment_map, container, false);

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!gps || !network) {


            Toast.makeText(getActivity(), "gps off", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(getActivity(), "gps on", Toast.LENGTH_SHORT).show();

            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

            }
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

          /*  double lat=location.getLatitude();
            double lang=location.getLongitude();*/

            double lat=0;
            double lang=0;


            Geocoder geocoder=new Geocoder(getActivity());

            List<Address> list;

            lat=35.726010;
            lang=51.372446;

            try {

                list=geocoder.getFromLocation(lat,lang,1);
                Address address=list.get(0);

                name=address.getLocality();
                country=address.getCountryName();
                country_code=address.getCountryCode()+"";
                subadminaria=address.getSubAdminArea();
              adminaria=address.getAdminArea();

                Toast.makeText(getActivity(), name+","+country+","+country_code, Toast.LENGTH_SHORT).show();

            }
            catch (Exception ex){


            }


            GPSTracker gpsTracker=new GPSTracker(getActivity());
            if (gpsTracker.canGetLocation())
            {

                lat=gpsTracker.getLatitude();
                lang=gpsTracker.getLongitude();


            }
            else {


                gpsTracker.showSettingsAlert();
            }





        }

        return rootview;
    }





}
