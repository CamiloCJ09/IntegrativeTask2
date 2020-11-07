package model;

public class PublicP extends Playlist {
    private double[] rates;
    private double score;
    private int count;

    /**
     * Constructor de la playlist publica
     * @param name , nombre de la playlist publica
     */
    public PublicP(String name){  //Todo: double[] rates
        super(name);
        this.rates = new double[10];
    }
    
    /** 
     * Método que calcula la calificación promedio
     * @return double , con el promedio
     */
    public double rateAverage(){
        double theAverage = 0;
        theAverage = score;
        return theAverage/count;
    }
    
    
    /** 
     * Método que imprime toda la información de una playlist
     * @return String , información de la playlist
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
