/* !未解决
 * 题目来源：牛客网
 * Author:Ning
 * 题目:
 *     打印从1到最大的n位数,位数没有限制
 * 知识:
 *     大数问题的考虑，这里使用字符串来模拟加法以及打印输出.
 *     java中的字符串String类是不可修改的,StringBuffer是可以修改的，一般用StringBuffer.
 *     String的各种拼接实际上是在常量空间中产生很多字符串常量，StringBuffer可以不生成新的对象，在自身上修改
 *     StringBuffer与StringBuilder区别是StringBuffer是线程安全可以同步访问的,StirngBuilder不行
 *     
 *     String类与Char数组之间是可以顺利转换的,StringBuffer和String类之间也是可以顺利转换的，StringBuffer与Char数组是不能直接转换的，可以通过String类作为跳板
 *     
 *     我们输出一个对象时，首先会去调用它的.toStirng()方法，基本类型都有重写这个方法，因此输出的不是内存地址，而是真正的基本类型的值
 *     对于数组类型，其他类型的数组都被认为是Object类型，所以会输出内存地址,
 *     而char[]调用的方法是输出char这个数组中的每一个值，所以不是内存地址了.因此只有char[]是可以直接输出真正的值的.
 */
public class Print1ToMaxOfNDigits {
	public void print1ToMaxOfNDigits(int n){
		int DigitsEnd = 1;
		for (int i=0;i<n;i++){
			DigitsEnd*=10;
		}
		for (int i=1;i<DigitsEnd;i++)
			System.out.println(i);
	}
	
	public static void main(String[] args){
		Print1ToMaxOfNDigits test = new Print1ToMaxOfNDigits();
		test.print1ToMaxOfNDigits1(5);
	}
	
	public void print1ToMaxOfNDigits1(int n){
//		StringBuffer result = new StringBuffer("");
//		for (int i=0;i<n;i++){
//			result.append("0");
//		}
//		result.replace(n-1, n, "1");//这里"1"是字符串，自增、进位不知道怎么实现，"1"和"2"的联系......看起来是要用n层循环才能实现，有点蠢
//		System.out.println(result);
//		char a[] = new char[]{'a','b'};
//		System.out.println(a+1);//char-->int
//		char b = (char)(a+1);
//		System.out.println(b);
//		System.out.println(a);//char[]数组可以直接输出各元素字符拼接起来的内容
		int a[] =new int[]{1,2,3,4,5};
		System.out.println(a);//int[]数组则是只能输出对象的内存地址
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
	
	public void print1ToMaxOfNDigits2(int n){
		if (n<=0) return;
		char[] result = new char[n];
		
		for (int i=0;i<result.length;i++){
			result[i] = '0';
		}
	        

		System.out.println(result);
		
	}
}
