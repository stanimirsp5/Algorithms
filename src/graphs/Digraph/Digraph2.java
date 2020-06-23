package graphs.Digraph;

import graphs.In;
import simpleDS.Bag;

public class Digraph2 {

    // linked list
    //
    int V;
    int E;
    Bag<Integer>[] bag;

    public Digraph2(int V){
        this.V = V;
        this.E = 0;
        bag = new Bag[V];
        for (int v = 0; v < V; v++) {
            bag[v] = new Bag<Integer>();
        }
    }
    public Digraph2(In in){
//        V = in.readInt();
//        E = in.readInt();
        this(in.readInt()); // read V and construct this graph
        int E = in.readInt(); // TOCheck why comment not works
        for (int i = 0; i < E; i++) {
            addEdge(in.readInt(),in.readInt());
        }
    }
    private void addEdge(int v,int w){
        bag[v].add(w);
        E++;
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return bag[v];
    }

}
