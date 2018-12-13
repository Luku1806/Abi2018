
/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.util.*;

public class Main
{
   int[] zahlen = new int[30];
   Random random = new Random();
   
    /**
     * Konstruktor für Objekte der Klasse Main
     */
    public Main()
    {
        
    }
    
    public void ausgeben(){
        for(int i = 0; i < 30; i++){
            System.out.println("Wurf " + i + " =" + zahlen[i]);
        }
    }
    
    /**
     * 
     */
    public void wuerfeln(){
        for(int i = 0; i < 30; i++){
            zahlen[i] = random.nextInt(7);
        }
    }
}
