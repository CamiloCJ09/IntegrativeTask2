package model;

public class Song {
    
    private String title;
    private String artistName;
    private String releasingDate;
    
    //Relacion
    private Time duration;
    private Gender songGender;

    public Song(String title, String artistName, String releasingDate, Time duration, Gender songGender){
        this.title = title;
        this.artistName = artistName;
        this.releasingDate = releasingDate;
        this.duration = duration;
        this.songGender = songGender;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the artistName
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * @param artistName the artistName to set
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * @return String return the releasingDate
     */
    public String getReleasingDate() {
        return releasingDate;
    }

    /**
     * @param releasingDate the releasingDate to set
     */
    public void setReleasingDate(String releasingDate) {
        this.releasingDate = releasingDate;
    }

    /**
     * @return Gender return the songGender
     */
    public Gender getSongGender() {
        return songGender;
    }

    /**
     * @param songGender the songGender to set
     */
    public void setSongGender(Gender songGender) {
        this.songGender = songGender;
    }

    /**
     * @return Time return the duration
     */
    public Time getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }

}
