package graphs;

import graphs.draw.DrawGraph;
import simpleDS.Bag;

import java.io.FileNotFoundException;

public class Graph2 {
    private int V;
    private int E;
    private Bag[] adj;

    public Graph2(int v){
        V = v;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag();
        }
    }

    public Graph2(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Bag[] getList(){
        return adj;
    }

    public void printG(){
        for (int i = 0; i < V; i++) {
            System.out.println("vertex " + i + " edge ");
            adj[i].print();
        }
    }
    // return vertices adjacent to vertex v
    public Iterable<Integer> adj(int v){
        return adj[v];
    }


    public static int degree(Graph2 G, int v){ // compute the degree of vertex
        int degree = 0;
        for (int w: G.adj(v) ){
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph2 G){ // compute the degree of vertex
//        int currDegree = 0;
        int degree=0, currDegree = 0;
        for (int i = 0; i < G.V-1 ; i++) {
            for(int w : G.adj(i)){
                currDegree++;
            }
            degree = degree > currDegree ? degree : currDegree;
            currDegree=0;
        }

        return degree;
    }


    public static int selfLoop(Graph2 G){
      int count = 0;
        for (int v = 0; v < G.V; v++) {
            for (int w : G.adj(v)) {
                if(v == w) count++;
            }
        }
        return count/2;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //teenyWeenyG,tinyG,mediumG
        In in = new In(pathName);
        Graph2 g = new Graph2(in);
//        Graph2 g2 = new Graph2(5);
//        g2.addEdge(4,1);
//        g2.addEdge(4,3);
//        g2.addEdge(2,0);
//        g2.addEdge(1,0);
        g.printG();
//        System.out.println("dg "+degree(g,0));
//        System.out.println("dg "+maxDegree(g));
        System.out.println("self loops  "+selfLoop(g));

    }
}
