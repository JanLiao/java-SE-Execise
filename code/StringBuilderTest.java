import java.util.*;
import java.util.Map.Entry;
public class StringBuilderTest{
	public static void main(String[] args){
		Integer i=8;
		Boolean b=true;
		System.out.println(b);
		System.out.println(i);
		String t1=new String("kk");
		System.out.println(t1);
		String s="s";
		StringBuilder t=new StringBuilder("s");
		System.out.println(s);
		System.out.println(t);
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("age",25);
		map.put("sex","man");
		map.put("name","Jan");
		map.put("num","2016");

		Set<String> set1=map.keySet();
		for(String k:set1){
			System.out.print(k+" ");
		}

		//Set<Map.Entry<String,Object>> set=map.entrySet<Map.Entry<String,Object>>();
		for(Map.Entry<String,Object> entry:map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

		Set<Map.Entry<String,Object>> entrySet=map.entrySet();
		for(Map.Entry<String,Object> entry:entrySet){
			System.out.println(entry.getKey()+entry.getValue());

		}

		int array[]={55,88,2,5,3,6,9,8};
		for(int k:array){
			System.out.print(k);
		}

		byte[] ba=new byte[8];
		for(byte k:ba){
			System.out.print(k+" ");
		}
	}
}