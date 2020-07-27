package graphs.MST;

public class Edge implements Comparable<Edge>{
    private int v;      // one vertex
    private int w;      // the other vertex
    private double weight;    // edge weight

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){ // weight of this edge
        return weight;
    }

    public int either(){ // either of this edges vertices
        return v;
    }

    public int other(int vertex){ // the other vertex
        if(vertex == v){
            return w;
        }
        else if(vertex == w){
            return v;
        }
        else throw new IllegalArgumentException();
    }

    public int compareTo(Edge that){
        if(this.weight() < that.weight()){
            return -1;
        }else if(this.weight() > that.weight()){
            return +1;
        }else return 0;
    }

    public String toString(){
        return String.format("%d-%d %.5f", v, w, weight);
    }

}
