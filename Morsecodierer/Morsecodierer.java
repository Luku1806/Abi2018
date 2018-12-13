/**
 * Die Klasse beinhaltet einen Morsebaum, um eine String zu codieren und Morsecodes zu decodieren.
 * 
 * @author Lukas Reining
 * @version 1.1 vom 28.03.2017
 */
public class Morsecodierer
{
    //Test Morsecode (Handballspiel) ..../.-/-./-../-.../.-/.-../.-../.../.--./.././.-.. 
    // Attribute
    private BinaryTree<Character> morsebaum;

    /**
     * Konstruktor für Objekte der Klasse Morsecodierer
     */
    public Morsecodierer()
    {
        morsebaum = createMorsebaum();
    }

    /**
     * Uebersetzt einen Reihe von Morsecodes in Normaltext.
     * Beispielkodierung des Wortes "Handballspiel": "..../.-/-./-../-.../.-/.-../.-../.../.--./.././.-.." .
     * Jeder Code besteht aus ein bis vier "." und/oder "-". 
     * Um das Ende der Kodierung der einzelnen Buchstaben zu markieren, dient "/" als Trennzeichen.
     * 
     * @param code Der zu uebersetzende Morsecode.
     * @return Die Uebersetzung des Morsecodes in Normaltext.
     */
    public String morsecodeIterativDecodieren(String code){
        BinaryTree<Character> tempTree = morsebaum;
        String decoded = "";
        for(int i = 0; i < code.length(); i++){
            if(tempTree != null){
                switch(code.charAt(i)){
                    case '.': 
                        tempTree = tempTree.getLeftTree();
                        break;
                    case '-': 
                        tempTree = tempTree.getRightTree();
                        break;  
                    case '/': 
                        if(!tempTree.isEmpty()){
                            decoded += tempTree.getContent(); 
                        }else{
                            decoded += '*';
                        }
                        tempTree = morsebaum;
                        break;
                }
            }else{
                decoded += '*';
                tempTree = morsebaum;
            }
        }
        //Wenn der Code nicht mit einem "/" abgeschlossen wurde, wird das letzte Zeichen hier hinzugefuegt
        if(!code.endsWith("/")){
            if(tempTree != null && !tempTree.isEmpty()){
                decoded += tempTree.getContent();
            }else{
                decoded += '*';
            }
        }
        return decoded;
    }

    /**
     * Erstellt einen Morsebaum, und gibt diesen zurueck.
     * 
     * @return Der Morsebaum.
     */
    public BinaryTree<Character> createMorsebaum(){
        //4.Ebene
        BinaryTree<Character> h = new BinaryTree<Character>('H');
        BinaryTree<Character> v = new BinaryTree<Character>('V');
        BinaryTree<Character> f = new BinaryTree<Character>('F');
        BinaryTree<Character> ue = new BinaryTree<Character>('\u00DC');
        BinaryTree<Character> l = new BinaryTree<Character>('L');
        BinaryTree<Character> ae = new BinaryTree<Character>('\u00C4');
        BinaryTree<Character> p = new BinaryTree<Character>('P');
        BinaryTree<Character> j = new BinaryTree<Character>('J');
        BinaryTree<Character> b = new BinaryTree<Character>('B');
        BinaryTree<Character> x = new BinaryTree<Character>('X');
        BinaryTree<Character> c = new BinaryTree<Character>('C');
        BinaryTree<Character> y = new BinaryTree<Character>('Y');
        BinaryTree<Character> q = new BinaryTree<Character>('Q');
        BinaryTree<Character> z = new BinaryTree<Character>('Z');
        BinaryTree<Character> oe = new BinaryTree<Character>('\u00D6');
        BinaryTree<Character> ch = null;
        //3.Ebene
        BinaryTree<Character> s = new BinaryTree<Character>('S',h,v);
        BinaryTree<Character> u = new BinaryTree<Character>('U',f,ue);
        BinaryTree<Character> r = new BinaryTree<Character>('R',l,ae);
        BinaryTree<Character> w = new BinaryTree<Character>('W',p,j);
        BinaryTree<Character> d = new BinaryTree<Character>('D',b,x);
        BinaryTree<Character> k = new BinaryTree<Character>('K',c,y);
        BinaryTree<Character> g = new BinaryTree<Character>('G',q,z);
        BinaryTree<Character> o = new BinaryTree<Character>('O',oe,ch);
        //2.Ebene
        BinaryTree<Character> i = new BinaryTree<Character>('I',s,u);
        BinaryTree<Character> a = new BinaryTree<Character>('A',r,w);
        BinaryTree<Character> n = new BinaryTree<Character>('N',d,k);
        BinaryTree<Character> m = new BinaryTree<Character>('M',g,o);
        //1.Ebene
        BinaryTree<Character> e = new BinaryTree<Character>('E',i,a);
        BinaryTree<Character> t = new BinaryTree<Character>('T',n,m);
        //Wurzel
        return new BinaryTree<Character>('*',e,t);
    }
}
