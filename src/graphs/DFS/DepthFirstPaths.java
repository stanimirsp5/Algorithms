// DepthFirstPaths not only determine whether there exists a path between two given vertices, but to find such a path if one exists
package graphs.DFS;

import graphs.Graph;
import graphs.In;
import searching.RedBlackBST.StdOut;

import java.io.FileNotFoundException;
import java.util.Iterator;
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
//        Stack<Integer> path = new Stack<Integer>();
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\tinyPathG.txt";//PC //teenyWeenyG,tinyG,mediumG,tinyPathG
        //String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/tinyPathG.txt";//Mac //teenyWeenyG,tinyG,mediumG

        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        DepthFirstPaths dfs = new DepthFirstPaths(G,s); // computes paths from s to each vertex connected to s
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if(dfs.hasPathTo(v)){ // iterate through the vertices on a path from s to any vertex connected to s
                Stack<Integer> path = (Stack<Integer>) dfs.pathTo(v);
                Iterator<Integer> iter = path.iterator();
                while (iter.hasNext()){
                    int num = iter.next();
                   // System.out.println(num);
                    if(num == s){
                        System.out.print(num);
                    }else{
                        System.out.print("-"+ num);
                    }
                }
//                for(int i = 0; i < path.size(); i++)
//                {
//                    if(path[i] == s){
//                        System.out.print(x);
//                    }else{
//                        System.out.print("-"+ x);
//                    }
//                }
//                for(int x : path){
//                    if(x == s){
//                        System.out.print(x);
//                    }else{
//                        System.out.print("-"+ x);
//                    }
//                }
            }
            System.out.println();
        }
    }

}
