
/**
 * Die Klasse erzeugt eine Würfelsimulation.
 * Diese kann 30 zufällige Würfe machen, den Durschnitt und die Summe der Augen aller Würfe berechnen.
 * Außerdem können die Würfelergebnisse sowie Summe und Durchschnitt auf der Konsole ausgegeben werden.
 * 
 * @author Lukas Reining 
 * @version 05.04.2016
 */

import java.util.*;

public class Wuerfelsimulation
{
   int[] wuerfe = new int[30];
   Random random = new Random();
   
    /**
     * Konstruktor für Objekte der Klasse Wuerfelsimulation.
     * Beim Erzeugen eines Würfelexperimentes wird ein erstes mal gewürfelt.
     */
    public Wuerfelsimulation()
    {
        wuerfeln();
    }
    
     /**
     * Der Durchschnitt der Augenzahlen aller Würfe wird berechnet.
     * @return Der berechnete Durchschnitt
     */
    public double durchschnitt(){
        return (double) summe() / wuerfe.length;
    }
    
    /**
     * Die Summe der Augen aller Würfe wird berechnet.
     * @return Die berechnete Summe
     */
    public int summe(){
        int summe = 0;
        for(int i = 0; i < wuerfe.length; i++){
            summe += wuerfe[i];
        }
        return summe;
    }
    
    /**
     * Gibt für jeden Wurf die gewürfelte Augenzahl auf der Konsole aus.
     * Danach gibt er noch die Summe und den Durchschnitt auf der Konsole aus.
     */
    public void ausgeben(){
        for(int i = 0; i < wuerfe.length; i++){
            System.out.println("Wurf " + (i+1) + " ergab " + wuerfe[i]);
        }
        System.out.println("Die Summe der gewürfelten Zahlen beträgt " +  summe());
        System.out.println("Der Durchschnitt der gewürfelten Zahlen beträgt " +  durchschnitt());
    }
    
    /**
     * Weist jedem Wurf einen zufälligen Wert zwischen 1 und 6 zu 
     * und simuliert so einen Würfel
     */
    public void wuerfeln(){
        for(int i = 0; i < wuerfe.length; i++){
            wuerfe[i] = random.nextInt(6)+ 1;
        }
    }
}
