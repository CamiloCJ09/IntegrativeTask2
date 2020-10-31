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
             "** Duration: "+timeToFormat(updateDuration())+"\n"+
             "** Genre: "+changeGendersOfPlaylist(playlistAllGenders())+"\n"+
             "** User: "+myUser.getUserName()+"\n"+
             "******************************\n";

            return out;
        }

}
