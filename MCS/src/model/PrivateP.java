package model;

public class PrivateP extends Playlist {
    private User myUser;
    public PrivateP(String name, User myUser){
        super(name);
        this.myUser = myUser;
    }
    public void setMyUser(User mysUser){
        this.myUser = myUser;
    }

    public User getMyUser() {
        return myUser;
    }
    @Override
    public String playlistToString(){
        String out = "";
        out ="********** Playlist **********\n"+
             "** Title: "+getName()+"\n"+
             "** Duration: "+getDuration()+"\n"+
             "** Genre: "+getSongGender()+"\n"+
             "** User: "+myUser.getUserName()+"\n"+
             "******************************\n";

        return out;
    }

}
