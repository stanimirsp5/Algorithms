package unionFind;

public class Main {

    public static void main(String[] args) {
        WeightedQuickUnion wqu = new WeightedQuickUnion();
       wqu.union(9,1);
       wqu.union(7,3);
       wqu.union(7,1);
       wqu.union(1,5);
       System.out.println(wqu.connected(9,5));
    }
//    public static void main(String[] args) {
//        unionFind.QuickUnion qu = new unionFind.QuickUnion();
//       qu.union(0,5);
//       qu.union(1,5);
//       qu.union(5,5);
//       qu.union(7,0);
//       qu.union(5,9);
//       qu.connected(9,8);
//    }
//    public static void main(String[] args) {
//        unionFind.QuickFind qf = new unionFind.QuickFind();
//        qf.union(0,5);
//        qf.union(1,5);
//        qf.find(5,5);
//    }
}
