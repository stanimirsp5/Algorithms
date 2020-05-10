package graphs.DFS;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;

public class DepthFirstPaths2 {
    private static boolean[] marked;
    private static int[] cameFrom;
    int startPoint;
    int count;

    public DepthFirstPaths2(Graph G, int startPoint){
        marked = new boolean[G.V()];
        cameFrom = new int[G.V()];
        this.startPoint = startPoint;

        dfs(G,startPoint);
    }
    private void dfs(Graph G,int v){
        marked[v] = true;
        count++;

        for (int w: G.adj(v)) {
            if(!marked[w]){
                cameFrom[w] = v;
                dfs(G,w);
            }
        }
    }

    public static boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int w){
        if(!hasPathTo(w)) return null;
        Deque<Integer> path = new ArrayDeque();
        for (int v = w; v != startPoint ; v = cameFrom[v]) {
            path.push(v);
        }
        path.push(startPoint);
        return path;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\verySmallG.txt";//PC //teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/verySmallG.txt";//Mac //tinyPathG,teenyWeenyG,tinyG,mediumG,verySmallG

        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        DepthFirstPaths2 dfs = new DepthFirstPaths2(G,s);

            if(G.V() == dfs.count){
                System.out.println("Connected");
            }else {
                System.out.println("NOT connected");
            }

         for(int i=0;i < G.V();i++){
             System.out.print(s + " to "+ i +": ");
             if(hasPathTo(i)){
                 for(int w: dfs.pathTo(i)){
                     if(w == s){
                         System.out.print(w);
                     }else {
                         System.out.print(" - "+w);
                     }
                 }
             }
             System.out.println();
        }

    }

}
