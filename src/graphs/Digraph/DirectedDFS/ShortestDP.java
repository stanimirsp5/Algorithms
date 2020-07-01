package graphs.Digraph.DirectedDFS;

import graphs.Digraph.Digraph2;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// BreadthFirstDirectedPaths
public class ShortestDP { // is there directed path from s to v, if so find a shortest path
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path

    public ShortestDP(Digraph2 G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        bfs(G,s);
    }

    private void bfs(Digraph2 G,int v){
        marked[v]= true;

        Queue<Integer> breath = new ArrayDeque<Integer>();
        breath.add(v);
        while (breath.size() != 0){
            int num = breath.poll();
            if(!marked[num]){



            }
        }

//        for (int w: G.adj(v)) {
//
//            if(!marked[w]){
//
//
//
//            }
//
//        }


    }











    public static void main(String[] args) throws FileNotFoundException {
//        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\directedPath.txt";//PC directedPath,middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
//        In in = new In(pathName);

    }
}
