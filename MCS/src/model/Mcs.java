package model;



public class Mcs {

    public static int MAX_USERS = 2;
    public static int MAX_PLAYLISTS = 20;
    public static int MAX_POOLOFSONGS = 2;
    private int numUsers;
    private int numSongs;

    private User users[];
    private Playlist thePlaylist[];
    private Song poolOfSongs[];
    
    public Mcs(){
        users = new User[MAX_USERS];
        thePlaylist = new Playlist[MAX_PLAYLISTS];
        poolOfSongs = new Song[MAX_POOLOFSONGS];
        numUsers = 0;
        numSongs = 0;
    }
    public boolean hasUser(){
        return numUsers < MAX_USERS;
    }
    public boolean hasSongs(){
        return numSongs < MAX_POOLOFSONGS;
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
    public void addPlaylist(String name, String songGender){
        
        for(int i = 0; i < MAX_PLAYLISTS; i++){
            if(thePlaylist[i] == null){
                //thePlaylist[i] = new Playlist(name, genderOfSong, duration);
                //System.out.println(thePlaylist[i].getName()+" Duracion "+thePlaylist[i].getDuration().getMinutes()+ thePlaylist[i].getDuration().getSeconds()+" Genero "+thePlaylist[i].getSongGender());
            }
        }
        
    }
    public void addSongToPool(String title, String artistName, String releasingDate, int minutes, int seconds, String songGender){//Desde aquí se crean las canciones y directamente se guardan en el pool
        Time duration = new Time(minutes, seconds);
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
    public void addToPlaylist(){//Mandamos las canciones del pool a cualquier playlist disponible elegida por el usuario

    }
    public boolean accessToPlaylist(){
        boolean var = false;

        return var;
    }
    public String showUsers(){
        String msg = "";
        for(int i = 0; i<MAX_USERS; i++){
            if(users[i] != null){
                msg += "********** User **********\n"+
                "** UserName: "+users[i].getUserName()+"\n"+
                "** Age: "+users[i].getAge()+"\n"+
                "** Category: "+users[i].getRank()+"\n"+
                "**************************\n";
            }
        }
        return msg;
    }
    public String showSongs(){
        String msg = "";
        boolean out = false;
        for(int i = 0; i<MAX_POOLOFSONGS ; i++){
            if(poolOfSongs[i] != null){
                msg += "********** Song **********\n"+
                "** Title: "+poolOfSongs[i].getTitle()+"\n"+
                "** Artist: "+poolOfSongs[i].getArtistName()+"\n"+
                "** Duration: "+poolOfSongs[i].getDuration().toString()+"\n"+
                "** Genre: "+poolOfSongs[i].getSongGender()+"\n"+
                "**************************\n";
                
            }
            
        }
        return msg;
    }


    
    
}
