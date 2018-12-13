/**
 * Die Klasse stellt Methoden zur Berechnung von Fakultaeten zur Verfuegung.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 03.02.2017
 */
public class FakRechner
{
    /**
     * Konstruktor
     */
    public FakRechner(){
    }

    /**
     * Berechnet die Fakultaet einer bestimmten Zahl 'n' mit Hilfe von Iteration.
     * 
     * @param n Die Zahl, zu der die Fakultaet berechnet werden soll.
     * @return Die Fakultaet der Zahl n.
     */
    public int fakultaet_iterativ(int n)
    {
        int temp = 1;
        for(int i = 1; i <= n; i++){
            temp *= i;
        }
        return temp;
    }

    /**
     * Berechnet die Fakultaet einer bestimmten Zahl 'n' mit Hilfe von Rekursion.
     * 
     * @param n Die Zahl, zu der die Fakultaet berechnet werden soll.
     * @return Die Fakultaet der Zahl n.
     */
    public int fakultaet_rekursiv(int n)
    {
        if(n <= 1){
            // Da 0!==1 && 1!==1 
            return 1;
        }else{
            return n * fakultaet_rekursiv(n-1);
        }
    }

    /**
     * Gibt einen Ausschnitt aus der Reihe der Fakultaeten auf der Konsole aus.
     * 
     * @param start Beginn des Ausschnittes der Fakultaeten.
     * @param end  Ende des Ausschnittes der Fakultaeten.
     */
    public void ausgabeFakultaeten(int start, int end){
        for(int i = start; i <= end; i++){
            System.out.println(String.format("%03d", i) + "! " + "Iterativ: " + fakultaet_iterativ(i));
            System.out.println("     Rekursiv: " + fakultaet_iterativ(i));
        }
    }
}
