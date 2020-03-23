package graphs;

import graphs.example.Bag;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//import graphs.example.In;

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

    public Graph(In in) throws FileNotFoundException {
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
        adj[v].add(w); // Add w to v's list
        adj[w].add(v); // Add v to w's list
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
