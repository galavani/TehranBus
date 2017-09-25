package com.example.zuut.tehranbus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zuut.tehranbus.Fragment.DescriptionFragment;
import com.example.zuut.tehranbus.Fragment.MapFragment;
import com.example.zuut.tehranbus.Fragment.MovesFragment;

/**
 * Created by z.uut on 12/23/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {


    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:
                return new DescriptionFragment();
            case 1:
                return new MapFragment();

            case 2:
                return new MovesFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
