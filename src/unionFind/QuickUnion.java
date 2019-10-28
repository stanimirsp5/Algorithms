package unionFind;

public class QuickUnion {
    int[] nums = {0,1,2,3,4,5,6,7,8,9};
                //5,1,2,3,4,9,6,7,8,9
    private int root(int index){
        while (index != nums[index]){ // when they index == nums[index] this number is root, if they are not equal search root until find it
            index = nums[index]; // find the link which points to the next link
        }
        return index; // return the root
    }

    public void union(int firstNumIndex,int secondNumIndex) {
        int root1 = root(firstNumIndex);
        int root2 = root(secondNumIndex);
        nums[root1] = root2;
    }

    public void connected(int firstNumIndex,int secondNumIndex) {
        if(root(firstNumIndex) == root(secondNumIndex)){
            System.out.println("Connected");
        }else{
            System.out.println("Not connected");
        }
        //return root(firstNumIndex) == root(secondNumIndex);
    }
}

//public class unionFind.QuickUnion {
//    int[] nums= {0,1,2,3,4,5,6,7,8,9};
//
//    private int root(int index){
//        while (index != nums[index]){
//            index = nums[index];
//        }
//        return index;
//    }
//
//    public void union(int firstNumIndex,int secondNumIndex) {
//        int i = root(firstNumIndex);
//        int j = root(secondNumIndex);
//        nums[i] = j;
//    }
//
//    public void connected(int firstNumIndex,int secondNumIndex) {
//        if(root(firstNumIndex) == root(secondNumIndex)){
//            System.out.println("Connected");
//        }else{
//            System.out.println("Not connected");
//        }
//        //return root(firstNumIndex) == root(secondNumIndex);
//    }
//}