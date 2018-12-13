import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.06.2017
 * @author 
 */

public class GUI{

    //GUI
    //JFrame
    JFrame frame;
    //JPanels
    private JPanel panelMainMenu = new MainMenuPanel(this);
    private JPanel panelEncodeMenu = new EncodePanel(this);
    private JPanel panelDecodeMenu = new DecodePanel(this);

    public GUI() { 
        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        showMainMenu();
    }

    public static void main(String[] args) {
        new GUI();
    } // end of main

    public void showMainMenu(){
        frame.getContentPane().removeAll();
        frame.add(panelMainMenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void showDecodeMenu(){
        frame.getContentPane().removeAll();
        frame.add(panelDecodeMenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void showEncodeMenu(){
        frame.getContentPane().removeAll();;
        frame.add(panelEncodeMenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }   

} // end of class jframeFirstTest
