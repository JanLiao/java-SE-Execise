class Food{
	public void foodMethod(){
		System.out.println("Parent");
	}
}

interface Sell{
	void sellRice();
}

class Rice extends Food implements Sell{
	public void sellRice(){
		System.out.println("Child sellRice");
	}

	// public void foodMethod(){
	// 	System.out.println("Children");
	// }
}

public class InstanceTest{
	public static void main(String[] args){
		Rice rice = new Rice();
		System.out.println(rice);
		System.out.println(rice instanceof Food);
		System.out.println(rice instanceof Rice);
		System.out.println(rice instanceof Sell);
		rice.sellRice();
		rice.foodMethod();

		Food food = new Rice();
		System.out.println(rice instanceof Food);
		System.out.println(rice instanceof Rice);
		System.out.println(rice instanceof Sell);
		//food.sellRice();
		food.foodMethod();

		Food food1 = new Food();
		System.out.println(food1);
		food1 = rice;
		System.out.println(food1);
		food1.foodMethod();
		
	}
}