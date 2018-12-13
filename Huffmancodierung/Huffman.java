/**
 * Beschreiben Sie hier die Klasse Huffman.
 * 
 * @author Lukas Reining
 * @version 1.1 vom 06.05.2017
 */
public class Huffman{
    //Instanzvariablen
    private List<BinaryTree<Zeichen>> huffmanliste;
    private BinaryTree<Zeichen> huffmantree;

    /**
     * Konstruktor für Objekte der Klasse Huffman
     */
    public Huffman(){
        huffmanliste = new List<BinaryTree<Zeichen>>();
        huffmantree = new BinaryTree<Zeichen>();
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
    private BinaryTree<Zeichen> erstelleBaum(List<BinaryTree<Zeichen>> wahrscheinlichkeiten){
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
     * Codiert einen mindestens 2 stelligen Text in Huffmancode und gibt diesen als String zurueck.
     * 
     * @param pText Der zu codierende Text.
     * @return Der codierte Text als String.
     */
    public String textCodieren(String pText){
        if(pText.length() > 1){
            String ergebniss = "";
            huffmanliste = haeufigkeit(pText);
            huffmanliste = sortiereHuffmanliste(huffmanliste);
            huffmantree = erstelleBaum(huffmanliste);
            for(int i = 0; i < pText.length(); i++){
                ergebniss += charCodieren(pText.charAt(i),huffmantree,"");
            }
            return ergebniss;
        }else{
            System.out.println("Text muss laenger als 2 Zeichen sein!");
            return null;
        }
    }

    /////////// Fuer Tests //////////////

    private void ausgabeHuffmanliste(){
        huffmanliste.toFirst();
        System.out.println("Wahrscheinlichkeitsliste:");
        while(huffmanliste.hasAccess()){
            Zeichen z = huffmanliste.getContent().getContent();
            System.out.println(z.getZeichen() + ": " + z.getAnzahl());
            huffmanliste.next();
        }
        System.out.println();
    }

    private void ausgabeHuffmantree(){
        besuche(huffmantree);
        System.out.println();
    }

    private void besuche(BinaryTree<Zeichen> tree){
        if(!tree.getLeftTree().isEmpty()){
            besuche(tree.getLeftTree());
        }
        if(!tree.getRightTree().isEmpty()){
            besuche(tree.getRightTree());
        }
        Zeichen z = tree.getContent();
        System.out.println("Node:" + z.getZeichen() + ": " + z.getAnzahl());
    }

    /**
     * Codiert einen Text in Huffmancode und gibt diesen mitsamt aller Schritte auf der Konsole aus.
     * 
     * @param pText Der zu codierende Text.
     */
    public void test(String pText){
        huffmanliste = haeufigkeit(pText); //36
        System.out.println("Unsortierte Huffmanliste:");
        ausgabeHuffmanliste();
        huffmanliste = sortiereHuffmanliste(huffmanliste);
        System.out.println("Sortierte Huffmanliste:");
        ausgabeHuffmanliste();
        huffmantree = erstelleBaum(huffmanliste);
        System.out.println("Huffmantree:");
        ausgabeHuffmantree();
        for(int i = 0; i < pText.length(); i++){
            char c = pText.charAt(i);
            System.out.println(c + ": " + charCodieren(c,huffmantree,""));
        }
        System.out.println();
        System.out.println(pText + ": " + textCodieren(pText));
    }
}
