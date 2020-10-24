package model;

public class Restricted extends Playlist {
    public final int MAX_MYUSERS = 5;
    private User myUsers[];

    public Restricted(String name, Gender songGender, Time duration, User myUsers[]){
        super(name, songGender, duration);
        myUsers = new User[MAX_MYUSERS];
    }
}
