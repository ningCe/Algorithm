package com.jianzhiOffer;
/*
 * 来源：剑指offer
 * 题目：正则表达式匹配
 *      .表示任意字符都可以,*表示在*之前的字符可以出现任意次（含0次）
 *      字符串完全匹配模式
 * 解题思路：逐字匹配，两种情况:
 *     模式的第二个字符不是*，那么只要逐个进行匹配，.处任何字符都可以通过;
 *     第二个字符是*，那么有两种选择：
 *         一是在模式上向后移动两个字符，直接略过；
 *         二是如果模式中的第一个字符与字符串相匹配，则在字符串上向后移动一个字符，与此同时，模式上有两种选择:
 *             可以在模式上向后移动两个字符;
 *             也可以保持模式不变.
 *   用递归实现以上的思路
 * 
 */
public class Match {
	public boolean match(char[] str,char[] pattern) {
		int indexStr = 0;
		int indexPat = 0;
		boolean result = false;
		while ((indexStr<str.length)&&(indexPat<pattern.length)) {
			if (!isStarBehind(pattern, indexPat)) {
				if ((str[indexStr]==pattern[indexPat])||(pattern[indexPat]=='.')) {
					indexPat++;
					indexStr++;
				}
				else 
					return false;
			}
			else {
				
			}
		}
		return false;
	}
	
	public boolean isStarBehind(char[] patt,int index) {
		if (index<patt.length-1) {
			if (patt[index+1]=='*')
				return true;
			else return false;
		}
		else return false;
	}
	
	public boolean match2(char[] str,char[] pattern) {
		if ((str==null)||(pattern==null))
			return false;
		else {
			return matchCore(str,pattern);
		}
	}
	
	public boolean matchCore(char[] str,char[] pattern) {
		if (str.length==0 && pattern.length==0)
			return true;//匹配成功
		if (str.length!=0 && pattern.length==0)
			return false;
		if (str.length==0 && pattern.length==1)
			return false;
		if (pattern.length>1) {
		if (pattern[1]=='*') {
			if ((pattern[0]==str[0])||(pattern[0]=='.' && str.length!=0)){
				return matchCore(getMinusNSubchar(str,1), pattern)|| matchCore(getMinusNSubchar(str,1), getMinusNSubchar(pattern,2))
					 ||matchCore(str, getMinusNSubchar(pattern,2));
			}
			else {
				return matchCore(str,getMinusNSubchar(pattern,2));
			}
		}
		}
		

		if ((pattern[0]==str[0])||(pattern[0]=='.'&&str.length!=0)) {
			return matchCore(getMinusNSubchar(str,1), getMinusNSubchar(pattern,1));
		}
		return false;
		
		
	}
	
	char[] getMinusNSubchar(char[] str,int N) {
		int length = str.length;
		String temp = new String(str);
		System.out.println(temp);
		StringBuffer temp1 = new StringBuffer(temp);
		String temp2 = new String(temp1.substring(N, length));
		return(temp2.toCharArray());
	}
	
	public static void main(String[] args) {
		char[] pattern = new char[] {'a','b','*','a','c','*','a','*'};
		char[] str = new char[] {'a','a','a'};
		Match te = new Match();
		System.out.println(te.match2(str, pattern));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
