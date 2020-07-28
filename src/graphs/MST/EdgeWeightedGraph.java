package graphs.MST;

import graphs.example.In;
import simpleDS.Bag;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;        // number of vertices
    private int E;
    private Bag<Edge>[]adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(In in){

        if (in == null) throw new IllegalArgumentException("argument is null");

        try {
            V = in.readInt();
            adj = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Edge>();
            }

            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                double weight = in.readDouble();
                Edge e = new Edge(v, w, weight);
                addEdge(e);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in EdgeWeightedGraph constructor", e);
        }
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge>edges(){
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //teenyWeenyG,tinyG,mediumG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/diG/tinyEWG.txt";//Mac //tinyEWG,tinyPathG,twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        System.out.println(G);

    }

}
