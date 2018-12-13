
/**
 * Die Hauptklasse der Rollersimulation
 * @author Lukas Reining
 * @version 1.0
 */
public class MainClass
{
    /**
     * Die Hauptmethode ruft die Methode Rollersimulation auf.
     * @param pZuFahrendeStrecke Die Strecke die der Roller zurücklegen soll
     */
    public static void main(int pZuFahrendeStrecke)throws InterruptedException {
        starteSimulation(pZuFahrendeStrecke);
    }
    
    /**
     * Der Besitzer fährt mit dem Roller eine vorgegeben Strecke.
     * Nachdem die vorgegeben Strecke gefahren wurde, wird der Tankinhalt angezeigt.
     * @param pStrecke Die zu fahrende Strecke.
     */
    public static void starteSimulation(int pStrecke) throws InterruptedException {
        Besitzer besitzer1 = new Besitzer("Tim" , 50 , new Roller(20 , 0 , 18));
        besitzer1.fahreDeinenRoller(pStrecke);
        System.out.println("Fahre los...");
        for (int i=0; i <pStrecke ; i++ ){
            System.out.println("...");
            Thread.sleep(300);
        }
        System.out.println("Der Tank beinhaltet noch " + besitzer1.meinRoller.getTankinhalt()+ " Liter");
    }
}
