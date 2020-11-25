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
     * Método que imprime toda la información de una playlist
     * @return String , información de la playlist
     */
    @Override
    public String playlistToString(){
        String out = super.playlistToString();
        out +="** User: "+myUser.getUserName()+"\n"+
             "******************************\n";

            return out;
        }

}
