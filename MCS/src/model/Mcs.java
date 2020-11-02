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
     *
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
     *
     * @param index
     */
    public String returnUserName(int index){
        index = index-1;
        String userName = "";
        userName = users[index].getUserName();
        return userName;
    }
    
    /** 
     * @param name
     * @return User
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
     * @param indexes
     * @return User[]
     */
    public User[] restrictedUserArray(int[] indexes){
        User[] usersArray = new User[5];
        for(int i = 0; i<5; i++){
            usersArray[i] = users[indexes[i]];
        }
        return usersArray;
    }
    
    /** 
     * @return boolean
     */
    public boolean hasUser(){
        return numUsers < MAX_USERS;
    }
    
    /** 
     * @return boolean
     */
    public boolean hasSongs(){
        return numSongs < MAX_POOLOFSONGS;
    }
    
    /** 
     * @return boolean
     */
    public boolean hasPlaylist(){
        return numPlaylist < MAX_PLAYLISTS;
    }

    
    /** 
     * @param userName
     * @param password
     * @param age
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
     * @param title
     * @param artistName
     * @param releasingDate
     * @param minutes
     * @param seconds
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
     * @param index1
     * @param accessToPlaylist(
     */
    public void addToPlaylist(int index1, int index2){//Mandamos las canciones del pool a cualquier playlist disponible elegida por el usuario
        index1 = index1-1;
        index2 = index2-1;
        thePlaylist[index1].addAtOnce(poolOfSongs[index2]);
        
    }
    
    /** 
     * @return boolean
     */
    public boolean accessToPlaylist(){
        boolean var = false;

        return var;
    }
    
    /** 
     * @return String
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
     * @return String
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
     * @return String
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
     * @param namePosicion
     */
    public void userIndex(int namePosicion){
        int index = namePosicion-1;
        users[index].setAmountOfSong(users[index].getAmountOfSongs()+1); 
    }
    
    /** 
     * @param index
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
     * @param name
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
     * @param name
     * @param usersArray
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
     * @param name
     * @param myUser
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
     * @return String
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
     * @return String
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
     * @return Playlist[]
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
        System.out.println(out);
        return onlyPublicPlaylist;
    }
    
    /** 
     * @param onlyPublic
     * @param index
     * @param score
     */
    public void updateScoreInPPlaylist(Playlist[] onlyPublic, int index, double score){
        boolean out = false;
        for(int i = 0; i < onlyPublic.length && !out; i++){
            if(onlyPublic[index].getName().equals(thePlaylist[i].getName())){
                thePlaylist[i].setRate(score);
                out = true;
            }
        }
    }
    
    /** 
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
     * @return String
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
    
    /** 
     * @param grade
     * @return double[]
     */
    public double[] askGradePublicPlaylist(double grade){
        boolean out = false;
        double[] average = new double[MAX_USERS];
        for(int i = 0; i<MAX_USERS; i++){
            if(average[i] != 0){
                average[i] = grade;
            }
        }
        return average;
    }

    
    
}
