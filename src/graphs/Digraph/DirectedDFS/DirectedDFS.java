package graphs.Digraph.DirectedDFS;

import graphs.Digraph.Digraph;
import graphs.Graph;
import graphs.In;
import simpleDS.Bag;

import java.io.FileNotFoundException;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int s: sources) {
            if (!marked(s)){
                dfs(G,s);
            }
        }
    }

    private void dfs(Digraph G,int v){
        marked[v] = true;
        for (int w : G.adj(v) ) {
            if (!marked(v)){
                dfs(G,w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\twoGraphsG.txt";//PC //teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG
        // String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/verySmallG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        // Digraph G = new Digraph(in);

        // javac scratches.java - compile code
        // java scratches -f file.txt pass arguments
        In in = new In(pathName);
        Digraph G = new Digraph(in);

        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i < args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }


        DirectedDFS reachable = new DirectedDFS(G,sources);
        for (int v = 0; v < G.V(); v++) {
            if(reachable.marked(v)){
                System.out.println(v + " ");
            }

        }
        System.out.println();


    }

}
