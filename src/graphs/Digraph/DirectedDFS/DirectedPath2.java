package graphs.Digraph.DirectedDFS;

import graphs.Digraph.Digraph2;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DirectedPath2 { // is there path from s to v, if so print it

    boolean marked[];
    int paths[];
    int startV;
    public DirectedPath2(Digraph2 G, int s){
        marked = new boolean[G.V()];
        paths = new int[G.V()];
        startV = s;
        dfs(G,s);
    }

    private void dfs(Digraph2 G, int v){
        marked[v] = true;
        for (int w:G.adj(v)) {
            if(!marked[w]){
                paths[w] = v; // going to paths[w], it comes from v
                dfs(G,w);
            }
        }
    }

    public ArrayDeque<Integer> getPaths(int v){

        ArrayDeque<Integer> pathsArr = new ArrayDeque<>();

        for (int w = v; w != startV; w = paths[w]) {
            pathsArr.push(w);
        }

        return pathsArr;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\shortDG.txt";//PC middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);
        Digraph2 G = new Digraph2(in);
        int s = 4;
        DirectedPath2 paths = new DirectedPath2(G,s);
        System.out.println(s);

        for (int w :  paths.getPaths(3)) {
            System.out.println(w);
        }
    }

}
