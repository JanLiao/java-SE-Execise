	import java.awt.*;
	import javax.swing.*;
	public class MyBorderLayout extends JFrame{
		private String name[]={"east","south","west","north","center"};
		private JButton button[]=new JButton[name.length];
		private JPanel contentPane;

		public MyBorderLayout(){
			super("this frame");
		}

		public void init(){
			JFrame jf=new JFrame();
			jf.setSize(500,400);
			contentPane=new JPanel();
			contentPane.setLayout(new BorderLayout(5,5));
			for(int i=0;i<name.length;i++){
				button[i]=new JButton((name[i]));
			}

			contentPane.add(button[0],BorderLayout.EAST);
			contentPane.add(button[1],BorderLayout.SOUTH);
			contentPane.add(button[2],BorderLayout.WEST);
			contentPane.add(button[3],BorderLayout.NORTH);
			contentPane.add(button[4],BorderLayout.CENTER);
			jf.getContentPane().add(contentPane);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setVisible(true);
		}

		public static void main(String[] args){
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					MyBorderLayout app= new MyBorderLayout();
					app.init();
				}
			});
		}
	}