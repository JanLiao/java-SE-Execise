import java.awt.*;
import javax.swing.*;
public class DrawFrame extends JFrame{
	private DrawPanel dp=new DrawPanel();

	public DrawFrame(){
		getContentPane().add(dp);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				DrawFrame df=new DrawFrame();
			}
		});
	}
}

class DrawPanel extends JPanel{
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D)g;
		g2.drawRect(20,20,240,150);
		g2.drawOval(20,20,240,150);
	}
}