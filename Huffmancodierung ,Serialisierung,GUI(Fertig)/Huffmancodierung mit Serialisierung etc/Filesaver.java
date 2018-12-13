import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Die Klasse dient dem Speichern von Huffmancodes auf dem lokalen Dateisystem.
 * 
 * @author Jannik Stadtler und Lukas Reining 
 * @version 1.0 vom 01.06.2017
 */
public final class Filesaver{

    /**
     * Speichert einen Huffmancode als ".huff" Datei auf dem lokalen Dateisystem.
     * 
     * @param huffmancode Das Huffmancode-Objekt das gespeichert werden soll.
     * @param filename Der Name und Pfad an dem die Datei gespeichert werden soll. 
     *                 Formatbeispiel.: "D:\\Bilder\\huffman" fuer eine Datei namens "huffman.huff".
     */
    public static void saveHuffmanToFile(Huffmancode huffmancode, String filename){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename + ".huff");
            out = new ObjectOutputStream(fos);
            out.writeObject(huffmancode);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Laedt eine ".huff" Datei vom lokalen Dateisystem.
     * 
     * @param filename Der Name und Pfad von dem die Datei geladen werden soll. 
     *                 Formatbeispiel.: "D:\\Bilder\\huffman.huff" fuer eine Datei namens "huffman.huff".
     */
    public static Huffmancode loadHuffmanFromFile(String filename){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        Huffmancode h = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            h = (Huffmancode) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return h;
    }
}
