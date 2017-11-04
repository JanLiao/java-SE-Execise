import java.util.*;
public class Message implements Subject{
	private String msg;
	private List<Observer> listObserver = new ArrayList<Observer>();
	public void registerObserver(Observer o){
		if(!listObserver.contains(o)){
			listObserver.add(o);
		}
	}
	public void unregisterObserver(Observer o){
		if(listObserver.contains(o)){
			listObserver.remove(o);
		}
	}
	public void notifyObserver(){
		for(Observer ob:listObserver){
			ob.update(msg);
		}
	}
	public void distributemsg(String s){
		this.msg = s;
		notifyObserver();
	}
}