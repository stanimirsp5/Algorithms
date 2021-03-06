package graphs.Digraph.DirectedCycle;

import graphs.Digraph.Digraph;
import graphs.Digraph.Digraph2;
import graphs.Digraph.DirectedDFS.ShortestDP;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Deque<Integer> cycle;   // vertices on a cycle (if one exists)
    private boolean[] onStack;      // vertices on function-call stack

    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {


            if(!marked[v]){
                dfs(G,v);

            }
        }
    }

    private void dfs(Digraph G, int v){
        onStack[v] = true;
        marked[v] = true;
        for (int w: G.adj(v)) {
            if(this.hasCycle()){
                return;
            }
            else if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }else if(onStack[w]){
                cycle = new LinkedList<>();
                for (int x = v; x != w ; x = edgeTo[x]) {
                    cycle.push(x);
                }

                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\tinyDG.txt";//PC tinyDG,directedPath,middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);
        Digraph G = new Digraph(in);
        int s = 1;
        int v = 1;
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
