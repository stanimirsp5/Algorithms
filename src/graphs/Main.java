package graphs;

//import graphs.example.Graph;
//import graphs.example.In;

import graphs.draw.DrawGraph;
import graphs.draw.MainDraw;
import searching.RedBlackBST.StdOut;
import simpleDS.Bag;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import graphs.example.In;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";
        //List list = new ArrayList();

        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//PC
//        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/teenyWeenyG.txt";//Mac
//        In in = new In(pathName);
//        Graph g = new Graph(in);

        Graph2 g2 = new Graph2(5);
        //Graph2 g2 = new Graph2(5);
        g2.addEdge(4,1);
        g2.addEdge(4,3);
        g2.addEdge(2,0);
        g2.addEdge(1,0);
        //g2.printG();
        Bag[] bag = g2.getList();
        call(bag);
    }
    public static void call(Bag[] bag){
        MainDraw.main(bag);
    }
}



//        List<Integer> llist[] = new LinkedList[10];
//        llist[0] = new LinkedList<>();
//        llist[0].add(5);
//        llist[0].add(13);
//        llist[0].add(1);
//
//        for ( int i: llist[0]) {
//            System.out.println(i);
//        }