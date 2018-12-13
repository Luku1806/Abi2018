/**
 * Beschreiben Sie hier die Klasse Bestellung.
 * 
 * @author Lukas Reining
 * @version 12.01.2018
 */
public class ShopServer extends Server{

    //verfuegbare Groessen und Farben
    private static final String[] GROESSEN = {"XS","S","M","L","XL","XXL"};
    private static final String[] FARBEN = {"weiss","schwarz","rot","gruen","blau","gelb"};
    //Alle Bestellungen
    private List<Bestellung> bestellungen;

    /**
     * Default Konstruktor fuer einen Server auf Port 5000.
     */
    public ShopServer(){
        this(5000);
    }

    /**
     * Konstruktor fuer beliebigen Port
     */
    public ShopServer(int port){
        super(port);
        bestellungen = new List<Bestellung>();
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort){
        String moeglicheGroessen = "Moegliche Groessen: ";
        String moeglicheFarben = "Moegliche Farben: ";
        for(String g : GROESSEN){
            moeglicheGroessen += g + ",";
        }
        for(String f : FARBEN){
            moeglicheFarben += f + ",";
        }
        send(pClientIP, pClientPort, "Wilkommen!\nWählen sie eine Groesse und Farbe fuer ihr T-Shirt.\n" + moeglicheGroessen + "\n" + moeglicheFarben);
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
        String[] nachrichtenTeile = pMessage.split(":");
        if(nachrichtenTeile[0].equals("TSHIRT")){
            boolean gKorrekt = false;
            boolean fKorrekt = false;
            //Check if size was right
            for(String g : GROESSEN){
                if(nachrichtenTeile[1].equalsIgnoreCase(g)){
                    gKorrekt = true;
                    break;
                }
            }
            //Check if color was right
            for(String f : FARBEN){
                if(nachrichtenTeile[2].equalsIgnoreCase(f)){
                    fKorrekt = true;
                    break;
                }
            }
            //Antwort auf T-Shirt Auswahl
            if(gKorrekt && fKorrekt){
                send(pClientIP, pClientPort, "Die Groesse ist " + nachrichtenTeile[1] + 
                    " und die Farbe ist " + nachrichtenTeile[2] + 
                    " und kostet 19,99 Euro!\nBitte bestätigen sie die Bestellung!");
                Bestellung bestellung = new Bestellung(new TShirt(nachrichtenTeile[1],nachrichtenTeile[2]), 0);
                if(bestellungen.isEmpty()){
                    bestellungen.insert(bestellung);
                }else{
                    bestellungen.append(bestellung);
                }
            }else{
                send(pClientIP, pClientPort, "Die Groesse und/oder die Farbe ist ungueltig.\nBitte richtig eingeben.");
            }
        }else if(nachrichtenTeile[0].equals("BESTAETIGUNG")){
            boolean korrekt = false;
            //Pruefe ob Eingabe korrekt war
            if(nachrichtenTeile[1].equalsIgnoreCase("ja") || nachrichtenTeile[1].equalsIgnoreCase("nein")){
                korrekt = true;
            }
            //Antwort auf Besteatigung
            if(korrekt){
                if(nachrichtenTeile[1].equalsIgnoreCase("ja")){
                    send(pClientIP, pClientPort, "Danke fuer ihre Bestellung!");
                    closeConnection(pClientIP, pClientPort);
                }else if(nachrichtenTeile[1].equalsIgnoreCase("nein")){
                    send(pClientIP, pClientPort, "Ihre Bestellung wurde storniert.");
                    closeConnection(pClientIP, pClientPort);
                }
            }else{
                send(pClientIP, pClientPort, "Bitte geben sie ja oder nein ein.");
            }
        }else if(nachrichtenTeile[0].equals("ABMELDEN")){
            send(pClientIP, pClientPort, "Bis zum naechsten mal!");
            closeConnection(pClientIP, pClientPort);
        }else{
            send(pClientIP, pClientPort, "Unbekannte oder fehlerhafte Eingabe");
        }
    }

    @Override
    public void processClosedConnection(String pClientIP, int pClientPort){
    }

    /**
     * Gibt alle Bestellungen mit ID und Status auf der Konsole aus.
     */
    public void showBestellungen(){
        System.out.println("Aktuelle Bestellungen:");
        if(!bestellungen.isEmpty()){
            bestellungen.toFirst();
            while(bestellungen.hasAccess()){
                Bestellung current = bestellungen.getContent();
                TShirt cShirt = current.getShirt();
                char bTag = '?';
                if(current.istBestaetigt()){
                    bTag = '\u2713'; //Haken
                }else{
                    bTag = '\u2715'; //Kreuz
                }
                System.out.println(current.getID() + ": |TShirt in " + cShirt.getFarbe() + " in Groesse " + cShirt.getGroesse() + "| Bestaetigt: " + bTag);
                bestellungen.next();
            }
        }else{
            System.out.println("Es sind keine Bestellungen vorhanden.");
        }
    }
}
