package graphs.Digraph.DirectedDFS;

import graphs.Digraph.Digraph;
import graphs.Digraph.Digraph2;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// BreadthFirstDirectedPaths
public class ShortestDP { // is there directed path from s to v, if so find a shortest path
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    int startV;
    public ShortestDP(Digraph2 G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        startV = s;
        bfs(G,s);
    }

    private void bfs(Digraph2 G,int v){
        marked[v]= true;
        Queue<Integer> breath = new ArrayDeque<Integer>();
        breath.add(v);
        while (breath.size() != 0){
            int num = breath.poll();

            for (int w: G.adj(num) ) {
                if(!marked[w]){
                    breath.add(w);
                    edgeTo[w] = num;
                }
            }
            marked[num]= true;

        }
    }

    public Deque<Integer> shortestPath(int v){

        Deque<Integer> paths = new LinkedList<>();
        paths.add(v);

        for (int i = v; i < startV ; i = edgeTo[v]) {
            paths.add(i);
        }

        return paths;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\middleDG.txt";//PC directedPath,middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);
        Digraph2 G = new Digraph2(in);
        int s = 1;
        int v = 0;
        ShortestDP path = new ShortestDP(G,s);

        for (int w: path.shortestPath(v) ) {

            System.out.println(w);

        }
    }
}
