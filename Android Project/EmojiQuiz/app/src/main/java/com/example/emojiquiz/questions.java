package com.example.emojiquiz;

import android.content.Intent;

public class questions {
    String hint;
    String answer;
    String pictureName;
    //image for current image
    private void setGameInfo(Integer index){
        switch (index){
            case 0: //life of pi
                answer="life of pi";
                pictureName="@drawable/movie1";
                hint="Doubt is useful. It keeps faith a living thing. After all, you cannot know the strength of your faith until it has been tested";
                break;
            case 1: //Wolf of Wall Street
                answer="wolf of wall street";
                pictureName="@drawable/movie2";
                hint="Let me tell you something. There's no nobility in poverty. I've been a rich man and I've been a poor man. And I choose rich every fucking time.";
                break;
            case 2: //Lord of the Rings
                answer="lord of the rings";
                pictureName="@drawable/movie3";
                hint="You shall not pass!";
                break;
            case 3: //Harry Potter
                answer="harry potter";
                pictureName="@drawable/movie4";
                hint="Sunshine daises butter mellow, turn that stupid fat rat yellow!";
                break;
            case 4: //Beauty and the Beast
                answer="beauty and the beast";
                pictureName="@drawable/movie5";
                hint="He’s no monster, Gaston; you are!";
                break;
            case 5: //ratatouille
                answer="ratatouille";
                pictureName="@drawable/movie6";
                hint="Anyone can cook!";
                break;
            case 6: //bridesmaids
                answer="bridesmaids";
                pictureName="@drawable/movie7";
                hint="Because you are the problem, Annie. And you are the solution.";
                break;
            case 7: //fight club
                answer="fight club";
                pictureName="@drawable/movie8";
                hint="It's only after we've lost everything that we're free to do anything.";
                break;
            default:
                answer="none";
                pictureName="@drawable/movie1";
                hint="this is broken";
        }
    }

    //getters
    public String getHint(){
        return hint;
    }

    public String getAnswer(){
        return answer;
    }

    public String getPhotoName(){
        return pictureName;
    }


    //setters

    public void setQuestions(Integer GameIndex){
        setGameInfo(GameIndex);
    }


}
