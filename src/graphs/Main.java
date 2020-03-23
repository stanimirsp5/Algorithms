package graphs;

//import graphs.example.Graph;
//import graphs.example.In;

import searching.RedBlackBST.StdOut;

import java.io.FileNotFoundException;
//import graphs.example.In;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "G:\\Documents\\Projects\\Algorithms\\src\\sources\\tinyG.txt";
        In in = new In(pathName);
        Graph g = new Graph(in);
//        StdOut.println(g);
        printG(g);
    }

    public static void printG(Graph g){
        for (int v = 0; v < g.V(); v++) {
            for (int w: g.adj(v) ) {
                StdOut.println(v + "-" + w);
            }
        }
    }

}