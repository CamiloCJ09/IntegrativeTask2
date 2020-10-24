package model;

public class Time {
    
    private int minutes;
    private int seconds;

    public Time(int minutes, int seconds){
        this.minutes = minutes;
        this.seconds = seconds;
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
}
