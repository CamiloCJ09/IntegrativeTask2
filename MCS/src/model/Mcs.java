package model;



public class Mcs {

    public static int MAX_USERS = 10; 
    public static int MAX_PLAYLISTS = 20;
    public static int MAX_POOLOFSONGS = 30;
    private int numUsers; 
    private int numSongs;
    private int numPlaylist;
    //Relations
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
     * Method that returns the name of the user in a certain position of the array
     * pre: there must be at least one user created in the user array
     * pos: 
     * @param index position in the arrangement of users to know which of them we refer to
     */
    public String returnUserName(int index){
        index = index-1;
        String userName = "";
        userName = users[index].getUserName();
        return userName;
    }
    
    /** 
     * Method that allows me to find a particular user to be able to assign it to a playlist
     * pre: there must be a user created
     * pos:
     * @param name username to find
     * @return user to assign to a playlist
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
     * Method that creates an arrangement with users able to access a certain restricted playlist
     * @param indexes location of users who can access a restricted playlist
     * @return User[] an array of users who are able to access the restricted playlist
     */
    public User[] restrictedUserArray(int[] indexes){
        User[] usersArray = new User[5];
        for(int i = 0; i<5; i++){
            usersArray[i] = users[indexes[i]];
        }
        return usersArray;
    }
    
    /** 
     * Method that lets me know if users can still be created
     * @return boolean that determines if there is space or not
     */
    public boolean hasUser(){
        return numUsers < MAX_USERS;
    }
    
    /** 
     * Method that lets me know if songs can still be created
     * @return boolean that determines if there is space or not
     */
    public boolean hasSongs(){
        return numSongs < MAX_POOLOFSONGS;
    }
    
    /** 
     * Method that lets me know if playlist can still be created
     * @return boolean that determines if there is space or not
     */
    public boolean hasPlaylist(){
        return numPlaylist < MAX_PLAYLISTS;
    }

    
    /** 
     * Method that create an user
     * Pre: Must have space in the users array
     * @param userName User name
     * @param password User password
     * @param age User age
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
     * Method that allows the user to create songs and add them directly to the song pool
     * pre: the pool of songs array must be declared
     * pos:
     * @param title Song name
     * @param artistName Artist name
     * @param releasingDate Release date
     * @param minutes Minutes that the song have
     * @param seconds Seconds that the song have
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
     * Method for adding a song to a playlist
     * pre: there must be a playlist array with at least one playlist and there must be a pool of song array with at least one song
     * @param index1 playlist to which we want to add a song
     * @param index2 song which we want to add to a playlist
     * @param index3 user who adds the song to the playlist
     */
    public String addToPlaylist(int index1, int index2, int index3){
        String msg = "";
        index1 = index1-1;
        index2 = index2-1;
        index3 = index3-1;
        boolean out = false;
        if(thePlaylist[index1] instanceof PrivateP){
            if(((PrivateP)thePlaylist[index1]).getMyUser().equals(users[index3])){
                thePlaylist[index1].addAtOnce(poolOfSongs[index2]);
                msg = "Canción añadida a la playlist";
            }else{
                msg = "No puedes añadir canciones a esta playlist";
            }
        }else if(thePlaylist[index1] instanceof Restricted){
            User[] restrictedUsers = ((Restricted)thePlaylist[index1]).getMyUsers();
            for(int i = 0; i < restrictedUsers.length && !out; i++){
                if(restrictedUsers[i].equals(users[index3])){
                    thePlaylist[index1].addAtOnce(poolOfSongs[index2]);
                    msg = "Canción añadida a la playlist";
                    out = true;
                }else{
                    msg = "No puedes añadir canciones a esta playlist";
                }
            }
        }else{
            thePlaylist[index1].addAtOnce(poolOfSongs[index2]);
            msg = "Canción añadida a la playlist";
        }
        return msg;
    }
   
    /** 
     * Method that displays the information of all created users
     * pre: there must be at least one user created in the user's array
     * @return String , with the information of all the users created so far
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
     * Method that displays the information of all songs created so far
     * pre: there must be at least one song in the song arrangement
     * @return String , with the information of all the songs created so far
     */
    public String showSongs(){
        String msg = "";
        for(int i = 0; i<MAX_POOLOFSONGS ; i++){
            if(poolOfSongs[i] != null){
                msg += poolOfSongs[i].showSongData();
            }
            
        }
        return msg;
    }
    
    /** 
     * Method that displays the names of all users created so far
     * pre: there must be at least one user created in the user's array
     * @return String , with the names of all the users created so far
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
    * Method that adds 1 to the total number of songs shared by a user
    * @param namePosition index where the user is located
     */
    public void userIndex(int namePosition){
        int index = namePosition-1;
        users[index].setAmountOfSong(users[index].getAmountOfSongs()+1); 
    }
    
    /** 
     * Method that updates the rank of each user
     * pre: there must be at least one user created in the user's array
     * @param index , location of the user we want to update their rank
     */
    public void updateRank(int index){
        index = index-1;
        if(users[index].getAmountOfSongs()>=3 && users[index].getAmountOfSongs()<10){
            users[index].setRank(users[index].convert("LITTLECONTRIBUTOR"));
        }else if(users[index].getAmountOfSongs()<30){
            users[index].setRank(users[index].convert("MIDLECONTRIBUTOR"));
        }else{
            users[index].setRank(users[index].convert("STARCONTRIBUTOR"));
        }
    }
    
    /** 
     * Method that allows creating a playlist
     * pre: a playlist arrangement must be declared in order to save
     * @param name name of the playlist
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
     * Method that allows creating a playlist
     * pre: a playlist arrangement must be declared in order to save
     * @param name name of the playlist
     * @param usersArray array of users who have access to the playlist
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
     * Method that allows creating a playlist
     * pre: a playlist arrangement must be declared in order to save
     * @param name the name of the playlist
     * @param myUser user that create the playlist
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
     * Method that allows showing all the playlists created so far
     * pre: there must be at least one playlist in the playlist array
     * @return String , with all the information of each playlist
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
     * Method that allows showing all the public playlists created so far
     * pre: There must be at least one public playlist created so far
     * @return String , with the names of all the public playlists created so far
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
     * Method that allows saving all the public playlists in an arrangement
     * pre: there must be at least one public playlist in the overall song arrangement
     * @return Playlist[] , array with all public playlists created so far
     */
    public Playlist[] onlyPublicPlaylistsToScore(){ 
        onlyPublicPlaylist = new Playlist[MAX_PLAYLISTS];
        int position = 0;
        for(int i = 0; i < MAX_PLAYLISTS; i++){
            if(thePlaylist[i] instanceof PublicP){
                if(onlyPublicPlaylist[position] == null){
                    onlyPublicPlaylist[position] = thePlaylist[i];
                    position++;
                }
            }
        }
        return onlyPublicPlaylist;
    }
    
    /** 
     * Method that allows adding rating values ​​to a public playlist
     * pre:
     * @param onlyPublic array of public playlists created so far
     * @param index playlist position to search
     * @param score grade to assign
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
     * Method that allows showing the names of all the playlists created so far
     * pre: 
     * @return String , with the name of the playlists
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
     * Method that allows displaying the names of all the songs created so far
     * pre:
     * @return String , which has all the names of all the songs created so far
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