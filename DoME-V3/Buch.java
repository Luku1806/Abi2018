
/**
 * Objekte dieser Klasse repräsentieren Buecher. Es werden
 * Informationen über ein Buch verwaltet, die wieder
 * abgefragt werden können.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Buch extends Medium
{
    private String autor;

    /**
     * Konstruktor für Objekte der Klasse Buch
     * @param derTitel Der Titel dieses Buches.
     * @param derAutor Der Regisseur dieses Buches.
     * @param laenge Die Seitenzahl des Buches.
     * @param pGenre Das Genre des Buches.
     */
    public Buch(String derTitel, String derAutor, int laenge, String pGenre)
    {
       super(derTitel,laenge,pGenre);
       autor = derAutor;
    }

     /**
     * Gib die Details des Buches auf der Konsole aus.
     */
    public void ausgeben()
    {
        System.out.print("Buch: " + titel + " (" + spielzeit + " Seiten)");
        if(habIch) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + autor);
        System.out.println("    " + genre);
        System.out.println("    " + kommentar);
    }
}
