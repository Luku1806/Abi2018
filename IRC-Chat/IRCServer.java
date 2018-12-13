/**
 * Ein IRC-Server!
 *
 * @author Lukas Reining
 * @version 26.01.2018
 */
public class IRCServer extends Server{

    //Default Serverport
    private static final int serverPort = 5000;
    //Alle gueltigen Kommandos
    private final String cMessage = "MSG"; // MSG Dies ist ne Nachricht
    private final String cWhisper = "WHISPER"; // WHISPER Lukas Dies ist ne geheime Nachricht
    private final String cNick = "NICK"; // NICK NeuerCoolerName
    private final String cAFK = "AFK"; // AFK
    private final String cHelp = "HELP"; // HELP
    private final String cUserList = "USERLIST"; // USERLIST
    private final String cLeave = "LEAVE"; // LEAVE
    private final String cColor = "COL"; //Reserviert fuer zukuenftige Implementation von Farbe
    // Begruessungs und Hilfetext
    private final String begruessungstext = "Herzlich willkommen!\nAuf dem Info-VZ Server kannst du mit deinen Kumpels chatten und dich über den großartigen, im höchsten Grade interessanten Stoff des Informatikunterrichts der gymnasialen Oberstufe am Immanuel-Kant-Gymnasium austauschen.\nUm deine Möglichkeiten voll ausschöpfen zu können, tippe jetzt /help!\n(Bis morgen nur 14,99€! Teilnahme ab 18 Jahren. Glücksspiel kann süchtig machen. Keine Gewinnausschüttung an Minderjährige. Rauchen kann tödlich sein. Eine abwechslungsreiche Ernährung und viel Bewegung sind essentiell für einen gesunden Lebensstil. Vater unser im Himmel usw)\n";
    private final String hilfetext = "\nInfo-VZ Server bietet dir schier grenzenlose Möglichkeiten! Hier sind sie einmal für dich aufgelistet:\nWHISPER ‘Name‘ ‘Nachricht‘ ->Flüstere einem Mitschüler eine Nachricht zu. Die anderen Teilnehmer können diese Nachricht nicht sehen.\nNICK ‘Name‘ -> Ändere deinen Nicknamen. Dieser wird allen Teilnehmern angezeigt.\nCOL ‘Farbe‘ -> Ändere die Farbe, in der deine Nachrichten angezeigt werden. Nur bestimmte Farben sind zulässig.\nUSERLIST -> Zeigt dir alle Namen der Benutzer die momentan verbunden sind.\nAFK -> Teile den anderen mit, dass du gerade nicht anwesend bist. Bist du bereits AFK, hebst du den Status mit diesem Befehl auf.\nLEAVE -> Hiermit kannst du den Chatraum verlassen, auch wenn es dafür sicher keinen Grund gibt. Du musst mit einer Befragung der CIA rechnen (Waterboarding inklusive).\nHELP -> (Bonus Feature für reiche Kunden) Listet alle Befehle auf, die dir zur Verfügung stehen.\n";
    //Sonstige Attribute
    private List<Benutzer> benutzer;
    private final String defaultName = "Anonymous";

    /**
     * Constructor for objects of class IRCServer
     */
    public IRCServer(){
        super(serverPort);
        benutzer = new List<Benutzer>();
        System.out.println("IRC-Server auf Port " + serverPort + " gestartet...");
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort){
        System.out.println(pClientIP + " ist jetzt verbunden");
        Benutzer b = new Benutzer(pClientIP , defaultName, null);
        if(getUser(pClientIP) == null){
            if(benutzer.isEmpty()){
                benutzer.insert(b);
            }else{
                benutzer.append(b);
            }
        }
        send(pClientIP, pClientPort, begruessungstext);
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
        String senderName = getUsername(pClientIP);
        System.out.println("[" + senderName + "] " + pMessage);
        String[] msgParts = pMessage.split(" ",2);
        if(msgParts[0].equals(cMessage) && msgParts.length > 1){
            sendToAll("[" + senderName + "] " + msgParts[1]);
        }else if(msgParts[0].equals(cWhisper)){
            String[] whisperParts = pMessage.split(" ",3);
            String partnerIp = getIpZuName(whisperParts[1]);
            if(!partnerIp.equals("noIpFound")){
                send(partnerIp, pClientPort, "[" + senderName + "]" + "(whispert) " + whisperParts[2]);
            }else{
                send(pClientIP, pClientPort, "[SERVER] " + "Der Benutzer " + whisperParts[1] + " konnte nicht gefunden werden!");
            }
        }else if(msgParts[0].equals(cNick)){
            Benutzer b = getUser(pClientIP);
            if(b != null && !msgParts[1].isEmpty() && !msgParts[1].equalsIgnoreCase("Server")){
                sendToAll("[SERVER] " + b.getName() + " ist jetzt " + msgParts[1]);
                b.setName(msgParts[1]);
            }else if(msgParts[1].equalsIgnoreCase("Server")){
                send(pClientIP, pClientPort, "[SERVER] Der Name 'Server' ist nicht erlaubt!");
            }else{
                send(pClientIP, pClientPort, "[SERVER] Kommando nicht gueltig");
            }
        }else if(msgParts[0].equals(cLeave)){
            send(pClientIP, pClientPort, "[SERVER] Bye!");
            closeConnection(pClientIP, pClientPort);
        }else if(msgParts[0].equals(cHelp)){
            send(pClientIP, pClientPort, hilfetext);
        }else if(msgParts[0].equals(cUserList)){
            send(pClientIP, pClientPort, getUserList());
        }else if(msgParts[0].equals(cAFK)){
            sendToAll("[SERVER] " + senderName + " ist jetzt AFK!");
        }else{
            send(pClientIP, pClientPort, "[SERVER] Kommando nicht gueltig!");
        }
    }

    public void processClosedConnection(String pClientIP, int pClientPort){
        if(!removeUser(pClientIP)){
            System.out.println(pClientIP + " konnte nicht geloescht werden");
        }
    }

    /**
     * Erzeugt eine Liste der Benutzernamen in Form einer String.
     * 
     * @return Die Liste der Benutzernamen.
     */
    private String getUserList(){
        String list = "Verbundene Benutzer:\n";
        benutzer.toFirst();
        while(benutzer.hasAccess()){
            Benutzer b = benutzer.getContent();
            list += b.getName() + "\n";
            benutzer.next();
        }
        return list;
    }

    /**
     * Sucht den User zu einer IP-Adresse aus der Liste heraus.
     * 
     * @param ip Die IP-Adresse des gesuchten Clients.
     * @returnDer Client
     */
    private Benutzer getUser(String ip){
        benutzer.toFirst();
        while(benutzer.hasAccess()){
            Benutzer b = benutzer.getContent();
            if(b.getIpAdresse().equals(ip)){
                return b;
            }
            benutzer.next();
        }
        return null;
    }
    
    /**
     * Entfernt den User zu einer IP-Adresse aus der Liste.
     * 
     * @param ip Die IP-Adresse des zu loeschenden Clients.
     * @return False falls loeschen nicht erfolgreich war.
     */
    private boolean removeUser(String ip){
        benutzer.toFirst();
        while(benutzer.hasAccess()){
            Benutzer b = benutzer.getContent();
            if(b.getIpAdresse().equals(ip)){
                benutzer.remove();
                return true;
            }
            benutzer.next();
        }
        return false;
    }

    /**
     * Sucht den Namen zu einer IP Adresse in der Liste der Clients.
     * 
     * @param ip Die IP-Adresse des gesuchten Clients.
     * @return Der Name zu der IP-Adresse
     */
    private String getUsername(String ip){
        benutzer.toFirst();
        while(benutzer.hasAccess()){
            Benutzer b = benutzer.getContent();
            if(b.getIpAdresse().equals(ip)){
                return b.getName();
            }
            benutzer.next();
        }
        return "noNameFound";
    }

    /**
     * Sucht die IP-Adresse zu einem Namen in der Liste der Clients.
     * 
     * @param name Der Name des gesuchten Clients.
     * @return Die IP-Adresse zu dem Namen.
     */
    private String getIpZuName(String name){
        benutzer.toFirst();
        while(benutzer.hasAccess()){
            Benutzer b = benutzer.getContent();
            if(b.getName().equals(name)){
                return b.getIpAdresse();
            }
            benutzer.next();
        }
        return "noIpFound";
    }
}
