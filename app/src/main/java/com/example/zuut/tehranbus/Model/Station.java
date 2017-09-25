package com.example.zuut.tehranbus.Model;

/**
 * Created by z.uut on 12/18/2016.
 */

public class Station {
    private int id;
   private int Line;
    private String Title;
    private String EnglishTitle;
    private String Lat;
    private String Long;
    private String Addres;
    private String  Description;


    public  Station()
    {}

    public  Station(int id,String Title,String EnglishTitle,int Line,String Lat,String Long,String Addres,String  Description)
    {

        this.setId(id);
        this.setLine(Line);
        this.setTitle(Title);
        this.setEnglishTitle(EnglishTitle);
        this.setLat(Lat);
        this.setLong(Long);
        this.setAddres(Addres);
        this.setDescription(Description);

    }

    public  Station(int id,String Title,String  Description) {

        this.setId(id);
        this.setTitle(Title);
        this.setDescription(Description);


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getLine() {
        return Line;
    }

    public void setLine(int Line) {
        this.Line =Line;
    }


    public String getEnglishTitle() {
        return EnglishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.EnglishTitle = EnglishTitle;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }



    public String getLat() {
        return Lat;
    }

    public void setLat(String Lat) {
        this.Lat = Lat;
    }


    public String getAddres() {
        return Addres;
    }

    public void setAddres(String Addres) {
        this.Addres = Addres;
    }




    public String getLong() {
        return Long;
    }

    public void setLong(String Long) {
        this.Long = Long;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}
