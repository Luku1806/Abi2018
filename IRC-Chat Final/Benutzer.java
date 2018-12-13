
/**
 * Write a description of class Benutzer here.
 *
 * @author (Leon Schmidthuis, Jan Malte Gollan)
 * @version (Version 1.0 31.01.2018)
 */
public class Benutzer
{
    private String name;
    private String ipAdresse;
    private String color;

    /**
     * Konstruktor für die Klasse Benutzer
     */
    public Benutzer(String ipAdresse, String name, String color)
    {                           
        this.name = name;
        this.ipAdresse = ipAdresse;
        this.color = color;
    }

    /**
     * Get Methode für die Klasse Name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get Methode für die Klasse Color.
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Get Methode für die Klasse IpAdresse.
     */
    public String getIpAdresse()
    {
        return ipAdresse;
    }
    
    /**
     * Set Methode für die Klasse Name.
     */
    public void setName(String pName)
    {
         name= pName;
    }
    
     /**
     * Set Methode für die Klasse Color.
     */
    public void setColour(String pColor)
    {
        color = pColor;
    }
    
     /**
     * Set Methode für die Klasse IpAdresse.
     */
    public void setIpAdresse(String pIpAdresse){
        ipAdresse = pIpAdresse;
    }   
}