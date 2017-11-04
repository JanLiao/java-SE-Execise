public class TestPath{
	public static void main(String[] args){
		String path = "C:\\Users\\MrLiao\\Desktop\\code";
		String name = "sss.ssw.t";
		String str = path.substring(0, path.lastIndexOf(":"));
		System.out.println(str);
		System.out.println(name.lastIndexOf("."));
		String ss = name.substring(0, name.lastIndexOf("."));
		System.out.println(ss);
	}
}