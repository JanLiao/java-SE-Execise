import java.io.*;
public class Result1{
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
		        
		        	num[k]=gm(data,2);
                //if(avg==0) avg=-1;
                if(num[k]<=0) {
                	num[k]=avg;
                }
                else if(num[k]>avg){
                	num[k]=(num[k]+avg)/2;
                }
                else{
                    num[k]=avg;
                }
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
			File f2=new File("C:/Users/MrLiao/Desktop/商务智能实践/样本/prediction_ja_20170414_011.txt");
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

	public static double gm(double[] fs, int T) {

        // 预测模型函数
        int size = fs.length;
        int tsize = fs.length - 1;
        double[] arr = fs;// 原始数组
        double[] arr1 = new double[size];// 经过一次累加数组
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            arr1[i] = sum;
        }
        double[] arr2 = new double[tsize];// arr1的紧邻均值数组
        for (int i = 0; i < tsize; i++) {
            arr2[i] = (double) (arr1[i] + arr1[i + 1]) / 2;
        }
        /*
         * 
         * 下面建立 向量B和YN求解待估参数向量， 即求参数a,b
         */
        /*
         * 下面建立向量B, B是5行2列的矩阵， 相当于一个二维数组。
         */
        double[][] B = new double[tsize][2];
        for (int i = 0; i < tsize; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 1)
                    B[i][j] = 1;
                else
                    B[i][j] = -arr2[i];
            }

        }
        /*
         * 下面建立向量YN
         */
        double[][] YN = new double[tsize][1];
        for (int i = 0; i < tsize; i++) {
            for (int j = 0; j < 1; j++) {
                YN[i][j] = arr[i + 1];
            }
        }

        /*
         * B的转置矩阵BT,2行5列的矩阵
         */
        double[][] BT = new double[2][tsize];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < tsize; j++) {
                BT[i][j] = B[j][i];
            }
        }
        /*
         * 将BT和B的乘积所得到的结果记为数组B2T,则B2T是一个2*2的矩阵
         */
        double[][] B2T = new double[2][2];
        for (int i = 0; i < 2; i++) {// rows of BT

            {
                for (int j = 0; j < 2; j++)// cloums of B
                {
                    for (int k = 0; k < tsize; k++)// cloums of BT=rows of B
                    {
                        B2T[i][j] = B2T[i][j] + BT[i][k] * B[k][j];
                    }
                }

            }
        }
        /* 下面求B2T的逆矩阵，设为B_2T，怎么适用于一般的矩阵？ */
        double[][] B_2T = new double[2][2];
        B_2T[0][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * B2T[1][1];
        B_2T[0][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * (-B2T[0][1]);
        B_2T[1][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * (-B2T[1][0]);
        B_2T[1][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * B2T[0][0];
        /*
         * 根据以上所求的各已知量下面求待估参数的未知量a和b，待估向量矩阵等于B_2T*BT*YN
         * 下面我们分别求这些矩阵的乘积，首先求B_2T*BT，令B_2T*BT的乘积为A矩阵，则A就是一个2*5的矩阵
         */
        /*
         * 
         * 
         * 
         * 下面先求A矩阵
         */
        double[][] A = new double[2][tsize];
        for (int i = 0; i < 2; i++) {// rows of B_2T
            {
                for (int j = 0; j < tsize; j++)// cloums of BT
                {
                    for (int k = 0; k < 2; k++)// cloums of B_2T=rows of BT
                    {
                        A[i][j] = A[i][j] + B_2T[i][k] * BT[k][j];
                    }
                }

            }
        }
        /*
         * 
         * 
         * 下面求A和YN矩阵的乘积，令乘积为C矩阵，则C就是一个2*1的矩阵
         */
        double[][] C = new double[2][1];
        for (int i = 0; i < 2; i++) {// rows of A

            {
                for (int j = 0; j < 1; j++)// cloums of YN
                {
                    for (int k = 0; k < tsize; k++)// cloums of A=rows of YN
                    {
                        C[i][j] = C[i][j] + A[i][k] * YN[k][j];
                    }
                }

            }
        }
        /* 根据以上所得则a=C[0][0],b=C[1][0]; */
        double a = C[0][0], b = C[1][0];
        int i = T;// 读取一个数值
        double Y = (arr[0] - b / a) * Math.exp(-a * (i + 1)) - (arr[0] - b / a)
                * Math.exp(-a * i);
        return Y;
    }
}