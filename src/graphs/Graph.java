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
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public Bag[] getList(){
        return adj;
    }

    public static int degree(Graph G, int v){ // compute the degree of vertex
        int degree = 0;
        for (int w: G.adj(v-1) ){
          degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G){ // compute maximum degree
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G,v) > max){
                max = degree(G,v);
            }
        }
        return max;
    }

    public static double averageDegree(Graph G){
        return 2.0 * G.E() / G.V();
    }

     public int selfLoop(Graph G){ // 1-1 is a self loop
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w: G.adj(v)) {
                if(v == w) count++;
            }
        }
        return count/2; // each edge counted twice
     }

    public void printG(){
        for (int i = 0; i < adj.length; i++) {
            System.out.println("vertex " + i + " edges: " );
            adj[i].print();
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //teenyWeenyG,tinyG,mediumG
        In in = new In(pathName);
        Graph g = new Graph(in);
        //System.out.println("dg "+degree(g,g.V));
        //System.out.println("av dg "+averageDegree(g));
       // System.out.println("self loops  "+selfLoop(g));
      //  g.printG();
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