/**
 * Die Klasse Medium. Sie dient als Superklasse fuer Medien wie CD und DVD.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public abstract class Medium
{
    protected String titel;
    protected int spielzeit;
    protected String genre;
    protected boolean habIch;
    protected String kommentar;

    /**
     * Konstruktor für die Klasse Medium.
     * @param derTitel Der Titel des Mediums.
     * @param laenge Die Spielzeit des Mediums.
     * @param pGenre Das Genre des Mediums.
     */
    public Medium(String derTitel, int laenge, String pGenre)
    {
        titel = derTitel;
        spielzeit = laenge;
        genre = pGenre;
        habIch = false;
        kommentar = "<kein Kommentar>";
    }
    
     /**
     * Setze einen Kommentar für dieses Medium.
     * @param kommentar Der einzutragende Kommentar.
     */
    public void setzeKommentar(String kommentar)
    {
        this.kommentar = kommentar;
    }

     /**
     * @return den Kommentar für dieses Medium.
     */
    public String gibKommentar()
    {
        return kommentar;
    }
    
    /**
     * Setze, ob wir dieses Medium in unserer Sammlung haben.
     * @param vorhanden true, wenn wir das Medium haben, false sonst.
     */
    public void setzeVorhanden(boolean vorhanden)
    {
        habIch = vorhanden;
    }
    
    /**
     * @return true, wenn wir diese CD in
     * unserer Sammlung haben.
     */
    public boolean gibVorhanden()
    {
        return habIch;
    }
    
    public abstract void ausgeben();

}
