package graphs.CC;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ConnectedComponents {
    public boolean[] marked;
    public int[] pathTo;
    public int s;

    public ConnectedComponents(Graph G, int s){
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        for (int w: G.adj(v)) {
            if (!marked[w]){
                marked[v] = true;
                pathTo[v]= w;
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
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\verySmallG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/verySmallG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        int s = 0;
        ConnectedComponents cc = new ConnectedComponents(G,s);

        for (int w = 0; w < G.V(); w++) {
            System.out.print("from " +s+ " to "+w+": ") ;
            for (int v: cc.getPathTo(w)) {
                if(v==s) System.out.print(v);
                else System.out.print("-"+v);
            }
            System.out.println();
        }
        
    }

}
