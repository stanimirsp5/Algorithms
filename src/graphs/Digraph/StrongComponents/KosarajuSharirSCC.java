package graphs.Digraph.StrongComponents;

import graphs.Digraph.DepthFirstOrder.DepthFirstOrder;
import graphs.Digraph.Digraph;
import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;

public class KosarajuSharirSCC {

    private boolean[] marked;   // reached vertices
    private int[] id;           // component identifiers
    private int count;          // number of strong components

    private KosarajuSharirSCC(Digraph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int s: order.reversePostorder()) {
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int count(){
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/tinyPathG.txt";//Mac //tinyPathG,twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Digraph G = new Digraph(in);
//        KosarajuSharirSCC scc = new KosarajuSharirSCC(G);
//        for (int w: scc.stronglyConnected(1,6)) {
//            System.out.println(w);
//        }


    }
}
