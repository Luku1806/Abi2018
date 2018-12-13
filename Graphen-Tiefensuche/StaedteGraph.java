
/**
 * Beschreiben Sie hier die Klasse Staedtegraph.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class StaedteGraph{

    private final String[] staedteNamen = {"Muenster","Y","X","3","Duelmen","Haltern","Luedinghausen","79","80","Werne","Luenen","Kamen","Hamm"};
    private Graph sGraph;

    /**
     * Konstruktor für Objekte der Klasse Dijkstra
     */
    public StaedteGraph(){
        create();
    }

    private void create(){
        sGraph = new Graph();
        //Create Vertices and addd them to the graph
        for(String name: staedteNamen){
            sGraph.addVertex(new Vertex(name));
        }
        //Create Edges
        //From Muenster
        sGraph.addEdge(new Edge(sGraph.getVertex("Muenster"), sGraph.getVertex("Y"),13));
        sGraph.addEdge(new Edge(sGraph.getVertex("Muenster"), sGraph.getVertex("X"),8));
        sGraph.addEdge(new Edge(sGraph.getVertex("Muenster"), sGraph.getVertex("Werne"),37));
        sGraph.addEdge(new Edge(sGraph.getVertex("Muenster"), sGraph.getVertex("79"),24));
        sGraph.addEdge(new Edge(sGraph.getVertex("Muenster"), sGraph.getVertex("Hamm"),40));
        //From Y
        sGraph.addEdge(new Edge(sGraph.getVertex("Y"), sGraph.getVertex("Duelmen"),31));
        sGraph.addEdge(new Edge(sGraph.getVertex("Y"), sGraph.getVertex("3"),1));
        //From x
        sGraph.addEdge(new Edge(sGraph.getVertex("X"), sGraph.getVertex("3"),4));
        sGraph.addEdge(new Edge(sGraph.getVertex("X"), sGraph.getVertex("79"),15));
        //From 3
        sGraph.addEdge(new Edge(sGraph.getVertex("3"), sGraph.getVertex("Luedinghausen"),16));
        //From Duelmen
        sGraph.addEdge(new Edge(sGraph.getVertex("Duelmen"), sGraph.getVertex("Haltern"),12));
        //From Haltern
        sGraph.addEdge(new Edge(sGraph.getVertex("Haltern"), sGraph.getVertex("Luedinghausen"),20));
        //From Luedinghausen
        sGraph.addEdge(new Edge(sGraph.getVertex("Luedinghausen"), sGraph.getVertex("Luenen"),21));
        //From 79
        sGraph.addEdge(new Edge(sGraph.getVertex("79"), sGraph.getVertex("Luedinghausen"),15));
        sGraph.addEdge(new Edge(sGraph.getVertex("79"), sGraph.getVertex("80"),11));
        sGraph.addEdge(new Edge(sGraph.getVertex("79"), sGraph.getVertex("Hamm"),24));
        //From 80
        sGraph.addEdge(new Edge(sGraph.getVertex("80"), sGraph.getVertex("Werne"),5));
        //From Werne
        sGraph.addEdge(new Edge(sGraph.getVertex("Werne"), sGraph.getVertex("Luenen"),10));
        //From Luenen
        sGraph.addEdge(new Edge(sGraph.getVertex("Luenen"), sGraph.getVertex("Kamen"),10));
        //From Hamm
        sGraph.addEdge(new Edge(sGraph.getVertex("Hamm"), sGraph.getVertex("Luenen"),24));
        sGraph.addEdge(new Edge(sGraph.getVertex("Hamm"), sGraph.getVertex("Kamen"),17));
    }

    /**
     * Gibt den Staedtegraphen zurueck.
     * 
     * @return Der StaedteGraph.
     */
    public Graph getStaedteGraph(){
        return this.sGraph;
    }
}
