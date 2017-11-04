public abstract class Sharp{
	private String color;

	public abstract double  perimeter();

	public abstract String getType();

	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color=color;
	}
}