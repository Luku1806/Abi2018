
/**
 * Ist ein Chat Client.
 *
 * @author Daniel, Timon, Jonas
 * @version 31.01.2018
 */
import java.util.ArrayList;
public class ChatClient extends Client
{
    private ArrayList<String> messages = new ArrayList<String>();
    private boolean afk;
    
    /**
     * Constructor for objects of class ChatClient.
     * 
     * @param pServerIP ist die server IP.
     * @param pServerPort ist der server Port.
     */
    public ChatClient(String pServerIP, int pServerPort)
    {
        super(pServerIP, pServerPort);
        afk=true;
    }
    
    /**
     * Sendet eine Nachricht an den Server.
     * 
     * @param pMessage ist die Nachricht die gesendet wird.
     */
    public void senden(String pMessage)
    {
        this.send(pMessage);
    }

    /**
     * Speichert die ankommenden Nachrichten in eine ArrayList, wo diese von der GUI ausgelesen werden kann.
     * 
     * @param pMessage ist die einkommende Nachricht.
     */
    public void processMessage(String pMessage)
    {
        messages.add(pMessage);
    }
    
    /**
     * Ueberprueft ob eine Nachricht einen Befehl beinhaltet und gibt einen Wahrheitswert zurück.
     * 
     * @param pMessage ist die Nachricht die zu ueberpruefen ist.
     * @return ob die Nachricht einen Befehl beinhaltet.
     */
    public boolean befehl(String pMessage)
    {
        String[] part=pMessage.split(" ");
        return (part[0].equals("WHISPER")||part[0].equals("NICK")||part[0].equals("COL")||part[0].equals("AFK")||part[0].equals("LEAVE")||part[0].equals("HELP")||part[0].equals("USERLIST"));
    }
    
    /**
     * Sendet eine reine Nachricht an den Server und setzt zu dem Zweck ein MSG vornab.
     * 
     * @param pMessage ist die Nachricht.
     */
    public void message(String pMessage)
    {
        if(!pMessage.isEmpty()&&!befehl(pMessage))
        {
            senden("MSG "+pMessage);
        }
        else senden(pMessage);
    }
    
    /**
     * Sendet eine Nachricht an den Server, dass der Client AFK ist.
     */
    public void afk()
    {
        senden("AFK");
        afk=!afk;
    }
    
    /**
     * Sendet eine Nachricht an den Server, wo der Befehl WHISPER hinzugefuegt wird.
     * 
     * @param pName ist der anzuschreibende Client.
     * @param pMessage ist die Nachricht an den Client.
     */
    public void whisper(String pName, String pMessage)
    {
        if(!pMessage.isEmpty())
        {
            senden("WHISPER "+pName+" "+pMessage);
        }
    }
    
    /**
     * Sendet eine Nachricht an den Server, mit der der Name geaendert wird.
     * 
     * @param pName ist der neue Name.
     */
    public void nick(String pName)
    {
        if(!pName.isEmpty())
        {
            senden("NICK "+pName);
        }
    }
    
    /**
     * Gibt die ArrayList aus.
     * 
     * @return die ArrayList.
     */
    public ArrayList<String> getMessages()
    {
        return messages;
    }
    
    
    /**
     * Die sondierende Methode fuer das Attribut afk.
     */
    public boolean getAfk()
    {
        return afk;
        }
}