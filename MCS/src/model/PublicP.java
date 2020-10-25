package model;

public class PublicP extends Playlist {
    private double Avrate;
    private double[] rates = new double[10];
    public PublicP(String name){  //!double[] rates
        super(name);
        this.rates = rates;
    }
    public double rateAverage(){
        double theAverage = 0;
        for(int i = 0; i<10; i++){
            theAverage += rates[i];
        }
        theAverage = theAverage/10;
        return theAverage;
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
