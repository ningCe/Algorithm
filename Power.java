import java.util.Scanner;

/*
 * 来源：剑指offer
 * Author:Ning
 * 题目:
 *     数值的整数次方
 *     给定基数为double类型，和指数为整数类型，求不用考虑大数问题的数值整数次方
 *     注意事项:指数有可能是0，有可能是负数.需要都考虑到
 */
public class Power {
	public double power(double base,int exponent){
		if (exponent==0) return 1;
		else if (exponent<0){
			return (1/unsignedpower(base, -exponent));
		}
		else {
			return unsignedpower(base, exponent);
		}
	}
	
	public double unsignedpower(double base,int exponent){
		double result = 1.0;
		for (int i=0;i<exponent;i++){
			result = base*result;
		}
		return result;
	}
	
	public double unsignedpower1(double base,int exponent){
		if (exponent==0) return 1;
		if (exponent==1) return base;
		double result = unsignedpower1(base, exponent>>1);
		result *=result;
		if ((exponent&1)==1){
			result *=base;
		}
		return result;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		if ((test&1)==1)
			System.out.println("Odd!");
		else System.out.println("Not Odd!");
		
		
	}
}
