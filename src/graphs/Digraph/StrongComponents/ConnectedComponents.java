package graphs.Digraph.StrongComponents;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;

public class ConnectedComponents {

    boolean[] marked;
    int[] ids;
    int currentV = 0;
    public ConnectedComponents(Graph G){
        marked = new boolean[G.V()];
        ids = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {

            if(!marked[v]){
                dfs(G,v);
                currentV++;
            }
        }

    }

    public void dfs(Graph G, int v){
        marked[v] = true;

        for (int w: G.adj(v)) {
            ids[w] = currentV;

            if(!marked[w]){
                dfs(G,w);
            }
        }

    }

    public int[] getConnected(){
        return ids;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/tinyPathG.txt";//Mac //tinyPathG,twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        ConnectedComponents scc = new ConnectedComponents(G);
        for (int w: scc.getConnected()) {
            System.out.println(w);
        }


    }
}
