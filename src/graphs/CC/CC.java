package graphs.CC;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class CC {
    private boolean[] marked;
    private int[] id; // vertex-indexed array
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if(!marked[w]){
               dfs(G,w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\twoGraphsG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/twoGraphsG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        int n = cc.count();
        System.out.println(n + " components");

        Queue<Integer>[] components;
        components = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            components[i] = new LinkedList<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < n; i++) {
            for (int v : components[i]) {
                System.out.print(v +" ");
            }
            System.out.println();
        }
    }

}
