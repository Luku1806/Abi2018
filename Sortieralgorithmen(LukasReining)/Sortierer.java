/**
 * Die Klasse liefert Methoden zur Sortierung von Listen.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Sortierer
{

    private List<Integer> liste = new List<Integer>();

    /**
     * Konstruktor fuer Objekte der Klasse Sortierer
     */
    public Sortierer(){
        //Zahlenreihe aus dem Buch
        liste.append(7);
        liste.append(13);
        liste.append(2);
        liste.append(36);
        liste.append(203);
        liste.append(8);
        liste.append(12);
        liste.append(1);
    }

    /**
     * Sortiert die klasseninterne Liste mit Hilfe des selectionSorts und gibt diese davor und danach aus.
     */
    public void selectionSortTest(){
        System.out.print("Vorher: ");
        ausgeben(liste);
        liste = selectionSort(liste);
        System.out.print("Nachher: ");
        ausgeben(liste);
    }

    /**
     * Sortiert die klasseninterne Liste mit Hilfe des quickSorts und gibt diese davor und danach aus.
     */
    public void quickSortTest(){
        ausgeben(liste, "Ausgangsliste");
        liste = quickSort(liste);
        ausgeben(liste, "Sortiert");
    }

    /**
     * Gibt die Laenge einer Liste zurueck.
     * 
     * @param pListe Die Liste, dessen Laenge zurueck gegeben werden soll.
     * @return Die Laenge der Liste.
     */
    public int laenge(List<Integer> pListe){
        int laenge = 0;
        pListe.toFirst();
        while(pListe.hasAccess()){
            laenge++;
            pListe.next();
        }
        return laenge;
    }

    /**
     * Fuehrt den quick Sort auf einer Liste aus.
     * 
     * @param pListe Die zu sortierende Liste.
     * @return Die sortierte Liste.
     */
    public List<Integer> quickSort(List<Integer> pListe){
        if(laenge(pListe) > 1){
            List<Integer> kleinere = new List<Integer>();
            List<Integer> groessere = new List<Integer>();
            pListe.toFirst();
            int pivot = pListe.getContent();
            pListe.remove();
            while(!pListe.isEmpty()){
                int temp = pListe.getContent();
                if(temp < pivot){
                    kleinere.append(temp);
                }else{
                    groessere.append(temp);
                }
                pListe.remove();
            }
            quickSort(kleinere);
            quickSort(groessere);
            pListe.concat(kleinere);
            pListe.append(pivot);
            pListe.concat(groessere);
        }
        return pListe;
    }

    /**
     * Fuehrt den selection Sort auf einer Liste aus.
     * 
     * @param pListe Die zu sortierende Liste.
     * @return Die sortierte Liste.
     */
    public List<Integer> selectionSort(List<Integer> pListe){
        List<Integer> hListe = new List<Integer>();
        while(!pListe.isEmpty()){
            pListe.toFirst();
            //Erster Wert wird ermittelt
            int temp = pListe.getContent();
            pListe.next();
            //Alle weiteren Werte werden durchgegeangen und der kleinste Wert wird ermittelt
            while(pListe.hasAccess()){
                if(pListe.getContent() < temp){
                    temp = pListe.getContent();
                }
                pListe.next();
            }
            //Der ermittelte kleinste Wert wird aus der Liste entfernt 
            //Da die Liste keinen direkten Zugriff ermoeglicht, muss die Liste hierfuer durchlaufen werden bis der Zeiger auf der Position des kleinsten Wertes ist
            pListe.toFirst();
            while(pListe.hasAccess()){
                if(pListe.getContent() == temp){
                    pListe.remove();
                    break;
                }
                pListe.next();
            }
            //Der ermittelte kleinste wird wird an die Hilfsliste angehangen.
            hListe.append(temp);
        }
        return hListe;
    }
    
    /**
     * Gibt eine Liste pListe auf der Konsole aus.
     * 
     * @param pListe Die auszugebende Liste.
     * @param pBezeichner Der Bezeichner der Liste.
     */
    public void ausgeben(List pListe, String pBezeichner){
        String stringListe = pBezeichner + ": {";
        pListe.toFirst();
        while(pListe.hasAccess()){
            stringListe += pListe.getContent();
            pListe.next();
            if(pListe.hasAccess()){
                stringListe += ",";
            }
        }
        stringListe += "}";
        System.out.println(stringListe);
    }

    /**
     * Gibt eine Liste pListe auf der Konsole aus.
     * 
     * @param pListe Die auszugebende Liste.
     */
    public void ausgeben(List pListe){
        String stringListe = "Liste: {";
        pListe.toFirst();
        while(pListe.hasAccess()){
            stringListe += pListe.getContent();
            pListe.next();
            if(pListe.hasAccess()){
                stringListe += ",";
            }
        }
        stringListe += "}";
        System.out.println(stringListe);
    }
}
