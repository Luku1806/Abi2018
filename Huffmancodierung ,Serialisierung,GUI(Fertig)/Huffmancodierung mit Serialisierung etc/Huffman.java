import java.util.Hashtable;

/**
 * Beschreiben Sie hier die Klasse Huffman.
 * 
 * @author Jannik Stadtler und Lukas Reining
 * @version 1.1 vom 06.05.2017
 */
public class Huffman{

    private BinaryTree<Zeichen> huffmantree;

    /**
     * Konstruktor für Objekte der Klasse Huffman
     */
    public Huffman(){

    }

    /**
     * Ermittelt die Häufigkeit der einzelnen Zeichen in einer String und schreibt diese als Zeichen-Objekt in einen leeren Binärbaum,
     * und gibt diese als Huffmanliste zurueck.
     * 
     * @param pText Der zu benutzende Text.
     * @return Die Huffmanliste die jedes Zeichen zusammen mit seiner Haeufigkeit als einzelne Baueme gespeichert hat.
     */
    private List<BinaryTree<Zeichen>> haeufigkeit(String pText){
        List<BinaryTree<Zeichen>> wahrscheinlichkeiten = new List<BinaryTree<Zeichen>>();
        for(int i = 0; i < pText.length(); i++){
            boolean gefunden = false;
            char charText = pText.charAt(i);
            wahrscheinlichkeiten.toFirst();
            while(wahrscheinlichkeiten.hasAccess()){
                Zeichen zeichenListe = wahrscheinlichkeiten.getContent().getContent();
                char charListe = zeichenListe.getZeichen();
                if(charText == charListe){
                    zeichenListe.erhoeheAnzahl();
                    gefunden = true;
                    break;
                }
                wahrscheinlichkeiten.next();
            }
            if(!gefunden){
                BinaryTree<Zeichen> node = new BinaryTree<Zeichen>(new Zeichen(charText));
                wahrscheinlichkeiten.append(node);
            }
        }
        return wahrscheinlichkeiten;
    }

    /**
     * Sortiert eine Huffmanliste nach Hauefigkeit.
     * 
     * @param Die zu sortierende Huffmanliste.
     * @return Die sortierte Huffmanliste.
     */
    private List<BinaryTree<Zeichen>> sortiereHuffmanliste(List<BinaryTree<Zeichen>> wahrscheinlichkeiten){
        List<BinaryTree<Zeichen>> hListe = new List<BinaryTree<Zeichen>>();
        while(!wahrscheinlichkeiten.isEmpty()){
            wahrscheinlichkeiten.toFirst();
            //Erster Wert wird ermittelt
            Zeichen z1 = wahrscheinlichkeiten.getContent().getContent();
            wahrscheinlichkeiten.next();
            //Alle weiteren Werte werden durchgegeangen und der kleinste Wert wird ermittelt
            while(wahrscheinlichkeiten.hasAccess()){
                Zeichen z2 = wahrscheinlichkeiten.getContent().getContent();
                if(z2.getAnzahl() < z1.getAnzahl()){
                    z1 = z2;
                }
                wahrscheinlichkeiten.next();
            }
            //Der ermittelte kleinste Wert wird aus der Liste entfernt 
            //Da die Liste keinen direkten Zugriff ermoeglicht, muss die Liste hierfuer durchlaufen werden bis der Zeiger auf der Position des kleinsten Wertes ist
            wahrscheinlichkeiten.toFirst();
            while(wahrscheinlichkeiten.hasAccess()){
                if(wahrscheinlichkeiten.getContent().getContent() == z1){
                    wahrscheinlichkeiten.remove();
                    break;
                }
                wahrscheinlichkeiten.next();
            }
            //Der ermittelte kleinste wird wird an die Hilfsliste angehangen.
            hListe.append(new BinaryTree<Zeichen>(z1));
        }
        return hListe;
    }

    /**
     * Erstellt einen Huffmanbaum und gibt diesen zurueck.
     * 
     * @param Die zu benutzende Huffmanliste.
     * @return Der erstellte Huffmantree.
     */
    private BinaryTree<Zeichen> createTree(List<BinaryTree<Zeichen>> wahrscheinlichkeiten){
        // Hole neue Zeichen und entferne diese aus der Liste
        wahrscheinlichkeiten.toFirst();
        BinaryTree<Zeichen> erstes = wahrscheinlichkeiten.getContent();
        wahrscheinlichkeiten.remove();
        BinaryTree<Zeichen> zweites = wahrscheinlichkeiten.getContent();
        wahrscheinlichkeiten.remove();
        //Zusammenfuegen der 2 kleinsten Elemente zu einem Baum bis nur noch eine ueber ist, welcher der gesamte Huffmantree ist
        while(zweites != null){
            // Erstelle neuen Teilbaum aus den beiden kleinsten und fuegt diesen der Liste hinzu
            int anzahl = erstes.getContent().getAnzahl()+zweites.getContent().getAnzahl();
            BinaryTree<Zeichen> node = new BinaryTree<Zeichen>(new Zeichen('#',anzahl), erstes, zweites);
            // Das neue Element an die passende Stelle der Liste einfuegen
            wahrscheinlichkeiten.toFirst();
            while(wahrscheinlichkeiten.hasAccess() && wahrscheinlichkeiten.getContent().getContent().getAnzahl() <= node.getContent().getAnzahl()){
                wahrscheinlichkeiten.next();
            }
            if(wahrscheinlichkeiten.hasAccess()){
                wahrscheinlichkeiten.insert(node);
            }else{
                wahrscheinlichkeiten.append(node);
            }
            // Hole neue Zeichen und entferne diese aus der Liste
            wahrscheinlichkeiten.toFirst();
            erstes = wahrscheinlichkeiten.getContent();
            wahrscheinlichkeiten.remove();
            zweites = wahrscheinlichkeiten.getContent();
            wahrscheinlichkeiten.remove();
        }
        return erstes;
    }

    /**
     * Codiert einen Character in den zugehoerigen Huffmancode.
     * 
     * @param pZeichen Das zu codierende Zeichen.
     * @param pBaum Der zu benutzende Huffmantree.
     * @param pCode Hilfsparameter! Leere String eingeben!
     * 
     * @return Der eingegebene Character als Huffmancode.
     */
    private String charCodieren(char pZeichen, BinaryTree<Zeichen> pBaum, String pCode){
        if(pBaum.isEmpty()){
            return "";
        }
        if(pBaum.getContent().getZeichen() == pZeichen){
            return pCode;
        }else{
            String teilcode = charCodieren(pZeichen,pBaum.getLeftTree(),pCode + '0');
            if(teilcode == ""){
                return charCodieren(pZeichen,pBaum.getRightTree(),pCode + '1');
            }else{
                return teilcode;
            }
        }
    }

    /**
     * Erstellt eine Codetabelle zu einem Text und dem dazugehoerigen Huffmantree.
     * 
     * @param pBaum Der in die Tabelle zu uebertragende Huffmanbaum.
     * @param pText Der zum Baum gehoerige Text.
     * 
     * @return Die zum Baum und Text gehorige Codetabelle.
     */
    private Hashtable<Character,String> createTableFromTree(BinaryTree<Zeichen> pBaum, String pText){
        Hashtable<Character,String> pCodeTable = new Hashtable<Character,String>();
        for(char c : pText.toCharArray()){
            pCodeTable.put(c,charCodieren(c,pBaum,""));
        }
        return pCodeTable;
    }

    /**
     * Codiert einen mindestens 2 stelligen Text in binaeren Huffmancode und gibt diesen als String zurueck.
     * 
     * @param pText Der zu codierende Text.
     * @return Der codierte Text als String.
     */
    private String textToHuffmanBinary(String pText){
        if(pText.length() > 1){
            String ergebniss = "";
            List<BinaryTree<Zeichen>> huffmanliste = haeufigkeit(pText);
            huffmanliste = sortiereHuffmanliste(huffmanliste);
            huffmantree = createTree(huffmanliste);
            for(int i = 0; i < pText.length(); i++){
                ergebniss += charCodieren(pText.charAt(i),huffmantree,"");
            }
            return ergebniss;
        }else{
            System.out.println("^^FEHLER: Text muss laenger als 2 Zeichen sein!");
            return null;
        }
    }

    /**
     * Dekodiert einen String aus Binaercode mit Hilfe der Huffman Codierung.
     * 
     * @param huffmantree Der zum Binaercode gehoerige Huffmantree.
     * @param Binaey Der Binaercode der in Klartext uebersetzt werden soll.
     */
    private String huffmanBinaryToText(BinaryTree<Zeichen> huffmantree, String binary){
        String decoded = "";
        BinaryTree<Zeichen> pointer = huffmantree;
        for(char i : binary.toCharArray()){
            if(i == '0'){
                pointer = pointer.getLeftTree();
            }
            else if(i == '1'){
                pointer = pointer.getRightTree();
            }
            else{
                System.out.println("^^FEHLER: Bitte gib eine Binaercode ein!");
                return null;
            }
            if(pointer.getLeftTree().getContent() == null && pointer.getRightTree().getContent() == null){
                decoded += pointer.getContent().getZeichen();
                pointer = huffmantree;
            }
        }
        return decoded;
    }

    /**
     * Codiert Binaercode zu Ascii-Code.
     * 
     * @param code Der zu codierende Binaercode.
     * @return Der in Ascii-Code uebersetzte Binaercode.
     */
    private String binaryToAscii(String pBinaer){
        String ascii = "";
        String rest = "";
        int length = pBinaer.length();
        if(length%8 != 0){
            rest = pBinaer.substring(length - (length%8), length);
            pBinaer = pBinaer.substring(0, length - (length%8));
        }
        for(int i=0; i <= pBinaer.length()-8; i += 8){
            int charCode = Integer.parseInt(pBinaer.substring(i, i+8), 2);
            ascii += (char) charCode;
        }
        if(rest.length() > 0){
            ascii += "###"+rest;
        }
        return ascii;
    }

    /**
     * Codiert Ascii-Code zu Binaercode.
     * 
     * @param code Der zu codierende Ascii-Code.
     * @return Der in Binaercode uebersetzte Ascii-Code.
     */
    private String asciiToBinary(String code){
        String binaer = "";
        String rest = "";
        if(code.contains("###")){
            rest = code.substring(code.indexOf("###")+3, code.length());
            code = code.substring(0, code.indexOf("###"));
        }
        for(int i = 0; i< code.length(); i++){
            int charCode = (int)code.charAt(i);
            String binary = String.format("%8s", Integer.toBinaryString(charCode)).replace(' ', '0');
            binaer += binary;
        }
        return binaer+rest;
    }

    /**
     * Komprimiert einen Text mithilfe der Huffmancodierung.
     * 
     * @param pText Der zu komprimierende Text.
     * @return Ein Huffmancode Objekt, dass Kodierung(Komprimierung) und den zum dekodieren benoetigten Huffmantree beinhaltet. 
     */
    public Huffmancode compress(String toCompress){
        //Text in Huffman-Binaercode uebersetzen
        String huffman = textToHuffmanBinary(toCompress);
        //Huffman-Binaercode in Asciicode uebersetzten(Komprimierung)
        huffman = binaryToAscii(huffman);
        //Huffmancode-Objekt erstellen und zurueckgeben
        return new Huffmancode(huffman,createTableFromTree(huffmantree,toCompress));
    }
    
    /**
     * Dekomprimiert einen in Huffmancode kodierten Text.
     * 
     * @param toDecompress Das Huffmancode-Objekt welches Code und Baum bereitstellt.
     * @return Der dekomprimierte und ecodierte Text. 
     */
    public String decompress(Huffmancode toDecompress){
        //Asciicode in Huffman-Binaercode uebersetzten(Komprimierung)
        String klartext = asciiToBinary(toDecompress.getCode());
        //Zum Text gehoerenden Huffmantree holen
        BinaryTree<Zeichen> huffmantree = toDecompress.getHuffmanTree();
        //Text in Huffman-Binaercode uebersetzen
        klartext = huffmanBinaryToText(huffmantree,klartext);
        //Huffmancode-Objekt erstellen und zurueckgeben
        return klartext;
    }
}
