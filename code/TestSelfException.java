import java.io.*;
class SelfException extends Exception{
	public SelfException(){
		super("自定义例外异常");
	}
}

public class TestSelfException{
	public static void main(String[] args){
		try{
			firstMethod();
		}catch(SelfException e){
			e.printStackTrace();
		}
	}

	public static void firstMethod() throws SelfException{
		secondMethod();
	}

	public static void secondMethod() throws SelfException{
		thridMethod();
	}

	public static void thridMethod() throws SelfException{
		throw new SelfException();
	}
}