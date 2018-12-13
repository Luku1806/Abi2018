/**
 * Die Klasse beschreibt den Ahnenbaum von Dionysos.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 20.03.2017
 */
public class Ahnenbaum{
    //Attribute
    private BinaryTree<Person> root;
    
    /**
     * Konstruktor fuer Objekte der Klasse Ahnenbaum
     */
    public Ahnenbaum()
    {
        //linker Teilbaum Ebene 2
        BinaryTree<Person> kronos = new BinaryTree<Person>(new Person("Kronos"));
        BinaryTree<Person> rhea = new BinaryTree<Person>(new Person("Rhea"));
        //rechter Teilbaum Ebene 2
        BinaryTree<Person> kadmos = new BinaryTree<Person>(new Person("Koenig Kadmos"));
        BinaryTree<Person> harmonia = new BinaryTree<Person>(new Person("Harmonia"));
        //linker Teilbaum Ebene 1
        BinaryTree<Person> zeus = new BinaryTree<Person>(new Person("Zeus"),kronos,rhea);
        //rechter Teilbaum Ebene 1
        BinaryTree<Person> semele = new BinaryTree<Person>(new Person("Semele"),kadmos,harmonia);
        //Wurzel
        root = new BinaryTree<Person>(new Person("Dionysos"),zeus,semele);
    }
}
