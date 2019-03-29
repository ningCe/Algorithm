package com.jianzhiOffer;
import java.util.List;

import com.suanfa.*;
/*
 * 来源：剑指Offer
 * 题目：在只遍历一次链表的前提下找到倒数第K个结点
 * 思路：遍历两遍比较好做，但是只遍历一遍应该需要用到两个指针。
 * 		注意三个问题：1.k=0;2.k>n;3.head==null
 */
public class KthNode {
	//遍历两遍的做法
	public ListNode FindKthToTail(ListNode head,int k) {
 		if (head==null) return null;
		if (k==0) return null;
		
		int count = 0;
		ListNode p = head;
		while(p!=null) {
			count++;
			p = p.next;
		}
		
		if (count<k) return null;
		
		ListNode q = head;
		int count1 = 1;
		while(count1<count-k+1) {
			q = q.next;
			count1++;
		}
		return q;
	}
	
	public ListNode FindKthToTail2(ListNode head,int k) {
 		if (head==null) return null;
		if (k==0) return null;
		
		ListNode p1 = head;
		ListNode p2 = head;
		
		for (int i=0;i<k-1;i++) {
			if (p1.next!=null) {
				p1 = p1.next;
			}
			else {
				return null;
			}
		}
		
		while (p1.next!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	public static void main(String[] args) {
		KthNode test = new KthNode();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = null;
		ListNode result = test.FindKthToTail2(p1, 1);
		System.out.println(result.val);
	}
}
