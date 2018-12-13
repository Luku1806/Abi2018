/**
 * Die Klasse beschribt eine Person mit einem Namen,Vornamen und Geschlecht.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 20.03.2017
 */
public class Person
{
    // Attribute
    private String name,vorname;
    private char geschlecht;

    /**
     * Konstruktor fuer Objekte der Klasse Person
     */
    public Person(String pName, String pVorname, char pGeschlecht)
    {
        name = pName;
        vorname = pVorname;
        geschlecht = pGeschlecht;
    }

    public String getName(){
        return this.name;
    }
    
     public String getVorname(){
        return this.vorname;
    }
    
     public char getGeschlecht(){
        return this.geschlecht;
    }
}
