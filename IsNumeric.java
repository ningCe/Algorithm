package com.jianzhiOffer;

/*
 * 来源：剑指offer
 * 题目：表示数值的字符串判定
 * 		包括整数和小数
 * 		格式是A[.[B]][e|EC]
 * 
 * 思路：以上述格式来写，A代表整数，可正可负，B代表小数后的数字，只能取正数，C是指数，可正可负；
 * 		A的存在与B的存在是或的关系；B的存在与C的存在是与的关系
 * 			-->小数点前面或者后面都可以没有数字，但是不能同时没有，因此是或的关系；
 * 			   e/E的前面没有0-9数是不允许的，e/E的后面没有0-9的数也是不允许的，因此是与的关系。
 *		这里要时刻注意对字符数组的越界判定！这个是与c++的字符串不同的地方，c++的字符串后会接/0带代表到了最后，而Java的数组不会。
 */
public class IsNumeric {
	public static void main(String[] args) {
		IsNumeric test  = new IsNumeric();
		char[] str = new char[] {'1','0','0'};
		System.out.println(test.isNumeric(str));
	}
	public boolean isNumeric(char[] str) {
		if ((str.length == 0) || (str == null))
			return false;
		boolean result = false;
		int p = 0;
		if ((str[p] == '+') || (str[p] == '-')) 
			p++;
			
			int porigin0 = p;
			while (p < str.length) {
				if ((str[p] <= '9') && (str[p] >= '0'))
					p++;
				else
					break;
			}
			result = p > porigin0;
			

		if ((p<str.length)&&(str[p] == '.')) {
			p++;

			int porigin1 = p;
			while (p < str.length) {
				if ((str[p] <= '9') && (str[p] >= '0'))
					p++;
				else
					break;
			}
			result = result || (p > porigin1);
		}

		if ((p<str.length)&&(str[p] == 'e' || str[p] == 'E')) {
			p++;
			if ((p<str.length)&&(str[p] == '+' || str[p] == '-'))
				p++;

			int porign2 = p;
			while (p < str.length) {
				if ((str[p] <= '9') && (str[p] >= '0'))
					p++;
				else
					break;
			}
			result = result && (p > porign2);
		}

		return (result && (p == str.length));

	}
}
