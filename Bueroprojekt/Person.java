/**
 * Eine Person die sich im Buero anstellen kann.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Person
{
    // Instanzvariablen
    private String name;

    /**
     * Konstruktor für Objekte der Klasse Person
     */
    public Person(String pName)
    {
        name = pName;
    }
    
    /**
     * Die sondierende Methode fuer das Attribut name.
     * @return Der Name der Person.
     */
    public String getName(){
        return this.name;
    }
    
    public void vorstellen(){
        System.out.println("Hallo mein Name ist " + this.name + ".");
    }
}
