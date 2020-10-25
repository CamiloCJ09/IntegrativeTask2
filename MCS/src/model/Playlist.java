package model;

public class Playlist {
    public final int MAX_SONGS_PLAYLIST = 30;
    private String name;
    
    private Gender songGender;
    private Time duration;
    private Song[] playSongs = new Song[MAX_SONGS_PLAYLIST];

    public Playlist(String name){
        this.name = name;
        this.songGender = Gender.UNKNOWN;
        this.duration = new Time(0, 0);
        this.playSongs = playSongs;
        
    }
    public void updateGender(){
        
    }
    public void addAtOnce(Song mySong){
        boolean out = false; 
        for(int i = 0; i<MAX_SONGS_PLAYLIST && !out; i++){
            if(playSongs[i] == null){
                playSongs[i] = mySong;
                out = true;
                //System.out.println(playSongs[i]);
            }
        }
        
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
    public String playlistToString(){
        String out = "";
        out ="********** Playlist **********\n"+
             "** Title: "+name+"\n"+
             "** Duration: "+duration+"\n"+
             "** Genre: "+songGender+"\n"+
             "******************************\n";

        return out;
    }
}
