import java.io.*;
public class GetData{
	public static void main(String[] args){
		int[] data=new int[4000];
		for(int i=0;i<4000;i++){
			data[i]=0;
		}
		String[][] sdata=new String[4000][14];
		for(int i=0;i<4000;i++){
			for(int j=0;j<14;j++){
				sdata[i][j]="";
			}
		}
		try{
			File f=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/count2.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String line=br.readLine();
			while(line!=null){
				String[] str=line.split(",");
				int id=Integer.parseInt(str[0]);
				int quantity=Integer.parseInt(str[1]);
				data[id-1]=quantity;
				line=br.readLine();
			}
			br.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}

        try{
			File f1=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/prediction_lilei_20170320（提交样例）.txt");
			FileReader fr1=new FileReader(f1);
			BufferedReader br1=new BufferedReader(fr1);
			String line1=br1.readLine();
			line1=br1.readLine();
			int length=0;
			while(line1!=null){
				length++;
				int i,j;
				i=(int)(length-1)/4000;
				j=length-4000*i-1;
				String[] rData=line1.split(",");
                sdata[j][i]=rData[0]+","+rData[1]+","+data[j];
				line1=br1.readLine();
			}
			//System.out.println(i+";"+j);
			System.out.println(length);
			br1.close();
			fr1.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		try{
			File f2=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/prediction_ja_20170413_1.txt");
			FileWriter fw=new FileWriter(f2);
	        BufferedWriter bw=new BufferedWriter(fw);
			for(int m=0;m<14;m++){
				for(int n=0;n<4000;n++){
					bw.write(sdata[n][m]);
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