import java.awt.*;
import javax.swing.*;
public class JScrollPaneFrame extends JFrame{
	JScrollPane js=new JScrollPane();
	JTextArea jt=new JTextArea();

	public JScrollPaneFrame(){
		this.getContentPane().add(js,BorderLayout.CENTER);
        js.getViewport().add(jt);
		jt.setText("JTextArea");
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				JScrollPaneFrame jsc=new JScrollPaneFrame();
				jsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jsc.setSize(500,400);
				jsc.setVisible(true);
			}
		});
	}
}