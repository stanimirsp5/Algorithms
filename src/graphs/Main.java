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

        String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\teenyWeenyG.txt";//PC work
        //String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/tinyG.txt";//Mac //teenyWeenyG,tinyG,mediumG
        In in = new In(pathName);
        Graph g = new Graph(in);
        Bag[] bag = g.getList();
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