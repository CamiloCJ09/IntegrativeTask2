package model;

public class Playlist {
    private String name;
    
    private Gender songGender;
    private Time duration;

    public Playlist(String name, Gender songGender, Time duration){
        this.name = name;
        this.songGender = songGender;
        this.duration = duration;
        
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getSongGender() {
        return songGender;
    }

    public void setSongGender(Gender songGender) {
        this.songGender = songGender;
    }
  
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

}
