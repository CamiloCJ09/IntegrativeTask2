package model;

public abstract class Playlist {
    public final int MAX_SONGS_PLAYLIST = 30;
    private String name;
    
    private Gender songGender;
    private Time duration;
    private Song[] playSongs;

    //private String gendersInString = changeGendersOfPlaylist(playlistAllGenders());

    public Playlist(String name){
        this.name = name;
        this.songGender = Gender.UNKNOWN;
        this.duration = new Time(0, 0);
        this.playSongs = new Song[MAX_SONGS_PLAYLIST];
        
    }
    
    
    /** 
     * @param updateGender(
     * @return double
     */
    public abstract double rateAverage();
    public void updateGender(){
        
    }
    
    /** 
     * @param mySong
     */
    public void addAtOnce(Song mySong){
        boolean out = false; 
        for(int i = 0; i<MAX_SONGS_PLAYLIST && !out; i++){
            if(playSongs[i] == null){
                playSongs[i] = mySong;
                out = true;
                //System.out.println(playSongs[i]); //! Validación
            }
        }
        
    }
    
    /** 
     * @return String
     */
    /*public String getGendersInString(){
        return gendersInString;
    }
    */
    public String getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return Gender
     */
    public Gender getSongGender() {
        return songGender;
    }

    
    /** 
     * @param songGender
     */
    public void setSongGender(Gender songGender) {
        this.songGender = songGender;
    }
  
    
    /** 
     * @return Time
     */
    public Time getDuration() {
        return duration;
    }

    
    /** 
     * @param duration
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }
    
    /** 
     * @return Gender[]
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
     * @param allGenders
     * @return String
     */
    public String changeGendersOfPlaylist(Gender[] allGenders){
        String out = "";
        boolean stop = false;
        if(allGenders[0] == null){
            out = "UNKNOWN";
        }else{
            //Gender pruve = null;
            //int count = 0;
            for(int i = 0; i<MAX_SONGS_PLAYLIST; i++){
                for(int j = 0; j<MAX_SONGS_PLAYLIST-1 && !stop; j++){
                    if(i != j){
                        if(allGenders[i] == allGenders[j]){
                            allGenders[i] = null;
                            //count++;
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
     * @return int
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
     * @param newSecondsTotal
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
     * @return String
     */
    public String playlistToString(){
        String out = "";
        out ="********** Playlist **********\n"+
             "** Title: "+name+"\n"+
             "** Duration: "+timeToFormat(updateDuration())+"\n"+
             "** Genre: "+changeGendersOfPlaylist(playlistAllGenders())+"\n"+
             "******************************\n";

        return out;
    }
    public abstract void setRate(double rate);
}
