/**
 * Klasse Spieler mit Fehlern
 * 
 * @author David Tepaße
 * @version 01
 * 
 * in dieser Klasse ist ein Fehler. Sie stimmt nicht mit
 * der Beschreibung unseres Spiels überein! Finden und korrigieren sie ihn.
 * 
 */

public class Spieler  
{
    /**
     * Eine Person kennt zwei Würfel und den Topf:
     */ 

    private   Wuerfel wuerfel1;
    private   Wuerfel wuerfel2;
    private   Topf topf;

    /** 
     * Hier folgen die Attribute der Klasse Person:
     */

    private String name;
    private int punkte;
    private int vermoegen;
    private int wurfAnzahl;
    private boolean hatGesetzt;
    private boolean zugBeendet = false;

    /**
     * Konstruktor für Objekte der Klasse Spieler
     * Mit der folgenden Methode wird ein Objekt der Klasse Spieler hergestellt.
     */
    public Spieler(Wuerfel pWuerfel1, Wuerfel pWuerfel2, Topf pTopf)
    {
        this.wuerfel1 = pWuerfel1;
        this.wuerfel2 = pWuerfel2;
        this.topf = pTopf;
        this.vermoegen = 1000;
    }

    /**
     * (Hier fehlen die Kommentare. Das ist Ihre Aufgabe:.........)
     */
    public void topfLeeren ()
    {
        this.vermoegen = this.vermoegen + this.topf.einsatzAbgeben();
        this.punkte = 0;
        this.wurfAnzahl = 0;
    }
    
    public void starteNeueRunde(){
        this.wurfAnzahl = 0;
        this.punkte = 0;
        this.zugBeendet = false;
        this.hatGesetzt = false;
    }

    /**
     * 
     */
    public int wurfAnzahlAngeben ()
    {
        return this.wurfAnzahl;
    }

    /**
     * 
     */
    public void einsatzSetzen(int einsatz)
    {
        if (this.vermoegen < einsatz)
        {
            einsatz = this.vermoegen;
        } 
        this.topf.einsatzAufnehmen(einsatz);
        this.vermoegen=this.vermoegen-einsatz;
        this.hatGesetzt=true; 
    }

    /**
     * 
     */
    public void wuerfeln ()
    {
        if(!this.zugBeendet){
            wuerfel1.rollen();
            wuerfel2.rollen();
            if(wuerfel1.punktzahlAngeben()+wuerfel2.punktzahlAngeben() != 7){
                this.punkte += wuerfel1.punktzahlAngeben()+wuerfel2.punktzahlAngeben();
            }else{
                zugBeenden();
                punkte -= 7;
            }
            this.wurfAnzahl++;
        }
    }

    /**
     * Beendet den Zug des Spielers, sodass dieser nicht mehr Würfeln kann
     */
    public void zugBeenden(){
        this.zugBeendet = true;
    }

    /**
     * 
     */
    public void setName (String neuerName)
    {
        this.name = neuerName;
    }

    /**
     * Die bis dahin erreichte Punktesumme wird zurückgegeben.
     * 
     */
    public int getPunktestand()
    {
        return this.punkte;
    }
    
    /**
     * 
     */
    public boolean hatGesetzt()
    {
        return this.hatGesetzt;
    }

    /**
     * 
     */
    public boolean hatZugBeendet()
    {
        return this.zugBeendet;
    }

    /**
     * 
     */
    public String getName()
    {
        return this.name;
    }

    public int getVermoegen(){
        return this.vermoegen;
    }

    public int getZuege(){
        return this.wurfAnzahl;
    }
}

