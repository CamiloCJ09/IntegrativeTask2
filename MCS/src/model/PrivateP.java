package model;

public class PrivateP extends Playlist {
    private User myUser;
    public PrivateP(String name, User myUser){
        super(name);
        this.myUser = myUser;
    }
    
    /** 
     * @param mysUser
     */
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
