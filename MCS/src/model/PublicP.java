package model;

public class PublicP extends Playlist {
    private double[] rates;
    private double score;
    private int count;

    /**
     * 
     *Public playlist builder
     * @param name , name of the public playlist
     */
    public PublicP(String name){  //Todo: double[] rates
        super(name);
        this.rates = new double[10];
    }
    
    /** 
     * Method that calculates the average grade
     * @return double , with the average
     */
    public double rateAverage(){
        double theAverage = 0;
        theAverage = score;
        return theAverage/count;
    }
    
    
    /** 
     * Method that prints all the information of a playlist
     * @return String , playlist information
     */
    @Override
    public String playlistToString(){
        String out = super.playlistToString();
        out +="** Score: "+rateAverage()+"\n"+
             "******************************\n";

        return out;
    }

    public double[] getRate() {
        return rates;
    }

    public void setRate(double[] rates){
        this.rates = rates;
    }

    public void setRate(double userScore) {
        score += userScore;
        count++;
    }

}
