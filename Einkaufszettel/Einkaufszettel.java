
/**
 * Die Klasse stellt einen Einkaufszettel dar, dem man beliebeig viele Artikel hinzufuegen kann, diese aber auch geloescht werden koennen.
 * Der Inhalt des Einkaufszettels kann auf der Konsole ausgegeben werden.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Einkaufszettel
{
    // Anfang Variablen
    private List<Artikel> listArtikel;
    private String zettelBezeichnung;
    // Ende Variablen

    /**
     * Konstruktor fuer den Einkaufszettel mit der Zettelbezeichnung "Einkaufszettel".
     */
    public Einkaufszettel()
    {
        listArtikel = new List<Artikel>();
        zettelBezeichnung = "Einkaufszettel";
    }

    /**
     * Konstruktor fuer den Einkaufszettel mit beliebeiger Zettelbezeichnung.
     * 
     * @param pZettelBezeichnung Die beliebeige Zettelbezeichnung.
     */
    public Einkaufszettel(String pZettelBezeichnung)
    {
        listArtikel = new List<Artikel>();
        zettelBezeichnung = pZettelBezeichnung;
    }

    /**
     * Fuegt einen neuen Artikel mit einem beliebigen Namen hinzu.
     * 
     * @param pArtikelName Der Artikelname des zu hinzufuegenden Artikel.
     */
    public void addArtikel(String pArtikelName){
        addArtikel(new Artikel(pArtikelName));
    }

    /**
     * Fuegt einen Artikel zur Liste hinzu.
     * 
     * @param pArtikel Der hinzuzufuegende Artikel.
     */
    public void addArtikel(Artikel pArtikel){
        boolean enthaeltBereits = false;
        listArtikel.toFirst();
        if(!enthaeltArtikel(pArtikel.getArtikelName())){
            // Wenn es noch keinen Artikel mit dem gewuenschten Artikelnamen gibt wird dieser hinzugefuegt.
            listArtikel.append(pArtikel);
            System.out.println(pArtikel.getArtikelName() + " wurde zum Einkaufszettel hinzugefuegt.");
        }else{
            // Wenn es schon einen Artikel mit dem gewuenschten Artikelnamen gibt wird dieser nicht ausgegeben.
            System.out.println(pArtikel.getArtikelName() + " existiert bereits und wurde nicht zum Einkaufszettel hinzugefuegt.");
        }
    }
    
    /**
     * Prueft ob die Liste einen Artikel mit einem bestimmten Namen bereits enthaelt.
     * 
     * @param pArtikelName Der Name des zu pruefenden Artikel.
     */
    public boolean enthaeltArtikel(String pArtikelName){
         while(listArtikel.hasAccess()){
            // Jeder bisherige Artikelname wird mit dem gewuenschten neuen verglichen.
            if(listArtikel.getContent().getArtikelName() == pArtikelName){
                return true;
            }
            listArtikel.next();
        }
        return false;
    }

    /**
     * Entfernt einen Artikel mit einem bestimmten Artikelnamen, fals dieser in der Liste vorhanden ist.
     * 
     * @param pArtikelName Der Name des zu loeschenden Artikel.
     */
    public void removeArtikel(String pArtikelName){
        listArtikel.toFirst();
        while(listArtikel.hasAccess()){
            // Vergleicht den Namen des aktuellen Artikel der Liste mit dem Namen des zu loeschenden Artikels.
            if(listArtikel.getContent().getArtikelName() == pArtikelName){
                // Wenn der Name des aktuellen Artikels dem Namen des zu loeschenden Artikels gleicht, wird dieser geloescht und die Schleife wird abgebrochen.
                listArtikel.remove();
                System.out.println(pArtikelName + " wurde entfernt.");
                break;
            }
            listArtikel.next();
        }
    }

    /**
     * Gibt die Einkaufsliste auf der Konsole aus.
     */
    public void listeAusgeben(){
        System.out.println();
        //Die Zettelbezeichnung wird geschrieben.
        System.out.println("***" + zettelBezeichnung +"***");
        //Alle Artikelnamen werden geschrieben, begonnen bei dem ersten in der Liste.
        listArtikel.toFirst();
        while(listArtikel.hasAccess()){
            System.out.println(listArtikel.getContent().getArtikelName());
            listArtikel.next();
        }
        System.out.println();
    }
}
