import java.util.*;
public class MathTest{
	public static void main(String[] args){		
		String num = Integer.toBinaryString(2147483646);
		String num1 = Integer.toBinaryString(5);
		int len = num.length();
		int nnm = (int)Math.pow(2, 31);
		int nnm1 = (int)Math.pow(2, 3);
		System.out.println(nnm);
		System.out.println(nnm1);
		System.out.println(nnm-2147483646);
		System.out.println(len);
		System.out.println(num);
		System.out.println(num1);
	}
}