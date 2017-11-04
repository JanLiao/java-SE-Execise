import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TestLayout extends JFrame{
	public TestLayout(){
		//JPanel jp=new JPanel();
		setLayout(null);
		Container c=getContentPane();
		JButton jb=new JButton("pass");
		jb.setBounds(10,30,80,30);
		c.add(jb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args){
		new TestLayout();
	}
}