package graphs.BFS;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.*;

public class BreadthFirstPaths {
    private boolean[] marked; // Is a shortest path to this vertex known?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G,int s){
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true; // Mark the source
        queue.add(s); // put it onto the queue
        while (!queue.isEmpty()){
            int v = queue.poll(); // remove next vertex from the queue
            for (int w : G.adj(v)) {
                if(!marked[w]){
                    edgeTo[w] = v; // save last edge of a shortest path
                    marked[w] = true; // mark it becaoue path is known
                    queue.add(w);// and add it to the queue
                }
            }

        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        Deque<Integer> path = new ArrayDeque<>();

        if(!hasPathTo(v)) return null;

            for (int w = v; w != s ; w = edgeTo[v]) {
                path.add(w);
            }
            path.add(s);


        return path;

    }
static int getResult(boolean... vars) {
    int count = 0;
    for (boolean var : vars) {
        count += (var ? 1 : 0);
    }
    return count;
}
    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\verySmallG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, s);

        int markedVertecies = getResult(bfp.marked);
        if (markedVertecies == G.V()) {
            System.out.println("CONNECTED");
        } else {
            System.out.println("Not connected");
        }
        for (int v = 0; v < G.V() ; v++) {
            System.out.print(s + " to " + v + ": ");
            if(bfp.hasPathTo(v)) {
                for (int path : bfp.pathTo(v)) {
                    if((path == s)) System.out.print(path);
                    else System.out.print( " - "+path);
                }
            }
            System.out.println();
        }
    }
}
