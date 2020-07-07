package graphs.Digraph.DirectedCycle;

import graphs.Digraph.Digraph;
import graphs.Digraph.Digraph2;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.Deque;

public class DirectedCycle2 {

    private boolean[] marked;
    private boolean[] onStack;
    private int[] pathTo;
    private Deque<Integer> cycle;

    public DirectedCycle2(Digraph2 G){
        pathTo = new int[G.V()];
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if(!marked[i]){
                dfs(G,i);
            }
        }
    }

    private Deque<Integer> dfs(Digraph2 G, int v){
        marked[v] = true;
        onStack[v] = true;

        for (int w : G.adj(v) ) {

            if(hasCycle()){
                return cycle;
            }else if(!marked[w]){
                pathTo[w] = v;
                dfs(G,w);
            }else if(onStack[w]){

                for (int i = v; i != w ; i = pathTo[w]) {
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(v);

            }


        }
        onStack[v] = false;
        return cycle;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\shortDG.txt";//PC tinyDG,directedPath,middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);
        Digraph G = new Digraph(in);

        DirectedCycle directedCycle = new DirectedCycle(G);

        //directedCycle.dfs(G,v);
        System.out.println("Has cycle ");

        if(!directedCycle.hasCycle()){
            System.out.println(directedCycle.hasCycle());
            return;
        }

        for (int w: directedCycle.cycle()) {
            System.out.println(w);
        }

        System.out.println(directedCycle.hasCycle());
    }

}
