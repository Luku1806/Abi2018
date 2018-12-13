
/**
 * Write a description of class Vokabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vokabel
{
    // Anfang Konstanten
    public static final int ERWARTET_DEUTSCHE_UEBERSETUNG = 1;
    public static final int ERWARTET_ENGLISCHE_UEBERSETZUNG = 2;
    // Ende Konstanten

    // Anfang Variablen
    private String deutsch;
    private String englisch;
    private int modus = 1;
    // Ende Variablen

    /**
     * Konstruktor fuer Objekte der Klasse Vokabel
     */
    public Vokabel(String pDeutsch, String pEnglisch)
    {
        deutsch = pDeutsch;
        englisch = pEnglisch; 
    }

    /**
     * Gibt den die deutsche Uebersetzung der Vokabel zurueck.
     * 
     * @return Die deutsche Uebersetzung.
     */
    public String getDeutsch(){
        return this.deutsch;
    }

    /**
     * Gibt den die englische Uebersetzung der Vokabel zurueck.
     * 
     * @return Die englische Uebersetzung.
     */
    public String getEnglisch(){
        return this.englisch;
    }

    /**
     * Gibt die dem aktuellen Modus entsprechende zu Uebersetzende Vokabel zurueck.
     * 
     * @retun Die zu uebersetzende Vokabel.
     */
    public String getZuUebersetzen(){
        if(modus == ERWARTET_DEUTSCHE_UEBERSETUNG){
            return englisch;
        }else if(modus == ERWARTET_ENGLISCHE_UEBERSETZUNG){
            return deutsch;
        }
        return null;
    }

    /**
     * Gibt zurueck ob die Vokabel dem aktuellen Modus entsprechend richtig uebersetzt wurde.
     * 
     * @return True wenn richtig uebersetzt wurde.
     */
    public boolean isRichtigUebersetzt(String pUebersetzung){
        if(modus == ERWARTET_DEUTSCHE_UEBERSETUNG){
            if(pUebersetzung.equals(deutsch)){
                return true;
            }
        }else if(modus == ERWARTET_ENGLISCHE_UEBERSETZUNG){
            if(pUebersetzung.equals(englisch)){
                return true;
            }
        }
        return false;
    }
}
