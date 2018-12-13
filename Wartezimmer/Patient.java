
/**
 * Die Klasse stellt einen Patienten dar.
 * 
 * @author Lukas Reining 
 * @version 1.0
 */
public class Patient
{
    // Instanzvariablen
    private String name;
    private String krankenkasse;

    /**
     * Konstruktor für Objekte der Klasse Patient
     */
    public Patient(String pName,String pKrankenkasse)
    {
       name = pName;
       krankenkasse = pKrankenkasse;
    }
    
    /**
     * Der Patient nennt seine persoenlichen Daten.
     */
    public void nennePatientendaten(){
        System.out.println("\nMein Name ist " + this.name + ".");
        System.out.println("Ich bin bei der " + this.krankenkasse + " versichert.");
    }
}
