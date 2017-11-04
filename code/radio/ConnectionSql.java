import java.sql.;
import java.io.*;
public class ConnectionSql{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/";
	String user="root";
	String pwd="a123456";
	Connection conn;
	public ConnectionSql(){
		try{
			Class.forName("driver");
		}catch(Exception e){
			e.printStackTrace();
		}

		try{
			conn=DriverManager.getConnection(url,user,pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void close(){
		conn.close();
	}
}