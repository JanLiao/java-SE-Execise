import java.io.*;
public class TestFile{
	public static void main(String[] args){
			File f=new File("D:\\99客服\\a.txt");
			if(f.exists()){
				f.delete();
				System.out.println("File is exist");
			}else{
				try{
					f.createNewFile();
					System.out.println("File is created");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			File f1=new File("C:/");
			File[] filelist=f1.listFiles();
			for(int i=0;i<filelist.length;i++){
				if(filelist[i].isFile()){
					System.out.println("文件="+filelist[i]);
				}
				else{
					System.out.println("目录="+filelist[i]);
				}
			}
	}
}