import java.io.*;

public class InputTest{
	public static void main(String[] args){
		byte[] arr = new byte[1000];
		try{
			File file = new File("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			FileInputStream isr = new FileInputStream(file);
			for(int i=0;i<1000;i++){
				int b = isr.read();
				arr[i] = (byte)b;
				if(b==-1) break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		for(int i=0;i<300;i++){
			System.out.print(arr[i]);
			System.out.print(" ");
		}

		System.out.println();
		byte[] array = new byte[1024];
		int start = 0;
		int end = 1024;
		try{
			File ff = new File("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			FileInputStream ffs = new FileInputStream(ff);
			while(start<end){
				int result = ffs.read(array, start, end-start);
				System.out.println("result="+result);
				if(result==-1) break;
				start = start+result;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}