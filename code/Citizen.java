public class Citizen implements Comparable{
	private String id;

	public Citizen(String theId){
		this.id=theId;
	}

	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(this==obj){
			return true;
		}
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		Citizen c=(Citizen) obj;
		return id.equals(c.id);
	}

	public int hashCode(){
		return id.hashCode();
	}

	public String toString(){
		return id;
	}

	public String getId(){
		return id;
	}

	public int compareTo(Object other){
		Citizen c=(Citizen) other;
		return id.compareTo(c.getId());
	}
}