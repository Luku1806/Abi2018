/**
 * Write a description of class SuchAlgorithmen here.
 *
 * @author Lukas Reining
 * @version 1.0
 */
public class SuchAlgorithmen{
    // instance variables - replace the example below with your own
    private Graph graph;
    private List<Edge> edges;
    private List<Vertex> vertices;

    /**
     * Constructor for objects of class SuchAlgorithmen
     */
    public SuchAlgorithmen(){
        graph = new StaedteGraph().getStaedteGraph();
        edges = graph.getEdges();
        vertices = graph.getVertices();
    }
    
    public void tiefensuche(String startStadt){
        Vertex v = graph.getVertex(startStadt);
        if(v == null){
            System.out.println("Die Stadt " + startStadt + " gibt es nicht im Graphen");
            return;
        }
        graph.setAllVertexMarks(false);
        tiefensuche(v);
        System.out.println();
    }

    private void tiefensuche(Vertex v){
        System.out.println(v.getID());
        v.setMark(true);
        List<Vertex> neighbors = graph.getNeighbours(v);
        neighbors.toFirst();
        while(neighbors.hasAccess()){
            Vertex current = neighbors.getContent();
            if(!current.isMarked()){
                tiefensuche(current);
            } 
            neighbors.next();
        }
    }

      public void breitensuche(String startStadt){
        Vertex v = graph.getVertex(startStadt);
        if(v == null){
            System.out.println("Die Stadt " + startStadt + " gibt es nicht im Graphen");
            return;
        }
        breitensuche(v);
        System.out.println();
    }
    
    private void breitensuche(Vertex v){
        graph.setAllVertexMarks(false);
        Queue<Vertex> queue = new Queue<Vertex>();
        queue.enqueue(v);
        v.setMark(true);  
        System.out.println(v.getID());
        while(!queue.isEmpty()){
            List<Vertex> neighbors = graph.getNeighbours(queue.front());
            queue.dequeue();
            neighbors.toFirst();
            while(neighbors.hasAccess()){
                Vertex current = neighbors.getContent();
                if(!current.isMarked()){
                    current.setMark(true);
                    queue.enqueue(current);
                    System.out.println(current.getID());
                } 
                neighbors.next();
            }
        }
    }
}
