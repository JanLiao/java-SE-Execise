import java.util.*;
public class TestCalendar{
	public static void main(String[] args){
		Calendar call=Calendar.getInstance();
		System.out.println("月份="+call.get(Calendar.MONTH));
		System.out.println("月份="+call.get(Calendar.DAY_OF_MONTH));
	}
}