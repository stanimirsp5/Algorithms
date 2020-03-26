package graphs;

import simpleDS.Bag;

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

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public void printG(){
        for (int i = 0; i < V; i++) {
            System.out.println("vertex " + i + " edge ");
            adj[i].print();
        }
    }

}
