
/**
 * Beschreiben Sie hier die Klasse ZahlenGenerator.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.util.Random;

public class ZahlenGenerator
{
    int[] zahlen = new int[1000];
    Random random = new Random();
    
    /**
     * Konstruktor für Objekte der Klasse ZahlenGenerator
     */
    public ZahlenGenerator()
    {
    }

    public void zahlenausgabe()
    {
        for (int i = 0; i < 10; i++){
            System.out.print("");
        }
    }
    
    public void erzeugeZahlen(){
        for(int i = 0; i < zahlen.length; i++){
            zahlen[i] = random.nextInt(999);
        }
    }
}
