
import java.io.*;
public class Result{
	public static void main(String[] args){
		//Result result=new Result();
		double sum;
        
		double[] data=new double[23];
		for(int i=0;i<23;i++){
			data[i]=0;
		}
		double[] num=new double[4000];
		for(int i=0;i<4000;i++){
			
				num[i]=0;
			
		}
		String[][] sdata=new String[4000][14];
		for(int i=0;i<4000;i++){
			for(int j=0;j<14;j++){
				sdata[i][j]="";
			}
		}
		int k=0;
		try{
			File f=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/data.txt");
		    FileReader fr=new FileReader(f);
		    BufferedReader br=new BufferedReader(fr);

		    String line=br.readLine();
		    while(line!=null){
		    	for(int i=0;i<23;i++){
		    	String[] str=line.split(",");
		    	data[i]=Double.parseDouble(str[2]);
		    	line=br.readLine();
		        }
		        // for(int i=0;i<23;i++){
		        // 	System.out.print(data[i]+"///");
		        // }
		        // System.out.println();
		        //double avg;
		        sum=0;
		        for(int i=0;i<23;i++){
		        	sum=sum+data[i];
		        }
		        double avg=sum/23;
                ARIMA arima=new ARIMA(data); 
		        int []model=arima.getARIMAmodel();
                num[k]=arima.aftDeal(arima.predictValue(model[0],model[1]));
                System.out.println(num[k]);
                System.out.println();
                //num[k]=model[1];
                //num[k]=(model[0]+model[1])/2;

		        //num[k]=gm(data,2);

                //if(avg==0) avg=-1;
                // if(num[k]<=0) {
                // 	num[k]=avg;
                // }
                // else if(num[k]>avg){
                // 	num[k]=(num[k]+avg)/2;
                // }
                // else{
                //     num[k]=avg;
                // }

                //if(num[k]<avg) num[k]=avg;
                //line=br.readLine();
		        
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
				int number;
				//int curnumber=(int)num[j];
				if(num[j]>0){
				number=(int)num[j]+1;
				}else{
				number=0;
				}
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
			File f2=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/prediction_ja_20170414_012.txt");
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