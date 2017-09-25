package com.example.zuut.tehranbus.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.zuut.tehranbus.Model.Moves;
import com.example.zuut.tehranbus.Model.Station;

/**
 * Created by z.uut on 12/19/2016.
 */

public class MoveDbAdapter extends database {

    public static String KEY_ID = "Id";
    public static String KEY_ID_STATION = "Id_Station";
    public static String KEY_TIME = "Time";
    public static String KEY_DAY = "Day";
    Moves moves;

    public MoveDbAdapter(Context context) {

        super(context);

    }


    //insert
    public void Insert(Station station) {

        // write into database

        SQLiteDatabase db = this.getWritableDatabase();

        //Array for database
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID_STATION, station.getLine());
        contentValues.put(KEY_TIME, station.getTitle());
        contentValues.put(KEY_DAY, station.getEnglishTitle());



        // code of insert
        db.insertOrThrow(TABLE_STATION, null, contentValues);
    }


    //select
    public ArrayList<Moves> getdata(int ID) {
        ArrayList<Moves> list = new ArrayList<Moves>();


//ReadDatabase
        SQLiteDatabase db = this.getReadableDatabase();

//values of select
        // String select_database = "SELECT * FROM" + TABLE_STATION;
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_INFORMATION+" WHERE "+KEY_ID_STATION+"="+ID+"",null);


        // Cursor cursor = db.rawQuery("SELECT * FROM" + TABLE_STATION, null);

        for(;cursor.moveToNext();) {

            int id = cursor.getInt(0);
            int id_station = cursor.getInt(1);
            String time = cursor.getString(2);
            String day = cursor.getString(3);


            // station=new Station(id,title,englishtitle,line,lat,lang,addres,description);

            Moves moves=new Moves(id,id_station,time,day);
            list.add(moves);

            // list.add(id + " " + line+" "+title+" "+englishtitle+""+lat+""+lang+""+addres+""+description);

        }
        return list;
    }


    public ArrayList<Moves> getMoves()
    {
        ArrayList<Moves> lst=new ArrayList<Moves>();
        String selectquery="SELECT * FROM "+TABLE_INFORMATION;

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery,null);


        for(;cursor.moveToNext();)
        {

            //read all data
            int id=cursor.getInt(0);
            int id_station=cursor.getInt(1);
            String day=cursor.getString(2);
            String time=cursor.getString(3);

            moves=new Moves(id,id_station,day,time);

            lst.add(moves);
        }
        return  lst;
    }



    /*public String getdatalive()
    {
        String title = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * from " + TABLE_STATION, null);

        cursor.moveToFirst();
        //   int id = cursor.getInt(0);
        title = cursor.getString(1);

        return title;
    }
*/

}
