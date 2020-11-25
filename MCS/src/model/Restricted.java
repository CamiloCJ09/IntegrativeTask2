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
    
    /** 
     * Método que muestra todos los usuarios que están asignados a esta playlist
     * @return String , coon los nombres de todos los usuarios 
     */
    public String showAllUsers(){
        String out0 = "";
        for(int i = 0; i<5; i++){
            out0 += myUsers[i].getUserName()+", ";
        }
        return out0;
    }
    
    /** 
     * Método que imprime toda la información de una playlist
     * @return String , información de la playlist
     */
    @Override
    public String playlistToString(){
        String out = super.playlistToString();
        out +="** Users: "+showAllUsers()+"\n"+
             "******************************\n";

        return out;
    }
    
    


}
