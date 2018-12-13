/**
 * Ein T-Shirt fuer den T-Shirtshop.
 * 
 * @author Lukas Reining
 * @version 12.01.2018
 */
public class TShirt{
    
    private String groesse;
    private String farbe;
    private double preis = 19.95;

    /**
     * Constructor for objects of class TShirt
     */
    public TShirt(String groesse, String farbe){
        this.groesse = groesse;
        this.farbe = farbe;
    }
    
    //Getter fuer alle Attribute
    public String getGroesse(){
        return this.groesse;
    }
    
    public String getFarbe(){
        return this.farbe;
    }
    
    public double getPreis(){
        return this.preis;
    }
}
