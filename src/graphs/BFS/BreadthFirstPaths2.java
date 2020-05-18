package graphs.BFS;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths2 {

    boolean [] marked;
    int[] pathTo;
    int s;
    public BreadthFirstPaths2 (Graph G, int s){
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    public void bfs(Graph G, int v){
        marked[v] = true;
        Queue<Integer> vertices = new LinkedList<>();
        vertices.add(v);
        while (vertices.size() > 0) {
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    vertices.add(w);
                    pathTo[w] = v;
                    marked[w] = true;
                }
            }
            v = vertices.poll();
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Deque<Integer> pathTo(Graph G, int v){
        if (!hasPathTo(v)) return null;
        Deque<Integer> paths = new LinkedList<>();
        for (int w = v; w != s; w = pathTo[w]) { // TODO diff between s and v
            paths.add(w);
        }
        paths.add(v);
        return paths;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\verySmallG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        BreadthFirstPaths2 bfp = new BreadthFirstPaths2(G,s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " : " +v);
            for (int w : bfp.pathTo(G, v)) {
                System.out.print(" - " +w);
            }
        }
        System.out.println();
    }
}
