/**
 * Berechnet die Pruefziffer von Geldscheinen.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public final class GeldscheinPruefer
{
   /**
    * Gibt an ob die Pruefziffer eines Gelscheins korrekt ist.
    */
    public static final boolean pruefeGeldschein(String pruefziffer){
        //Druckereinummer
        String druckerei = pruefziffer.substring(0,2);
        String druckereiNum = new String();
        for(char c: druckerei.toCharArray()){
            int num = (int)c - (int)'A' + 1;
            druckereiNum += num;
        }
        pruefziffer = pruefziffer.replace(druckerei,druckereiNum);
        //Quersumme
        String ziffern = pruefziffer.substring(0,pruefziffer.length()-1);
        char[] zahlenAsChar = ziffern.toCharArray();
        int quersumme = 0;
        for(char c: ziffern.toCharArray()){
            quersumme += Character.getNumericValue(c);
        }
        //Checking
        int ergebnis = quersumme % 9;
        ergebnis = 7 - ergebnis;
        int last = Character.getNumericValue(pruefziffer.charAt(pruefziffer.length()-1));
        return ergebnis == last;
    }
}
