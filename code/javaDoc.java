/**
*javadoc 演示程序——<b>JavaDoc</b>
*
*@author  Jan  Liao
*@version  1.0  2017/4/5
*/
public class javaDoc{
/**
*在main()方法中使用的显示用字符串
*
*@see  #main(java.lang.String[])
*/


	static String SDisplay;

	static String 变量;
/**
*显示JavaDoc
*
*@param  ss
*aa
*args
*bb    从命令行带入的字符串
*/
	public static void main(String args[]){
		SDisplay="HelloWOrld";
		变量="test";
		System.out.println(SDisplay+变量);
	}
}