package graphs.Digraph.DirectedDFS;

import graphs.Digraph.Digraph;
import graphs.Graph;
import graphs.In;
import simpleDS.Bag;

import java.io.FileNotFoundException;
// Test which vertices are reachable from a given vertex or a given set of vertices
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
            if (!marked(w)){
                dfs(G,w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\shortDG.txt";//PC //teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        // String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/verySmallG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        // Digraph G = new Digraph(in);

        // javac scratches.java - compile code
        // java scratches -f file.txt pass arguments
        In in = new In(pathName);
        Digraph G = new Digraph(in);
        //G.print();
        Bag<Integer> sources = new Bag<Integer>();
//        while(true){
//            System.out.println(in.readInt());
//            if(in.readInt() == 5){
//                break;
//            }
//            sources.add(in.readInt());
//
//        }
        In in2 = new In(pathName);
        in2.readInt();
        in2.readInt();
        for (int i = 1; i < 5; i++) {
//            System.out.println(in2.readInt());
            sources.add(in2.readInt());
//            sources.add(in.readInt());
        }
//
//
//        DirectedDFS reachable = new DirectedDFS(G,sources); //is there a directed path from any vertex in the set to v
        int s = 3;
        DirectedDFS reachable = new DirectedDFS(G,s); //  is there a directed path from s to v
        for (int v = 0; v < G.V(); v++) {
            //if(s == v) continue;
            if(reachable.marked(v)){
                System.out.println(v + " ");
            }

        }
        System.out.println();
    }
}
