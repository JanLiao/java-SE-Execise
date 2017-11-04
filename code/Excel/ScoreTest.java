import java.io.*;
public class ScoreTest{
	public static void main(String[] args){
		float[][] score = new float[14][2];
		try{
			FileInputStream fis = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\s1.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);		
			String s;
			int k = 0;
			while((s = br.readLine()) != null){
				String[] str = s.split("\\t");
				for(int i =0; i < str.length; i++){
					System.out.println(str[i]);
				}
				score[k][0] = Float.parseFloat(str[3]);
				score[k][1] = Float.parseFloat(str[4]);
				k++;
			}
			br.close();
			isr.close();
			fis.close();

			for(int i = 0; i < 14; i++){
				for(int j = 0; j < 2; j++){
					System.out.print(score[i][j] + " ");
				}
				System.out.println();
			}
		}catch(IOException e){
			System.err.println(e);
		}

		System.out.println("--------------------");
		System.out.println("--------------------");

		float value = 0;
		float sum = 0;

		for(int i = 0; i < 14; i++){
			sum = sum + score[i][0]*score[i][1];
			value = value + score[i][0];
			System.out.println(value + "=" + sum);
		}
		System.out.println(sum);
		System.out.println(value);
		System.out.println(sum/value);
	}
}