package com.example.zuut.tehranbus.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.zuut.tehranbus.Model.Station;

/**
 * Created by z.uut on 12/19/2016.
 */

public class StationAdapter extends database {

    public static String KEY_ID = "id";
    public static String KEY_LINE = "Line";
    public static String KEY_TITLE = "Title";
    public static String KEY_ENDLISH_TITLE = "EnglishTitle";
    public static String KEY_LAT = "Lat";
    public static String KEY_LANG = "Long";
    public static String KEY_ADDRES = "Addres";
    public static String KEY_DESCRIPTION = "Description";
   // public static final String TABLE_STATION = "Tbl_Station";

    public StationAdapter(Context context) {

        super(context);

    }


    //insert
    public void Insert(Station station) {

        // write into database

        SQLiteDatabase db = this.getWritableDatabase();

        //Array for database
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_LINE, station.getLine());
        contentValues.put(KEY_TITLE, station.getTitle());
        contentValues.put(KEY_ENDLISH_TITLE, station.getEnglishTitle());
        contentValues.put(KEY_LAT, station.getLat());
        contentValues.put(KEY_LANG, station.getLong());
        contentValues.put(KEY_ADDRES, station.getAddres());
        contentValues.put(KEY_DESCRIPTION, station.getDescription());


        // code of insert
        db.insertOrThrow(TABLE_STATION, null, contentValues);
    }


    //select
    public ArrayList<Station> getdata() {
        ArrayList<Station> list = new ArrayList<Station>();

        Station station=new Station();
//ReadDatabase
        SQLiteDatabase db = this.getReadableDatabase();

//values of select
      // String select_database = "SELECT * FROM" + TABLE_STATION;
        Cursor cursor=db.rawQuery("SELECT * FROM " + TABLE_STATION,null);


     // Cursor cursor = db.rawQuery("SELECT * FROM" + TABLE_STATION, null);

    for(;cursor.moveToNext();) {

            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String englishtitle = cursor.getString(2);
            int line = cursor.getInt(3);
            String lat = cursor.getString(4);
            String lang = cursor.getString(5);
            String addres = cursor.getString(6);
            String description = cursor.getString(7);

       // station=new Station(id,title,englishtitle,line,lat,lang,addres,description);

         station=new Station(id,title,englishtitle,line,lat,lang,addres,description);
     list.add(station);

          // list.add(id + " " + line+" "+title+" "+englishtitle+""+lat+""+lang+""+addres+""+description);

   }
        return list;
    }
     public Station getstationdetail( int Id)
     {

         Station station=new Station();


         SQLiteDatabase db = this.getReadableDatabase();

         Cursor cursor=db.query(TABLE_STATION,new String[]{KEY_ID,KEY_TITLE,KEY_DESCRIPTION}
                 ,KEY_ID+"=?",new String[]{String.valueOf(Id)},null,null,null,null);

         if (cursor.moveToNext()){

             int id=cursor.getInt(0);
             String title=cursor.getString(1);
             String description=cursor.getString(2);
             station=new Station(id,title,description);
         }


return  station;



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
