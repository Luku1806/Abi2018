
/**
 * Beschreiben Sie hier die Klasse Arrayhandler.
 * 
 * @author Lukas Reining  
 * @version 1.0 vom 30.04.2016
 */
import java.util.Random;
public class Arrayhelper
{
    int[] zahlen = new int[100];
    Random random = new Random();

    /**
     * Konstruktor für Objekte der Klasse Arrayhandler
     */
    public Arrayhelper()
    {
        demo();
    }
    
    /**
     * Führt eine Demonstration aller Methoden durch
     */
    public void demo(){
         erzeugeZahlen();
        zahlenausgabe(zahlen);
        System.out.println("Sortiere Zahlen");
        zahlenausgabe(zahlen);
        selectionSort(zahlen);
        System.out.println("Suche Zahl 26 im Array");
        if(binaereSuche(26 , zahlen)){
            System.out.println("Zahl 26 im Array gefunden");
        }else{
            System.out.println("Zahl 26 nicht im Array gefunden");
        }
    }

    /**
     * Führt eine binäre Suche durch.
     * @param pSuch Der Wert der gesucht werden soll
     */
    public boolean binaereSuche(int pSuch , int[] array){
        int links , rechts , mitte;
        links = 0;
        rechts = array.length - 1;
        while(links <= rechts){
            mitte =(links + rechts)/2;
            if(array[mitte] == pSuch){
                return true;
            }
            if(array[mitte] < pSuch){
                links = mitte++;
            }
            if(array[mitte] > pSuch){
                rechts = mitte--;
            }
        }
        return false;
    }
    
    /**
     * Der Selection-Sort Algorithmus nach Vorlage des Pseudocodes aus dem Buch
     * @param sortieren Das zu sortierende Array
     * @return Das sortierte Array
     */
    public int[] selectionSort(int[] sortieren){
        int links = 0;
        int n = sortieren.length;
        while(links < n){
            int min = links;
            for(int i= links + 1; i < sortieren.length; i++ ){
                if (sortieren[i] < sortieren[min]){
                    min = i;
                }
            }
            int temp = sortieren[min];
            sortieren[min] = sortieren[links];
            sortieren[links] = temp;
            links++;
        }
        return sortieren;
    }
    
    /**
	* Weist dem Array "Zahlen" einen zufälligen Wert zwischen 1 und 500 zu.
	*/
    public void erzeugeZahlen(){
        for(int i = 0; i < zahlen.length; i++){
            zahlen[i] = random.nextInt(500)+1;
        }
    }
    
    /**
	* Die Werte eines Arrays werden auf der Konsole ausgegeben.
	*@param array Das auszugebende Array
	*/
    public void zahlenausgabe(int[] array )
    {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}

