
/**
 * Verschluesselt nach dem Prinzip der Cesar-Chiffre.
 * 
 * @author Lukas Reining
 * @version (eine Versionsnummer oder ein Datum)
 */
public final class CesarChiffre{

    /**
     * Verschluesselt einen Text nach dem Prinzip der Cesar-Chiffre.
     * 
     * @param pText Der zu verschluesselnde Text.
     * @return Der verschluesselte Text.
     */
    public static String verschluesseln(String pText){
        String chiffre = "";
        String upperCase = pText.toUpperCase();
        for(char c : upperCase.toCharArray()){
            chiffre += verschluesseln(c);
        }
        return chiffre;
    }

    /**
     * Entschluesselt einen nach dem Prinzip der Cesar-Chiffre verschluesselten Text.
     * 
     * @param pText Der zu entschluesselnde Text.
     * @return Der entschluesselte Text.
     */
    public static String entschluesseln(String pText){
        String klartext = "";
        String upperCase = pText.toUpperCase();
        for(char c : upperCase.toCharArray()){
            klartext += entschluesseln(c);
        }
        return klartext;
    }

    /**
     * Verschluesselt einen Buchstaben nach dem Prinzip der Cesar-Chiffre.
     * 
     * @param pBuchstabe Der zu verschluesselnde Buchstabe.
     * @return Der verschluesselte Buchstabe.
     */
    private static char verschluesseln(char pBuchstabe){
        if(Character.toString(pBuchstabe).matches("[A-Z]")){
            int ascii = (int) pBuchstabe;
            int chiffre = ascii += 3;
            if(chiffre > (int)'Z'){
                int uebertrag = chiffre - (int)'Z';
                chiffre = (int)'A' - 1 + uebertrag;
            }
            char c = (char)chiffre;
            return c;
        }else{
            return pBuchstabe;
        }
    }

    /**
     * Entschluesselt einennach dem Prinzip der Cesar-Chiffre verschluesselten Buchstaben.
     * 
     * @param pBuchstabe Der zu entschluesselnde Buchstabe.
     * @return Der entschluesselnde Buchstabe.
     */
    private static char entschluesseln(char pBuchstabe){
        if(Character.toString(pBuchstabe).matches("[A-Z]")){
            int ascii = (int) pBuchstabe;
            int klartext = ascii -= 3;
            if(klartext < (int)'A'){
                int uebertrag = (int)'A' - klartext;
                klartext = (int)'Z' + 1 - uebertrag;
            }
            char c = (char)klartext;
            return c;
        }else{
            return pBuchstabe;
        }
    }
}
