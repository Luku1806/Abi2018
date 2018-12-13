/**
 * Beschreiben Sie hier die Klasse ZahlenGenerator.
 * 
 * @author () 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.util.Random;

public class ZahlenGenerator
{
    int[] zahlen = new int[100];
    Random random = new Random();

    /**
     * Konstruktor für Objekte der Klasse ZahlenGenerator
     */
    public ZahlenGenerator()
    {
        erzeugeZahlen();
    }

	/**
	* Das Array wird auf die existenz von 20 Zufallswerten überprüft.
	* Für jede Zahl wird auf der Konsole ausgegeben ob sie im Array gefunden wurde.
	* Zuletzt wird ausgegeben wie viele der 20 zahlen gefunden wurden.
	*/
    public void randomSearch(){
		int treffer = 0;
		for(int i = 0; i < 20 ; i++){
			int gesuchterWert = random.nextInt(500);
			System.out.println("Suche " + gesuchterWert + " im Array");
			if(lineareSuche(zahlen , gesuchterWert)){
				System.out.println("Gefunden");
				treffer++;
			}else{
				System.out.println("NICHT gefunden");
			}
			System.out.println();
		}
		System.out.println(treffer + " von 20 Zahlen im Array gefunden");
    }

	/**
	* Durchsucht das gegebene Array auf den gegebenen Wert.
	*@param array Das zu durchsuchende Array
	*@param pSuch Der Wert auf den das Array geprüft werden soll
	*@return Gibt an ob der Wert gefunden wurde(true = gefunden)
	*/
    public boolean lineareSuche(int[] array , int pSuch){
        boolean gefunden = false;
        int zaehler = 0;
        while(!gefunden && zaehler < array.length){
            if(array[zaehler] == pSuch){
                gefunden = true;
            }
            zaehler++;
        }
        return gefunden;
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

	/**
	* Weist dem Array "Zahlen" einen zufälligen Wert zwischen 1 und 500 zu.
	*/
    public void erzeugeZahlen(){
        for(int i = 0; i < zahlen.length; i++){
            zahlen[i] = random.nextInt(500)+1;
        }
    }
}
