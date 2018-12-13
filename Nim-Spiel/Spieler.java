
/**
 * Der Spieler fuer das Nim-Spiel.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 25.06.2016
 */
public class Spieler
{
    //Variablen fuer den Spieler
    private int vermoegen;
    private String name;
    private boolean hatGesetzt = false;
    //Andere Spielobjekte
    private Topf topf;
    private Schachtel schachtel;

    /**
     * Konstruktor fuer Objekte der Klasse Spieler mit eigenen Namen
     */
    public Spieler(String pName , int pVermoegen , Topf pTopf , Schachtel pSchachtel){
        vermoegen = pVermoegen;
        name = pName;
        topf = pTopf;
        schachtel = pSchachtel;
    }

    /**
     * Laesst den Spieler seinen Einsatz in den Topf einzahlen.
     * @param pEinsatz Der Einsatz der Eingezahlt werden soll.
     */
    public void setzen(int pEinsatz){
        if(pEinsatz <= this.vermoegen){
            this.vermoegen -= pEinsatz;
            topf.setInhalt(topf.getInhalt() + pEinsatz);
            this.hatGesetzt = true;
        }
    }

    /**
     * Laesst den Spieler Hoelzer aus der Schachtel ziehen.
     * @param pAnzahl Die Anzahl an Hoelzern die gezogen wird.
     */
    public void ziehen(int pAnzahl){
        int hoelzerInSchachtel = schachtel.getAnzahl();
        if(hoelzerInSchachtel > pAnzahl){
            schachtel.setAnzahl(hoelzerInSchachtel - pAnzahl);
        }else{
            schachtel.setAnzahl(0);
        }
    }

    /**
     * Laesst den Spieler den Topf leeren.
     */
    public void topfLeeren(){
        this.vermoegen += topf.getInhalt();
        topf.setInhalt(0);
    }

    /**
     * Laesst den Spieler die Schachtel aufuellen.
     * @p pHoelzer Die Menge an Hoelzern die in die Schachtel sollen.
     */
    public void schachtelFuellen(int pHoelzer){
        schachtel.setAnzahl(pHoelzer);
    }

    /**
     * Setzt den das "hatGesetzt" Attribut zurueck um den Start einer neuen Runde zu ermoeglichen.
     */
    public void bereiteRundeVor(){
        this.hatGesetzt = false;
    }

    /**
     * Die sondierende Methode fuer das Attribut name.
     * @return Der Name des Spielers.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Die sondierende Methode fuer das Attribut vermoegen.
     * @return Das Vermoegen des Spielers.
     */
    public int getVermoegen(){
        return this.vermoegen;
    }

    /**
     * Die sondierende Methode fuer das Attribut hatGesetzt.
     * @return Gibt an ob der Spieler gesetzt hat.
     */
    public boolean hatGesetzt(){
        return this.hatGesetzt;
    }
}
