import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class UseDialog extends JFrame{
	JMenuBar jm=new JMenuBar();
	JMenu jmFile=new JMenu();
	JMenuItem jmAbout=new JMenuItem();

	public UseDialog(){
		this.setJMenuBar(jm);
		jmFile.setText("File");
		jmAbout.setText("about");
		jm.add(jmFile);
		jmFile.add(jmAbout);
        jmAbout.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		AboutDialog dlg=new AboutDialog(UseDialog.this);
        		//dlg.setSize(500,400);
        		//dlg.setBounds(100,100,200,200);
        		//dlg.getPreferredSize();
        		dlg.setModal(true);
        		dlg.pack();
        		dlg.setVisible(true);
        	}
        });
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				UseDialog ud=new UseDialog();
				ud.setSize(500,400);
				ud.setVisible(true);
				ud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	class AboutDialog extends JDialog{
		JLabel jl=new JLabel();
		public AboutDialog (UseDialog parent){
			//super(parent);
			setTitle("about");
			jl.setText("cccc");
			getContentPane().add(jl);
		}
	}
}