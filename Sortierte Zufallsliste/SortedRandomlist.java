/**
 * Eine Liste die mit zufaelligen Zahlen gefuellt werden kann. Die Zahlen liegen nach Groe√üe sortiert vor.
 * 
 * @author Lukas Reining 
 * @version 1.0 
 */
public class SortedRandomlist
{
    //Attribute
    private List<Integer> liste;

    /**
     * Konstruktor
     */
    public SortedRandomlist(){
        liste = new List<Integer>();
    }

    /**
     * Fuellt die Liste mit 20 zufaelligen Werten. Diese werden so in die Liste eingeordnet, dass die Liste in geordneter Form vorliegt.
     */
    public void sortiertFuellen(){
        for(int i=0; i<20; i++){
            liste.toFirst();
            int zufall = zufallszahl(1,50);
            while(liste.hasAccess() && zufall > liste.getContent()){
                liste.next();
            }
            if(liste.hasAccess()){
                // Wenn eine Zahl in der Liste groeﬂer ist, als die Zufallszahl wird die Zufallszahl vor dieser eingeordnet.
                liste.insert(zufall);
            }else{
                // Wenn keine groeﬂere Zahl als die generierte Zufallszahl in der Liste vorhanden ist, wird die Zufallszahl ans Ende der Liste eingeordnet.
                liste.append(zufall);
            }
        }
    }

    /**
     * Entfernt alle Zahlen aus der Liste.
     */
    public void zuruecksetzen(){
        liste.toFirst();
        while(liste.hasAccess()){
            liste.remove();
        }
    }

    /**
     * Gibt die Liste auf der Konsole aus.
     */
    public void ausgeben(){
        String ausgabe = "Liste: {";
        liste.toFirst();
        while(liste.hasAccess()){
            ausgabe += liste.getContent();
            liste.next();
            if(liste.hasAccess()){
                ausgabe += ",";
            }
        }
        ausgabe += "}";
        System.out.println(ausgabe);
    }

    /**
     * Gibt eine Zufallszahl aus einem bestimmten Zahlenbereich zurueck.
     * 
     * @param kleinster Der kleinste Wert des Zahlenbereiches.
     * @param hoechster Der hoechste Wert des Zahlenbereiches.
     */
    private int zufallszahl(int kleinster, int hoechster){
        return (int)(Math.random()*hoechster)+kleinster;
    }
}
