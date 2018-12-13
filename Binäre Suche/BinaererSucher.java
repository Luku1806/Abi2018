/**
 * Beschreiben Sie hier die Klasse BinaererSucher.
 * 
 * @author Lukas Reining 
 * @version 1.0 vom 22.02.2017
 */
public class BinaererSucher
{
    private int[] testArray = {1,3,4,5,6,7,10,11};

    /**
     * Konstruktor für Objekte der Klasse BinaererSucher
     */
    public BinaererSucher(){
        for(int i=0; i < 10; i++){
            System.out.println(Math.log(i)/Math.log(2));
        }
    }

    public boolean testSucheRek(int i){
        return binaereSuche_rekursiv(testArray,0,testArray.length-1,i);
    }

    /**
     * Führt eine binaere Suche auf iterative Weise durch.
     * 
     * @param pSuch Der zu suchende Wert.
     * @param a Das zu durchsuchende Array.
     * 
     * @return True wenn gefunden.
     */
    public boolean binaereSuche_iterativ(int i , int[] a){
        int links, rechts, mitte;
        links = 0;
        rechts = a.length - 1;
        while(links <= rechts){
            mitte = (links + rechts)/2;
            if(a[mitte] == i){
                return true;
            }
            if(a[mitte] < i){
                links = mitte++;
            }
            if(a[mitte] > i){
                rechts = mitte--;
            }
        }
        return false;
    }

    /**
     * Führt eine binaere Suche auf rekursive Weise durch.
     * 
     * @param pSuch Der zu suchende Wert.
     * @param a Das zu durchsuchende Array.
     * 
     * @return True wenn gefunden.
     */
    public boolean binaereSuche_rekursiv(int[] a,int links, int rechts, int i){
        if(links > rechts){
            return false;
        }
        int mitte = (links+rechts)/2;
        if(a[mitte] == i){
            return true;
        }else if(i < a[mitte]){
            return binaereSuche_rekursiv(a, links, mitte-1, i);
        }else{
            return binaereSuche_rekursiv(a, mitte+1, rechts, i);
        }
    }
}
