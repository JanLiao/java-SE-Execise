import java.io.*;
public class Result2{
	public static void main(String[] args){
		ARIMA arima[]=new ARIMA[14];
		double num[][]=new double[4000][14];
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
                 // for(double i:data){
                 //    System.out.print(i+"//");
                 // }
				double sum=0;
				double avg;
				for(double i:data){
					sum+=i;
				}
				avg=sum/23;
                //System.out.println(sum);

				if(sum==0){
					num[k][0]=0;
				}else{
					arima[0]=new ARIMA(data);
					int model[]=arima[0].getARIMAmodel();
					num[k][0]=arima[0].aftDeal(arima[0].predictValue(model[0],model[1]));

					if(num[k][0]<0){
						if(sum>0){
							num[k][0]=(int)avg+1;
						}else{
							num[k][0]=0;
						}
					}else{
						num[k][0]=(num[k][0]+avg)/2;
					}
				}
				if(num[k][0]>2*avg)  num[k][0]=(int)avg+1; 
				num[k][13]=num[k][0];

				//System.out.println(num[k][0]);

				for(int i=1;i<4;i++){
					for(int j=1;j<=22;j++){
						data[j-1]=data[j];
					}

					for(double p:data){
						sum+=p;
					}
					avg=sum/23;
					if(sum==0){
						num[k][i]=0;
					}else{
						data[22]=num[k][i-1];
						arima[i]=new ARIMA(data);
						int model1[]=arima[i].getARIMAmodel();
						num[k][i]=arima[i].aftDeal(arima[i].predictValue(model1[0],model1[1]));

						if(num[k][i]<0){
							if(sum>0){
								num[k][i]=(int)avg+1;
							}else{
								num[k][i]=0;
							}
						}else{
							num[k][i]=(num[k][i]+avg)/2;
						}
						if(num[k][i]>2*avg) num[k][i]=(int)avg+1;
						num[k][i+3]=num[k][i];
						num[k][i+6]=num[k][i];
						num[k][i+9]=num[k][i];
					}
				}
                //System.out.println(num[k]);
				k++;
				//System.out.println(k);

			}
			//System.out.println(k);
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
				int number=(int)num[j][i];
				String[] rData=line1.split(",");
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
			File f2=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/prediction_ja_20170414_021.txt");
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