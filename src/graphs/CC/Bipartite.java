package graphs.CC;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
// bipartite is graph whose vertices can be divided into two disjoint and independent sets
// vertices in first set aren't connected between each other, but only with the vertices in second set
public class Bipartite {
    private boolean[] marked;
    private boolean[] color;
    private boolean isBipartite = true;

    public Bipartite(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfs(G,s);
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;

        for (int w: G.adj(v)) {
            if(!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            }else if(color[w] == color[v]){
                isBipartite = false;
            }
        }
    }

    private boolean isBipartite(){
        return isBipartite;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\extraSources\\bipartiteG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        //String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/twoGraphsG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        Bipartite bipartite = new Bipartite(G);
        System.out.println(bipartite.isBipartite);
    }
}
