import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class PopMenuFrame extends JFrame{
	JPanel jp;
	BorderLayout borderLayout=new BorderLayout();
	JPopupMenu popupMenu=new JPopupMenu();
	JMenuItem mnuCopy=new JMenuItem("copy");
	JMenuItem mnuCut=new JMenuItem("cut");

	JTextArea jTextArea=new JTextArea();

	public PopMenuFrame(){
		jp=(JPanel)getContentPane();
		jp.setLayout(borderLayout);
		setSize(500,400);
		setTitle("PopMenuFrame");
		popupMenu.add(mnuCopy);
		popupMenu.add(mnuCut);
		jTextArea.setComponentPopupMenu(popupMenu);
		jp.add(jTextArea,BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				PopMenuFrame pmf=new PopMenuFrame();
			}
		});
	}
}