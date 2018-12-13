import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 31.01.2018
  * @author 
  */

public class ChatGUI extends JFrame {
  // Anfang Attribute
  private JButton nick = new JButton();
  private JTextArea chatVerlauf = new JTextArea("");
    private JScrollPane chatVerlaufScrollPane = new JScrollPane(chatVerlauf);
  private JButton afk = new JButton();
  private JTextField nachricht = new JTextField();
  private JButton senden = new JButton();
  private JButton whisper = new JButton();
  
  private ChatClient client;
  // Ende Attribute
  
  public ChatGUI(String ip) { 
    // Frame-Initialisierung
    super();
    client = new ChatClient(ip,5000);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 591; 
    int frameHeight = 726;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    nick.setBounds(16, 16, 273, 41);
    nick.setText("\"nick\"");
    nick.setMargin(new Insets(2, 2, 2, 2));
    nick.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        nick_ActionPerformed(evt);
      }
    });
    afk.setBackground(Color.GREEN);
    cp.add(nick);
    chatVerlauf.setEditable(false);
    chatVerlaufScrollPane.setBounds(16, 80, 513, 513);
    cp.add(chatVerlaufScrollPane);
    afk.setBounds(360, 16, 169, 41);
    afk.setText("AFK");
    afk.setMargin(new Insets(2, 2, 2, 2));
    afk.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        afk_ActionPerformed(evt);
      }
    });
    cp.add(afk);
    nachricht.setBounds(16, 608, 417, 49);
    cp.add(nachricht);
    senden.setBounds(448, 608, 57, 49);
    senden.setText("Senden");
    senden.setMargin(new Insets(2, 2, 2, 2));
    senden.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        senden_ActionPerformed(evt);
      }
    });
    cp.add(senden);
    whisper.setBounds(512, 608, 57, 49);
    whisper.setText("Whisper");
    whisper.setMargin(new Insets(2, 2, 2, 2));
    whisper.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        whisper_ActionPerformed(evt);
        
      }
    });
    cp.add(whisper);
    // Ende Komponenten
    chatAktualisieren(100);
    setVisible(true);
  } // end of public ChatGUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new ChatGUI("");
  } // end of main
  
  public void nick_ActionPerformed(ActionEvent evt) {
      String nickname = JOptionPane.showInputDialog(this, "Bitte geben Sie den neuen Benutzernamen ein.", JOptionPane.QUESTION_MESSAGE);
      nick.setText(nickname);
      client.nick(nickname);
  } // end of nick_ActionPerformed

  public void afk_ActionPerformed(ActionEvent evt) {
      client.afk();
      boolean isAfk = client.getAfk();
      if(isAfk)
      {
          afk.setBackground(Color.RED);
      }
      else
      {
          afk.setBackground(Color.GREEN);
      }           
  } // end of afk_ActionPerformed

  public void senden_ActionPerformed(ActionEvent evt) {
      client.message(nachricht.getText());
  } // end of senden_ActionPerformed

  public void whisper_ActionPerformed(ActionEvent evt) {
      String empfaenger = JOptionPane.showInputDialog(this, "Bitte geben Sie den Benutzernamen des Empfaengers hier ein.", JOptionPane.QUESTION_MESSAGE);
      client.whisper(empfaenger,nachricht.getText());
  } // end of whisper_ActionPerformed
  
  public void chatAktualisieren(long pTimeIntervall)
  {
     Runnable runnable = new Runnable(){
         public void run()
         {
             while(true)
             {
                 ArrayList<String> messages = client.getMessages();
             for(int i = 0; i<messages.size(); i++)
             {
                 chatVerlauf.setText(chatVerlauf.getText() + "\n" + messages.get(i) + "\n");
                 messages.remove(i);
                }
                try
                {
                    Thread.sleep(pTimeIntervall);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        }; 
        Thread thread = new Thread(runnable);
        thread.start();
    }

  // Ende Methoden
} // end of class ChatGUI
