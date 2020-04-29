//depth-first search is a recursive method for systematically examining each of the vertices and edges in a graph
//determine whether there exists a path between two given vertices
// ** depth-first search is a recursive method for searching a connected graph **
package graphs.DFS;
import graphs.Graph;
import graphs.In;
import searching.RedBlackBST.StdOut;

import java.io.FileNotFoundException;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for(int w : G.adj(v)){
            StdOut.println(w);
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/verySmallG.txt";//Mac //tinyPathG,teenyWeenyG,tinyG,mediumG,verySmallG
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\verySmallG.txt";//PC work //tinyPathG,teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }
        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else                         StdOut.println("connected");
    }
}
