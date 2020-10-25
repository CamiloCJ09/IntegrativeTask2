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
    public void setAmountOfSong(int amountOfSongs){
        this.amountOfSongs = amountOfSongs;
    }
    public int getAmountOfSongs(){
        return amountOfSongs;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setRank(Rank userRank){
        this.userRank = userRank;
    }
    public Rank getRank(){
        return userRank;
    }
    public Rank convert(String userRank){
        Rank myUserRank = Rank.valueOf(userRank);
        return myUserRank;

    }
}
