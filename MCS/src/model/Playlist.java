package model;

public abstract class Playlist {
    public final int MAX_SONGS_PLAYLIST = 30;
    private String name;
    private Time duration;
    private Song[] playSongs;

    //We never call this builder constructor
    /**
     * Generic playlist constructor
     * @param name , name of the playlist
     */
    public Playlist(String name){
        this.name = name;
        this.duration = new Time(0, 0);
        this.playSongs = new Song[MAX_SONGS_PLAYLIST];
        
    }
    
    /** 
     * Method that let add a song to the playlist
     * pre: array for saving songs to playlist must be defined
     * pos: 
     * @param mySong The song that will be added to the playlist
     */
    public void addAtOnce(Song mySong){
        boolean out = false; 
        for(int i = 0; i<MAX_SONGS_PLAYLIST && !out; i++){
            if(playSongs[i] == null){
                playSongs[i] = mySong;
                out = true;
            }
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
    
    /** 
     * Method that returns an array with the genres of all the songs stored in the playlist
     * pre:
     * @return Gender[] arrangement with all genres of songs from the playlist
     */
    public Gender[] playlistAllGenders(){
        Gender allSongsGender[] = new Gender[MAX_SONGS_PLAYLIST];
            for(int i = 0; i<MAX_SONGS_PLAYLIST; i++){
                if(playSongs[i] != null){
                    allSongsGender[i] = playSongs[i].getSongGender();
                }
            }
        return allSongsGender;
    }
    
    /** 
     * Method that updates the genre of the playlist without repeating genres
     * pre:
     * pos:
     * @param allGenders genre arrangement of all songs in playlist
     * @return String , with the genres without repeating from the playlist
     */
    public String changeGendersOfPlaylist(Gender[] allGenders){
        String out = "";
        boolean stop = false;
        if(allGenders[0] == null){
            out = "UNKNOWN";
        }else{
            for(int i = 0; i<MAX_SONGS_PLAYLIST; i++){
                for(int j = 0; j<MAX_SONGS_PLAYLIST-1 && !stop; j++){
                    if(i != j){
                        if(allGenders[i] == allGenders[j]){
                            allGenders[i] = null;
                        }  
                    }  
                }     
            }
            for(int i = 0; i < MAX_SONGS_PLAYLIST; i++){
                if(allGenders[i] != null){
                    out += allGenders[i]+", ";
                }
            }
        }
        return out;
    }
    
    /** 
     * Method that updates the playlist time
     * pre: song arrangement must be defined with at least one song
     * pos:
     * @return int , seconds of total playlist duration
     */
    public int updateDuration(){
        int newSecondsTotal = 0;
        for(int i = 0; i < MAX_SONGS_PLAYLIST; i++){
            if(playSongs[i] != null){
                newSecondsTotal += playSongs[i].songDurationSong();
            }
        }
        return newSecondsTotal;
    }
    
    /** 
     * Method that converts the total seconds of the playlist to the desired format
     * pre:
     * pos:
     * @param newSecondsTotal total amount of seconds from the playlist
     * @return String
     */
    public String timeToFormat(int newSecondsTotal){
        String out = "";
        int minutes = newSecondsTotal/60;
        int seconds = newSecondsTotal-(minutes*60);
        out = minutes+":"+seconds;
        return out;
    }
    
    /** 
     * Method that prints all the information of a playlist
     * @return String , information of the playlist
     */
    public String playlistToString(){
        String out = "";
        out ="********** Playlist **********\n"+
             "** Title: "+name+"\n"+
             "** Duration: "+timeToFormat(updateDuration())+"\n"+
             "** Genre: "+changeGendersOfPlaylist(playlistAllGenders())+"\n";

        return out;
    }

}
