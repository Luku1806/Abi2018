/**
 * Die Klasse beschreibt ein Spiel mit einem Wuerfel.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Spiel
{
    private Wuerfel wuerfel;

    /**
     * Konstruktor fuer Spiel-Objekte
     */
    public Spiel(){
        wuerfel = new Wuerfel();
    }

    /**
     * Addiert die Ergebnisse von x Wuerfelergebnissen auf rekursive Weise und gibt diese zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Die Summe der Wuerfelergebnisse.
     */
    public int addiere_rekursiv(int x){
        if(x<=1){
            return wuerfel.wuerfeln();
        }
        return wuerfel.wuerfeln() + addiere_rekursiv(x-1);
    }

    /**
     * Addiert die Ergebnisse von x Wuerfelergebnissen auf iterative Weise und gibt diese zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Die Summe der Wuerfelergebnisse.
     */
    public int addiere_iterativ(int x){
        int temp= 0;
        for(int i=0; i<x; i++){
            temp += wuerfel.wuerfeln();
        }
        return temp;
    }

    /**
     * Vergleicht die Ergebnisse von x Wuerfelergebnissen auf rekursive Weise und gibt das hoechste zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Das hoechste Wuerfelergebnis.
     */
    public int maxFinden_rekursiv(int x){
        if(x<=0){
            return 0;
        }
        int wuerfelergebniss = wuerfel.wuerfeln();
        int vorherig = maxFinden_rekursiv(x-1);
        if(wuerfelergebniss > vorherig){
            return wuerfelergebniss;
        }else{
            return vorherig;
        }
    }

    /**
     * Vergleicht die Ergebnisse von x Wuerfelergebnissen auf iterative Weise und gibt das hoechste zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Das hoechste Wuerfelergebnis.
     */
    public int maxFinden_iterativ(int x){
        int hoechste = 0;
        for(int i=0; i<x; i++){
            int wurf = wuerfel.wuerfeln();
            if(wurf > hoechste){
                hoechste = wurf;
            }
        }
        return hoechste;
    } 

    /**
     * Vergleicht die Ergebnisse von x Wuerfelergebnissen auf rekursive Weise und gibt das kleinste zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Das kleinste Wuerfelergebnis.
     */
    public int minFinden_rekursiv(int x){
        if(x<=1){
            return wuerfel.wuerfeln();
        }
        int wuerfelergebniss = wuerfel.wuerfeln();
        int vorherig = minFinden_rekursiv(x-1);
        if(wuerfelergebniss < vorherig){
            return wuerfelergebniss;
        }else{
            return vorherig;
        }
    }

    /**
     * Vergleicht die Ergebnisse von x Wuerfelergebnissen auf iterative Weise und gibt das kleinste zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Das kleinste Wuerfelergebnis.
     */
    public int minFinden_iterativ(int x){
        int kleinstes = wuerfel.wuerfeln();
        for(int i=0; i<x-1; i++){
            int wurf = wuerfel.wuerfeln();
            if(wurf < kleinstes){
                kleinstes = wurf;
            }
        }
        return kleinstes;
    } 

    /**
     * Gibt X Wuerfelergebnisse mit Hilfe von Rekursion als String zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Die Wuerfelergebnisse als String.
     */
    public String gibXErgebnisse_rekursiv(int x){
        if(x<=0){
            return "";
        }
        return String.valueOf((wuerfel.wuerfeln())) + gibXErgebnisse_rekursiv(x-1);
    }

    /**
     * Gibt X Wuerfelergebnisse mit Hilfe von Iteration als String zurueck.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Die Wuerfelergebnisse als String.
     */
    public String gibXErgebnisse_iterativ(int x){
        String ergebniss = "";
        for(int i=0; i<x; i++){
            ergebniss += String.valueOf((wuerfel.wuerfeln()));
        } 
        return ergebniss;
    }

    /**
     * Gibt X Wuerfelergebnisse mit Hilfe von Rekursion als int zurueck.
     * Diese Methode ist die gleiche Methode wie oben, doch mit int als Rueckgabewert, da dies so im Buch stand.
     * Da es mir allerdings unlogisch vorkam, das ganze als int zurueckzugeben habe ich es oben als String zrueckgegeben, was fuer mich die bessere Art ist.
     * Diese Methode habe ich nur programmiert da sie im Buch so gefordert war.
     * 
     * @param x Die Anzahl an Wuerfelergebnissen.
     * @return Die Wuerfelergebnisse als int.
     */
    public int gibXErgebnisse_rekursiv_buch(int x){
        if(x<=1){
            return wuerfel.wuerfeln();
        }
        return Integer.parseInt(String.valueOf((wuerfel.wuerfeln())) + String.valueOf((gibXErgebnisse_rekursiv(x-1))));
    }

    /**
     * Gibt den Wuerfel des Spiels zurueck.
     * 
     * @return der Wuerfel des Spiels.
     */
    public Wuerfel getWuerfel(){
        return this.wuerfel;
    }
}
