package graphs.CC;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;

public class Cycle2 {
    public boolean[] marked;
    public boolean hasCycle = false;

    public Cycle2(Graph G){
        marked = new boolean[G.V()];

        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {

                dfs(G, s, -1);
            }
        }
    }

    public void dfs(Graph G,int v, int p){
        marked[v] = true;

        for (int w: G.adj(v)) {
            if (!marked[w]){
                dfs(G,w,v);
            }else if(p != w){
                hasCycle = true;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        //String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/twoGraphsG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        Cycle2 c = new Cycle2(G);
        System.out.println(c.hasCycle);
    }
}
