import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.*;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

//implements ActionListener, ChangeListener 
public class JanPlayer1 extends JFrame implements ActionListener,ItemListener{
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel();
	JPanel jp5=new JPanel();
	JPanel jp6=new JPanel();
	JPanel jp7=new JPanel();
	JPanel jp8=new JPanel();
	JPanel jp9=new JPanel();
	JPanel jp10=new JPanel();
	JTable table;
	JScrollPane scr;
	JLabel label1=new JLabel();
	JComboBox<String> comBox;
	// comBox.addItem("顺序播放");
	// comBox.addItem("随机播放");
	JButton button1=new JButton("上一首");
	JButton button2=new JButton("播放");
	JButton button3=new JButton("下一首");
	JLabel label2;
	JLabel label3;
	JLabel label4=new JLabel();
	JLabel label5=new JLabel();
	JProgressBar progressBar;
	Timer timer;
	int startId=1;
	int playModel=1;
	String mp3Path;
	PlayThread pt=null;
	boolean flag=true;
	Random random;
	String mp3Time;
	int timerstart;
	int timetotal;

	public JanPlayer1(){
		super("播放器");
    	//musicTable();
		paint();
	}

	public void musicTable(){
		File dir=new File("D:\\KuGou\\music");
		String[] musicName=dir.list();
		if(musicName==null){
			System.out.println("目录不存在或文件为空");
		}else{
			int length=musicName.length;
			Object[][] obj=new Object[length][2];
			for(int i=0;i<musicName.length;i++){
				String filename=musicName[i];
				String[] str=filename.split(".");
				musicName[i]=str[0];
				obj[i][0]=i+1;
				obj[i][1]=str[0];
			}
			String[] columnMusic={"歌曲号","歌曲名"};
			table=new JTable(obj,columnMusic);
			table.setPreferredScrollableViewportSize(new Dimension(280,400));
			JScrollPane scr=new JScrollPane(table);
			jp3.add(scr,BorderLayout.CENTER);
		}
	}

	public void paint(){
		setBounds(80,50,950,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setLayout(new BorderLayout());
		jp1.setPreferredSize(new Dimension(950,450));
		jp2.setPreferredSize(new Dimension(950,80));
		getContentPane().add(jp1,BorderLayout.NORTH);
		getContentPane().add(jp2,BorderLayout.SOUTH);

		jp1.setLayout(new BorderLayout());
		jp3.setPreferredSize(new Dimension(300,420));
		jp4.setPreferredSize(new Dimension(580,420));
		jp1.add(jp3,BorderLayout.WEST);
		jp1.add(jp4,BorderLayout.EAST);

		File dir=new File("D:\\KuGou\\music");
		String[] musicName=dir.list();
		if(musicName==null){
			System.out.println("目录不存在或文件为空");
		}else{
			int length=musicName.length;
			System.out.println(length);
			Object[][] obj=new Object[length][2];
			for(int i=0;i<length;i++){
				String filename=musicName[i];
    			//System.out.println(filename);
				int size=filename.indexOf(".");
				String str=filename.substring(0,size);
    			// String[] str=filename.split(".");
    			//System.out.println(str);
    			//musicName[i]=str[0];
				obj[i][0]=i+1;
    			//System.out.println(obj[i][0]);
    			//obj[i][1]=musicName[i];
				obj[i][1]=str;
			}
			String[] columnMusic={"歌曲号","歌曲名"};
			table=new JTable(obj,columnMusic);
			table.setPreferredScrollableViewportSize(new Dimension(250,420));
			scr=new JScrollPane(table);
			jp3.add(scr,BorderLayout.CENTER);
			table.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(1);
    		//table.getColumn("歌曲号").setPreferredWidth(1);  两种设置列宽度都可以

			label1.setText("该区域用于显示歌词");
			label1.setFont(new java.awt.Font("Dialog",1,42));
			label1.setForeground(Color.blue);
			jp4.setLayout(new BorderLayout());
            //jp4.add(label4,BorderLayout.NORTH);
			jp4.add(label1,BorderLayout.CENTER);
    		//jp4.add(label5,BorderLayout.SOUTH);

			jp2.setLayout(new BorderLayout());
			jp5.setPreferredSize(new Dimension(425,80));
			jp6.setPreferredSize(new Dimension(475,80));
			jp2.add(jp5,BorderLayout.WEST);
			jp2.add(jp6,BorderLayout.EAST);

			jp5.setLayout(new FlowLayout(FlowLayout.LEFT));
			comBox=new JComboBox<String>();
			comBox.addItem("顺序播放");
			comBox.addItem("随机播放");
			comBox.addItemListener(this);
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
			jp5.add(comBox,BorderLayout.CENTER);
			jp5.add(button1,BorderLayout.CENTER);
			jp5.add(button2,BorderLayout.CENTER);
			jp5.add(button3,BorderLayout.CENTER);

			jp6.setLayout(new BorderLayout());
			jp7.setPreferredSize(new Dimension(475,40));
			jp8.setPreferredSize(new Dimension(475,40));
			jp6.add(jp7,BorderLayout.NORTH);
			jp6.add(jp8,BorderLayout.SOUTH);

			jp8.setLayout(new FlowLayout(FlowLayout.LEFT));
			progressBar=new JProgressBar();
			progressBar.setOrientation(JProgressBar.HORIZONTAL);
			progressBar.setMinimum(0);
			progressBar.setMaximum(100);
			progressBar.setValue(0);
            //progressBar.addChangeListener(this);
			progressBar.setPreferredSize(new Dimension(465,8));
			progressBar.setBorderPainted(false);
			progressBar.setForeground(new Color(55,165,228));
			progressBar.setBackground(new Color(218,218,218));
            timer=new Timer(990,this);
			jp8.add(progressBar);

			jp7.setLayout(new BorderLayout());
			jp9.setPreferredSize(new Dimension(220,40));
			jp10.setPreferredSize(new Dimension(200,40));
			jp7.add(jp9,BorderLayout.WEST);
			jp7.add(jp10,BorderLayout.EAST);

			jp9.setLayout(new FlowLayout(FlowLayout.LEFT));
			label2=new JLabel("歌曲名",JLabel.LEFT);
			label3=new JLabel("00:00/00:00",JLabel.RIGHT);
			label2.setFont(new java.awt.Font("Dialog",1,15));
			label2.setForeground(Color.red);
			jp9.add(label2);
			jp10.setLayout(new FlowLayout(FlowLayout.RIGHT));
			jp10.add(label3);
		}
	}

	public void playerMp3(String mp3Path){
		BufferedInputStream buffer = null;

        /**
         * 获取文件数据流
         */
        try {
        	buffer = new BufferedInputStream(new FileInputStream(mp3Path));
        } catch (Exception e) {
            // try {
            //     buffer = new BufferedInputStream(new URL(mp3Path).openStream());
            // } catch (Exception e1) {
            //     e1.printStackTrace();
            // }
        }

        try {
        	Player player = new Player(buffer);
        	player.play();
        } catch (JavaLayerException e) {
        	e.printStackTrace();
        }
    }

    class PlayThread extends Thread{
    	String mp3Path1;
    	public PlayThread(String mp3Path1){
    		this.mp3Path1=mp3Path1;
    		// String mp3Time=getMp3Time(mp3Path);
		    // label3.setText("00:00/"+mp3Time);
    	}


    	public void run(){
    		//System.out.println(mp3Path1);
    		BufferedInputStream buffer = null;

        /**
         * 获取文件数据流
         */
        try {
        	buffer = new BufferedInputStream(new FileInputStream(mp3Path1));
        } catch (Exception e) {
            // try {
            //     buffer = new BufferedInputStream(new URL(mp3Path).openStream());
            // } catch (Exception e1) {
            //     e1.printStackTrace();
            // }
        }

        try {
        	Player player = new Player(buffer);
        	player.play();
        } catch (JavaLayerException e) {
        	e.printStackTrace();
        }
    }
}

public void itemStateChanged(ItemEvent e){
	if(e.getStateChange()==ItemEvent.SELECTED){
		String s=(String) comBox.getSelectedItem();
		if(s.equals("随机播放")){
			playModel=2;
			System.out.println(playModel);
		}else{
			playModel=1;
			System.out.println(playModel);
		}
	}
}

public String getMp3Time(String mp3Path) {
 
        try {
            File file = new File(mp3Path);
 
            if (file.exists() && file.isFile()) {
                FileInputStream fis = new FileInputStream(file);
                int bytes = fis.available();
 
                Bitstream bit = new Bitstream(fis);
                Header header = bit.readFrame();
                long time = (long) header.total_ms(bytes);
                System.out.println(time);
 
                return formatTime(time);
            }
        } catch (IOException | BitstreamException e) {
            System.out.println(e);
        }
 
        return null;
    }

public String formatTime(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
 
        return dateFormat.format(calendar.getTime());
    }

public int timeAll(String mp3Time){
	String s[]=mp3Time.split(":");
	return 60*(Integer.parseInt(s[0]))+Integer.parseInt(s[1]);
}

public String translate(int timerstart){
	int t=timerstart/60;
	int t1=timerstart%60;
	if(t<10){
		if(t1<10){
			return "0"+t+":"+"0"+t1;
		}else{
			return "0"+t+":"+t1;
		}
	}else{
		if(t1<10){
			return t+":"+"0"+t1;
		}else{
			return t+":"+t1;
		}
	}
}

public void actionPerformed(ActionEvent e1){
	File dir=new File("D:\\KuGou\\music");
	String[] musicName=dir.list();
	if(e1.getSource()==button2){
		int size=musicName[startId-1].indexOf(".");
		String str=musicName[startId-1].substring(0,size);
		//String s=label2.getText();
		label2.setText(str);
		//System.out.println(label2.getText());
		mp3Path="D:\\KuGou\\music\\"+musicName[startId-1];
		mp3Time=getMp3Time(mp3Path);
		timetotal=timeAll(mp3Time);
		System.out.println(timetotal);
		label3.setText("00:00/"+mp3Time);
		timer.start();
    		//playerMp3(mp3Path);
		if(pt==null){
			pt=new PlayThread(mp3Path);
			pt.start();
		}else{

		}
	}else if(e1.getSource()==button3){
		timerstart=0;
		progressBar.setValue(0);
		if(playModel==1){

			if(startId<musicName.length){
				startId++;
				mp3Path="D:\\KuGou\\music\\"+musicName[startId-1];
				mp3Time=getMp3Time(mp3Path);
				timetotal=timeAll(mp3Time);
		        label3.setText("00:00/"+mp3Time);
		        timer.start();
    		    // playerMp3(mp3Path);
				int size=musicName[startId-1].indexOf(".");
				String str=musicName[startId-1].substring(0,size);
		//String s=label2.getText();
				label2.setText(str);
				if(pt==null){
					pt=new PlayThread(mp3Path);
					pt.start();
				}else{

    		    pt.stop();  //方法已被弃用
    		    pt=new PlayThread(mp3Path);
    		    pt.start();
    		}
    	}else{
    		startId=1;
    		mp3Path="D:\\KuGou\\music\\"+musicName[startId-1];
    		mp3Time=getMp3Time(mp3Path);
    		timetotal=timeAll(mp3Time);
		    label3.setText("00:00/"+mp3Time);
		    timer.start();
    		    //playerMp3(mp3Path);
    		int size=musicName[startId-1].indexOf(".");
    		String str=musicName[startId-1].substring(0,size);
		//String s=label2.getText();
    		label2.setText(str);
    		if(pt==null){
    			pt=new PlayThread(mp3Path);
    			pt.start();
    		}else{

    			pt.stop();
    			pt=new PlayThread(mp3Path);
    			pt.start();
    		}
    	}
    }else if(playModel==2){
    	random=new Random();
    	startId=random.nextInt(musicName.length)%(musicName.length);
    	String mp3Path="D:\\KuGou\\music\\"+musicName[startId-1];
    	mp3Time=getMp3Time(mp3Path);
    	timetotal=timeAll(mp3Time);
		label3.setText("00:00/"+mp3Time);
		timer.start();
    		    // playerMp3(mp3Path);
    	int size=musicName[startId-1].indexOf(".");
    	String str=musicName[startId-1].substring(0,size);
		//String s=label2.getText();
    	label2.setText(str);
    	if(pt==null){
    		pt=new PlayThread(mp3Path);
    		pt.start();
    	}else{

    		pt.stop();
    		pt=new PlayThread(mp3Path);
    		pt.start();
    	}
    }else{}
}else if(e1.getSource()==button1){
	timerstart=0;
	progressBar.setValue(0);
	if(playModel==1){

		if(startId==1){
			startId=musicName.length;
			String mp3Path="D:\\KuGou\\music\\"+musicName[startId-1];
			mp3Time=getMp3Time(mp3Path);
			timetotal=timeAll(mp3Time);
		    label3.setText("00:00/"+mp3Time);
		    timer.start();
    		    // playerMp3(mp3Path);
			int size=musicName[startId-1].indexOf(".");
			String str=musicName[startId-1].substring(0,size);
		//String s=label2.getText();
			label2.setText(str);
    		//System.out.println(mp3Path);
    		//playerMp3(mp3Path);
			if(pt==null){
				pt=new PlayThread(mp3Path);
				pt.start();
			}else{

				pt.stop();
				pt=new PlayThread(mp3Path);
				pt.start();
			}


		}else{
			startId=startId-1;
			String mp3Path="D:\\KuGou\\music\\"+musicName[startId-1];
			mp3Time=getMp3Time(mp3Path);
			timetotal=timeAll(mp3Time);
		    label3.setText("00:00/"+mp3Time);
		    timer.start();
    		    // playerMp3(mp3Path);
			int size=musicName[startId-1].indexOf(".");
			String str=musicName[startId-1].substring(0,size);
		//String s=label2.getText();
			label2.setText(str);
    		//System.out.println(mp3Path);
			if(pt==null){
				pt=new PlayThread(mp3Path);
				pt.start();
			}else{

				pt.stop();
				pt=new PlayThread(mp3Path);
				pt.start();
			}
		}
	}else if(playModel==2){
		random=new Random();
		startId=random.nextInt(musicName.length)%(musicName.length);
		String mp3Path="D:\\KuGou\\music\\"+musicName[startId-1];
		mp3Time=getMp3Time(mp3Path);
		timetotal=timeAll(mp3Time);
		label3.setText("00:00/"+mp3Time);
		timer.start();
    		    // playerMp3(mp3Path);
		int size=musicName[startId-1].indexOf(".");
		String str=musicName[startId-1].substring(0,size);
		//String s=label2.getText();
		label2.setText(str);
		if(pt==null){
			pt=new PlayThread(mp3Path);
			pt.start();
		}else{

			pt.stop();
			pt=new PlayThread(mp3Path);
			pt.start();
		}
	}else{}
}else if(e1.getSource()==timer){
	int value;

	    timerstart++;
	    String ss=translate(timerstart);
	    value=100*timerstart/timetotal;
        //int value=progressBar.getValue();
        if(value<=100){
        	progressBar.setValue(value);
        }else{
        	timer.stop();
        }
	    label3.setText(ss+"/"+mp3Time);
}else{}
}

public static void main(String[] args){
	SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			JanPlayer1 jplayer=new JanPlayer1();
			jplayer.setVisible(true);
		}
	});
}
}