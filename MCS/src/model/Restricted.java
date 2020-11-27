package model;

public class Restricted extends Playlist {
    public final int MAX_MYUSERS = 5;
    private User myUsers[]; 

    public Restricted(String name, User[] myUsers){
        super(name);
        this.myUsers = new User[MAX_MYUSERS];;
    }

    /**
     * @return User return the myUsers
     */
    public User[] getMyUsers() {
        return myUsers;
    }

    /**
     * @param myUsers the myUsers[] to set
     */
    public void setMyUsers(User[] myUsers) {
        this.myUsers = myUsers;
    }
    
    /** 
     * Method that shows all the users that are assigned to this playlist
     * @return String , with the names of all users that have access to the playlist 
     */
    public String showAllUsers(){
        String out0 = "";
        for(int i = 0; i<5; i++){
            out0 += myUsers[i].getUserName()+", ";
        }
        return out0;
    }
    
    /** 
     * Method that prints all the information of a playlist
     * @return String , playlist information
     */
    @Override
    public String playlistToString(){
        String out = super.playlistToString();
        out +="** Users: "+showAllUsers()+"\n"+
             "******************************\n";

        return out;
    }
    
    


}
