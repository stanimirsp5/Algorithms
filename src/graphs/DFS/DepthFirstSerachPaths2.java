package graphs.DFS;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;

public class DepthFirstSerachPaths2 {
    boolean[] marked;
    int count;

    public void findPaths(Graph G,int startVertex){
        marked= new boolean[G.V()];
        dfs(G,startVertex);
    }

    public void dfs(Graph G, int startVertex){
        marked[startVertex] = true;
        count++;
        for(int w: G.adj(startVertex)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/verySmallG.txt";//Mac //tinyPathG,teenyWeenyG,tinyG,mediumG,verySmallG

        In in = new In(pathName);
        Graph G = new Graph(in);

        DepthFirstSerachPaths2 serachPaths = new DepthFirstSerachPaths2();
        serachPaths.findPaths(G,1);
        if(serachPaths.count != G.V()) {
            System.out.println("not connected");
        }else {
            System.out.println(" connected biatch!");
        }
    }
}
