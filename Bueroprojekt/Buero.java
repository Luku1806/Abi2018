/**
 * Die Klasse beschreibt ein Buero zu dem Personen kommen koennen, sich anstellen koennen und drangenommen werden.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Buero
{
    private Queue<Person> warteschlange;
    private int anzahlWartender;

    /**
     * Konstruktor für Objekte der Klasse Buero
     */
    public Buero(){
        warteschlange = new Queue<Person>();
        anzahlWartender = 0;
    }

    /**
     * Eine Person stellt sich an der Warteschlange an.
     * @param pName Der Name der sich anstellenden Person.
     */
    public void hintenAnstellen(String pName){
        warteschlange.enqueue(new Person(pName));
        anzahlWartender++;
        System.out.println("Eine Person hat das Wartezimmer betreten. Es warten jetzt " + anzahlWartender + " Personen.");
    }

    /**
     * Die erste Person in der Warteschlange wird in das Buero gebeten.
     */
    public void einlassen(){
        System.out.println("Der naechste bitte.");
        if(warteschlange.front() != null){
            warteschlange.front().vorstellen();
            warteschlange.dequeue();
            anzahlWartender--;
            System.out.println("Es warten jetzt " + anzahlWartender + " Personen.");
        }else{
            System.out.println("Es befindet sich niemand im Wartezimmer.");
        }
    }
    
    /**
     * Alle anstehenden Personen verlassen die Warteschlange.
     */
    public void sprechstundeBeenden(){
        while(warteschlange.front() != null){
            warteschlange.dequeue();
        }
        anzahlWartender = 0;
        System.out.println("Die Sprechstunde ist beendet, kommen sie spaeter wieder.");
    }
}
