package model;

public class Time {
    
    private int minutes;
    private int seconds;

    public Time(int minutes, int seconds){
        this.minutes = 0;
        this.seconds = 0;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public int getMinutes(){
        return minutes;
    }
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    public int getSeconds(){
        return seconds;
    }
    public String toString(){
        String msg = "";
        msg = minutes+":"+seconds;
        return msg;
    }
    public int timeToSeconds(){
        int totalSeconds = 0;
        totalSeconds = (minutes*60)+seconds;
        return totalSeconds;
    }
}
