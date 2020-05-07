package graphs.DFS;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;

public class DepthFirstPaths2 {
    boolean[] marked;
    int[] cameFrom;
    int[] edgeTo;
    int count;

    public DepthFirstPaths2(Graph G, int startPoint){
        marked = new boolean[G.V()];
        cameFrom = new int[G.V()];
        dfs(G,startPoint);
    }
    private void dfs(Graph G,int v){
        marked[v] = true;
        count++;

        for (int w: G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
                edgeTo[w] = v;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\verySmallG.txt";//PC //teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
//        for (int i = 0; i < G.adj(s); i++) {
//
//        }
        DepthFirstPaths2 dfs = new DepthFirstPaths2(G,s);

//        for(boolean w : dfs.marked){
            if(G.V() == dfs.count){
                System.out.println("Connected");
            }else {
                System.out.println("NOT connected");
            }
//        }
    }

}
