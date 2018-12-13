import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 14.06.2016
 * @author 
 */

public class Spiel extends JApplet {
    // Anfang Attribute
    // SpielObjekte
    private Spieler spieler1,spieler2;
    private Wuerfel wuerfel1,wuerfel2;
    private Topf topf1;
    private Schiedsrichter schiri;
    //Ende SpielObjekte
    //Variablen für den Spielablauf
    private int spielerAmZug = 1;
    //Ende Variablen für den Spielablauf
    //Anzeige
    private JLabel labelSpieler1 = new JLabel();
    private JLabel labelSpieler2 = new JLabel();
    private JButton buttonSetzen = new JButton();
    private JSpinner einsatzWaehler = new JSpinner();
    private SpinnerNumberModel einsatzWaehlerModel = new SpinnerNumberModel(0, 0, 10000, 1);
    private JLabel informationsAnzeige = new JLabel();
    private JLabel labelVermoegenSp1 = new JLabel();
    private JLabel labelZuegeSp1 = new JLabel();
    private JLabel labelPunkteSp1 = new JLabel();
    private JLabel labelVermoegenSp2 = new JLabel();
    private JLabel labelZuegeSp2 = new JLabel();
    private JLabel labelPunkteSp2 = new JLabel();
    private JButton buttonWuerfeln = new JButton();
    private ImageIcon buttonWuerfelnIcon = new ImageIcon("src/diceicon.png");
    private JButton buttonBeenden = new JButton();
    private JLabel labelJackpot = new JLabel();
    //Ende Anzeige
    // Ende Attribute

    public Spiel(){
        wuerfel1 = new Wuerfel();
        wuerfel2 = new Wuerfel();
        topf1 = new Topf();
        spieler1 = new Spieler(wuerfel1,wuerfel2,topf1);
        spieler2 = new Spieler(wuerfel1,wuerfel2,topf1);
        schiri = new Schiedsrichter(spieler1 , spieler2);
    }

    /**
     * Setzt die Werte der Anzeige auf die aktuellen Werte der Objekte
     */
    public void setAnzeigenwerte(){
        //Werte von Spieler 1
        labelVermoegenSp1.setText("Vermögen:" + spieler1.getVermoegen());
        labelZuegeSp1.setText("Züge:" + spieler1.getZuege());
        labelPunkteSp1.setText("Punktestand:" + spieler1.getPunktestand());
        //Werte von Spieler 2
        labelVermoegenSp2.setText("Vermögen:" + spieler2.getVermoegen());
        labelZuegeSp2.setText("Züge:" + spieler2.getZuege());
        labelPunkteSp2.setText("Punktestand:" + spieler2.getPunktestand());
        //Jackpot
        labelJackpot.setText("Aktuell im Jackpot: " + topf1.getEinsatz());
    }

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(null);
        cp.setBounds(0, 0, 400, 450);
        // Anfang Komponenten

        labelSpieler1.setBounds(32, 24, 131, 28);
        labelSpieler1.setText("Spieler 1");
        labelSpieler1.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(labelSpieler1);
        labelSpieler2.setBounds(224, 24, 131, 28);
        labelSpieler2.setText("Spieler 2");
        labelSpieler2.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(labelSpieler2);
        buttonSetzen.setBounds(200, 328, 81, 33);
        buttonSetzen.setText("Setzen");
        buttonSetzen.setMargin(new Insets(2, 2, 2, 2));
        buttonSetzen.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonSetzen_ActionPerformed(evt);
                }
            });
        buttonSetzen.setEnabled(true);
        cp.add(buttonSetzen);
        einsatzWaehler.setBounds(96, 328, 81, 33);
        einsatzWaehler.setValue(0);
        einsatzWaehler.setModel(einsatzWaehlerModel);
        einsatzWaehler.setEnabled(true);
        cp.add(einsatzWaehler);

        informationsAnzeige.setBounds(8, 376, 363, 25);
        informationsAnzeige.setText("Spieler 1 bitte setzen!");
        informationsAnzeige.setHorizontalTextPosition(SwingConstants.LEFT);
        informationsAnzeige.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(informationsAnzeige);
        labelVermoegenSp1.setBounds(40, 64, 123, 25);
        labelVermoegenSp1.setText("Spieler 1 Vermögen");
        cp.add(labelVermoegenSp1);
        labelZuegeSp1.setBounds(40, 112, 123, 25);
        labelZuegeSp1.setText("Spieler 1 Züge");
        cp.add(labelZuegeSp1);
        labelPunkteSp1.setBounds(40, 136, 123, 25);
        labelPunkteSp1.setText("Spieler 1 Punkte");
        cp.add(labelPunkteSp1);
        labelVermoegenSp2.setBounds(232, 64, 123, 25);
        labelVermoegenSp2.setText("Spieler 2 Vermögen");
        cp.add(labelVermoegenSp2);
        labelZuegeSp2.setBounds(232, 112, 123, 25);
        labelZuegeSp2.setText("Spieler 2 Züge");
        cp.add(labelZuegeSp2);
        labelPunkteSp2.setBounds(232, 136, 123, 25);
        labelPunkteSp2.setText("Spieler 2 Punkte");
        cp.add(labelPunkteSp2);
        buttonWuerfeln.setBounds(144, 208, 89, 81);
        buttonWuerfeln.setText("");
        buttonWuerfeln.setMargin(new Insets(2, 2, 2, 2));
        buttonWuerfeln.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonWuerfeln_ActionPerformed(evt);
                }
            });
        buttonWuerfeln.setIcon(buttonWuerfelnIcon);
        buttonWuerfeln.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonWuerfeln.setBackground(new Color(0xEEEEEE));
        buttonWuerfeln.setContentAreaFilled(true);
        buttonWuerfeln.setIconTextGap(0);

        buttonWuerfeln.setBorderPainted(false);
        buttonWuerfeln.setToolTipText("Würfeln");
        buttonWuerfeln.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonWuerfeln.setEnabled(false);
        cp.add(buttonWuerfeln);
        buttonBeenden.setBounds(144, 296, 89, 25);
        buttonBeenden.setText("Zug beenden");
        buttonBeenden.setMargin(new Insets(2, 2, 2, 2));
        buttonBeenden.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonBeenden_ActionPerformed(evt);
                }
            });
        buttonBeenden.setToolTipText("Beendet den Zug des Spielers");
        buttonBeenden.setEnabled(false);
        cp.add(buttonBeenden);
        labelJackpot.setBounds(112, 176, 155, 25);
        labelJackpot.setText("Aktueller Jackpot");
        labelJackpot.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(labelJackpot);
        // Ende Komponenten
        setAnzeigenwerte();
    } // end of init

    // Anfang Methoden   
    public void buttonSetzen_ActionPerformed(ActionEvent evt) {
        if(!spieler1.hatGesetzt()){
            spieler1.einsatzSetzen(Integer.valueOf(einsatzWaehler.getValue().toString()).intValue());
        }else if(!spieler2.hatGesetzt()){
            spieler2.einsatzSetzen(Integer.valueOf(einsatzWaehler.getValue().toString()).intValue());
        }
        if(spieler1.hatGesetzt()&&spieler2.hatGesetzt()){
            aktiviereSetzen(false);
            aktiviereWuerfeln(true);
        }
        setAnzeigenwerte();
    } // end of buttonSetzen_ActionPerformed

    public void buttonWuerfeln_ActionPerformed(ActionEvent evt) {
        if(spielerAmZug == 1){
            spieler1.wuerfeln();
            if(spieler1.hatZugBeendet()){
                spielerAmZug = 2;
            }
        }else if(spielerAmZug == 2){
            spieler2.wuerfeln();
            if(spieler2.hatZugBeendet()){
                spielerAmZug = 1;
            }
        }
        if(spieler1.hatZugBeendet() && spieler2.hatZugBeendet()){
            aktiviereWuerfeln(false);
            rundeBeenden();
        }
        setAnzeigenwerte();
    }

    // end of buttonWuerfeln_ActionPerformed

    public void buttonBeenden_ActionPerformed(ActionEvent evt) {
        if(spielerAmZug == 1){
            spieler1.zugBeenden();
            spielerAmZug = 2;
        }else if(spielerAmZug == 2){
            spieler2.zugBeenden();
            spielerAmZug = 1;
        }
        if(spieler1.hatZugBeendet() && spieler2.hatZugBeendet()){
            aktiviereWuerfeln(false);
            rundeBeenden();
        }
        setAnzeigenwerte();
    } // end of buttonBeenden_ActionPerformed

    /**
     * Wertet die Runde aus, und setzt die Rundenspeziefischen Werte zurück auf den Normalwert
     */
    public void rundeBeenden(){
        schiri.auswerten();
        spieler1.starteNeueRunde();
        spieler2.starteNeueRunde();
        if(spielerAmZug == 1){
            spielerAmZug = 2;
        }else{
            spielerAmZug = 1;
        }
        aktiviereSetzen(true);
    }

    /**
     * Ändert den Text der Informationsanzeige
     * @param info Die neue Information
     */
    public void schreibInfo(String info){
        informationsAnzeige.setText(info);
    }

    /**
     * Aktiviert oder deaktiviert das Setzen des Einsatzes
     * @param aktiv Entscheidet ob das Setzen aktiv ist
     */
    public void aktiviereSetzen(boolean aktiv){
        if(aktiv){
            einsatzWaehler.setEnabled(true);
            buttonSetzen.setEnabled(true);
        }else{
            einsatzWaehler.setEnabled(false);
            buttonSetzen.setEnabled(false);
        }
    }

    /**
     * Aktiviert oder deaktiviert das Würfeln und das beenden des Zuges
     * @param aktiv Entscheidet ob das Setzen aktiv ist
     */
    public void aktiviereWuerfeln(boolean aktiv){
        if(aktiv){
            buttonWuerfeln.setEnabled(true);
            buttonBeenden.setEnabled(true);
        }else{
            buttonWuerfeln.setEnabled(false);
            buttonBeenden.setEnabled(false);
        }
    }

    // Ende Methoden
} // end of class Spiel
