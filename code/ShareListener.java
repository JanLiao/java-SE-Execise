import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class ShareListener extends JFrame{
	private JButton jb1=new JButton("north");
	private JButton jb2=new JButton("south");
	private JButton jb3=new JButton("east");
	private JButton jb4=new JButton("west");
	private JPanel jp;
	JTextField textField =new JTextField();
	public ShareListener(){
		try{
			jbInit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void jbInit() throws Exception{
		jp=(JPanel) getContentPane();
		setLayout(new BorderLayout(5,5));
        jb1.addActionListener(new MyActionListener());
        jb2.addActionListener(new MyActionListener());
        jb3.addActionListener(new MyActionListener());
        jb4.addActionListener(new MyActionListener());
		jp.add(jb1,BorderLayout.NORTH);
		jp.add(jb2,BorderLayout.SOUTH);
		jp.add(jb3,BorderLayout.EAST);
		jp.add(jb4,BorderLayout.WEST);
		jp.add(textField,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setVisible(true);
	}

class MyActionListener implements ActionListener{
	// private ShareListener adaptee;
	// MyActionListener(){
	// 	this.adaptee=adaptee;
	// }
	public void actionPerformed(ActionEvent e){
		String str=e.getActionCommand();
		textField.setText("You pass :"+str);
	}
} 

     public static void main(String[] args){
     	SwingUtilities.invokeLater(new Runnable(){
     		public void run(){
     			ShareListener shareListener=new ShareListener();
     		}
     	});
     }
}