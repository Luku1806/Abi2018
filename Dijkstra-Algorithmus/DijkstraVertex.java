/**
 * Beschreiben Sie hier die Klasse DijkstraVertex.
 * 
 * @author Lukas Reining
 * @version 1.0 vom 20.02.2018
 */
public class DijkstraVertex extends Vertex{

    private double distance;
    private Vertex vorgaenger;

    /**
     * Konstruktor für Objekte der Klasse DijkstraVertex
     */
    public DijkstraVertex(String iD){
        super(iD);
        this.distance = Double.MAX_VALUE;
    }

    /**
     * Konstruktor für Objekte der Klasse DijkstraVertex
     */
    public DijkstraVertex(Vertex vertex){
        super(vertex.getID());
        this.distance = Integer.MAX_VALUE;
    }

    /**
     * Konstruktor für Objekte der Klasse DijkstraVertex
     */
    public DijkstraVertex(Vertex vertex, double distance){
        super(vertex.getID());
        this.distance = distance;
    }

    public double getDistance(){
        return this.distance;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    public Vertex getVorgaenger(){
        return this.vorgaenger;
    }

    public void setVorgaenger(Vertex vorgaenger){
        this.vorgaenger = vorgaenger;
    }
}
