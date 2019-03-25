public class Solution {
    public void reOrderArray(int[] array) {
        int p = 0;
        int q = array.length-1;
        int [] test = new int[array.length];
        for (int i=0;i<array.length;i++)
            test[i] =array[i];
        for (int i=0;i<test.length;i++)
            if ((test[i]&1)!=0) {
                array[p] = test[i];
                p++;
            }
        for (int i=test.length-1;i>=0;i--)
            if ((test[i]&1)==0){
                array[q] = test[i];
                q--;
            }
        // array = test;
    }


    public static void main(String[] args){//也就是说，传递过去的数组，被更改了指向，是不会回过头来影响main里的array的，因此其实就是个副本
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,0};
        for (int i=0;i<array.length;i++)
            System.out.println(array[i]);
        Solution test = new Solution();
        test.reOrderArray(array);
        for (int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }
}