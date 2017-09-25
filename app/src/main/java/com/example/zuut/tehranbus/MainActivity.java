package com.example.zuut.tehranbus;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.TextView;

import java.io.IOException;

import com.example.zuut.tehranbus.Database.StationAdapter;
import com.example.zuut.tehranbus.Database.database;
import com.example.zuut.tehranbus.Fragment.Stationfragment;

public class MainActivity extends AppCompatActivity  {

    database database1;
    TextView lst_data;
    StationAdapter stationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        lst_data = (TextView) findViewById(R.id.lst_data);

        database1 = new database(getApplicationContext());


        LoadingDatabase();

        stationAdapter = new StationAdapter(getApplicationContext());

        //   lst_data.setText(stationAdapter.getdata());

        //fragment
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.container, new Stationfragment()).commit();


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

     getMenuInflater().inflate(R.menu.menus,menu);
        final SearchView searchView=(SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search ));

        //click on SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent=new Intent(getApplicationContext(),SearchActivity.class);
                intent.putExtra("title",toString());

                startActivity(intent);



                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }
    //loding database in app

    private void LoadingDatabase() {
        try {
            database1.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        database1.openDataBase();
    }
}
