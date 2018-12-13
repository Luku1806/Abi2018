/**
 * Die Klasse beschreibt ein Kartenspiel.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 25.01.2017
 */
public class Kartenspiel
{
    //Attribute
    private Karte[] karten;

    /**
     * Konstruktor für Objekte der Klasse Kartenspiel.
     * Kartenstapel wird erstellt und befuellt.
     */
    public Kartenspiel()
    {
        karten = new Karte[32];
        fuellen();
    }

    /**
     * Fuellt den Kartenstapel mit allen verfuegbaren Karten.
     */
    public void fuellen(){
        for(int i=0; i<4; i++){
            for(int j=0; j<8; j++){
                karten[(i*8)+j] = new Karte(Karte.FARBEN[i],Karte.BILDER[j]);
            }
        }
    }

    /**
     * Mischt den Kartenstapel.
     */
    public void mischen(){
        for(int i=0; i<32; i++){
            int a = (int) (Math.random() * 32);
            int b = (int) (Math.random() * 32);
            while(a == b){
                // Prueft ob a == b, wenn ja dann wird eine neue Zahl generiert
                b = (int) (Math.random() * 32);
            }
            // Dreieckstausch der Karten
            Karte temp = karten[a];
            karten[a] = karten[b];
            karten[b] = temp;
        }
    }

    /**
     * Ueberprueft ob eine Karte mit einer bestimmten Farbe und einem bestimmten Bild vorhanden ist.
     * 
     * @param pFarbe Die Farbe der gesuchten Karte.
     * @param pBild Das Bild der gesuchten Karte. 
     * 
     * @return True wenn Karte gefunden.
     */
    public boolean vorhanden(String pFarbe, String pBild){
        for(Karte karte : karten){
            if(karte.getFarbe().equals(pFarbe) && karte.getBild().equals(pBild)){
                //Wenn Karte gefunden
                return true;
            }
        }
        return false;
    }

    /**
     * Entfernt alle Karten mit eine bestimmten Farbe
     * 
     * @param pFarbe Die Farbe der auszusortierenden Karte. 
     */
    public void aussortieren(String pFarbe){
        for(int i=0; i<karten.length; i++){
            if(karten[i].getFarbe().equals(pFarbe)){
                karten[i] = null;
            }
        }
    }

    /**
     * Gibt an ob in der ersten Haelfte des Kartendecks mehr rote Karten vorhanden sind.
     * 
     * @return Gibt true zurueck wenn mehr rote Karten in der 
     */
    public boolean mehrRoteErsteHaelfte(){
        int schwarz = 0;
        int rot = 0;
        for(int i=0; i<karten.length/2; i++){
            if(karten[i].getFarbe().equals("Pik") || karten[i].getFarbe().equals("Kreuz")){
                schwarz++;
            }else if(karten[i].getFarbe().equals("Karo") || karten[i].getFarbe().equals("Herz")){
                rot++;
            }
        }
        return schwarz < rot;
    }

    /**
     * Gibt die Karten untereinander auf der Konsole aus.
     */
    public void ausgeben(){
        for(Karte k : karten){
            System.out.println(k.getFarbe() + " " + k.getBild());
        }
        System.out.println();
    }
}
