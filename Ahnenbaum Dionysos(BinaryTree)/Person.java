/**
 * Die Klasse beschribt eine Person mit einem Namen.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 20.03.2017
 */
public class Person
{
    // Attribute
    private String name;

    /**
     * Konstruktor für Objekte der Klasse Person
     */
    public Person(String pName)
    {
        name = pName;
    }

    public String getName(){
        return this.name;
    }
}
