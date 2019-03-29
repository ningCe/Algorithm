package com.jianzhiOffer;
/*
 * 来源：剑指offer
 * 题目：调整数组顺序，使得数组的奇数位于偶数前面，没有相对位置固定的要求 
 * 
 */
public class ReOrderArray {
	public void reOrderArray(int [] array) {
		if ((array.length==0)||(array==null))
			return;
		for (int i=0;i<array.length;i++) {
			if (((array[i]) & 1)==0) {
				int temp = array[i];
				for (int j=i+1;j<array.length;j++) {
					array[j-1] = array[j];
				}	
				array[array.length-1] = temp;
			}
		}
	}
	
	public void reOrderArray2(int [] array) {
		if ((array.length==0)||(array==null))
			return; 
		int p1 = 0;
		int p2 = array.length-1;
		while (p1<p2) {
			while ((p1<p2)&&((array[p1]&1)==1))
				p1++;
			while ((p2>p1)&&((array[p2]&1)==0))
				p2--;
			if (p1<p2) {
				int temp = array[p2];
				array[p2] = array[p1];
				array[p1] = temp;
			}
			
		}
	}
	public static void main(String[] args) {
		int [] test = new int[] {1,2,3,4,5,6,7,8,9,0};
		ReOrderArray Test = new ReOrderArray();
		Test.reOrderArray2(test);
		for (int i=0;i<test.length;i++)
			System.out.println(test[i]);
	}
}
