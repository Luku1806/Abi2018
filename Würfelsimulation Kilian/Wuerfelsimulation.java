
/**
 * Die Klasse erzeugt eine W�rfelsimulation.
 * Diese kann 30 zuf�llige W�rfe machen, den Durschnitt und die Summe der Augen aller W�rfe berechnen.
 * Au�erdem k�nnen die W�rfelergebnisse sowie Summe und Durchschnitt auf der Konsole ausgegeben werden.
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
     * Konstruktor f�r Objekte der Klasse Wuerfelsimulation.
     * Beim Erzeugen eines W�rfelexperimentes wird ein erstes mal gew�rfelt.
     */
    public Wuerfelsimulation()
    {
        wuerfeln();
    }
    
     /**
     * Der Durchschnitt der Augenzahlen aller W�rfe wird berechnet.
     * @return Der berechnete Durchschnitt
     */
    public double durchschnitt(){
        return (double) summe() / wuerfe.length;
    }
    
    /**
     * Die Summe der Augen aller W�rfe wird berechnet.
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
     * Gibt f�r jeden Wurf die gew�rfelte Augenzahl auf der Konsole aus.
     * Danach gibt er noch die Summe und den Durchschnitt auf der Konsole aus.
     */
    public void ausgeben(){
        for(int i = 0; i < wuerfe.length; i++){
            System.out.println("Wurf " + (i+1) + " ergab " + wuerfe[i]);
        }
        System.out.println("Die Summe der gew�rfelten Zahlen betr�gt " +  summe());
        System.out.println("Der Durchschnitt der gew�rfelten Zahlen betr�gt " +  durchschnitt());
    }
    
    /**
     * Weist jedem Wurf einen zuf�lligen Wert zwischen 1 und 6 zu 
     * und simuliert so einen W�rfel
     */
    public void wuerfeln(){
        for(int i = 0; i < wuerfe.length; i++){
            wuerfe[i] = random.nextInt(6)+ 1;
        }
    }
}
