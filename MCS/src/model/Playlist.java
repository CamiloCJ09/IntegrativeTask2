package model;

public abstract class Playlist {
    public final int MAX_SONGS_PLAYLIST = 30;
    private String name;
    private Time duration;
    private Song[] playSongs;

    //private String gendersInString = changeGendersOfPlaylist(playlistAllGenders());
    /**
     * Constructor de la playlist genérica
     * @param name , nombre de la playlist
     */
    public Playlist(String name){
        this.name = name;
        this.duration = new Time(0, 0);
        this.playSongs = new Song[MAX_SONGS_PLAYLIST];
        
    }
    
    /** 
     * Método que permite añadir una canción a la playlist
     * pre: El arreglo para guardar las canciones en la playlist debe estar definido
     * pos: 
     * @param mySong la canción que será agregada a la playlist
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
     * Método que devuelve un arreglo con los géneros de todas las canciones guardadas en la playlist
     * pre:
     * @return Gender[] arreglo con todos los géneros de las canciones de la playlist
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
     * Método que actualiza el genero de la playlist sin repetir géneros
     * pre:
     * pos:
     * @param allGenders arreglo de géneros de todas las canciones en la playlist
     * @return String , con los géneros sin repetir de la playlist
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
     * Método que actualiza el tiempo de la playlist
     * pre: el arreglo de canciones debe estar definido con al menos una canción
     * pos:
     * @return int , segundos de duración total de la playlist
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
     * Método que convierte los segundos totales de la playlist al formato deseado
     * pre:
     * pos:
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
     * Método que imprime toda la información de una playlist
     * @return String , información de la playlist
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
