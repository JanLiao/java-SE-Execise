public class TestGenerics{
	public static void main(String[] args){
		MyGenerics<String> g1=new MyGenerics<String>();
		g1.setField("hello");
		System.out.println(g1.getField());
	}
}

class MyGenerics<T>{
	private T field;
	public void setField(T t){
		this.field=t;
	}
	public T getField(){
		return this.field;
	}
}