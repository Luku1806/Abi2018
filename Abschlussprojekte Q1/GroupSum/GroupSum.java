
/**
 * Stellt eine Methode zur Ueberpruefung ob eine Menge Zahlen, eine Teilmenge enthaelt, die in der Summe eine bestimmte Zahl abbildet.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public final class GroupSum{

    /**
     * Gibt zurueck ob eine Menge an Zahlen, eine Teilmenge enthaelt, die in der Summe eine gegebene Zahl ergibt.
     * 
     * @param menge Die zu ueberpruefende Menge an Zahlen.
     * @param n Die Anzahl an Zahlen.
     * @param sum Die gesuchte Menge.
     */
    public static final boolean groupSum(int[] menge, int n, int sum){
        if(sum == 0){
            return true;
        }else if(n == 0){
            return false;
        } 
        if (menge[n-1] > sum){
            return groupSum(menge, n-1, sum);
        }
        return groupSum(menge, n-1, sum) || groupSum(menge, n-1, sum-menge[n-1]);
    }
    
    public static final void test(){
        int summe = 7;
        int[] zahlen = {1,5,6};
        System.out.print("Ueberpruefe Zahlen: ");
        for(int i: zahlen){
            System.out.print(i + " ");
        }
        System.out.println();
        if(groupSum(zahlen,zahlen.length, summe)){
            System.out.print("Teilenge mit der Summe " + summe + " gefunden\n");
        }else{
             System.out.print("Keine Teilenge mit der Summe " + summe + " gefunden\n");
        }
    }
}
