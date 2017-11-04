import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingClient{
	JFrame jf = new JFrame("聊天客户端");
	JTextArea jt = new JTextArea();
	JTextField jtf = new JTextField(15);
	OutputStreamWriter osw = null;
	public static void main(String[] args){
		SwingClient sc = new SwingClient();
		try{
			sc.createForm();
			sc.clientStart("localhost", 8888);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//创建客户端用户的图形窗体
	public void createForm(){
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().add(jt, BorderLayout.CENTER);
		JButton jb = new JButton("发送");
		SendButtonAction sendAction = new SendButtonAction();
		jb.addActionListener(sendAction);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jf.getContentPane().add(jp, BorderLayout.SOUTH);
		jf.setSize(300, 200);
		jf.setVisible(true);
	}

	//创建客户端Socket,连接服务器
	public void clientStart(String ip, int port) throws Exception{
		Socket s = new Socket(ip, port);
		osw = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
		//打开一个接受消息的线程
		new MySocketReadServer(s).start();
	}

	//添加按钮事件
	class SendButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			String msg = jtf.getText();
			jtf.setText("");
			if("".equals(msg)){
				JOptionPane.showMessageDialog(jf, "发送的内容为空");
				return ;
			}
			try{
				PrintWriter pw = new PrintWriter(osw, true);
				pw.println(msg);
				pw.flush();
			}catch(Exception e){
				JOptionPane.showMessageDialog(jf, "发送失败,请重试!");
				e.printStackTrace();
			}
		}
	}

	//接受消息
	class MySocketReadServer extends Thread{
		private Socket s;
		public MySocketReadServer(Socket s){
			this.s = s;
		}
		public void run(){
			try{
				InputStreamReader isr = new InputStreamReader(s.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				while(true){
					String msg = jt.getText()+"\n\r"+br.readLine();
					jt.setText(msg);
					if("88".equals(msg)){
						break;
					}
				}
			}catch(Exception e){
				System.out.println("已退出聊天室");
			}
		}
	}
}