import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class MenuFrame extends JFrame{
	JPanel jp;
	JMenuBar jmb=new JMenuBar();
	JMenu jm1=new JMenu();
	JMenu jm2=new JMenu();
	JMenuItem jmi1=new JMenuItem();
	JMenuItem jmi2=new JMenuItem("open");
	JMenuItem jmi3=new JMenuItem();
	JMenuItem jmi4=new JMenuItem("exit");
	JMenu jm3=new JMenu();
	public MenuFrame(){
		try{
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.init();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void init() throws Exception{
		jp=(JPanel)getContentPane();
		jp.setLayout(null);
		setSize(new Dimension(500,400));
		setJMenuBar(jmb);
		jm1.setText("文件");
		jm2.setText("编辑");
		jm3.setText("帮助");
		jmi1.setText("新建");
		//jmi2.setText("打开")；
		jmi2.setText("打开");
		jmi3.setText("保存");
		//jmi4.setText("退出")；
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		//jp.add(jmb);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		jmi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(-1);
			}
		});
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MenuFrame mf=new MenuFrame();
			}
		});
	}
}