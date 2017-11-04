import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyCardLayout extends JFrame implements ActionListener{
	private CardLayout cardLayout1;
	private String name[]={"C","UML","Java","Oracle"};
	private JLabel card[]=new JLabel[name.length];
	private JPanel cp,sp;
	private JButton previous=new JButton("previous");
	private JButton next=new JButton("next");

	public MyCardLayout(){
		super("this");
	}

	public void init(){
		JFrame jf=new JFrame("hai");
		cardLayout1=new CardLayout();
		cp=new JPanel();
		cp.setLayout(cardLayout1);
		for(int i=0;i<name.length;i++){
			card[i]=new JLabel(name[i]);
			cp.add(name[i],card[i]);
		}

		sp=new JPanel();
		sp.add(previous);
		sp.add(next);
		jf.setLayout(new FlowLayout(FlowLayout.CENTER));
		jf.add(sp);
		jf.add(cp);
		previous.addActionListener(this);
		next.addActionListener(this);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500,400);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		String command=e.getActionCommand();
		if(command.equals("previous")){
			cardLayout1.previous(cp);
		}else if(command.equals("next")){
			cardLayout1.next(cp);
		}
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MyCardLayout app=new MyCardLayout();
				app.init();
			}
		});
	}
}