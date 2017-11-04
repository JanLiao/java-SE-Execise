import java.awt.*;
import javax.swing.*;
public class JTextFieldTest extends JFrame{
	JTextField textField=new JTextField(30);
	JPanel jp;
	public JTextFieldTest(){
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		jp=(JPanel)getContentPane();
		setLayout(new FlowLayout());
		jp.add(textField);
		textField.setText("455");
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				JTextFieldTest jt=new JTextFieldTest();
			}
		});
	}
}