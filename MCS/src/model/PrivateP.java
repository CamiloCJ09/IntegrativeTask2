package model;

public class PrivateP extends Playlist {
    private User myUser;
    public PrivateP(String name, Gender songGender, Time duration, User myUser){
        super(name, songGender, duration);
        this.myUser = myUser;
    }
    public void setMyUser(User mysUser){
        this.myUser = myUser;
    }
}
