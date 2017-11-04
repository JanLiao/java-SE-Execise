import java.sql.*;
import java.io.*;
public class SqlConnection{
	Connection conn=null;
	Statement stm=null;
	ResultSet res=null;
	String url="jdbc:mysql://localhost:3306/login";
	String user="root";
	String pwd="a123456";
	public SqlConnection(){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			com.mysql.jdbc.Driver driver=new com.mysql.jdbc.Driver();
			conn=DriverManager.getConnection(url,user,pwd);
			if(conn!=null){
				System.out.println("Driver success!");
			}else{
				System.out.println("Driver failed");
			}

			stm=conn.createStatement();
			res=stm.executeQuery("select * from user");
			while(res.next()){
				System.out.println(res.getString(1)+ "  "+
					res.getString(2)+"  "+
					res.getString(3));
				//System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new SqlConnection();
	}
}