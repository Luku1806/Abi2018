/**
 * Die Klasse beschreibt eine Spielkarte.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 25.01.2017
 */
public class Karte
{
    //Konstanten
    public final static String[] FARBEN = {"Pik","Kreuz","Karo","Herz"}; //Die verfuegbaren Farben als Konstante
    public final static String[] BILDER = {"7","8","9","10","Bube","Dame","König","Ass"}; //Die verfuegbaren Bilder als Konstante
    //Attribute
    private String farbe;
    private String bild;

    /**
     * Konstruktor für Objekte der Klasse Karte
     */
    public Karte(String pFarbe, String pBild){
        farbe = pFarbe;
        bild = pBild;
    }

    /**
     * Die sondierende Methode fuer das Attribut farbe.
     * 
     * @return Die Farbe der Karte
     */
    public String getFarbe(){
        return this.farbe;
    }

    /**
     * Die sondierende Methode fuer das Attribut bild.
     * 
     * @return Das Bild der Karte
     */
    public String getBild(){
        return this.bild;
    }
}
