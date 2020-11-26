package model;

public class PrivateP extends Playlist {
    private User myUser;
    public PrivateP(String name, User myUser){
        super(name);
        this.myUser = myUser;
    }

    public void setMyUser(User mysUser){
        this.myUser = mysUser;
    }

    public User getMyUser() {
        return myUser;
    }

    /** 
     * Method that prints all the information of a playlist
     * @return String , information of the playlist
     */
    @Override
    public String playlistToString(){
        String out = super.playlistToString();
        out +="** User: "+myUser.getUserName()+"\n"+
             "******************************\n";

            return out;
        }

}
