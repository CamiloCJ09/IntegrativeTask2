package model;

public class User {
    
    private String userName;
    private String password;
    private int age;
    private Rank userRank;
    private int amountOfSongs;

    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        userRank = Rank.NEWBIE;
        this.amountOfSongs = amountOfSongs;
    }
    
    /** 
     * @return String
     */
    public String userData(){
        String msg = "";
        msg += "********** User **********\n"+
                "** UserName: "+userName+"\n"+
                "** Age: "+age+"\n"+
                "** Category: "+userRank+"\n"+
                "**************************\n";
        return msg;
    }
    
    /** 
     * @param amountOfSongs
     */
    public void setAmountOfSong(int amountOfSongs){
        this.amountOfSongs = amountOfSongs;
    }
    
    /** 
     * @return int
     */
    public int getAmountOfSongs(){
        return amountOfSongs;
    }
    
    /** 
     * @param userName
     */
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    /** 
     * @return String
     */
    public String getUserName(){
        return userName;
    }
    
    /** 
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /** 
     * @return String
     */
    public String getPassword(){
        return password;
    }
    
    /** 
     * @param age
     */
    public void setAge(int age){
        this.age = age;
    }
    
    /** 
     * @return int
     */
    public int getAge(){
        return age;
    }
    
    /** 
     * @param userRank
     */
    public void setRank(Rank userRank){
        this.userRank = userRank;
    }
    
    /** 
     * @return Rank
     */
    public Rank getRank(){
        return userRank;
    }
    
    /** 
     * @param userRank
     * @return Rank
     */
    public Rank convert(String userRank){
        Rank myUserRank = Rank.valueOf(userRank);
        return myUserRank;

    }
}
