package model;

public class PublicP extends Playlist {
    private double Avrate;
    private double[] rates;
    public PublicP(String name){  //Todo: double[] rates
        super(name);
        this.rates = new double[10];
    }
    public double rateAverage(){
        double theAverage = 0;
        for(int i = 0; i<10; i++){
            theAverage += rates[i];
        }
        theAverage = theAverage/10;
        return theAverage;
    }
    @Override
    public String playlistToString(){
        String out = "";
        out ="********** Playlist **********\n"+
             "** Title: "+getName()+"\n"+
             "** Duration: "+timeToFormat(updateDuration())+"\n"+
             "** Genre: "+changeGendersOfPlaylist(playlistAllGenders())+"\n"+
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
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rates = rates;
    }

}
