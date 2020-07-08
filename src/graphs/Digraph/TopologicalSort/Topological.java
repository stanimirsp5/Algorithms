package graphs.Digraph.TopologicalSort;

import graphs.Digraph.DepthFirstOrder.DepthFirstOrder;
import graphs.Digraph.Digraph;
import graphs.Digraph.DirectedCycle.DirectedCycle;
import graphs.In;

import java.io.FileNotFoundException;

public class Topological {

    private Iterable<Integer> order;        // topological order

    public Topological(Digraph G){
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePostorder();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }
    public boolean hasOrder(){
        return order != null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\shortDG.txt";//PC tinyDG,directedPath,middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);
        Digraph G = new Digraph(in);
        Topological top = new Topological(G);
        if(top.order() == null) {
            System.out.println("Cycle fund. Not a DAG !!!");
            return;
        }
        for (int v: top.order()) {
            System.out.println(v);
        }

    }
}
