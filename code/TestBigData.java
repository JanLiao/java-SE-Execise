import java.io.*;
public class TestBigData{
	public static void main(String[] args){
		double[][] num=new double[4000][12];
		String[][] sdata=new String[4000][14];
		int k=0;
		try{
			File f=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/data.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
		
			double[] data=new double[23];
			String line=br.readLine();
			System.out.println(line);
			while(line!=null){
				for(int i=0;i<23;i++){
				   String str[]=line.split(",");
                   //int m=Integer.parseInt(str[0]);
                   int n=Integer.parseInt(str[2]);
                   data[i]=n;
                   line=br.readLine();
				}
                for(int i=0;i<11;i++){
                	num[k][i]=(data[i]+data[i+12])/2;
                }
                num[k][11]=data[11];
                k++;
			}
			System.out.println(k);
			fr.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
      
try{
			File f1=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/prediction_lilei_20170320（提交样例）.txt");
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
				// int number=(int)num[j];
				String[] rData=line1.split(",");
				int m=Integer.parseInt(rData[1].substring(5,7));
				int n=Integer.parseInt(rData[0]);
				int number=(int)num[n-1][m-1];
                sdata[j][i]=rData[0]+","+rData[1]+","+number;
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
			File f2=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/prediction_ja_20170414_020.txt");
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