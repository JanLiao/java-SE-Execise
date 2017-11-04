import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class LoginFrame extends JFrame{
	JLabel jl1=new JLabel("number");
	JLabel jl2=new JLabel("password");
	JTextField jt1=new JTextField(10);
	JPasswordField jt2=new JPasswordField(10);
	JButton jb1=new JButton("check");
	JButton jb2=new JButton("reset");
	public LoginFrame(){
		super("LoginFrame");
		init();
	}

	public void init(){
		JPanel jp=(JPanel)getContentPane();
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		jl1.setBounds(57,44,50,30);
		jt1.setBounds(107,44,108,28);
		jl2.setBounds(57,87,50,30);
		jt2.setBounds(107,87,108,28);
		jb1.setBounds(70,157,80,30);
		jb2.setBounds(160,157,80,30);
        jb1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		String cardid=(jt1.getText()).trim();
        		String pwd=(jt2.getText()).trim();
        		if(cardid==null||cardid.equals("")){
        			JOptionPane.showMessageDialog(LoginFrame.this,"please input card");
        		}else if(pwd==null||pwd.equals("")){
        			JOptionPane.showMessageDialog(LoginFrame.this,"please input pwd");
        		}
        	}
        });
        jb2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		jt1.setText("");
        		jt2.setText("");
        	}
        });
        jp.add(jl1);
        jp.add(jl2);
        jp.add(jt1);
        jp.add(jt2);
        jp.add(jb1);
        jp.add(jb2);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				LoginFrame lf=new LoginFrame();

			}
		});
	}
}