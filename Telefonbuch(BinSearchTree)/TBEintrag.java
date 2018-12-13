
/**
 * Beschreiben Sie hier die Klasse TBEintrag.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 15.05.2017
 */
public class TBEintrag implements ComparableContent<TBEintrag>{

    // Instanzvariablen
    private String name;
    private String vorname;
    private String telefonnummer;

    /**
     * Konstruktor für Objekte der Klasse TBEintrag.
     * 
     * @param name Der Nachname der Person des Telefonbucheintrags.
     * @param vorname Der Vorname der Person des Telefonbucheintrags.
     * @param telefonnummer Die zu dem Telefonbucheintrag gehoerige Telefonnummer.
     */
    public TBEintrag(String name,String vorname,String telefonnummer){
        this.name = name;
        this.vorname = vorname;
        this.telefonnummer = telefonnummer;
    }

    public String getName(){
        return this.name;
    }

    public String getVorname(){
        return this.vorname;
    }

    public String getTelefonnummer(){
        return this.telefonnummer;
    }

    //Comparator-Methoden
    @Override
    public boolean isLess(TBEintrag tbe){
        int wert = name.compareToIgnoreCase(tbe.getName());
        if(wert == 0){
            wert =  vorname.compareToIgnoreCase(tbe.getVorname());
        }
        return wert < 0;
    }

    @Override
    public boolean isEqual(TBEintrag tbe){
        int wert = name.compareToIgnoreCase(tbe.getName());
        if(wert == 0){
            wert =  vorname.compareToIgnoreCase(tbe.getVorname());
        }
        return wert == 0;
    }

    @Override
    public boolean isGreater(TBEintrag tbe){
        int wert = name.compareToIgnoreCase(tbe.getName());
        if(wert == 0){
            wert =  vorname.compareToIgnoreCase(tbe.getVorname());
        }
        return wert > 0;
    }
}
