import java.awt.*;
import javax.swing.*;

public class FrameTest{
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				HelloWorld frame=new HelloWorld();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}

class HelloWorld extends JFrame{
	JPanel contentPane;
	BorderLayout borderLayout1=new BorderLayout();
	public HelloWorld(){
		contentPane=(JPanel) getContentPane();
		JLabel label=new JLabel("Hello World");
		contentPane.add(label,BorderLayout.CENTER);
		setTitle("HelloFrame");
		setSize(new Dimension(400,300));
	}
}