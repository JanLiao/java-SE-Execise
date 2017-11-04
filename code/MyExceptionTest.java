import java.io.*;
import java.lang.*;
class MyException extends ArithmeticException{
     public MyException(){
     	super();
     }

     public MyException(String msg){
     	super(msg);
     }

     public String toString(){
     	return "除以0异常";
     }
}

public class MyExceptionTest{
	public static void main(String[] args){
		int a,b,q;
		try{
			a=Integer.parseInt(args[0]);
		    b=Integer.parseInt(args[1]);
			if(b==0){
				throw new MyException();
			}
			q=a/b;
            System.out.println(q);
		}catch(MyException e){
			System.out.println(e);
		}
	}
}