import java.io.*;
import java.lang.Math;
public class DoData{
	public static void main(String[] args){
		int[] data=new int[4000];
		for(int i=0;i<4000;i++){
			data[i]=0;
		}
		try{
			File f=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/data.txt");
		    FileReader fr=new FileReader(f);
		    BufferedReader br=new BufferedReader(fr);
		    String line=br.readLine();
		    //line=br.readLine();
		    while(line!=null){
		    	String[] str=line.split(",");
		    	int id=Integer.parseInt(str[0]);
		    	int quantity=Integer.parseInt(str[2]);
		    	data[id-1]+=quantity;
		    	line=br.readLine();
		    }
		    br.close();
		    fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}

        try{
        	File f1=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/count2.txt");
		    FileWriter fw=new FileWriter(f1);
		    BufferedWriter bw=new BufferedWriter(fw);
		    for(int i=0;i<4000;i++){
			    
			    //int k1=Math.ceil(data[i]/23);
			    if(data[i]%23==0){
			    	bw.write((i+1)+","+data[i]/23);
			        bw.newLine();
			    }else{
			    	int k=(int)data[i]/23+1;
			    	bw.write((i+1)+","+k);
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