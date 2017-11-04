import java.awt.*;
import javax.swing.*;
public class MyLayout{
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;

	public MyLayout(){
		JFrame jf=new JFrame("this");
		JPanel jp=new JPanel();
		jb1=new JButton("left");
		jb2=new JButton("center");
		jb3=new JButton("right");
		jp.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jf.getContentPane().add(jp);
		jf.setSize(500,400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				 new MyLayout();
			}
		});

	}
}