package graphs.example;


import searching.RedBlackBST.StdOut;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "G:\\Documents\\Projects\\Algorithms\\src\\sources\\tinyG.txt";
        In in = new In(pathName);
       // in
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