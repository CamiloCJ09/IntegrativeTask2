package model;

public class PublicP extends Playlist {
    private double[] rates;
    private double score;
    private int count;
    public PublicP(String name){  //Todo: double[] rates
        super(name);
        this.rates = new double[10];
    }
    
    /** 
     * @return double
     */
    @Override
    public double rateAverage(){
        double theAverage = 0;
        theAverage = score;
        return theAverage/count;
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
             "** Score: "+rateAverage()+"\n"+
             "******************************\n";

        return out;
    }

    /**
     * @return double return the rate
     */
    public double[] getRate() {
        return rates;
    }
    
    /** 
     * @param rates
     */
    public void setRate(double[] rates){
        this.rates = rates;
    }
    /**
     * @param rates the rate to set
     */
    public void setRate(double userScore) {
        score += userScore;
        count++;
    }

}
