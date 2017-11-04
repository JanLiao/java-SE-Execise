import java.io.*;


public class TTest{
	public static void main(String[] args){
		String str = "ss1 df1 we3   wee2  we5     wew     ";
		System.out.println("aaaaaaaaaaaaaaaa");
		System.out.print("\r");
		System.out.print("\n");
		System.out.print("\r");
		System.out.print("\n");
		System.out.println("aaaaaaaaaaaaaaaa");
		String[] s = str.split(" ");
		System.out.println(s.length);
		if("".equals(s[3])) System.out.println("cao");
		if(s[3] == null) System.out.println("numa");
		System.out.print(s[2] + ",");
		System.out.print(s[3] + ",");
		System.out.print(s[4] + ",");
		System.out.print(s[5] + ",");
		System.out.print(s[6] + ",");
		System.out.print(s[7] + ",");
		System.out.print(s[8] + ",");
		System.out.print(s[9] + ",");
		System.out.print(s[10] + ",");
		System.out.print(s[11] + ",");
		System.out.print(s[12] + ",");
		System.out.println();
		for(int i = 0; i < s.length; i++){
			if(s[i] == ""){
				System.out.println("kong");
			} else{
				System.out.println(s[i]);
			}
		}

		// float[][] score = new float[14][2];
		// try{
		// 	FileInputStream fis = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\s1.txt");
		// 	InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		// 	BufferedReader br = new BufferedReader(isr);		
		// 	String s;
		// 	int k = 0;
		// 	while((s = br.readLine()) != null){
		// 		String[] str = s.split("\t");
		// 		for(int i =0; i < str.length; i++){
		// 			System.out.println(str[i]);
		// 		}
		// 		score[k][0] = Float.parseFloat(str[3]);
		// 		score[k][1] = Float.parseFloat(str[4]);
		// 		k++;
		// 	}
		// 	br.close();
		// 	isr.close();
		// 	fis.close();

		// 	for(int i = 0; i < 14; i++){
		// 		for(int j = 0; j < 2; j++){
		// 			System.out.print(score[i][j] + " ");
		// 		}
		// 		System.out.println();
		// 	}
		// }catch(IOException e){
		// 	System.err.println(e);
		// }
	}
}