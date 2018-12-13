
/**
 * Beschreiben Sie hier die Klasse Schiedsrichter.
 * 
 * @author (Kilian und Lukas) 
 * @version (1.0)
 */
public class Schiedsrichter
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Spieler spieler1 , spieler2;

    /**
     * Konstruktor für Objekte der Klasse Schiedsrichter
     */
    public Schiedsrichter(Spieler pSpieler1 , Spieler pSpieler2)
    {
       spieler1 = pSpieler1;
       spieler2 = pSpieler2;
    }
    
    /**
     * Vergleicht die Punkte zwischen Spieler 1 und 2 und gibt dem besseren den Topf.
     */
    public void auswerten(){
        if(spieler1.getPunktestand() < spieler2.getPunktestand()){
            spieler2.topfLeeren();
            System.out.println(spieler2.getName() + " gewinnt und bekommt den Inhalt des Topfes.");
        }else if(spieler1.getPunktestand() > spieler2.getPunktestand()){
            spieler1.topfLeeren();
            System.out.println(spieler1.getName() + " gewinnt und bekommt den Inhalt des Topfes.");
        }
    }
}
