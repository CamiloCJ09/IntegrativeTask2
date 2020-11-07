package model;

public class Time {
    
    private int minutes;
    private int seconds;

    public Time(int minutes, int seconds){
        this.minutes = 0;
        this.seconds = 0;
    }
    
    /** 
     * @param minutes
     */
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    
    /** 
     * @return int
     */
    public int getMinutes(){
        return minutes;
    }
    
    /** 
     * @param seconds
     */
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    
    /** 
     * @return int
     */
    public int getSeconds(){
        return seconds;
    }
    
    /** 
     * @return String
     */
    public String toString(){
        String msg = "";
        msg = minutes+":"+seconds;
        return msg;
    }
    
    /** 
     * Método que pasa todos los minutos a segundos
     * @return int , cantidad total de segundos
     */
    public int timeToSeconds(){
        int totalSeconds = 0;
        totalSeconds = (minutes*60)+seconds;
        return totalSeconds;
    }
}
