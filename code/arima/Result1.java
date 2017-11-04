import java.util.*;
import java.util.Vector;
import Jama.Matrix;
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
                ARIMA arima=new ARIMA(data); 
		        int []model=arima.getARIMAmodel();
                num[k]=model[0];
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

class ARIMA {

	double[] originalData={};
	ARMAMath armamath=new ARMAMath();
	double stderrDara=0;
	double avgsumData=0;
	Vector<double[]> armaARMAcoe=new Vector<double[]>();
	Vector<double[]> bestarmaARMAcoe=new Vector<double[]>();
	

	public ARIMA(double [] originalData)
	{
		this.originalData=originalData;
	}

	public double[] preDealDif()
	{
		
		//seasonal Difference:Peroid=7
		double []tempData=new double[originalData.length-7];
		for(int i=0;i<originalData.length-7;i++)
		{
			tempData[i]=originalData[i+7]-originalData[i];
		}

		return tempData;
	}

	public double[] preDealNor(double[] tempData)
	{
		//Z-Score
		avgsumData=armamath.avgData(tempData);
		stderrDara=armamath.stderrData(tempData);
		
		for(int i=0;i<tempData.length;i++)
		{
			tempData[i]=(tempData[i]-avgsumData)/stderrDara;
		}
		
		return tempData;
	}

	public int[] getARIMAmodel()
	{
		double[] stdoriginalData=this.preDealDif();
		
		int paraType=0;
		double minAIC=9999999;
		int bestModelindex=0;
		int[][] model=new int[][]{{0,1},{1,0},{1,1},{0,2},{2,0},{2,2},{1,2},{2,1}};//,{3,0},{0,3},{3,1},{1,3},{3,2},{2,3},{3,3}};//,{4,0},{0,4},{4,1},{1,4},{4,2},{2,4},{4,3},{3,4},{4,4}};
		
		for(int i=0;i<model.length;i++)
		{
			if(model[i][0]==0)
			{
				MA ma=new MA(stdoriginalData, model[i][1]);
				armaARMAcoe=ma.MAmodel(); 
				paraType=1;
			}
			else if(model[i][1]==0)
			{
				AR ar=new AR(stdoriginalData, model[i][0]);
				armaARMAcoe=ar.ARmodel(); 
				paraType=2;
			}
			else
			{
				ARMA arma=new ARMA(stdoriginalData, model[i][0], model[i][1]);
				armaARMAcoe=arma.ARMAmodel();
				paraType=3;
			}
			

			double temp=getmodelAIC(armaARMAcoe,stdoriginalData,paraType);
			System.out.println("AIC of these model="+temp);
			if (temp<minAIC)
			{
				bestModelindex=i;
				minAIC=temp;
				bestarmaARMAcoe=armaARMAcoe;
			}
		}
		
		return model[bestModelindex];
 	}

	public double getmodelAIC(Vector<double[]> para,double[] stdoriginalData,int type)
	{
		double temp=0;
		double temp2=0;
		double sumerr=0;
		int p=0;
		int q=0;
		int n=stdoriginalData.length;
		Random random=new Random();
		
		if(type==1)
		{
			double[] maPara=para.get(0);
			q=maPara.length;
			double[] err=new double[q];  
			for(int k=q-1;k<n;k++)
			{
				temp=0;
				
				for(int i=1;i<q;i++)
				{
					temp+=maPara[i]*err[i];
				}
			
				
				for(int j=q-1;j>0;j--)
				{
					err[j]=err[j-1];
				}
				err[0]=random.nextGaussian()*Math.sqrt(maPara[0]);
				
				
				sumerr+=(stdoriginalData[k]-(temp))*(stdoriginalData[k]-(temp));
				
			}
			
			return (n-(q-1))*Math.log(sumerr/(n-(q-1)))+(q+1)*2;
		}
		else if(type==2)
		{
			double[] arPara=para.get(0);
			p=arPara.length;
			for(int k=p-1;k<n;k++)
			{
				temp=0;
				for(int i=0;i<p-1;i++)
				{
					temp+=arPara[i]*stdoriginalData[k-i-1];
				}
				
				sumerr+=(stdoriginalData[k]-temp)*(stdoriginalData[k]-temp);
			}
			return (n-(q-1))*Math.log(sumerr/(n-(q-1)))+(p+1)*2;
			
		}
		else
		{
			double[] arPara=para.get(0);
			double[] maPara=para.get(1);
			p=arPara.length;
			q=maPara.length;
			double[] err=new double[q];  
			
			for(int k=p-1;k<n;k++)
			{
				temp=0;
				temp2=0;
				for(int i=0;i<p-1;i++)
				{
					temp+=arPara[i]*stdoriginalData[k-i-1];
				}
			
				for(int i=1;i<q;i++)
				{
					temp2+=maPara[i]*err[i];
				}
			
				
				for(int j=q-1;j>0;j--)
				{
					err[j]=err[j-1];
				}
				
				err[0]=random.nextGaussian()*Math.sqrt(maPara[0]);
				
				sumerr+=(stdoriginalData[k]-(temp2+temp))*(stdoriginalData[k]-(temp2+temp));
			}
			return (n-(q-1))*Math.log(sumerr/(n-(q-1)))+(p+q)*2;
			
		}
	}

	public int aftDeal(int predictValue)
	{
		//System.out.println("predictBeforeDiff="+predictValue);
		return (int)(predictValue+originalData[originalData.length-7]);
	}

	public int predictValue(int p,int q)
	{
		int predict=0;
		double[] stdoriginalData=this.preDealDif();
		int n=stdoriginalData.length;
		double temp=0,temp2=0;
		double[] err=new double[q+1];
	
		Random random=new Random();
		if(p==0)
		{
			double[] maPara=bestarmaARMAcoe.get(0);
			for(int k=q;k<n;k++)
			{
				temp=0;
				for(int i=1;i<=q;i++)
				{
					temp+=maPara[i]*err[i];
				}
				
				for(int j=q;j>0;j--)
				{
					err[j]=err[j-1];
				}
				err[0]=random.nextGaussian()*Math.sqrt(maPara[0]);
			}
			predict=(int)(temp); 
		}
		else if(q==0)
		{
			double[] arPara=bestarmaARMAcoe.get(0);
			for(int k=p;k<n;k++)
			{
				temp=0;
				for(int i=0;i<p;i++)
				{
					temp+=arPara[i]*stdoriginalData[k-i-1];
				}
			}
			predict=(int)(temp);
		}
		else
		{

			double[] arPara=bestarmaARMAcoe.get(0);
			double[] maPara=bestarmaARMAcoe.get(1);
			err=new double[q+1];  
			for(int k=p;k<n;k++)
			{
				temp=0;
				temp2=0;
				for(int i=0;i<p;i++)
				{
					temp+=arPara[i]*stdoriginalData[k-i-1];
				}
			
				for(int i=1;i<=q;i++)
				{
					temp2+=maPara[i]*err[i];
				}
			
				
				for(int j=q;j>0;j--)
				{
					err[j]=err[j-1];
				}
				
				err[0]=random.nextGaussian()*Math.sqrt(maPara[0]);
			}
			
			predict=(int)(temp2+temp);
			
		}
	
		
		return predict;
	}

	public double[] getMApara(double[] autocorData,int q)
	{
		double[] maPara=new double[q+1];
		double[] tempmaPara=maPara;
		double temp=0;
		boolean iterationFlag=true;
		
		System.out.println("autocorData[0]"+autocorData[0]);
		while(iterationFlag)
		{
			for(int i=1;i<maPara.length;i++)
			{
				temp+=maPara[i]*maPara[i];
			}
			tempmaPara[0]=autocorData[0]/(1+temp);
		
			for(int i=1;i<maPara.length;i++)
			{
				temp=0;
				for(int j=1;j<maPara.length-i;j++)
				{
					temp+=maPara[j]*maPara[j+i];
				}
				tempmaPara[i]=-(autocorData[i]/tempmaPara[0]-temp);
			}
			iterationFlag=false;
			for(int i=0;i<maPara.length;i++)
			{
				if(maPara[i]!=tempmaPara[i])
				{
					iterationFlag=true;
					break;
				}
			}
			
			maPara=tempmaPara;
		}
		
		return maPara;
	}

}

class ARMAMath
{
	public double avgData(double[] dataArray)
	{
		return this.sumData(dataArray)/dataArray.length;
	}
	
	public double sumData(double[] dataArray)
	{
		double sumData=0;
		for(int i=0;i<dataArray.length;i++)
		{
			sumData+=dataArray[i];
		}
		return sumData;
	}
	
	public double stderrData(double[] dataArray)
	{
		return Math.sqrt(this.varerrData(dataArray));
	}
	
	public double varerrData(double[] dataArray)
	{
		double variance=0;
		double avgsumData=this.avgData(dataArray);
		
		for(int i=0;i<dataArray.length;i++)
		{
			dataArray[i]-=avgsumData;
			variance+=dataArray[i]*dataArray[i];
		}
		return variance/dataArray.length;//variance error;
	}
	

	public double[] autocorData(double[] dataArray,int order)
	{
		double[] autoCor=new double[order+1];
		double varData=this.varerrData(dataArray);
		
		for(int i=0;i<=order;i++)
		{
			autoCor[i]=0;
			for(int j=0;j<dataArray.length-i;j++)
			{
				autoCor[i]+=dataArray[j+i]*dataArray[j];
			}
			autoCor[i]/=dataArray.length;
			autoCor[i]/=varData;
		}
		return autoCor;
	}
	

	public double[] autocorGrma(double[] dataArray,int order)
	{
		double[] autoCor=new double[order+1];
		for(int i=0;i<=order;i++)
		{
			autoCor[i]=0;
			for(int j=0;j<dataArray.length-i;j++)
			{
				autoCor[i]+=dataArray[j+i]*dataArray[j];
			}
			autoCor[i]/=(dataArray.length-i);
			
		}
		return autoCor;
	}
	

	public double[] parautocorData(double[] dataArray,int order)
	{
		double parautocor[]=new double[order];
		
		for(int i=1;i<=order;i++)
	    {
			parautocor[i-1]=this.parcorrCompute(dataArray, i,0)[i-1];
	    }
		return parautocor;
	}

	public double[][] toplize(double[] dataArray,int order)
	{
		double[][] toplizeMatrix=new double[order][order];
		double[] atuocorr=this.autocorData(dataArray,order);

		for(int i=1;i<=order;i++)
		{
			int k=1;
			for(int j=i-1;j>0;j--)
			{
				toplizeMatrix[i-1][j-1]=atuocorr[k++];
			}
			toplizeMatrix[i-1][i-1]=1;
			int kk=1;
			for(int j=i;j<order;j++)
			{
				toplizeMatrix[i-1][j]=atuocorr[kk++];
			}
		}
		return toplizeMatrix;
	}

	
	public double[] getMApara(double[] autocorData,int q)
	{
		double[] maPara=new double[q+1];
		double[] tempmaPara=maPara;
		double temp=0;
		boolean iterationFlag=true;
		
		maPara[0]=1;
		while(iterationFlag)
		{
			for(int i=1;i<maPara.length;i++)
			{
				temp+=maPara[i]*maPara[i];
			}
			tempmaPara[0]=autocorData[0]/(1+temp);
		
			for(int i=1;i<maPara.length;i++)
			{
				temp=0;
				for(int j=1;j<maPara.length-i;j++)
				{
					temp+=maPara[j]*maPara[j+i];
				}
				tempmaPara[i]=-(autocorData[i]/maPara[0]-temp);
			}
			iterationFlag=false;
			for(int i=0;i<maPara.length;i++)
			{
				if(maPara[i]!=tempmaPara[i])
				{
					iterationFlag=true;
					break;
				}
			}
			
			maPara=tempmaPara;
		}
		
		return maPara;
	}
	
	public double[] parcorrCompute(double[] dataArray,int p,int q)
	{
		double[][] toplizeArray=new double[p][p];
		
		double[] atuocorr=this.autocorData(dataArray,p+q);
		double[] autocorrF=this.autocorGrma(dataArray, p+q);
		for(int i=1;i<=p;i++)
		{
			int k=1;
			for(int j=i-1;j>0;j--)
			{
				toplizeArray[i-1][j-1]=atuocorr[q+k++];
			}
			toplizeArray[i-1][i-1]=atuocorr[q];
			int kk=1;
			for(int j=i;j<p;j++)
			{
				toplizeArray[i-1][j]=atuocorr[q+kk++];
			}
		}
		
	    Matrix toplizeMatrix = new Matrix(toplizeArray);
	    Matrix toplizeMatrixinverse=toplizeMatrix.inverse();
		
	    double[] temp=new double[p];
	    for(int i=1;i<=p;i++)
	    {
	    	temp[i-1]=atuocorr[q+i];
	    }
	    
		Matrix autocorrMatrix=new Matrix(temp, p);
		Matrix parautocorDataMatrix=toplizeMatrixinverse.times(autocorrMatrix); //  [Fi]=[toplize]x[autocorr]';
		
		
		double[] result=new double[parautocorDataMatrix.getRowDimension()+1];
		for(int i=0;i<parautocorDataMatrix.getRowDimension();i++)
		{
			result[i]=parautocorDataMatrix.get(i,0);
		}
		
		
		double sum2=0;
		for(int i=0;i<p;i++)
			for(int j=0;j<p;j++)
			{
				sum2+=result[i]*result[j]*autocorrF[Math.abs(i-j)];
			}
		result[result.length-1]=autocorrF[0]-sum2; 
		
		
			return result;  

	}
}

class AR {
	
	double[] stdoriginalData={};
	int p;
	ARMAMath armamath=new ARMAMath();
	
	
	public AR(double [] stdoriginalData,int p)
	{
		this.stdoriginalData=stdoriginalData;
		this.p=p;
	}

	public Vector<double[]> ARmodel()
	{
		Vector<double[]> v=new Vector<double[]>();
		v.add(armamath.parcorrCompute(stdoriginalData, p, 0));
		return v;
		
		
	}
	
}


class MA {

	double[] stdoriginalData={};
	int q;
	ARMAMath armamath=new ARMAMath();
	
	
	public MA(double [] stdoriginalData,int q)
	{
		this.stdoriginalData=stdoriginalData;
		this.q=q;
	}

	public Vector<double[]> MAmodel()
	{
		Vector<double[]> v=new Vector<double[]>();
		v.add(armamath.getMApara(armamath.autocorGrma(stdoriginalData,q), q));
		return v;
	}
		
	
}
