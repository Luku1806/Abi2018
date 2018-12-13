import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 14.12.2016
 * @author 
 */

public class VokabelGui extends JApplet {
    // Anfang Attribute
    // Attribute Gui
    private JButton buttonToggleModus = new JButton();
    private JLabel labelZuUebersetzen = new JLabel();
    private JTextField textfieldUebersetzung = new JTextField();
    private JButton buttonPruefen = new JButton();
    private JSeparator jSeparator1 = new JSeparator();
    private JTextField textfieldDeutsch = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JTextField textfieldEnglisch = new JTextField();
    private JButton buttonHinzufuegen = new JButton();
    private JSeparator jSeparator2 = new JSeparator();
    // Ende Attribute Gui
    // Attribute Programm
    Vokabeltrainer mVokabeltrainer;
    // Ende Attribute Programm
    // Ende Attribute

    public VokabelGui(){
        mVokabeltrainer = new Vokabeltrainer();
    }

    /**
     * Zeigt einen Dialog mit der Ueberschrift "Ergebnis" und einem frei waehlbaren Text.
     * 
     * @param message Der anzuzeigende Text.
     */
    private void showErgebnisDialog(String message){
        JOptionPane.showMessageDialog(this, message, "Ergebnis", JOptionPane.PLAIN_MESSAGE);
    }

    // Anfang Methoden
    private void buttonToggleModus_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        showErgebnisDialog("Klappt");
    } 

    private void buttonPruefen_ActionPerformed(ActionEvent evt) {
        if(mVokabeltrainer.getCurrentVokabel().isRichtigUebersetzt(textfieldUebersetzung.getText())){
            showErgebnisDialog("Richtig");
        }else{
            showErgebnisDialog("Leider falsch");
        }
    }

    private void buttonHinzufuegen_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
    } 

    // Ende Methoden

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(null);
        cp.setBounds(0, 0, 298, 369);
        // Anfang Komponenten

        buttonToggleModus.setBounds(8, 288, 267, 25);
        buttonToggleModus.setText("Abfragemodus: ");
        buttonToggleModus.setMargin(new Insets(2, 2, 2, 2));
        buttonToggleModus.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonToggleModus_ActionPerformed(evt);
                }
            });
        cp.add(buttonToggleModus);
        labelZuUebersetzen.setBounds(8, 8, 270, 20);
        labelZuUebersetzen.setText("Cat");
        cp.add(labelZuUebersetzen);
        textfieldUebersetzung.setBounds(8, 40, 270, 20);
        cp.add(textfieldUebersetzung);
        buttonPruefen.setBounds(8, 64, 267, 25);
        buttonPruefen.setText("Pruefen");
        buttonPruefen.setMargin(new Insets(2, 2, 2, 2));
        buttonPruefen.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonPruefen_ActionPerformed(evt);
                }
            });
        cp.add(buttonPruefen);
        jSeparator1.setBounds(-8, 104, 284, 2);
        cp.add(jSeparator1);
        textfieldDeutsch.setBounds(8, 144, 270, 20);
        textfieldDeutsch.setText("");
        cp.add(textfieldDeutsch);
        jLabel1.setBounds(8, 120, 110, 20);
        jLabel1.setText("Deutsch:");
        cp.add(jLabel1);
        jLabel2.setBounds(8, 176, 110, 20);
        jLabel2.setText("Englisch:");
        cp.add(jLabel2);
        textfieldEnglisch.setBounds(8, 200, 270, 20);
        cp.add(textfieldEnglisch);
        buttonHinzufuegen.setBounds(8, 232, 267, 25);
        buttonHinzufuegen.setText("Vokabel hinzufuegen");
        buttonHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
        buttonHinzufuegen.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonHinzufuegen_ActionPerformed(evt);
                }
            });
        cp.add(buttonHinzufuegen);
        jSeparator2.setBounds(-8, 272, 292, 2);
        cp.add(jSeparator2);
        // Ende Komponenten

    }

}
