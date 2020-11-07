package model;



public class Mcs {

    public static int MAX_USERS = 10; 
    public static int MAX_PLAYLISTS = 20;
    public static int MAX_POOLOFSONGS = 30;
    private int numUsers; 
    private int numSongs;
    private int numPlaylist;

    private User users[];
    private Playlist thePlaylist[];
    private Song poolOfSongs[];
    
    /**
     *Constructor del Mcs
     */
    public Mcs(){
        users = new User[MAX_USERS];
        thePlaylist = new Playlist[MAX_PLAYLISTS];
        poolOfSongs = new Song[MAX_POOLOFSONGS];
        numUsers = 0;
        numSongs = 0;
        numPlaylist = 0;
    }
    
    /**
     * Método que nos retorna el nombre del usuario en una determinada posición del arreglo
     * pre: debe existir al menos un usuario creado en el arreglo de usuarios
     * pos: 
     * @param index posición en el arreglo de usuarios para saber a cual de ellos nos referimos
     */
    public String returnUserName(int index){
        index = index-1;
        String userName = "";
        userName = users[index].getUserName();
        return userName;
    }
    
    /** 
     * Método que me permite encontrar un usuario en particular para poder asignarlo a una playlist
     * pre: debe existir un usuario creado
     * pos:
     * @param name nombre del usuario a encontrar
     * @return User usuario a asignar a una playlist
     */
    public User whoIsThis(String name){
        boolean out = false;
        User myUser = null;
        for(int i = 0; i<MAX_USERS && !out; i++){
            myUser = users[i];
            if(myUser.getUserName().equals(name)){
                out = true;
            }
        }
        return myUser;
    }
    
    /** 
     * Método que crea un arreglo con los usuarios capaces de acceder a una determinada playlist restringida
     * @param indexes ubicación de los usuarios que pueden acceder a una playlist restringida
     * @return User[] un arreglo de usuarios que son capaces de acceder a la playlist restringida
     */
    public User[] restrictedUserArray(int[] indexes){
        User[] usersArray = new User[5];
        for(int i = 0; i<5; i++){
            usersArray[i] = users[indexes[i]];
        }
        return usersArray;
    }
    
    /** 
     * Método que me permite saber si aún se pueden crear usuarios
     * @return boolean que me determina si hay espacio o no
     */
    public boolean hasUser(){
        return numUsers < MAX_USERS;
    }
    
    /** 
     * Método que me permite saber si aún se pueden crear canciones
     * @return boolean que me determina si hay espacio o no
     */
    public boolean hasSongs(){
        return numSongs < MAX_POOLOFSONGS;
    }
    
    /** 
     * Método que me permite saber si aún se pueden crear canciones
     * @return boolean que me determina si hay espacio o no
     */
    public boolean hasPlaylist(){
        return numPlaylist < MAX_PLAYLISTS;
    }

    
    /** 
     * Método que permite crear un usuario
     * @param userName nombre de usuario
     * @param password contraseña del usuario
     * @param age edad del usuario
     */
    public void addUser(String userName, String password, int age){  
        boolean out = false;
        for(int i = 0; i < MAX_USERS && !out; i++){
            User aUser = users[i];
            if(aUser == null){
                aUser = new User(userName, password, age);
                out = true;
                users[i] = aUser;
                numUsers++;
            }
        }

    }
    
    
    /** 
     * Método que permite al usuario crear canciones y añadirlas directamente al pool de canciones
     * pre: debe estár declarado el array de pool of songs
     * pos:
     * @param title nombre de la canción
     * @param artistName nombre del artista
     * @param releasingDate fecha de salida
     * @param minutes los minutos que tiene la canción
     * @param seconds los segundos que tiene la canción
     */
    public void addSongToPool(String title, String artistName, String releasingDate, int minutes, int seconds, String songGender){//Desde aquí se crean las canciones y directamente se guardan en el pool
        Time duration = new Time(minutes, seconds);
        duration.setMinutes(minutes);
        duration.setSeconds(seconds);
        Gender genderOfSong = Gender.valueOf(songGender.toUpperCase());
        boolean out = false;
        for(int i = 0; i<MAX_POOLOFSONGS && !out; i++){
            if(poolOfSongs[i] == null){
                poolOfSongs[i] = new Song(title, artistName, releasingDate, duration, genderOfSong);
                out = true;
                numSongs++;
            }
        }
    }
    
    /** 
     * Método que permite añadir a una playlist una canción
     * pre: debe existir un array de playlist con al menos una playlist y debe existir un array de pool of song con al menos una canción
     * @param index1 playlist a la cual queremos añadir una canción
     * @param index2 canción la cual queremos añadir a una playlist
     */
    public void addToPlaylist(int index1, int index2){//Mandamos las canciones del pool a cualquier playlist disponible elegida por el usuario
        index1 = index1-1;
        index2 = index2-1;
        thePlaylist[index1].addAtOnce(poolOfSongs[index2]);
        
    }
   
    /** 
     * Método que muestra la información de todos los usuarios creados
     * pre: debe existir al menos un usuario creado en el arreglo del usuario
     * @return String , con la información de todos los usuarios creados hasta el momento
     */
    public String showUsers(){
        String msg = "";
        for(int i = 0; i<MAX_USERS; i++){
            if(users[i] != null){
                msg += users[i].userData();
            }
        }
        return msg;
    }
    
    /** 
     * Método que muestra la información de todas las canciones creadas hasta el momento
     * pre: debe existir al menos una canción en el arreglo de canciones
     * @return String , con la información de todas las canciones creadas hasta el momento
     */
    public String showSongs(){
        String msg = "";
        boolean out = false;
        for(int i = 0; i<MAX_POOLOFSONGS ; i++){
            if(poolOfSongs[i] != null){
                msg += poolOfSongs[i].showSongData();
            }
            
        }
        return msg;
    }
    
    /** 
     * Método que muestra los nombres de todos los usuarios creados hasta el momento
     * pre: debe existir al menos un usuario creado en el arreglo del usuario
     * @return String , con los nombres de todos los usuario creados hasta el momento
     */
    public String showNames(){
        String out = "";
        for(int i = 0; i<MAX_USERS ; i++){
            if(users[i] != null){
                out += "("+(i+1)+")"+users[i].getUserName()+",";
            }
        }
        return out;
    }
    
    /** 
     * Método que añade 1 al total de canciones compartidas por un usuario
     * @param namePosicion index donde se encuentra ubicado el usuario
     */
    public void userIndex(int namePosicion){
        int index = namePosicion-1;
        users[index].setAmountOfSong(users[index].getAmountOfSongs()+1); 
    }
    
    /** 
     * Método que actualiza el rango de cada usuario
     * pre: debe existir al menos un usuario creado en el arreglo del usuario
     * @param index , ubicación del usuario que deseamos actualizar su rango
     */
    public void updateRank(int index){
        index = index-1;
        if(users[index].getAmountOfSongs()>=3 && users[index].getAmountOfSongs()<10){
            
            users[index].setRank(users[index].convert("LITTLECONTRIBUTOR"));

        }else if(users[index].getAmountOfSongs()>=10 && users[index].getAmountOfSongs()<30){
            users[index].setRank(users[index].convert("MIDLECONTRIBUTOR"));
        }else if(users[index].getAmountOfSongs()==30){
            users[index].setRank(users[index].convert("STARCONTRIBUTOR"));
        }
    }
    
    /** 
     * Método que permite crear una playlist
     * pre: debe estar declarado un arreglo de playlist para poder guardar
     * @param name nombre de la playlist
     */
    public void createPlaylist(String name){
        boolean out = false;
        for(int i = 0; i<MAX_PLAYLISTS && !out; i++){
            if(thePlaylist[i] == null){
                Playlist mPlaylist = new PublicP(name);
                thePlaylist[i] = mPlaylist;
                numPlaylist++;
                out = true;
            }
        }
    }
    
    /** 
     * Método que permite crear una playlist
     * pre: debe estar declarado un arreglo de playlist para poder guardar
     * @param name nombre de la playlist
     * @param usersArray arreglo de usuarios los cuales tienen acceso a la playlist
     */
    public void createPlaylist(String name, User[] usersArray){
        boolean out = false;
        for(int i = 0; i<MAX_PLAYLISTS && !out; i++){
            Playlist mPlaylist = new Restricted(name, usersArray); //!Modificar
            thePlaylist[i] = mPlaylist;
            numPlaylist++;
            out = true;
        }
        
    }
    
    /** 
     * Método que permite crear una playlist
     * pre: debe estar declarado un arreglo de playlist para poder guardar
     * @param name the name of the playlist
     * @param myUser the name of the user that create the playlist
     */
    public void createPlaylist(String name, User myUser){
        boolean out = false;
        for(int i = 0; i<MAX_PLAYLISTS && !out; i++){
            
            Playlist mPlaylist = new PrivateP(name, myUser);
            thePlaylist[i] = mPlaylist;
            numPlaylist++;
            out = true;
        }
        
    }
    
    /** 
     * Método que permite mostrar todas las playlist creadas hasta el momento
     * pre: debe existir como mínimo una playlist en el arreglo de playlists
     * @return String , con toda la información de cada playlist
     */
    public String showPlaylists(){
        String out = "";
        for(int i = 0; i<MAX_PLAYLISTS; i++){
            if(thePlaylist[i] != null){
                thePlaylist[i].changeGendersOfPlaylist(thePlaylist[i].playlistAllGenders());
                thePlaylist[i].timeToFormat(thePlaylist[i].updateDuration());
                out += thePlaylist[i].playlistToString();
            }
            
        }
        
        return out;
    }
    
    
    /** 
     * Método que permite mostrar todas las playlists publicas creadas hasta el momento
     * pre: Debe existir como mínimo una playlist publica creada hasta el momento
     * @return String , con los nombres de todas las playlists publicas creadas hasta el momento
     */
    public String showPublicPlaylist(){
        String out = "";
        int posicion = 0;
        for(int i = 0; i < MAX_PLAYLISTS; i++){
            if(thePlaylist[i] != null){
                if(thePlaylist[i] instanceof PublicP){
                    out += "("+(posicion+1)+") "+thePlaylist[i].getName();
                    posicion++;
                }
            }
        }
        return out;
    }
    Playlist[] onlyPublicPlaylist;
    
    /** 
     * Método que permite guardar todas la playlist publicas en un arreglo
     * pre: debe existir por lo menos una playlist publica en el arreglo de canciones general
     * @return Playlist[] , arreglo con todas las playlists publicas creadas hasta el momento
     */
    public Playlist[] onlyPublicPlaylistsToScore(){ 
        onlyPublicPlaylist = new Playlist[MAX_PLAYLISTS];
        int posicion = 0;
        String out = "";
        for(int i = 0; i < MAX_PLAYLISTS; i++){
            if(thePlaylist[i] instanceof PublicP){
                if(onlyPublicPlaylist[posicion] == null){
                    onlyPublicPlaylist[posicion] = thePlaylist[i];
                    out += onlyPublicPlaylist[posicion].getName();
                    posicion++;
                }
            }
        }
        //System.out.println(out);
        return onlyPublicPlaylist;
    }
    
    /** 
     * Método que permite añadir valores de calificación a una playlist publica
     * pre:
     * @param onlyPublic arreglo de playlists publicas creadas hasta el momento
     * @param index posición de playlist a buscar
     * @param score calificación a asignar
     */
    public void updateScoreInPPlaylist(Playlist[] onlyPublic, int index, double score){
        boolean out = false;
        for(int i = 0; i < onlyPublic.length && !out; i++){
            Playlist var = null;
            if(onlyPublic[index].getName().equals(thePlaylist[i].getName())){
                var = thePlaylist[i];
                ((PublicP) var).setRate(score);                
                out = true;
            }
        }
    }
    
    /** 
     * Método que permite mostrar los nombres de todas las playlists creadas hasta el momento
     * pre: 
     * @return String
     */
    public String showPlaylistNames(){
        String out = "";
        for(int i = 0; i<MAX_PLAYLISTS; i++){
            if(thePlaylist[i] != null){
                out += "("+(i+1)+") "+thePlaylist[i].getName();
            }
            
        }
        return out;
    }
    
    /** 
     * Método que permite mostrar los nombres de todas las canciones creadas hasta el momento
     * pre:
     * @return String , que posee todos los nombres de todas las canciones creadas hasta el momento
     */
    public String showSongNames(){
        String out = "";
        for(int i = 0; i<MAX_POOLOFSONGS; i++){
            if(poolOfSongs[i] != null){
                out += "("+(i+1)+") "+poolOfSongs[i].getTitle();
            }
        }
        return out;
    }

    



}