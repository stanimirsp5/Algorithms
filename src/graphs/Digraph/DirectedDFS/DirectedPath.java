package graphs.Digraph.DirectedDFS;

import graphs.Digraph.Digraph2;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Stack;

public class DirectedPath { //  is there a directed path from s to v

    boolean[] marked;
    int[] edgeTo;
    int startV;

    public DirectedPath(Digraph2 G,int s){
        startV = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G,s);

    }

    private void dfs(Digraph2 G, int s){
        marked[s] = true;

        for (int w: G.adj(s)) {
            if(!marked[w]){
                edgeTo[w] = s;
                dfs(G,w);
            }
        }
    }

    public Iterable<Integer> findPath(int v){
        if(!hasPathTo(v)) return null;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        for (int x = v; x != startV; x = edgeTo[x] ) {
            path.push(x);
        }
        path.push(startV);
        return path;
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public static void main(String[] args) throws FileNotFoundException {

        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\middleDG.txt";//PC middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);

        Digraph2 G = new Digraph2(in);
        int s = 5;
        DirectedPath dfs = new DirectedPath(G,s);
        System.out.println();
        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                System.out.printf("%d to %d:  ", s, v);
                for (int x : dfs.findPath(v)) {
                    if (x == s) System.out.print(x);
                    else        System.out.print("-" + x);
                }
                System.out.println();
            }

            else {
                System.out.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }
}
