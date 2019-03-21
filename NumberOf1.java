import java.util.Random;

/*
 * 来源:剑指offer
 * Author:Ning
 * 题目:
 *     输入一个整数n，输出该数二进制表示中1的个数
 * 知识:
 * 
 * 		java的数据类型：基本类型（八种）+引用类型（数组，类，接口）
 * 		基本类型:byte(1),short(2),int(4),long(8),float(4),double(8),boolean(1),char(2) 1字节=8bit，1bit是一个最基本的二进制,byte是8位二进制
 *             byte,short,int,long 初始化可以直接用数字表示
 *             float:float price = 12.2f f不可省略，否则会被当做double处理,会报错，因为float无法转换成double
 *             double:double price = 12.254d 或者double price = 12.254 可省略，即默认浮点类型是double
 *             数据转换:隐式(两者兼容、目标类型的取值范围大于源数据类型 byte->short->int->long->float->double，char->int)
 *             		 +显式(两者不兼容，或者目标类型取值范围小于源数据类型) a = (int)b，注意对b没有影响.
 *             类型提升:所有的byte类型，short类型和char型在二元操作符情况下，都会被提升为int型
 *                    如果一个操作数是float，double,long,那么计算的结果就是该类型.
 *      引用类型:String是引用类型，String 是引用类型，参数传递是引用传递，但参数改变，并不影响原地址所指向的值发生变化，因为参数改变，
 *             只是改变了引用，并没有改变传递进来的引用所指向的值。    
 *             String是类
 *                
 *     java中的操作符
 *         java的操作符+,-,*,/,=; &&,||,！(单目，自右向左); >,>=,<,<=,==,!=; 
 *                   ++,--; &,|,~,^(异或,相同为0,不同为1),>>,<<(向左或右移动指定的二进制位数,右移负数补1，正数补0),>>>无符号右移(全都补0);
 *                   result=<expression>?<statement1>:<statement3>;expression为真，执行statement1，否则执行statement3.
 *         操作符一般作用于基本类型，=、==、！=可以操作对象，String支持+和+=
 *         *基本类型的包装器类可以和基本类型相互转换，包装台静态属性可以取到各数值类型的最大范围,基本类型在栈，包装类在堆
 *         String后紧跟非String类型的元素就会尝试将非String类型转换成String
 *         
 *     java的进制
 *     	        计算机的一切都是二进制表示的 'A'->65->1000001 看数字或者字符时，将它们看作二进制01本质就可.
 *         计算机的最小计算单位是字节，8个比特位是一个字节，1024字节=1K
 *         
 *         负数:正数的按位取反+1
 *             但是要考虑该负数占多少内存:
 *                 byte x = -6; byte占一个字节，8个bit，6:00000110,按位取反:11111001，+1=-6:11111010.负数的高位全是1
 *         
 *         二进制、八进制、十六进制、十进制的表示和使用
 *         二进制:0b开头
 *         八进制:0开头
 *         十六进制:0x开头
 *         
 *         
 *         
 *         
 */
public class NumberOf1 {
	public int numberOf1(int n){
		int result = 0;
		while (n!=0){
			result++;
			n = (n-1)&n;
		}
		return result;
	}
	public int numberOf1_1(int n){
		int result = 0;
		int flag = 1;
		while (flag!=0){//按位与&的优先级比==与!=低
			if ((n&flag)!=0)
				result++;
			flag= flag<<1;	
		}
		return result;
	}
	public static void main(String[] args){
		
//		NumberOf1 test = new NumberOf1();
//		System.out.println(test.numberOf1_1(-5));
		int movedigits = 1;
		while (movedigits!=0){
			System.out.println(movedigits);
			movedigits = movedigits<<1;
		}
		
		
		
/*
		int a = 0xFFF;//0x和abcdef不区分大小写
		int b = 0b1000;//0b在jdk6以后才可以
		int c = 00000777;//0可以无限多
		int d = 6;
		int e = 6>>1;
		long f = 100;
		float q= 1f;
		byte a1 = 1;
		byte a2 = 2;
		a1 += a2; //自加是没有问题的
//		a1 = a1+a2;//这个编译报错,a1+a2在计算时 自动提升为int类型，不能给byte赋值
		System.out.println(a1);
		
//		Random rand = new Random(47);
//		int i = rand.nextInt(100);
//		System.out.println(i);
 * 
 */
	}
}
