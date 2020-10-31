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
    
    public Mcs(){
        users = new User[MAX_USERS];
        thePlaylist = new Playlist[MAX_PLAYLISTS];
        poolOfSongs = new Song[MAX_POOLOFSONGS];
        numUsers = 0;
        numSongs = 0;
        numPlaylist = 0;
    }
    public String returnUserName(int index){
        index = index-1;
        String userName = "";
        userName = users[index].getUserName();
        return userName;
    }
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
    public User[] restrictedUserArray(int[] indexes){
        User[] usersArray = new User[5];
        for(int i = 0; i<5; i++){
            usersArray[i] = users[indexes[i]];
        }
        return usersArray;
    }
    public boolean hasUser(){
        return numUsers < MAX_USERS;
    }
    public boolean hasSongs(){
        return numSongs < MAX_POOLOFSONGS;
    }
    public boolean hasPlaylist(){
        return numPlaylist < MAX_PLAYLISTS;
    }

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
    public void addToPlaylist(int index1, int index2){//Mandamos las canciones del pool a cualquier playlist disponible elegida por el usuario
        index1 = index1-1;
        index2 = index2-1;
        thePlaylist[index1].addAtOnce(poolOfSongs[index2]);
        
    }
    public boolean accessToPlaylist(){
        boolean var = false;

        return var;
    }
    public String showUsers(){
        String msg = "";
        for(int i = 0; i<MAX_USERS; i++){
            if(users[i] != null){
                msg += users[i].userData();
            }
        }
        return msg;
    }
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
    public String showNames(){
        String out = "";
        for(int i = 0; i<MAX_USERS ; i++){
            if(users[i] != null){
                out += "("+(i+1)+")"+users[i].getUserName()+",";
            }
        }
        return out;
    }
    public void userIndex(int namePosicion){
        int index = namePosicion-1;
        users[index].setAmountOfSong(users[index].getAmountOfSongs()+1); 
    }
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
    public void createPublicPlaylist(String name){
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
    public void createRestrictedPlaylist(String name, User[] usersArray){
        boolean out = false;
        for(int i = 0; i<MAX_PLAYLISTS && !out; i++){
            Playlist mPlaylist = new Restricted(name, usersArray); //!Modificar
            
            thePlaylist[i] = mPlaylist;
            numPlaylist++;
            out = true;
        }
        
    }
    public void createPrivatePlaylist(String name, User myUser){
        boolean out = false;
        for(int i = 0; i<MAX_PLAYLISTS && !out; i++){
            
            Playlist mPlaylist = new PrivateP(name, myUser);
            thePlaylist[i] = mPlaylist;
            numPlaylist++;
            out = true;
        }
        
    }
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
    public String showPlaylistNames(){
        String out = "";
        for(int i = 0; i<MAX_PLAYLISTS; i++){
            if(thePlaylist[i] != null){
                out += "("+(i+1)+") "+thePlaylist[i].getName();
            }
            
        }
        return out;
    }
    public String showSongNames(){
        String out = "";
        for(int i = 0; i<MAX_POOLOFSONGS; i++){
            if(poolOfSongs[i] != null){
                out += "("+(i+1)+") "+poolOfSongs[i].getTitle();
            }
        }
        return out;
    }
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
