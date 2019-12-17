package com.example.finalapp;

public class mexicanFood {
    private String place;
    private String shareURL;

    private void setLocationInfo(Integer location){
        switch (location){
            case 0: //The Hill
                place="Illegal Petes";
                shareURL="https://www.illegalpetes.com";
                break;
            case 1: //29th Street
                place="Chipotle";
                shareURL="https://www.chipotle.com";
                break;
            case 2: //Pearl Street
                place="Bartaco";
                shareURL="https://bartaco.com";
                break;
            default:
                place="At home";
                shareURL="https://www.cookingclassy.com/ground-beef-tacos/";
        }
    }

    public String getlocation(){
        return place;
    }

    public String getShareURL(){
        return shareURL;
    }

    public void setLocation(Integer locationIndex){
        setLocationInfo(locationIndex);
    }
}
