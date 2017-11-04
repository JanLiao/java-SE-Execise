import java.util.*;
class Outer{
	public Outer(){
	}
}
public class GenericClass<E>{
	private List<E> list;
	private final int size;
	public GenericClass(int size){
		list = new ArrayList<E>();
		this.size = size;
	}
	public void add(E e){
		if(list.size() < size){
			list.add(e);
			System.out.println("元素"+e+"添加成功");
		}else{
			System.out.println("list元素空间已满");
		}
	}
	public void remove(int index){
		if(index >= list.size()){
			System.out.println("index过大");
		}else{
			E e = list.remove(index);
			System.out.println("元素"+e+"已成功删除");
		}
	}
	public static void main(String[] args){
		GenericClass<Integer> gc1 = new GenericClass<Integer>(3);
		gc1.add(1);
		gc1.add(2);
		gc1.add(3);
		gc1.add(4);
		gc1.remove(4);
		gc1.remove(0);
		GenericClass<String> gc2 = new GenericClass<String>(4);
		gc2.add("goods");
		gc2.add("String");
		gc2.add("world");
		gc2.add("water");
		gc2.add("earth");
		gc2.remove(3);
		GenericClass<Outer> gc3 = new GenericClass<Outer>(2);
		Outer o1 = new Outer();
		Outer o2 = new Outer();
		Outer o3 = new Outer();
		gc3.add(o1);
		gc3.add(o2);
		gc3.add(o3);
	}
}