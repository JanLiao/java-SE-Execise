import java.awt.*;
import javax.swing.*;

public class JPanelDemo{
	public static void main(String[] args){
		JFrame frame=new JFrame("JPanelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		JPanel jp=new JPanel();
		jp.setSize(100,100);
		jp.setBackground(Color.RED);
		JLabel jl=new JLabel("Hello World!");
		jp.add(jl);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(jp);
		frame.setVisible(true);
	}
}