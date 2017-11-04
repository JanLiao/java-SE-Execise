import java.util.*;
public class TestNum{

	public void call(byte b){
		System.out.println(b);
	}

	public void call(long l){
		System.out.println(l);
	}


	public static void main(String[] args){
		String s="456";
		s+=1;
		long lifeTimes=(long)70*60*24*365*70;
		long lifeTimes1=70*60*24*365*70*1L;
		long lifeTimes2=1L*70*60*24*365*70;
		long lifeTimes3=(long)(70*60*24*365*70);
		System.out.println(lifeTimes);
		System.out.println(lifeTimes1);
		System.out.println(lifeTimes2);

		System.out.println(s);
		TestNum tn=new TestNum();
		tn.call(5);

		for(float f=0.1f;f<1;f+=0.1){
			System.out.println(f);
		}

		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("age",25);
		map.put("sex",1);
		map.put("name",55);
		map.put("kk",99);

		Set<String> set=map.keySet();
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext()){
			String key=iterator.next();
			System.out.print(key+":");
			System.out.println(map.get(key));
		}

		//Map.Entry<String,Object> set1=map.entrySet();
		// Iterator iterator1=map.entrySet().iterator();
		// while(iterator1.hasNext()){
		// 	Map.Entry entry=iterator1.next();
		// 	System.out.println(entry.getKey());
		// 	System.out.println(entry.getValue());
		// }

		int[] array=new int[5];
		int i=2;
		array[i++]=++i;
		//array[++i]=i=5;
		System.out.println(i);
		for(int k:array){
			System.out.print(k+" ");
		}

		for(String key:map.keySet()){
			System.out.println("key="+key);
		}

		for(Object value:map.values()){
			System.out.println("value="+value);
		}

		System.out.println(27<<40);
		System.out.println(27<<8);
	}
}