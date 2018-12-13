
/**
 * Beschreiben Sie hier die Klasse Terretorium.
 * 
 * @author (Kilian und Lukas) 
 * @version (1.0)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class Territorium extends JApplet implements ActionListener
{
    ArrayList<RoboterResizable> roboter = new ArrayList<RoboterResizable>();
    Button btnDrehen , btnVor ,btnWechsel;
    int ausgewaehlterRoboter = 0;

    public void init()
    {
        addRoboter(200 , 200 , 5);
        addRoboter(400 , 200 , 5);
        btnDrehen = new Button("Drehe links");    
        btnVor = new Button("Gehe vor");
        btnWechsel = new Button("Roboter wechseln");
        getContentPane().setLayout(null);      
        getContentPane().add(btnDrehen);  
        getContentPane().add(btnVor); 
        getContentPane().add(btnWechsel);
        btnDrehen.setBounds(this.getWidth()/2-155, this.getHeight()-60 ,100,50);    
        btnVor.setBounds(this.getWidth()/2-50, this.getHeight()-60 ,100,50);  
        btnWechsel.setBounds(this.getWidth()/2+55, this.getHeight()-60 ,100,50); 
        btnDrehen.addActionListener(this);
        btnVor.addActionListener(this);
        btnWechsel.addActionListener(this);
    }
    
    /**
     * Fügt dem Territorium einen Roboter hinzu
     * @param x Die X Koordinate des Roboters
     * @param y Die Y Koordinate des Roboters
     * @param z Bestimmt die Position auf der Z-Achse
     */
    public void addRoboter(int x,int y,int z){
        roboter.add(new RoboterResizable(x,y,z));
    }
    
    public void actionPerformed(ActionEvent event){      
        if (event.getSource() == btnDrehen){
            roboter.get(ausgewaehlterRoboter).dreheLinks();
            repaint();
        }else if (event.getSource() == btnVor){
            roboter.get(ausgewaehlterRoboter).geheVor();
            repaint();
        }else if (event.getSource() == btnWechsel){
           ausgewaehlterRoboter++;
           if(ausgewaehlterRoboter == roboter.size()){
               ausgewaehlterRoboter = 0;
           }
           repaint();
        }
    }

    public void paint(Graphics g)
    {
        clear(g);
        for(RoboterResizable r : roboter){
            r.zeigen(g);
        }
        g.drawString("Ausgewählter Roboter: " + (ausgewaehlterRoboter+1),0,20);
    }

    /**
     * Setzt den Anzeigenbereich zurück 
     */
    public void clear(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.BLACK);
    }

}