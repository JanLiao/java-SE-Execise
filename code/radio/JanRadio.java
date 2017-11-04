import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JanRadio extends JFrame implements ActionListener, ChangeListener {
	JButton jb1=new JButton("aaa1");
	JButton jb2=new JButton("aaa2");
	JButton jb3=new JButton("上一首");
	JButton jb4=new JButton("播放");
	JButton jb5=new JButton("下一首");
	JButton jb6=new JButton("开始");
	JButton jb7=new JButton("暂停");
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel();
	JProgressBar progressbar;
	Timer timer;
	JLabel label=new JLabel();
	int k=0;

	public JanRadio(){
        super("播放器");
        paint();
	}

	public void paint(){
		//setSize(1000,400);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		jp1.setPreferredSize(new Dimension(1000, 350));
		jp2.setPreferredSize(new Dimension(1000, 200));
		getContentPane().add(jp1,BorderLayout.NORTH);
		getContentPane().add(jp2,BorderLayout.SOUTH);
		jb6.addActionListener(this);
		jb7.addActionListener(this);

		jp3.setPreferredSize(new Dimension(300, 350));
		jp4.setPreferredSize(new Dimension(700, 350));
		jp1.setLayout(new BorderLayout());
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.add(jp3,BorderLayout.WEST);
		jp1.add(jp4,BorderLayout.EAST);


        progressbar=new JProgressBar();
        progressbar.setOrientation(JProgressBar.HORIZONTAL);
        progressbar.setMinimum(0);
        progressbar.setMaximum(100);
        progressbar.setValue(0);
        progressbar.addChangeListener(this);
        progressbar.setBorderPainted(false);
        progressbar.setForeground(new Color(55,165,228));
        progressbar.setBackground(new Color(218,218,218));
        
        timer=new Timer(100,this);
		jp3.add(jb1);
		jp4.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(progressbar);
		jp2.add(jb6);
		jp2.add(jb7);
		jp2.add(label);
		setBounds(80,50,1000,650);
	}

    public void actionPerformed(ActionEvent e){
    	//System.out.println("b-----------------");
    	if(e.getSource()==jb6){
    		timer.start();
    	}
    	if(e.getSource()==jb7){
    		timer.stop();
    	}
    	if(e.getSource()==timer){
    		int value=progressbar.getValue();
    		System.out.println(++k);
    		if(value<100){
    			progressbar.setValue(++value);
    		}else{
    			timer.stop();
    		}
    	}
    	//System.out.println("e---------------");
    }

    public void stateChanged(ChangeEvent e1){
    	int value=progressbar.getValue();
    	if(e1.getSource()==progressbar){
    		label.setText("目前已完成进度：" + Integer.toString(value) + "%");
    		label.setForeground(Color.blue);
    		//label.setForeground(Color.red);
    	}
    }

	public static void main(String[] args){
		JanRadio jRadio=new JanRadio();
	}
}