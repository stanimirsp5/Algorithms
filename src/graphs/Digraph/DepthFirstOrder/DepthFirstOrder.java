package graphs.Digraph.DepthFirstOrder;

import graphs.Digraph.Digraph;
import graphs.Digraph.Digraph2;
import graphs.In;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstOrder {
    private boolean[] marked;

    private Queue<Integer> pre;         // vertices in preorder
    private Queue<Integer> post;        // vertices in postorder
    private Deque<Integer> reversePost; // vertices in reverse postorder

    public DepthFirstOrder(Digraph G){
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new LinkedList<>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        pre.add(v);

        for (int w: G.adj(v)) {

            if(!marked[w]){
                dfs(G,w);

            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> preorder(){
        return pre;
    }

    public Iterable<Integer> postorder(){
        return post;
    }

    public Iterable<Integer> reversePostorder(){
        return reversePost;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathName=  "C:\\Users\\stanimir.petrov\\Google Drive\\Algorithms\\Java\\src\\sources\\diG\\shortDG.txt";//PC tinyDG,directedPath,middleDG,shortDG//teenyWeenyG,tinyG,mediumG,tinyPathG,verySmallG,twoGraphsG
        In in = new In(pathName);
        Digraph G = new Digraph(in);

        DepthFirstOrder dfo = new DepthFirstOrder(G);

        for (int w:dfo.reversePostorder()) {
            System.out.println(w);
        }

    }

}
