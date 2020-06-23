package graphs.Digraph.DirectedDFS;

import graphs.Digraph.Digraph2;
import graphs.In;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DirectedDFS2 {

    boolean marked[];


    public DirectedDFS2(Digraph2 G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDFS2(Digraph2 G, ArrayList<Integer> sources){
        for (int i = 0; i < sources.size(); i++) {
            if(!marked[i]){
                dfs(G,sources.get(i));
            }
        }
    }

        private void dfs(Digraph2 G, int v){
        marked[v] = true;

        for (int w: G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\shortDG.txt";//PC //teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);

        Digraph2 G = new Digraph2(in);

        int s = 1;

        DirectedDFS2 reachable = new DirectedDFS2(G,s);

        for (int i = 0; i < G.V(); i++) {

            if(reachable.marked(i)){
                System.out.println(i);
            }

        }

    }

}
