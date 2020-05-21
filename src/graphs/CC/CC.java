package graphs.CC;

import graphs.Graph;

public class CC {
    private boolean[] marked;
    private int[] id; // vertex-indexed array
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if(!marked[v]){
               dfs(G,w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

}
