
/**
 * Die Klasse bietet eine Methode, die ein Array aus ganzen Zahlen als Parameter aufnimmt, und dieses in umgekehrter Reihenfolge auf der Konsole ausgibt.
 * 
 * @author Lukas Reining 
 * @version 09.11.2016
 */
public class Umkehrer
{
    private Queue<Integer> ausgangsZahlen;
    private Stack<Integer> umgekehrteZahlen;

    /**
     * Konstruktor für Objekte der Klasse Umkehrer
     */
    public Umkehrer(){
        ausgangsZahlen = new Queue<>();
        umgekehrteZahlen = new Stack<>();
        // Methode ausgabeZahlenfolge wird aufgerufen um die Funktionsweise der Klasse bei Erstellung eines Objektes zu demonstrieren.
        int[] test = {1,2,3,4,5,6,7,8,9,10};
        ausgabeZahlenfolge(test);
    }

    /**
     * Gibt die im Parameter eingegebene Zahlenfolge in umgekehrter Reihenfolge auf der Konsole aus.
     * @param pZahlenfolge Die Ausgangszahlenfolge, die umgekehrt ausgegeben wird.
     */
    public void ausgabeZahlenfolge(int[] pZahlenfolge){
        // Fuellt die Queue mit den Werten aus dem Parameter
        for(int i=0; i<pZahlenfolge.length; i++){
            ausgangsZahlen.enqueue(pZahlenfolge[i]);
        }
        // Uebertraegt die Werte der Queue in den Stack
        while(!ausgangsZahlen.isEmpty()){
            umgekehrteZahlen.push(ausgangsZahlen.front());
            ausgangsZahlen.dequeue();
        }
        // Gibt alle Werte des Stackes auf der Konsole aus
        while(!umgekehrteZahlen.isEmpty()){
            System.out.println(umgekehrteZahlen.top());
            umgekehrteZahlen.pop();
        }
    }
}
