import java.math.BigInteger;

/**
 * Fuehrt einen StupidSort aus.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 19.06.2017
 */
public class StupidSorter
{

    /**
     * Konstruktor für Objekte der Klasse StupidSorter
     */
    public StupidSorter(){
    }

    public void test(int anzahl){
        int[] testwerte = new int[anzahl];
        for(int i = 0; i < testwerte.length; i++){
            testwerte[i] = (int) (Math.random()*100);
        }
        System.out.print("Sortieren von " + anzahl + " Zahlen: ");
        printIntArray(testwerte);
        long starttime = System.currentTimeMillis();
        printIntArray(stupidSort(testwerte));
        //Print out elapsed time
        long endtime = System.currentTimeMillis() - starttime;
        long millis = (endtime / 1000);
        long second = (endtime / 1000) % 60;
        long minute = (endtime / (1000 * 60)) % 60;
        long hour = (endtime / (1000 * 60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
        System.out.println(time);
        System.out.println();
    }

    public int[] stupidSort(int[] arr){
        BigInteger count = new BigInteger("0");
        while(!isSorted(arr)){
            int index1 = (int)(Math.random()*arr.length);
            int index2 = (int)(Math.random()*arr.length);
            while(index2 == index1){
                index2 = (int)(Math.random()*arr.length);
            }
            //Dreieckstausch
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
            count = count.add(BigInteger.ONE);
        }
        System.out.println("Anzahl der Vergleiche: " + count);
        return arr;
    }

    private boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    private void printIntArray(int[] arr){
        System.out.print("Array = {");
        for(int i : arr){
            System.out.print(i + ",");
        }       
        System.out.println("}");
    }
}
