package com.example.zuut.tehranbus.Settign;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by z.uut on 12/24/2016.
 */

public class Default_setting {
    Context m_context;

    SharedPreferences sharedPreferences;
    public  static String SHARED_KEY="id";
    public  static String NAME_PREFERENCES="station_id";
    SharedPreferences.Editor editor;
    public Default_setting(Context context)
    {
        this.m_context=context;
        sharedPreferences=m_context.getSharedPreferences(NAME_PREFERENCES,Context.MODE_PRIVATE);
        //save id
    }
    public void SaveID( String id)
    {
       editor =this.sharedPreferences.edit();
        editor.putString(SHARED_KEY,id);
        editor.commit();


    }
    //return id

    public String getId()
    {

        return this.sharedPreferences.getString(SHARED_KEY,"");
    }

}
