package graphs.CC;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if(!marked[s]){
                dfs(G,-1,s);
            }
        }
    }

    public void dfs(Graph G, int u, int v){ // u - parent, vertex we are coming from
        marked[v] = true;
        for (int w: G.adj(v) ) {
            if(!marked[w]){
                dfs(G,v,w);
            }else if(w!=u){
                hasCycle = true;
            }
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        //String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/twoGraphsG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        Cycle c = new Cycle(G);
        System.out.println(c.hasCycle);
    }
}
