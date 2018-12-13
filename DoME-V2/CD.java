/**
 * Objekte dieser Klasse repräsentieren CDs. 
 * Sie speichern Informationen über eine CD, die
 * wieder abgefragt werden können.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2006.03.30
 */
public class CD extends Medium
{
    private String kuenstler;
    private int titelanzahl;

    /**
     * Initialisierung einer CD.
     * @param derTitel der Titel der CD.
     * @param derKuenstler der Kuenstler dieser CD.
     * @param stuecke die Anzahl der Stuecke auf der CD.
     * @param laenge die Spielzeit der CD.
     * @param pGenre Das Genre des Mediums.
     */
    public CD(String derTitel, String derKuenstler, int stuecke, int laenge, String pGenre)
    {
        super(derTitel,laenge,pGenre);
        kuenstler = derKuenstler;
        titelanzahl = stuecke;
    }

    /**
     * Gib Details über diese CD auf der Konsole aus.
     */
    @Override
    public void ausgeben()
    {
        System.out.print("CD: " + titel + " (" + spielzeit + " Min)");
        if(habIch) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + kuenstler);
        System.out.println("    " + genre);
        System.out.println("    Titelanzahl: " + titelanzahl);
        System.out.println("    " + kommentar);
    }
}
