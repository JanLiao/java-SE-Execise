import java.io.*;
public class Encrypt{
	private static final int PWD=0x3f2e8dac;
	private static final String SUFFIX=".ee";

	//进行加密处理
	public void doEncrypt(String path){
		FileInputStream in=null;
		FileOutputStream out=null;
		try{
			int tmp=0;
			File inFile=new File(path);
			in=new FileInputStream(inFile);
			System.out.println("1111");
			File outFile=new File(path+SUFFIX);
			out=new FileOutputStream(outFile);
			while((tmp=in.read())!=-1){
				out.write(tmp^PWD);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(in!=null){
					in.close();
				}
				if(out!=null){
					out.close();
				}
			}catch(Exception e){
				System.out.println("关闭失败");
				e.printStackTrace();
			}
		}
	}

		//解密
		public void doDecrypt(String path){
			int index=path.lastIndexOf(SUFFIX);
			if(index!=path.length()-SUFFIX.length()){
				System.out.println("文件类型不正确，请重新输入----");
				return ;
			}
			FileInputStream in=null;
			FileOutputStream out=null;
			try{ 
                File inFile=new File(path);
                int tmp=0;
                in=new FileInputStream(inFile);
                String name=path.substring(0,index);
                File outFile=new File(name);
                out=new FileOutputStream(outFile);
                while((tmp=in.read())!=-1){
                	out.write(tmp^PWD);
                }
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{

				if(in!=null){
					in.close();
				}
				if(out!=null){
					out.close();
				}
				}catch(Exception e){
					System.out.println("关闭失败");
					e.printStackTrace();
				}
			}
		}

		public static void main(String[] args){
			Encrypt e=new Encrypt();
			if(args.length!=2){
				System.out.println("输入参数个数不对");
				return ;
			}

			if(args[0].equalsIgnoreCase("Encrypt")){
				e.doEncrypt(args[1]);
			}

			if(args[0].equalsIgnoreCase("Decrypt")){
				e.doDecrypt(args[1]);
			}
		}
	
}