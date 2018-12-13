import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Das Programm stellt eine Version des Nim-Spiels dar.
 *
 * @version 1.0 vom 21.06.2016
 * @author Lukas Reining
 */

public class NimSpiel extends JFrame {
    // Anfang Attribute
    // Anfang Grafikobjekte
    private JLabel labelHoelzerHeader = new JLabel();
    private JLabel labelHoelzerZahl = new JLabel();
    private JLabel labelInfos = new JLabel();
    private JButton buttonNehmen = new JButton();
    private JSpinner anzahlWaehler = new JSpinner();
    private SpinnerListModel anzahlWaehlerModel = new SpinnerListModel(new String[] {"1 Holz", "2 Hoelzer", "3 Hoelzer"});
    // Ende Grafikobjekte
    // Anfang Spielobjekte
    private Spieler spieler1,spieler2;
    private Topf topf;
    private Schachtel schachtel;
    // Ende Spielobjekte
    // Anfang Attritbute fuer den Spielverlauf
    private boolean spieler1AmZug = true;
    private boolean rundeBeendet = false;
    // Ende Attritbute fuer den Spielverlauf
    private JButton buttonSetzen = new JButton();
    private JSpinner einsatzWaehler = new JSpinner();
    private SpinnerNumberModel einsatzWaehlerModel = new SpinnerNumberModel(0, 0, 99999, 1);
    private JLabel labelVermoegen1 = new JLabel();
    private JLabel labelVermoegen2 = new JLabel();
    private JSeparator jSeparator1 = new JSeparator();
    private JSeparator jSeparator2 = new JSeparator();
    private JSeparator jSeparator3 = new JSeparator();
    private JSeparator jSeparator4 = new JSeparator();
    private JLabel labelVermoegenHeader = new JLabel();
    private JSeparator jSeparator5 = new JSeparator();
    private JLabel labelTopfinhalt = new JLabel();
    private JButton buttonNeueRunde = new JButton();
    // Ende Attribute

    /**
     * Der Konstruktor fuer das Nim-Spiel.
     */
    public NimSpiel() { 
        super();
        initScreen();
        topf = new Topf();
        schachtel = new Schachtel();
        spieler1 = new Spieler("Lukas", 500 , topf , schachtel);
        spieler2 = new Spieler("Krilu J Button", 500 , topf , schachtel);
        aktualisiereAnzeige();
        setNeueRundeAktiviert(true);
        zeigeInfo("Bitte starte das Spiel");
    } // end of public NimSpiel

    // Anfang Methoden

    /**
     * Startet das Programm des Spiels.
     */
    public static void main(String[] args) {
        new NimSpiel();
    } // end of main

    /**
     * Laesst den Spieler der an der Reihe ist ein Streichholz aus der Schachtel ziehen.
     * Zieht er das letzte Streichholz wird die Runde beendet.
     */
    public void buttonNehmen_ActionPerformed(ActionEvent evt) {
        Spieler spAmZug;
        if(spieler1AmZug){
            spAmZug = spieler1;
        }else{
            spAmZug = spieler2;
        }
        switch(anzahlWaehler.getValue().toString()){
            case "1 Holz": spAmZug.ziehen(1);
            break;
            case "2 Hoelzer": spAmZug.ziehen(2);
            break;
            case "3 Hoelzer": spAmZug.ziehen(3);
            break;
        }
        if(schachtel.getAnzahl() == 0){
            beendeRunde();
        }else{
            spieler1AmZug = !spieler1AmZug;
        }
        aktualisiereAnzeige();
    } // end of buttonNehmen_ActionPerformed

    /**
     * Laesst den Spieler seinen Einsatz in den Jackpot legen.
     * Wenn beide Spieler dies getan haben kann gezogen werden.
     */
    public void buttonSetzen_ActionPerformed(ActionEvent evt) {
        if(!spieler1.hatGesetzt()){
            spieler1.setzen(Integer.valueOf(einsatzWaehler.getValue().toString()));
        }else if(!spieler2.hatGesetzt()){
            spieler2.setzen(Integer.valueOf(einsatzWaehler.getValue().toString()));
        }
        if(spieler2.hatGesetzt()){
            starteZiehen();
        }
        aktualisiereAnzeige();
    } // end of buttonSetzen_ActionPerformed

    /**
     * Startet eine neue Runde.
     * Das setzen wird freigegeben und die Werte, wann ein Spieler an der Reihe ist werden zurueckgesetzt.
     */
    public void buttonNeueRunde_ActionPerformed(ActionEvent evt) {
        spieler1.schachtelFuellen(30);
        this.rundeBeendet = false;
        spieler1.bereiteRundeVor();
        spieler2.bereiteRundeVor();
        starteSetzen();
        aktualisiereAnzeige();
    } // end of buttonNeueRunde_ActionPerformed

    /**
     * Gibt den Eingabebereich fuer das Setzen frei.
     */
    public void starteSetzen(){
        setSetzenAktiviert(true);
        setNeueRundeAktiviert(false);
        setZiehenAktiviert(false);
    }

    /**
     * Gibt den Eingabebereich fuer das Ziehen frei.
     */
    public void starteZiehen(){
        setSetzenAktiviert(false);
        setZiehenAktiviert(true);
    }

    /**
     * Beendet die Runde, und zahlt dem Spieler, der gewonnen hat den Jackpot aus.
     */
    public void beendeRunde(){
        rundeBeendet = true;
        if(spieler1AmZug){
            spieler2.topfLeeren();
        }else{
            spieler1.topfLeeren();
        }
        setNeueRundeAktiviert(true);
    }

    /**
     * Zeigt eine Nachricht im Infofeld des Spiels.
     * @param pInformation Der Text der als Info angezeigt wird.
     */
    public void zeigeInfo(String pInformation){
        labelInfos.setText(pInformation);
    }

    /**
     * Aktualisiert die Anzeige der verschiedenen Spielattribute und steuert die Ausgabe der Infos fuer den Spieler.
     */
    public void aktualisiereAnzeige(){
        labelHoelzerZahl.setText(Integer.toString(schachtel.getAnzahl()));
        labelVermoegen1.setText(spieler1.getName() + ": " + String.valueOf(spieler1.getVermoegen()) + "€");
        labelVermoegen2.setText(spieler2.getName() + ": " + String.valueOf(spieler2.getVermoegen()) + "€");
        labelTopfinhalt.setText("Topf: " + String.valueOf(topf.getInhalt()) + "€");
        if(rundeBeendet){
            if(spieler1AmZug){
                zeigeInfo(spieler2.getName() + " hat die Runde gewonnen");
            }else{
                zeigeInfo(spieler1.getName() + " hat die Runde gewonnen");
            }
        }else if(!spieler1.hatGesetzt()){
            zeigeInfo(spieler1.getName() + " setze deinen Einsatz");
        }else if(!spieler2.hatGesetzt()){
            zeigeInfo(spieler2.getName() + " setze deinen Einsatz");
        }else if(spieler1AmZug){
            zeigeInfo(spieler1.getName() + " ziehe bitte 1-3 Hoelzer");
        }else{
            zeigeInfo(spieler2.getName() + " ziehe bitte 1-3 Hoelzer");
        }
    }

    /**
     * Gibt das Starten einer neuen Runde frei und sperrt das Setzen und Ziehen.
     * @param aktiv Entscheidet ob das Starten einer neuen Runde aktiviert wird.
     */
    public void setNeueRundeAktiviert(boolean aktiv){
        if(aktiv){
            setSetzenAktiviert(false);
            setZiehenAktiviert(false);
            buttonNeueRunde.setEnabled(true);
            buttonNeueRunde.setVisible(true);
        }else{
            buttonNeueRunde.setEnabled(false);
            buttonNeueRunde.setVisible(false);
        }
    }

    /**
     * Gibt das Ziehen frei.
     * @param aktiv Entscheidet ob das Ziehen von Streichhoelzern aktiviert wird.
     */
    public void setZiehenAktiviert(boolean aktiv){
        if(aktiv){
            buttonNehmen.setEnabled(true);
            anzahlWaehler.setEnabled(true);
        }else{
            buttonNehmen.setEnabled(false);
            anzahlWaehler.setEnabled(false);
        }
    }

    /**
     * Gibt das Setzen frei.
     * @param aktiv Entscheidet ob das Setzen des Einsatzes aktiviert wird.
     */
    public void setSetzenAktiviert(boolean aktiv){
        if(aktiv){
            buttonSetzen.setEnabled(true);
            einsatzWaehler.setEnabled(true);
        }else{
            buttonSetzen.setEnabled(false);
            einsatzWaehler.setEnabled(false);
        }
    }

    /**
     * Initialisiert den Screen mitsamt aller seiner Objekte.
     */
    public void initScreen(){
        // Frame-Initialisierung
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int frameWidth = 500; 
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);  
        setVisible(true);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten
        labelHoelzerHeader.setBounds(0, 8, 500, 25);
        labelHoelzerHeader.setText("Anzahl Hoelzer: ");
        labelHoelzerHeader.setHorizontalAlignment(SwingConstants.CENTER);
        labelHoelzerHeader.setHorizontalTextPosition(SwingConstants.LEFT);
        labelHoelzerHeader.setFont(new Font("Dialog", Font.BOLD, 12));
        cp.add(labelHoelzerHeader);
        setTitle("Nim-Spiel");
        labelHoelzerZahl.setBounds(0, 48, 500, 96);
        labelHoelzerZahl.setText("40");
        labelHoelzerZahl.setFont(new Font("Dialog", Font.BOLD, 100));
        labelHoelzerZahl.setHorizontalTextPosition(SwingConstants.CENTER);
        labelHoelzerZahl.setHorizontalAlignment(SwingConstants.CENTER);
        labelHoelzerZahl.setToolTipText("Die Anzahl an Hoelzern in der Schachtel");
        cp.add(labelHoelzerZahl);
        labelInfos.setBounds(0, 216, 500, 19);
        labelInfos.setText("Infos fuer den Spieler");
        labelInfos.setHorizontalAlignment(SwingConstants.CENTER);
        labelInfos.setHorizontalTextPosition(SwingConstants.CENTER);
        labelInfos.setBackground(Color.YELLOW);
        labelInfos.setOpaque(true);
        cp.add(labelInfos);
        buttonNehmen.setBounds(144, 152, 108, 50);
        buttonNehmen.setText("Hoelzer nehmen");
        buttonNehmen.setMargin(new Insets(2, 2, 2, 2));
        buttonNehmen.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonNehmen_ActionPerformed(evt);
                }
            });
        buttonNehmen.setToolTipText("Ziehen der Hoelzer");
        cp.add(buttonNehmen);
        anzahlWaehler.setBounds(256, 152, 108, 50);
        anzahlWaehler.setValue(0);
        anzahlWaehler.setModel(anzahlWaehlerModel);
        ((JSpinner.DefaultEditor)anzahlWaehler.getEditor()).getTextField().setEditable(false);
        anzahlWaehler.setToolTipText("Die Anzahl an Hoelzern die gezogen werden soll");
        cp.add(anzahlWaehler);

        buttonSetzen.setBounds(144, 400, 108, 50);
        buttonSetzen.setText("Einsatz setzen");
        buttonSetzen.setMargin(new Insets(2, 2, 2, 2));
        buttonSetzen.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonSetzen_ActionPerformed(evt);
                }
            });
        buttonSetzen.setToolTipText("Setzen des Einsatzes");
        cp.add(buttonSetzen);
        einsatzWaehler.setBounds(256, 400, 108, 50);
        einsatzWaehler.setValue(0);
        einsatzWaehler.setModel(einsatzWaehlerModel);
        einsatzWaehler.setToolTipText("Der Einsatz der abgegeben werden soll");
        cp.add(einsatzWaehler);

        labelVermoegen1.setBounds(128, 280, 250, 25);
        labelVermoegen1.setText("Spieler1: 100€");
        labelVermoegen1.setHorizontalAlignment(SwingConstants.CENTER);
        labelVermoegen1.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(labelVermoegen1);
        labelVermoegen2.setBounds(128, 312, 252, 25);
        labelVermoegen2.setText("Spieler2: 100€");
        labelVermoegen2.setHorizontalTextPosition(SwingConstants.CENTER);
        labelVermoegen2.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(labelVermoegen2);
        jSeparator1.setBounds(120, 248, 265, 1);
        cp.add(jSeparator1);
        jSeparator2.setBounds(384, 248, 1, 137);
        jSeparator2.setOrientation(SwingConstants.VERTICAL);
        cp.add(jSeparator2);
        jSeparator3.setBounds(120, 248, 1, 137);
        jSeparator3.setOrientation(SwingConstants.VERTICAL);
        cp.add(jSeparator3);
        jSeparator4.setBounds(120, 344, 265, 1);
        cp.add(jSeparator4);
        labelVermoegenHeader.setBounds(128, 256, 251, 23);
        labelVermoegenHeader.setText("Vermoegen der Spieler");
        labelVermoegenHeader.setHorizontalAlignment(SwingConstants.CENTER);
        labelVermoegenHeader.setHorizontalTextPosition(SwingConstants.CENTER);
        labelVermoegenHeader.setFont(new Font("@Arial Unicode MS", Font.BOLD, 14));
        cp.add(labelVermoegenHeader);
        jSeparator5.setBounds(120, 384, 265, 1);
        cp.add(jSeparator5);
        labelTopfinhalt.setBounds(128, 352, 252, 25);
        labelTopfinhalt.setText("Topf: 300€");
        labelTopfinhalt.setHorizontalAlignment(SwingConstants.CENTER);
        labelTopfinhalt.setHorizontalTextPosition(SwingConstants.CENTER);
        labelTopfinhalt.setFont(new Font("Dialog", Font.BOLD, 14));
        cp.add(labelTopfinhalt);
        buttonNeueRunde.setBounds(15, 472, 470, 33);
        buttonNeueRunde.setText("Neue Runde starten");
        buttonNeueRunde.setMargin(new Insets(2, 2, 2, 2));
        buttonNeueRunde.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonNeueRunde_ActionPerformed(evt);
                }
            });
        buttonNeueRunde.setVisible(false);
        buttonNeueRunde.setEnabled(false);
        cp.add(buttonNeueRunde);
        // Ende Komponenten
    }
    // Ende Methoden
} // end of class NimSpiel
