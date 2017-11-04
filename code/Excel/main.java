import java.io.*;
public class main{
	public static void main(String[] args){
		File oldName = new File("D:/filesystem/2017/arrayTest.class");
        File newName = new File("D:/filesystem/2017/java.txt");
        if(oldName.renameTo(newName)) {
            System.out.println("已重命名");
        } else {
            System.out.println("Error");
        }
        File file = new File("D:/filesystem/2017/java.txt");
        if(file.exists()){
        	System.out.println("已经存在");
        }
    }
}