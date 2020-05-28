package graphs.CC;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CC3 {
    public boolean[] marked;
    public int[] id;
    public int count = 0;

    public CC3(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v) ) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String pathName = "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\twoGraphsG.txt";//Mac //twoGraphsG,teenyWeenyG,tinyG,mediumG,verySmallG
        String pathName = "/Users/stanimir/Projects/Algorithms/src/sources/twoGraphsG.txt";//Mac //teenyWeenyG,tinyG,mediumG,verySmallG
        In in = new In(pathName);
        Graph G = new Graph(in);
        CC3 cc = new CC3(G);

        System.out.println(cc.count + " components");
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 0; i < cc.count; i++) {
            List<Integer> rowComponents = new ArrayList<>();
            int j = 0;
            for (int v: cc.id) {
                if(v == i){
                    rowComponents.add(j);
                }
                j++;
            }
            components.add(i, rowComponents);
        }

        for (List<Integer> rowComponents: components) {
            for (int v:rowComponents) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }
}
