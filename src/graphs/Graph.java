package graphs;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Graph {
    private final int V; // number of vertices
    private int E; // edges
    private Bag<Integer>[] adj; // adjacency lists

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists
        for (int v = 0; v < V; v++) { // Initialoze all lists
            adj[v] = new Bag<Integer>(); // to empty
        }
    }

    public Graph(DataInputStream in) throws FileNotFoundException {
        InputStream  is = new FileInputStream("c:\\test.txt");
        is.readI
        this(in.readInt()); // read V and construct this graph
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt(); // Read vertex
            int w = in.readInt(); // Read another vertex
            addEdge(v,w); // add edge connecting them
        }
    }
    private InputStream In(){

    }
    public int V(){return V;}
    public int E(){return E;}

    public void addEdge(int v, int w){
        adj[v].add(w); // Add w to v's list
        adj[w].add(v); // Add v to w's list
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
