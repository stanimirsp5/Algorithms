package graphs;
import simpleDS.Bag;

import java.io.FileNotFoundException;

public class Graph3 {
    Bag[] adj;
    int V;
    int E;
    public Graph3(int V){
        adj = new Bag[V];
        this.V = V;
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag();
        }
    }
    public Graph3(In in){
        this(in.readInt());
        E = in.readInt();

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

    public void print(){
        for (int i = 0; i < V; i++) {
            System.out.println("V " + i);
            adj[i].print();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //teenyWeenyG,tinyG,mediumG
        In in = new In(pathName);
        Graph3 g = new Graph3(in);
//        Graph2 g2 = new Graph2(5);
//        g2.addEdge(4,1);
//        g2.addEdge(4,3);
//        g2.addEdge(2,0);
//        g2.addEdge(1,0);
        g.print();
    }
}
