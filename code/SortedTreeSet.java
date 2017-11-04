import java.util.*;

public class SortedTreeSet{
	public static void main(String[] args){
		TreeSet<Citizen> ts=new TreeSet<Citizen>();
		Citizen c1=new Citizen("a10");
		Citizen c2=new Citizen("a99");
		Citizen c3=new Citizen("a08");
		ts.add(c1);
		ts.add(c2);
		ts.add(c3);
		ts.add("111");

		Iterator it=ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}