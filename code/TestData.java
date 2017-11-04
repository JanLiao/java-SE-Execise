import java.io.*;
public class TestData{
	public static void main(String[] args){
		String[][] data=new String[4000][14];
		for(int i=0;i<4000;i++){
			for(int j=0;j<14;j++){
				data[i][j]="";
			}
		}
		try{
			File f=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/prediction_lilei_20170320（提交样例）.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String line=br.readLine();
			line=br.readLine();
			
			int length=0;
			while(line!=null){
				length++;
				int i,j;
				i=(int)(length-1)/4000;
				j=length-4000*i-1;
				String[] rData=line.split(",");
                data[j][i]=rData[0]+","+rData[1]+","+"165";
				//rData[2]="154";
				// if(i<4000){
				// 	data[i][j]=rData[0]+","+rData[1]+"154";
				// 	i++;
				// }
				// else if(j<14){
				// 	i=0;
				// 	j+=1;
				// 	data[i][j]=rData[0]+","+rData[1]+","+"154";
				// }
				line=br.readLine();
			}
			//System.out.println(i+";"+j);
			System.out.println(length);
			br.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
System.out.println(data[0][0]);

		try{
			File f1=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/prediction_ja_20170413_165.txt");
			FileWriter fw=new FileWriter(f1);
	        BufferedWriter bw=new BufferedWriter(fw);
			for(int m=0;m<14;m++){
				for(int n=0;n<4000;n++){
					bw.write(data[n][m]);
					bw.newLine();
				}
			}
			bw.close();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}