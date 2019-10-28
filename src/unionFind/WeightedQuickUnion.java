package unionFind;

public class WeightedQuickUnion {

    int[] numArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int[] size = new int[numArr.length];
    private int count = numArr.length;

    void union(int index1, int index2) {
        int root1 = findRoot(index1);
        int root2 = findRoot(index2);
        if (root1 == root2) return;
//        numArr[root1] = root2;
        if (size[root1] < size[root2]) {
            numArr[root1] = root2;
            size[root2] += size[root1];
        }else{
            numArr[root2] = root1;
            size[root1] += size[root2];
        }
        count--;
    }

    int findRoot(int index) {
        while (numArr[index] != index) {
            index = numArr[index];
        }
        return index;
    }

    boolean connected(int index1, int index2) {
        return findRoot(index1) == findRoot(index2);
    }

    int count() {
        return count;
    }


}
