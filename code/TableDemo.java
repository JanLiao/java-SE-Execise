import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class TableDemo extends JFrame{
	private boolean DEBUG=true;

	public TableDemo(){
		Object[][] data={
			{"mary","campione","snowboarding",new Integer(5),new Boolean(false)},
			{"alison","huml","rowing",new Integer(3),new Boolean(true)},
			{"kathy","walrath","chasing toddlers",new Integer(2),new Boolean(false)},
			{"sharon","zakhour","speed reading",new Integer(6),new Boolean(false)},
			{"angela","lih","teaching",new Integer(8),new Boolean(true)}
		};

		String[] columnNames={"First Name","Last Name","Sport","# of Years","Vegetarian"};
		final JTable table=new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));

		if(DEBUG){
			table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					printDebugData(table);
				}
			});
		}

		JScrollPane scr=new JScrollPane(table);

		getContentPane().add(scr,BorderLayout.CENTER);

		addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent e){
             	System.exit(0);
             }
		});
	}

	private void printDebugData(JTable table1){
		int numRows=table1.getRowCount();
		int numCols=table1.getColumnCount();
		TableModel model=table1.getModel();
		//两种方法都可以
		//javax.swing.table.TableModel model=table1.getModel();

		System.out.println("Value of data:");
		for(int i=0;i<numRows;i++){
			System.out.print("   row  "+i+":");
			for(int j=0;j<numCols;j++){
				System.out.print("   "+model.getValueAt(i,j));
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				TableDemo frame=new TableDemo();
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}