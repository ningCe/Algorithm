package com.jianzhiOffer;
/*
 * ��Դ����ָoffer
 * ��Ŀ��������ʽƥ��
 *      .��ʾ�����ַ�������,*��ʾ��*֮ǰ���ַ����Գ�������Σ���0�Σ�
 *      �ַ�����ȫƥ��ģʽ
 * ����˼·������ƥ�䣬�������:
 *     ģʽ�ĵڶ����ַ�����*����ôֻҪ�������ƥ�䣬.���κ��ַ�������ͨ��;
 *     �ڶ����ַ���*����ô������ѡ��
 *         һ����ģʽ������ƶ������ַ���ֱ���Թ���
 *         �������ģʽ�еĵ�һ���ַ����ַ�����ƥ�䣬�����ַ���������ƶ�һ���ַ������ͬʱ��ģʽ��������ѡ��:
 *             ������ģʽ������ƶ������ַ�;
 *             Ҳ���Ա���ģʽ����.
 *   �õݹ�ʵ�����ϵ�˼·
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
			return true;//ƥ��ɹ�
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
