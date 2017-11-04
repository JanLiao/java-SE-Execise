import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FrameW extends JFrame implements WindowListener{
	public FrameW(){
		this.setSize(500,400);
		this.addWindowListener(this);
	}

    public void windowClosing(WindowEvent e){
    	System.out.println("Frame will close");
    	System.exit(1);
    }

	public void windowClosed(WindowEvent e){
        System.out.println("Frame closed");
	}

	public void windowOpened(WindowEvent e){

	}

	public void windowIconified(WindowEvent e){

	}

	public void windowDeiconified(WindowEvent e){

	}

	public void windowActivated(WindowEvent e){

	}

	public void windowDeactivated(WindowEvent e){

	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				FrameW app=new FrameW();
				app.setVisible(true);
			}
		});
	}
}