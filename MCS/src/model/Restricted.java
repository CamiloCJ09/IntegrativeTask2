package model;

public class Restricted extends Playlist {
    public final int MAX_MYUSERS = 5;
    private User myUsers[] = new User[MAX_MYUSERS];

    public Restricted(String name, User[] myUsers){
        super(name);
        this.myUsers = myUsers;
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
    public String showAllUsers(){
        String out0 = "";
        for(int i = 0; i<5; i++){
            out0 += myUsers[i].getUserName()+", ";
        }
        return out0;
    }
    @Override
    public String playlistToString(){
        String out = "";
        out ="********** Playlist **********\n"+
             "** Title: "+getName()+"\n"+
             "** Duration: "+timeToFormat(updateDuration())+"\n"+
             "** Genre: "+getSongGender()+"\n"+
             "** Users: "+showAllUsers()+"\n"+
             "******************************\n";

        return out;
    }

}
