//import java.util. *;

/**
 * Klasse Wuerfel nach Beschreibung
 * 
 * @author David Tepaße
 * @version 01
 */

public class Wuerfel
{
   /**
    * Attribut der Klasse Wuerfel:
    */
    private int punkte;

    /**
     * Konstruktor für Objekte der Klasse Wuerfel:
     */
    public Wuerfel()
    {
        // initialisiert die Augenzahl mit 0 
        punkte = 0;
    }
   
   /**
    * Diese Methode gibt die gewürfelte Augenzahl zurück.
    */
   public int punktzahlAngeben ()
   {
      return this.punkte;
   }
   
   /**
    * Diese Methode liefert einen Zufallswert zwischen 1 und maximum 
    */
   
   private int zufallsZahlAusgeben(int maximum)
   { 
      int wert=0;
      wert =(int)Math.round(Math.random()*(maximum-1))+1;
      return wert;
   }

   /**
    * lässt den Würfel rollen
    */
   public void rollen ()
   {
      this.punkte = zufallsZahlAusgeben(6);
   }

}

