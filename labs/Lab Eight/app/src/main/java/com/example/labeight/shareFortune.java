package com.example.labeight;

public class shareFortune {
    private String fortune;
    private String shareURL;

    private void setFortuneInformation(Integer fortuneTheme){
        switch (fortuneTheme){
            case 0: //love
                fortune="A beautiful, smart, and loving person will be coming into your life.";
                shareURL="https://www.reddit.com/r/love/";
                break;
            case 1: //financial
                fortune="Don’t worry; prosperity will knock on your door soon.";
                shareURL="https://www.reddit.com/r/financial/";
                break;
            case 2: //family
                fortune="Share your joys and sorrows with your family.";
                shareURL="https://www.facebook.com/";
                break;
            case 3: //friends
                fortune="A good friendship is often more important than a passionate romance.";
                shareURL="https://www.instagram.com/";
                break;
            case 4: //life advice
                fortune="A fresh start will put you on your way.";
                shareURL="https://www.reddit.com/r/LifeAdvice/";
                break;
            default:
                fortune="An inch of time is an inch of gold.";
                shareURL="https://www.google.com/";
        }
    }

    public String getFortune(){
        return fortune;
    }

    public String getShareURL(){
        return shareURL;
    }

    public void setFortune(Integer fortuneTheme){
        setFortuneInformation(fortuneTheme);
    }

    public void setShareURL(Integer fortuneTheme){
        setFortuneInformation(fortuneTheme);
    }



}
