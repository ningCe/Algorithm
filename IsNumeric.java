package com.jianzhiOffer;

/*
 * ��Դ����ָoffer
 * ��Ŀ����ʾ��ֵ���ַ����ж�
 * 		����������С��
 * 		��ʽ��A[.[B]][e|EC]
 * 
 * ˼·����������ʽ��д��A���������������ɸ���B����С��������֣�ֻ��ȡ������C��ָ���������ɸ���
 * 		A�Ĵ�����B�Ĵ����ǻ�Ĺ�ϵ��B�Ĵ�����C�Ĵ�������Ĺ�ϵ
 * 			-->С����ǰ����ߺ��涼����û�����֣����ǲ���ͬʱû�У�����ǻ�Ĺ�ϵ��
 * 			   e/E��ǰ��û��0-9���ǲ�����ģ�e/E�ĺ���û��0-9����Ҳ�ǲ�����ģ��������Ĺ�ϵ��
 *		����Ҫʱ��ע����ַ������Խ���ж����������c++���ַ�����ͬ�ĵط���c++���ַ�������/0����������󣬶�Java�����鲻�ᡣ
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
