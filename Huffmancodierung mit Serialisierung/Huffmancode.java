import java.util.Hashtable;
import java.io.Serializable;

/**
 * Beschreiben Sie hier die Klasse Huffmancode.
 * 
 * @author Jannik Stadtler und Lukas Reining
 * @version 1.0 vom 01.06
 */
public class Huffmancode implements Serializable{
    // Attribute
    private String code;
    private Hashtable<Character,String> codeTable;

    /**
     * Konstruktor für Objekte der Klasse Huffmancode
     */
    public Huffmancode(String pCode, Hashtable<Character,String> pCodeTable){
        this.code = pCode;
        this.codeTable = pCodeTable;
    }

    /**
     * @return Der zu Ascii codierte Huffmancode.
     */
    public String getCode(){
        return this.code;
    }

    /**
     * @return Die zum decodieren benoetigte Codetabelle.
     */
    public Hashtable<Character,String> getCodeTable(){
        return this.codeTable;
    }

    /**
     * Erstellt aus der Codetabelle einen Huffmantree und gibt diesen zurueck.
     * 
     * @return Der zum Code gehoerige Huffmantree.
     */
    public BinaryTree<Zeichen> getHuffmanTree(){
        BinaryTree<Zeichen> huffmantree = new BinaryTree<Zeichen>(new Zeichen('#'));
        for(char buchstabe: codeTable.keySet()){
            BinaryTree<Zeichen> tempTree = huffmantree;
            String codierung = codeTable.get(buchstabe);
            for(char c : codierung.toCharArray()){
                if(c == '0'){
                    if(tempTree.getLeftTree().isEmpty()){
                        tempTree.setLeftTree(new BinaryTree<Zeichen>(new Zeichen('#')));
                    }
                    tempTree = tempTree.getLeftTree();
                }else if(c == '1'){
                    if(tempTree.getRightTree().isEmpty()){
                        tempTree.setRightTree(new BinaryTree<Zeichen>(new Zeichen('#')));
                    }
                    tempTree = tempTree.getRightTree();
                }
            }
            tempTree.setContent(new Zeichen(buchstabe));
        }
        return huffmantree;
    }
}
