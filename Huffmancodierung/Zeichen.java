/**
 * Die Klasse beschreibt ein Zeichen, welches zusammen mit sseiner Häufigkeit in einem Text gespeichert wird.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 26.04.2017
 */
public class Zeichen
{
    //Attribute
    private char zeichen;
    private int anzahl = 1;

    /**
     * Erstellt ein Zeichen.
     * 
     * @param pZeichen Das Zeichen.
     */
    public Zeichen(char pZeichen)
    {
        this.zeichen = pZeichen;
    }
    
     /**
     * Erstellt ein Zeichen mit voreingestellter Anzahl.
     * 
     * @param pZeichen Das Zeichen.
     */
    public Zeichen(char pZeichen, int pAnzahl)
    {
        this.zeichen = pZeichen;
        this.anzahl = pAnzahl;
    }

    /**
     * Erhoeht die Anzahl des Zeichens im Text um 1.
     */
    public void erhoeheAnzahl(){
        this.anzahl++;
    }


    /**
     * Gibt das Zeichen als char zurueck.
     * 
     * @return Das Zeichen.
     */
    public char getZeichen(){
        return this.zeichen;
    }

    /**
     * Gibt die Anzahl des Zeichens im Text zurueck.
     * 
     * @return Die Anzahl des Zeichens im Text.
     */
    public int getAnzahl(){
        return this.anzahl;
    }

    /**
     * Setzt die Anzahl des Zeichens im Text auf einen beliebeigen Wert.
     * 
     * @param pZahl Die zu setztende Anzahl des Zeichens im Text.
     */
    public void setAnzahl(int pZahl){
        this.anzahl = pZahl;
    }
}
