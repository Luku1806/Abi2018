
/**
 * Die Klasse beinhaltet meinen eigenen Stammbaum, bis hin zu meinen Urgro�aeeltern.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 21.03.2017
 */
public class LukasStammbaum
{
    //Attribute
    private BinaryTree<Person> meinStammbaum;

    /**
     * Konstruktor fuer Objekte der Klasse LukasStambaum
     */
    public LukasStammbaum(){
        meinStammbaum = createStammbaum();
    }

    /**
     * Erstell meinen Stammbaum und gibt diesen zurueck.
     * 
     * @return Mein Stammbaum.
     */
    private BinaryTree<Person> createStammbaum(){
        //Wuzel-linkerTeilbaum-linkerTeilbaum-Blätter
        BinaryTree<Person> klara = new BinaryTree<Person>(new Person("Bock","Klara",'w'));
        BinaryTree<Person> adolf = new BinaryTree<Person>(new Person("Bock","Adolf",'m'));
        //Wuzel-linkerTeilbaum-rechterTeilbaum-Blätter
        BinaryTree<Person> auguste = new BinaryTree<Person>(new Person("Meise","Auguste",'w'));
        BinaryTree<Person> wilhelmKarl = new BinaryTree<Person>(new Person("Meise","Wilhelm Karl",'m'));
        //Wuzel-rechterTeilbaum-linkerTeilbaum-Blätter
        BinaryTree<Person> regine = new BinaryTree<Person>(new Person("Rosendahl","Regine",'w'));
        BinaryTree<Person> wilhelmRos = new BinaryTree<Person>(new Person("Rosendahl","Wilhelm",'m'));
        //Wuzel-rechterTeilbaum-rechterTeilbaum-Blätter
        BinaryTree<Person> maria = new BinaryTree<Person>(new Person("Reining","Maria",'w'));
        BinaryTree<Person> ludwigR = new BinaryTree<Person>(new Person("Reining","Ludwig",'m'));
        //Wuzel-linkerTeilbaum-linkerTeilbaum
        BinaryTree<Person> anne = new BinaryTree<Person>(new Person("Meise","Anne",'w'),klara,adolf);
        //Wuzel-linkerTeilbaum-rechterTeilbaum
        BinaryTree<Person> willy = new BinaryTree<Person>(new Person("Meise","Willy Johannes",'m'),auguste,wilhelmKarl);
        //Wuzel-rechterTeilbaum-linkerTeilbaum
        BinaryTree<Person> marlies = new BinaryTree<Person>(new Person("Reining","Marlies",'w'),regine,wilhelmRos);
        //Wuzel-rechterTeilbaum-rechterTeilbaum
        BinaryTree<Person> ludwig = new BinaryTree<Person>(new Person("Reining","Ludwig",'m'),maria,ludwigR);
        //Wuzel-linkerTeilbaum
        BinaryTree<Person> bettina = new BinaryTree<Person>(new Person("Reining","Bettina",'w'),anne,willy);
        //Wuzel-rechterTeilbaum
        BinaryTree<Person> thomas = new BinaryTree<Person>(new Person("Reining","Thomas",'m'),marlies,ludwig);
        //Wurzel
        return new BinaryTree<Person>(new Person("Reining","Lukas",'m'),bettina,thomas);
    }

    /**
     * Ruft die Methode besuche mit dem klasseneigenene Stammbaum auf.
     */
    public void besuche(){
        besuche(meinStammbaum);
    }

    /**
     * Traversiert alle Knoten eines Baumes und gibt deren Inhalt auf der Konsole aus.
     * 
     * @param pBaum Der zu traversierende Baum.
     */
    private void besuche(BinaryTree<Person> pBaum){
        Person rootPers = pBaum.getContent();
        System.out.println(rootPers.getVorname() + " " + rootPers.getName());
        if(!pBaum.getLeftTree().isEmpty()){
            besuche(pBaum.getLeftTree());
        }
        if(!pBaum.getRightTree().isEmpty()){
            besuche(pBaum.getRightTree());
        }
    }
}
