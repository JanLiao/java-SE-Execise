import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonEventFrame extends JFrame{
	 private JPanel contentPane;
     private JButton jb=new JButton("click me");
     private JTextField textField =new JTextField("You click button 0 Times",30);
     private int clickCount=0;

    public ButtonEventFrame(){
    	super("ButtonEventFrame");
    }

    public void init(){
    	contentPane=(JPanel) getContentPane();
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(new FlowLayout());
    	contentPane.add(jb);
    	contentPane.add(textField);
    	jb.addActionListener(new ButtonEvent());
    	setSize(500,400);
    	setVisible(true);
    }

    public static void main(String[] args){
    	SwingUtilities.invokeLater(new Runnable(){
    		public void run(){
    	ButtonEventFrame app=new ButtonEventFrame();
    	app.init();
    		}
    	});
    }


class ButtonEvent implements ActionListener{
	    //int clickCount=5;
        public void actionPerformed(ActionEvent e){
        	clickCount++;
        	textField.setText("You click Button on "+" "+clickCount+" "+" Times");
        }
    }
}