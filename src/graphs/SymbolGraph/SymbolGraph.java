package graphs.SymbolGraph;

import graphs.Graph;
import graphs.In;

import java.io.FileNotFoundException;

public class SymbolGraph {
    private ST<String,Integer> st; // String -> index
    private String[] keys; //index -> String
    private Graph G;

    public SymbolGraph(String stream, String sp) throws FileNotFoundException {
        st = new ST<String,Integer>();
        In in = new In(stream); // First pass

        while (in.hasNextLine()){                // builds the index
            String[] a = in.readInt().split(sp); // by reading strings
            for (int i = 0; i < a.length; i++) { // to associate each
                if(!st.contains(a[i]))           // distinct string
                    st.put(a[i], st.size());     // with index.
            }
        }
        keys = new String[st.size()];           // Inverted index
        for (String name: st.keys() ) {         // to get string keys
            keys[st.get(name)] = name;          // is an array.
        }

        G = new Graph(st.size());
        in = new In(stream);                    // Second pass
        while (in.hasNextLine())                // builds the graph
        {
            String[] a = in.readInt().split(sp);// by connecting the
            int v = st.get(a[0]);               // first vertex
            for (int i = 1; i < a.length; i++) {// on each line
                G.addEdge(v, st.get(a[i]));     // to all the others
            }
        }
    }

    public boolean contains(String s){
        return  st.contains(s);
    }
    public int indexOf(String s){
        return  st.get(s);
    }
    public String nameOf(int v){
        return  keys[v];
    }
    public Graph G(){
        return  G;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(filename,delim);

        Graph G = sg.graph();

        while (StdIn.hasNextLine()){
            String source = StdIn.readLine();
            for (int v: G.adj(sg.indexOf(source))) {
                System.out.println("    "+sg.nameOf(v));
            }
        }

    }

}
