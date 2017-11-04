import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JRadioButtonFrame extends JFrame{
	JRadioButton malebutton=new JRadioButton();
	JRadioButton femalebutton=new JRadioButton();
	JTextField textField=new JTextField();
	ButtonGroup group=new ButtonGroup();

	public JRadioButtonFrame(){
		try{
			init();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void init() throws Exception{
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JRadioButton");
		JPanel jp=(JPanel)getContentPane();
		jp.setLayout(null);
		malebutton.setText("male");
		femalebutton.setText("female");
		femalebutton.setBounds(57,100,108,28);
		malebutton.setBounds(57,44,123,30);
		textField.setBounds(62,155,173,36);
		malebutton.addActionListener(new MyActionListener());
		femalebutton.addActionListener(new MyActionListener());
		jp.add(malebutton);
		jp.add(femalebutton);
		jp.add(textField);
		// malebutton.setActionCommand("male");
		// femalebutton.setActionCommand("female");
		group.add(malebutton);
		group.add(femalebutton);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//这是窗口外观的美化
				try{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}catch(Exception e){
					e.printStackTrace();
				}
				JRadioButtonFrame jr=new JRadioButtonFrame();
				jr.setVisible(true);
			}
		});
	}

    class MyActionListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    	 String str=e.getActionCommand();

         //String str=group.getSelection().getActionCommand();两种都可以
         textField.setText(str);
         String str1=textField.getText();
    	 System.out.println(str1);
    	}
	}
}