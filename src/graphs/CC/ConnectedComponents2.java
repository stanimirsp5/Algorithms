package graphs.CC;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents2 {
    public boolean[] marked;
    public int[] pathTo;
    public int s;
    public int[] id;
    int idCounter = 0;

    public ConnectedComponents2(Graph G, int s){
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        this.s = s;
        id = new int[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if(!marked[i]) {
                dfs(G, i);
                idCounter++;
            }
        }
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = idCounter;

        for (int w: G.adj(v)) {
            if (!marked[w]){
                pathTo[w]= v;
                dfs(G,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Deque<Integer> getPathTo(int v){
        Deque paths = new ArrayDeque();
        if(!marked[v]) return null;
        for (int w = v; w != s ; w = pathTo[w]) {
            paths.push(w);
        }
        paths.push(s);
        return paths;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\twoGraphsG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/twoGraphsG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        ConnectedComponents2 cc = new ConnectedComponents2(G,s);

        int n = cc.idCounter;
        System.out.println(n+ " components");

        Queue<Integer>[] components = new Queue[n];
        for (int i = 0; i < n; i++) {
            components[i] = new LinkedList<>();
        }
        for (int i = 0; i < G.V(); i++) {
            components[cc.id[i]].add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int c: components[i]) {
                System.out.print(c +" ");
            }
            System.out.println();
        }
    }
}
