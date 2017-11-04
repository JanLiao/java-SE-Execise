import java.util.*;
public class Erasure{
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("east");
		list.add("west");
		list.add("south");
		list.add("north");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(6);
		list1.add(7);
		list1.add(8);
		Erasure er = new Erasure();
		er.printList(list);
		er.printList(list1);
		er.printList1(list1);
	}

	public void printList(List<?> list){
		for(Iterator<?> i = list.iterator(); i.hasNext();){
			System.out.println(i.next());
		}
	}
	public void printList1(List<? extends Number> list){
        Iterator<?> i = list.iterator();
        while(i.hasNext()){
        	System.out.println(i.next());
        }
	}
}