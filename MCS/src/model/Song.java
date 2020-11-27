package model;

public class Song {
    
    private String title;
    private String artistName;
    private String releasingDate;
    
    //Relacion
    private Time duration;
    private Gender songGender;

    /**
     * Método constructor de una canción
     * @param title the title of the song
     * @param artistName the name of the artist
     * @param releasingDate the releasing date
     * @param duration the duration of the song
     * @param songGender the gender of the song
     */
    public Song(String title, String artistName, String releasingDate, Time duration, Gender songGender){
        this.title = title;
        this.artistName = artistName;
        this.releasingDate = releasingDate;
        this.duration = duration;
        this.songGender = songGender;
    }

    
    /** 
     * Método que permite obtener la duración de una canción en segundos
     * @return int , total de segundos
     */
    public int songDurationSong(){
        int durationInSeconds = getDuration().timeToSeconds();
        return durationInSeconds;
    }
    
    /**
     * Method that displays song information 
     * @return String, with the information of the song
     */
    public String showSongData(){
        String msg = "";
        msg += "********** Song **********\n"+
                "** Title: "+title+"\n"+
                "** Artist: "+artistName+"\n"+
                "** Duration: "+duration+"\n"+
                "** Genre: "+songGender.toString()+"\n"+
                "**************************\n";
        return msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getReleasingDate() {
        return releasingDate;
    }

    public void setReleasingDate(String releasingDate) {
        this.releasingDate = releasingDate;
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
