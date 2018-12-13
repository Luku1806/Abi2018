
/**
 * Beschreiben Sie hier die Klasse Uhrenanzeige.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Uhrenanzeige
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String Anzeige;
    private Ziffernanzeige minute;
    private Ziffernanzeige stunde;

    /**
     * Konstruktor f�r Objekte der Klasse Uhrenanzeige
     */
    public Uhrenanzeige()
    {
        minute = new Ziffernanzeige(60);
        stunde = new Ziffernanzeige(24);
    }

    /**
     * Konstruktor f�r Objekte der Klasse Uhrenanzeige
     */
    public Uhrenanzeige(int pMinute , int pStunde)
    {
        minute = new Ziffernanzeige(60 , pMinute);
        stunde = new Ziffernanzeige(24 , pStunde);
    }

    /**
     * Setzt die Uhrzeit auf einen gew�hlten Wert
     * @param pStunden Die gew�nschten Stunden
     * @param pMinuten Die gew�nschten Minuten
     */
    public void setUhrzeit(int pStunden , int pMinuten){
        stunde.setWert(pStunden);
        minute.setWert(pMinuten);
    }

    /**
     *Gibt den Anzeigenwert zweistellig aus
     */
    public void anzeige(){
        System.out.println(stunde.getAnzeigewert() + ":" + minute.getAnzeigewert());
    }

    /**
     * Erh�ht einmal pro Minute den Wert der Minute , falls die Minuten bei 60 sind erh�ht er die Stunde
     */
    public void takt(){
        new java.util.Timer().schedule(new java.util.TimerTask()
        {
                public void run(){
                    minute.erhoehen();
                    if (minute.getWert() == 0){
                        stunde.erhoehen();
                    }
                    anzeige();
                    takt();
                }
            },60000);
    }
    
    public void starte(){
        anzeige();
        takt();
    }

}
