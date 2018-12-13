
/**
 * Ein Telefonbuch.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 17.05.2017
 */
public class Telefonbuch{

    //Attribute
    BinarySearchTree<TBEintrag> tTree;

    /**
     * Konstruktor für Objekte der Klasse Telefonbuch
     */
    public Telefonbuch()
    {
        tTree = new BinarySearchTree<TBEintrag>();
        testFill();
    }

    /**
     * Fuegt dem Telefonbuch einen Eintrag hinzu.
     * 
     * @param tbe Der einzufuegende Telefonbucheintag.
     */
    public void einfuegen(TBEintrag tbe){
        tTree.insert(tbe);
    }
    
    /**
     * Fuegt dem Telefonbuch einen Eintrag hinzu.
     * 
     * @param name Der zugehoerige Nachname des einzufuegenden Telefonbucheintag.
     * @param vorname Der zugehoerige Vorname des einzufuegenden Telefonbucheintag.
     * @param name Die zugehoerige Telefonnummer des einzufuegenden Telefonbucheintag.
     */
    public void einfuegen(String name,String vorname,String telefonnummer){
        einfuegen(new TBEintrag(name,vorname,telefonnummer));
    }
    
    public void suchen(String name, String vorname){
        TBEintrag e = tTree.search(new TBEintrag(name,vorname,""));
        if(e != null){
            System.out.println(e.getName() + "," + e.getVorname() + "   " + e.getTelefonnummer());
        }else{
            System.out.println("Der gewuenschte Eintrag ist nicht vorhanden!");
        }
    }
    
    /**
     * Gibt einen Eintrag aus dem Telefonbuch zurueck.
     * 
     * @param name Der zugehoerige Nachname des einzufuegenden Telefonbucheintag.
     * @param vorname Der zugehoerige Vorname des einzufuegenden Telefonbucheintag.
     * 
     * @return Der gefundene Telefonbucheintrag. Wenn nicht gefunden dann null.
     */
    public TBEintrag getEintrag(String name, String vorname){
        return tTree.search(new TBEintrag(name,vorname,""));
    }
    
    /**
     * Loescht einen Eintrag aus dem Telefonbuch.
     * 
     * @param name Der zugehoerige Nachname des zu loeschenden Telefonbucheintag.
     * @param vorname Der zugehoerige Vorname des zu loeschenden Telefonbucheintag.
     */
     public void entferne(String name, String vorname){
        tTree.remove(new TBEintrag(name,vorname,""));
    }
    
    /**
     * Gibt das Telefonbuch auf der Konsole aus.
     */
    public void ausgeben(){
        System.out.println("Telefonbuch:");
        ausgeben(tTree);
        System.out.println();
    }
     
    /**
     * Gibt das Telefonbuch auf der Konsole aus.
     * Diese wird aus dem Binaeren Suchbaum ausgelesen, mithilfe einer Inorder-Traversierung.
     */
    private void ausgeben(BinarySearchTree<TBEintrag> pTree){
        if(!pTree.getLeftTree().isEmpty()){
            ausgeben(pTree.getLeftTree());
        }
        TBEintrag e = pTree.getContent();
        System.out.println(e.getName() + "," + e.getVorname() + "   " + e.getTelefonnummer());
        if(!pTree.getRightTree().isEmpty()){
            ausgeben(pTree.getRightTree());
        }
    }
    
    ///// Fuer Tests /////
    private void testFill(){
        einfuegen("Hentschel","Stefan","01573/6666666");
        einfuegen("Hentschel","Jonas","01573/65896");
        einfuegen("Hentschel","Niels","01573/8764845");
        einfuegen("Ziegelhoefer","Justin","01573/666");
        einfuegen("Reining","Lukas","01573/633365");
        einfuegen("Herold","Sven","01573/96465896");
    }
    
}
