import java.util.Scanner;
/**
 * Client zum Bestellen beim T-Shirtshop.
 * 
 * @author Lukas Reining
 * @version 12.01.2018
 */
public class ShopClient extends Client{

    /**
     * Konstruktor fuer einen Client der sich mit einem Server mit belieber Adresse auf einem beliebeigen Port verbindet.
     */
    public ShopClient(String pServerIP, int pServerPort){
        super(pServerIP, pServerPort);
    }

    /**
     * Konstruktor fuer einen Client der sich mit einem Server auf der Loopback-Adresse auf Port 5000 verbindet.
     */
    public ShopClient(){
        this("127.0.0.1",5000);
    }
    
    
    @Override
    public void processMessage(String pMessage){
        System.out.println(pMessage);
    }

    /**
     * Bestellt ein bestimmtes T-Shirt beim Server
     * 
     * @param shirt Das zu bestellende T-Shirt.
     */
    public void bestelleTShirt(TShirt shirt){
        groesseFarbeWaehlen(shirt.getGroesse(), shirt.getFarbe());
    }

    /**
     * Waehlt auf dem Server ein T-Shirt von einer bestimmten Groesse und Farbe aus.
     * 
     * @param pGroesse Die gewuenschte Groesse.
     * @param pFarbe Die gewuenschte Farbe.
     */
    public void groesseFarbeWaehlen(String pGroesse, String pFarbe){
        send("TSHIRT:" + pGroesse + ":" + pFarbe);
    }

    /**
     * Bestaetigt die Auswahl auf dem Server oder verwirft diese.
     * 
     * @param pAntwort "Ja" zum bestaetigen. "Nein" zum verwerfen.
     */
    public void bestaetigen(String pAntwort){
        send("BESTAETIGUNG:" + pAntwort);
    }

    /**
     * Meldet den Client vom Server ab.
     */
    public void abmelden(){
        send("ABMELDEN");
    }
    
    /**
     * Unfertige Methode zur Eingabe und Besteatigung der Bestellung ueber die Konsole.
     * Funktioniert nur bei Eingaben in richtiger Reihenfolge und mit gueltigen Werten.
     */
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben sie eine der verfuegbaren Farben an:");
        String farbe = scanner.next();
        System.out.println("Geben sie eine der verfuegbaren Groessen an:");
        String groesse = scanner.next();
        groesseFarbeWaehlen(groesse, farbe);
        String bestaetigung = scanner.next();
        bestaetigen(bestaetigung);
    }

}
