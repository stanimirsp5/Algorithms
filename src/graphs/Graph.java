package graphs;
import searching.RedBlackBST.StdOut;
import simpleDS.Bag;
import java.io.FileNotFoundException;

public class Graph {
    private int V; // number of vertices
    private int E; // edges
    private Bag<Integer>[] adj; // adjacency lists

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists
        for (int v = 0; v < V; v++) { // Initialize all lists
            adj[v] = new Bag<Integer>(); // to empty
        }
    }

    public Graph(In in){
        this(in.readInt()); // read V and construct this graph
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt(); // Read vertex
            int w = in.readInt(); // Read another vertex
            addEdge(v,w); // add edge connecting them
        }
    }


    public int V(){return V;}
    public int E(){return E;}

    public void addEdge(int v, int w){
        // each edge appears twice in the data structure
        adj[v].add(w); // Add w to v's list
        adj[w].add(v); // Add v to w's list
        E++;
    }
    // return vertices adjacent to vertex v
   // public Iterable<Integer> adj(int v){
//        return adj[v];
//    }
    public Bag[] getList(){
        return adj;
    }

    public void printG(){
        for (int i = 0; i < adj.length; i++) {
            System.out.println("vertex " + i + " edges: " );
            adj[i].print();
        }

    }

//    public String toString(){
//        String s = V + " vertices, " + E + " edges\n";
//        for (int v = 0; v < V; v++) {
//            s += v + ": ";
//            for (int w : this.adj(v)) {
//                s += w + " ";
//            }
//            s += "\n";
//        }
//        return s;
//    }

//    public static void printG(Graph g){
//        for (int v = 0; v < g.V(); v++) {
//            for (int w: g.adj(v) ) {
//                StdOut.println(v + "-" + w);
//            }
//        }
//    }
}
