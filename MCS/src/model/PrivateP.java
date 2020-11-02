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
        this.myUser = myUser;
    }

    
    /** 
     * @return User
     */
    public User getMyUser() {
        return myUser;
    }

    
    /** 
     * @return double
     */
    @Override
    public double rateAverage(){
        double p1 = 0;
        return p1;
    }
    
    /** 
     * @return String
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
        
    /** 
    * @param rate
    */
    @Override
    public void setRate(double rate) {}

}
