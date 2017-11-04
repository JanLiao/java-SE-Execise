import java.util.*;
//import java.util.Timer;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class LambdaTest {

	public void test(){
		// Timer t=new Timer(2000,this);
		// t.start();
		//while(true);
	}

	// public void actionPerformed(ActionEvent e){
	// 	System.out.println("sss");
	// }

	public static void main(String[] args){
		String[] array={"liao","jing","an","liu","fang"};
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		Arrays.sort(array,(first,second) -> first.length()-second.length());
		System.out.println(Arrays.toString(array));

        // LambdaTest tes=new LambdaTest();
        // tes.test();
        Timer t=new Timer(2000,event -> 
			{
				System.out.println("The time is:"+new Date());
			});
		t.start();
		//while(true);
	
	}
}