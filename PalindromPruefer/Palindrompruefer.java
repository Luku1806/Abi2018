
/**
 * Der Palindrompruefer bietet Methoden um festzustellen, ob eine Zeichenkette ein Palindrom ist.
 * 
 * @author Lukas Reining 
 * @version 1.0
 */
public class Palindrompruefer
{

    /**
     * Constructor for objects of class Palindrompruefer
     */
    public Palindrompruefer(){
    }

    /**
     * Gibt auf der Konsole aus, ob eine String ein Palindrom ist.
     * 
     * @param pPalindrom Der Text der geprueft werden soll.
     */
    public void palindromPruefen(String pPalindrom){
        if(isPalindrom(pPalindrom)){
            System.out.println("'" + pPalindrom + "' ist ein Palindrom!");
        }else{
            System.out.println("'" + pPalindrom + "' ist kein Palindrom!");
        }
    }

    /**
     * Gibt zurueck ob eine String ein Palindrom ist.
     * Wenn die zu testende String Leerzeichen enthaelt, werden diese entfernt um auch Saetze die ein Palindrom bilden zu erkennen.
     * 
     * @param pText Die zu testende String.
     * 
     * @return True wenn der eingegebene Text ein Palindrom ist.
     */
    private boolean isPalindrom(String pText){
        Stack<Character> buchstabenStack = new Stack<Character>();
        // Die Leerzeichen werden entfernt, und alle restlichen Zeichen werden in ein char-Array uebertragen.
        char[] textAsArray = entferneWhitespace(pText).toCharArray();
        // Uebertragt alle Buchstaben in einen Stack.
        for(char buchstabe : textAsArray){
            buchstabenStack.push(buchstabe);
        }
        // Vergleicht die Werte des Array mit denen des Stacks um herauszufinden ob ein Palindrom vorliegt.
        for(char buchstabe : textAsArray){
            if(buchstabe != buchstabenStack.top()){
                // false wird zurueck gegeben, da eine Abweichung zwischen den Buchstaben vorliegt, und somit kein Palindrom vorhanden ist.
                return false;
            }
            buchstabenStack.pop();
        }
        // Wenn nicht vorzeitig false zurueck gegeben wurde liegt ein Palindrom vor, also wird true zurueckgegeben.
        return true;
    }

    /**
     * Gibt eine String zurueck, bei der alle Leerzeichen entfernt wurden.
     * 
     * @param pString Die String, bei der die Leerzeichen entfernt werden sollen.
     * 
     * @return Die eingegebene String ohne Leerzeichen.
     */
    private String entferneWhitespace(String pString){
        return pString.replaceAll("\\s+","");
    }
}
