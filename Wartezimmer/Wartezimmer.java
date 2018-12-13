/**
 * Die Klasse stellt ein Wartezimmer da, in welchem die Patienten darauf warten koennen, dass sie dran genommen werden.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Wartezimmer
{
    // Instanzvariablen
    private Queue<Patient> warteschlange;
    private int anzahlPatienten;

    /**
     * Konstruktor für Objekte der Klasse Wartezimmer
     */
    public Wartezimmer()
    {
        warteschlange = new Queue<Patient>();
        anzahlPatienten = 0;
    }

    /**
     * Fuegt einen Patienten zu dem Wartezimmer hinzu.
     * @param pName Der Name des sich anstellenden Patienten.
     * @param pKrankenkasse Der Name der Krankenkasse des Patienten.
     */
    public void patientEinfuegen(String pName,String pKrankenkasse){
        warteschlange.enqueue(new Patient(pName,pKrankenkasse));
        anzahlPatienten++;
        System.out.println("\nEin Patient hat das Wartezimmer betreten.");
        zeigeAnzahlWartender();
    }

    /**
     * Ruft den ersten Patienten in der Reihe auf und der Patient nennt seine Daten.
     */
    public void patientAufrufen(){
        if(warteschlange.front() != null){
            Patient ersterPatient = warteschlange.front();
            ersterPatient.nennePatientendaten();
            warteschlange.dequeue();
            anzahlPatienten--;
            System.out.println();
            zeigeAnzahlWartender();
        }else{
            System.out.println("\nDas Wartezimmer ist bereis leer.");
        }
    }
    
    /**
     * Gibt die Anzahl wartenden Patieneten in der Konsole aus.
     */
    public void zeigeAnzahlWartender(){
        System.out.println("Es befinden sich nun " + anzahlPatienten+ " im Wartezimmer.");
    }
}
