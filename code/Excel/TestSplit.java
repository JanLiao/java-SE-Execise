public class TestSplit{
	public static void main(String[] args){
		String fileName = "80s测试短片_hd.mp4";
		String ff = "59.64.159.224";
		String[] str = fileName.split(".");
		for(String s:str){
			System.out.println(s);
		}
		String[] str1 = ff.split("\\.");
		for(String s:str1){
			System.out.println(s);
		}
	}
}