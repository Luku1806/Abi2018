
/**
 * Die Klasse stellt Methoden zur Berechnung von Fibonaccizahlen verfuegung.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 03.02.2017
 */
public class FibRechner
{

    /**
     * Konstruktor
     */
    public FibRechner(){
    }

    /**
     * Berechnet eine beliebige Fibonaccizahl mit Hilfe von Rekursion. 
     * 
     * @param n Die zu berechnende Fibonaccizahl.
     * @return Die errechnete Fibonaccizahl.
     */
    public int fib_rekursiv(int n)
    {
        if(n<=1){
            return n;
        }else{
            return fib_rekursiv(n-1) + fib_rekursiv(n-2);
        }
    }

    /**
     * Berechnet eine beliebige Fibonaccizahl mit Hilfe von Iteration. 
     * 
     * @param n Die zu berechnende Fibonaccizahl.
     * @return Die errechnete Fibonaccizahl.
     */
    public int fib_iterativ(int n)
    {
        if(n<=1){
            return n;
        }else{
            int fib1 = 0;
            int fib2 = 1;
            for(int i = 1; i < n; i++){
                int neueZahl = fib1+fib2;
                fib1 = fib2;
                fib2 = neueZahl;
            }
            return fib2;
        }
    }
    
    /**
     * Gibt einen Ausschnitt aus der Reihe der Fibonaccizahlen auf der Konsole aus.
     * 
     * @param start Beginn des Ausschnittes der Fibonaccizahlen.
     * @param end  Ende des Ausschnittes der Fibonaccizahlen.
     */
    public void ausgabeFibonaccizahlen(int start, int end){
        for(int i = start; i <= end; i++){
            System.out.println("fib(" + String.format("%03d", i) + ") " + "Iterativ: " + fib_iterativ(i));
            System.out.println("         Rekursiv: " + fib_iterativ(i));
        }
    }
}
