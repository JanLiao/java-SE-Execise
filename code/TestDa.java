import java.io.*;
public class TestDa{
	public static void main(String[] args){
	int[][] data=new int[4000][14];
	String[][] strdata=new String[4000][14];
	File f=new File("C:\\Users\\MrLiao\\Desktop\\商务智能实践\\样本\\prediction_ja_20170414_016.txt");
	try{
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		line=br.readLine();
		int k=1;
		while(k<=4000){
			String[] str=line.split(",");
			int num=Integer.parseInt(str[2]);
			if(num==0){
				for(int i=0;i<14;i++){
					data[k-1][i]=0;
				}
			}else if(num<15){
				for(int i=0;i<14;i++){
					data[k-1][i]=num;
				}
			}
			else if(num<=100){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-14+i*2;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+2*(i-6);
				}
			}else if(num<=150){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-14+i*2;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+2*(i-6);
				}
			}else if(num<=200){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-21+i*3;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+3*(i-6);
				}
			}else if(num<=250){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-28+i*4;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+4*(i-6);
				}
			}else if(num<=300){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-35+i*5;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+5*(i-6);
				}
			}else if(num<=400){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-56+i*8;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+8*(i-6);
				}
			}else if(num<=1000){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-105+i*15;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+15*(i-6);
				}
			}else if(num<=2000){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-280+i*40;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+40*(i-6);
				}
			}else if(num<=3000){
				for(int i=0;i<7;i++){
					data[k-1][i]=num-490+i*70;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+70*(i-6);
				}
			}else{
				for(int i=0;i<7;i++){
					data[k-1][i]=num-700+i*100;
				}
				for(int i=7;i<14;i++){
					data[k-1][i]=num+100*(i-6);
				}
			}
			line=br.readLine();
			k++;
		}
		br.close();
		fr.close();
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
				String[] rData=line1.split(",");
				strdata[j][i]=rData[0]+","+rData[1]+","+data[j][i];
				line1=br1.readLine();
			}
			//System.out.println(i+";"+j);
			//System.out.println(length);
			br1.close();
			fr1.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		try{
			File f2=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/prediction_ja_20170414_022.txt");
			FileWriter fw=new FileWriter(f2);
			BufferedWriter bw=new BufferedWriter(fw);
			for(int m=0;m<14;m++){
				for(int n=0;n<4000;n++){
					bw.write(strdata[n][m]);
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