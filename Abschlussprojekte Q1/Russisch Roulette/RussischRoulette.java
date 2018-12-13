/**
 * Eine Simulation eines Russisch Roulette Spiels.
 * 
 * @author Lukas Reining 
 * @version 1.0
 */
public class RussischRoulette
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String[] testPlayers = {"Jonas","Sven","Mark","Lukas"};
    private Queue<Spieler> spieler;

    /**
     * Konstruktor für Objekte der Klasse RussischRoulette
     */
    public RussischRoulette(){
        spieler = new Queue<Spieler>();
    }

    public void schießen(){
        if(!spieler.isEmpty()){
            Spieler current = spieler.front();
            spieler.dequeue();
            if(spieler.isEmpty()){
                System.out.println(current.getName() + " hat gewonnen");
            }else if(Math.random() > 1/6){
                spieler.enqueue(current);
                System.out.println(current.getName() + " hat \u00fcberlebt");
            }else{
                System.out.println(current.getName() + " ist gestorben");
            }
        }
    }

    public void spielerHinzufuegen(String name){
        spieler.enqueue(new Spieler(name));
    }

    public void addtestPlayers(){
        for(String name : testPlayers){
            spielerHinzufuegen(name);
        }
    }
}
