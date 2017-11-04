import java.io.*;
public class data{
    public static void main(String[] args){
	    int[][] numData=new int[4000][23];
	    for(int i=0;i<4000;i++){
		    for(int j=0;j<23;j++){
			   numData[0][0]=0;
		    }
	    }
	    String line;
	    try{
	        File f=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/product_quantity1.txt");
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            line=br.readLine();
            while(line!=null){
        	    String[] str=line.split(",");
                int m,n;
                m=Integer.parseInt(str[0])-1;
                n=12*(Integer.parseInt(str[1].substring(0,4))-2014)+Integer.parseInt(str[1].substring(5,7))-1;
                numData[m][n]+=Integer.parseInt(str[6]);
                line=br.readLine();
            }
            br.close();
            fr.close();
	        }catch(Exception e){
		      e.printStackTrace();
	        }
	    // for(int i=0;i<3;i++){
		   //   for(int j=0;j<23;j++){
			  //   System.out.println((i+1)+","+numData[i][j]);
		   //  }
	    // }
	        try{
	        	File f1=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/bb.txt");
	        	FileWriter fw=new FileWriter(f1);
	        	BufferedWriter bw=new BufferedWriter(fw);
	        	 for(int i=0;i<4000;i++){
		             for(int j=0;j<23;j++){
		             	if(j<12){
		             		//System.out.println((i+1)+","+"2014-"+(j+1)+numData[i][j]);
		             		bw.write((i+1)+","+"2014-"+(j+1)+","+numData[i][j]);
		             		bw.newLine();
		             	}
			            else{
                             //System.out.println((i+1)+","+"2015-"+(j-11)+numData[i][j]);
                             bw.write((i+1)+","+"2015-"+(j-11)+","+numData[i][j]);
                             bw.newLine();
			            }
		            }
	             }
	             bw.close();
	             fw.close();
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
    }
}