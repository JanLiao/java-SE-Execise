import java.util.regex.*;
public class VerificationEmail{
	public static void main(String[] args){
		String regstring="\\w+@\\w+\\.\\p{Alpha}{2,4}(\\.\\p{Alpha}{2})?";
		Pattern ptn=Pattern.compile(regstring,Pattern.CASE_INSENSITIVE);
		Matcher matcher=ptn.matcher(args[0]);
		if(matcher.matches()){
			System.out.println("正确匹配");
		}else {
			System.out.println("匹配出错");
		}
	}
}