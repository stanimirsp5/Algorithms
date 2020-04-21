// DepthFirstPaths not only determine whether there exists a path between two given vertices, but to find such a path if one exists
package graphs.DFS;

import graphs.Graph;
import graphs.In;
import searching.RedBlackBST.StdOut;

import java.io.FileNotFoundException;
import java.util.Stack;

public class DepthFirstPaths {

    private boolean[] marked; // Has dfs() been called for this vertex?
    private int[] edgeTo; // last vertex on known path to this vertex
    private int s; // source
    private int count; // number of vertices connected to s

    public DepthFirstPaths(Graph G, int s){ // find paths in G from source s
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public int count() { // returns the number of vertices connected to the source vertex
        return count;
    }
    public boolean hasPathTo(int v){ // is there a path from s to v?
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){ // path from s to v; null if no such path
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    public static void main(String[] args) throws FileNotFoundException {
//        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//PC //teenyWeenyG,tinyG,mediumG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/tinyPathG.txt";//Mac //teenyWeenyG,tinyG,mediumG

        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        DepthFirstPaths dfs = new DepthFirstPaths(G,s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if(dfs.hasPathTo(v)){
                for(int x : dfs.pathTo(v)){
                    if(x == s){
                        System.out.print(x);
                    }else{
                        System.out.print("-"+ x);
                    }
                }
            }
            System.out.println();
        }
    }

}
