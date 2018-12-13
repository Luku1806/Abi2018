/**
 * Write a description of class IRCClient here.
 *
 * @author Lukas Reining
 * @version 26.01.2018
 */
public class IRCClient extends Client{

    /**
     * Constructor for objects of class IRCClient
     */
    public IRCClient(String address){
        super(address , 5000);
    }
    
    @Override
    public void processMessage(String pMessage){
        System.out.println(pMessage);
    }
    
    public void sendMessage(String message){
        this.send("MSG " + message);
    }
    
     public void whisper(String message, String username){
        this.send("WHISPER " + username + " " + message);
    }
    
    public void changeName(String newName){
        this.send("NICK " + newName);
    }
}
