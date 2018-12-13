/**
 * Der DijkstraAlgorithmus 
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Dijkstra{

    private Graph staedteGraph;

    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    private List<DijkstraVertex> dijkstraVertexes;

    /**
     * Konstruktor für Objekte der Klasse Dijkstra
     */
    public Dijkstra(){
        this.staedteGraph = new StaedteGraph().getStaedteGraph();
        this.vertexes = staedteGraph.getVertices();
        this.edges = staedteGraph.getEdges();
    }

    private void init(Vertex source){
        this.dijkstraVertexes = new List<DijkstraVertex>();
        //Copy Vertices
        vertexes.toFirst();
        while(vertexes.hasAccess()){
            DijkstraVertex dv = (DijkstraVertex)vertexes.getContent();
            dv.setDistance(Integer.MAX_VALUE);
            if(source == dv) dv.setDistance(0);
            if(dijkstraVertexes.isEmpty()){
                dijkstraVertexes.insert(dv);
            }else{
                dijkstraVertexes.append(dv);
            }
            vertexes.next();
        }
    }

    public void execute(String startVertex){
        Vertex v = staedteGraph.getVertex(startVertex);
        if(v == null){
            System.out.println("Der Startknoten " + startVertex + " existiert nicht!");
        }
        System.out.println("Berechne den kuerzesten Weg von " + startVertex + " nach:");
        execute(v);
        printList();
    }

    public void execute(Vertex source) {
        init(source);
        DijkstraVertex dv = getMinimum(dijkstraVertexes);
        while(dv != null){
            dv.setMark(true);
            findMinDistances(dv);
            dv = getMinimum(dijkstraVertexes);
        }
    }

    private void findMinDistances(DijkstraVertex vertex){
        List<Vertex> neighbours = staedteGraph.getNeighbours(vertex);
        neighbours.toFirst();
        while(neighbours.hasAccess()){
            DijkstraVertex target = (DijkstraVertex) neighbours.getContent();
            if(target.getDistance() > (vertex.getDistance() + getDistance(vertex,target))){
                target.setDistance(vertex.getDistance() + getDistance(vertex,target));
                target.setMark(false);
            }
            neighbours.next();
        }
    }

    /**
     * Sucht das Kantengewicht zwischen zwei Knoten, also die Distanz zwischen diesen.
     */
    private double getDistance(DijkstraVertex source, DijkstraVertex target){
        edges.toFirst();
        while(edges.hasAccess()){
            Edge e = edges.getContent();
            DijkstraVertex start = (DijkstraVertex) e.getVertices()[0];
            DijkstraVertex end = (DijkstraVertex) e.getVertices()[1];
            if((source == start && target == end) || (source == end && target == start)){
                return e.getWeight();
            }    
            edges.next();
        }
        throw new RuntimeException("Kein Kantengewicht gefunden");
    }

    /**
     * Findet den unbesuchten Knoten mit der kleinsten Entfernung zum Startknoten.
     */
    private DijkstraVertex getMinimum(List<DijkstraVertex> vertexes){
        DijkstraVertex smallest = null;
        vertexes.toFirst();
        while(vertexes.hasAccess()){
            DijkstraVertex current = vertexes.getContent();
            if(!current.isMarked()){
                if(smallest == null){
                    smallest = vertexes.getContent();
                }else if(current.getDistance() < smallest.getDistance()){
                    smallest = current;
                }
            }
            vertexes.next();
        }
        return smallest;
    }

    public void printList(){
        dijkstraVertexes.toFirst();
        while(dijkstraVertexes.hasAccess()){
            DijkstraVertex dv = dijkstraVertexes.getContent();
            System.out.println(dv.getID() + ": " + dv.getDistance());
            dijkstraVertexes.next();
        }
    }
}

