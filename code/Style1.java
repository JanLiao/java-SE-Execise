class Animal{

}

class Cat extends Animal{

}

class Dog extends Animal{

}

public class Style1{

    public void printInfo(Animal animal){
    	if(animal instanceof Cat){
    		System.out.println("Cat");
    	}else if(animal instanceof Dog){
    		System.out.println("Dog");
    	}else if(animal instanceof Animal){
    		System.out.println("Animal");
    	}
    }

	public static void main(String[] args){
		Style1 style = new Style1();
		Animal animal = new Animal();
		Cat cat = new Cat();
		Dog dog = new Dog();
		style.printInfo(cat);
		style.printInfo(animal);
		style.printInfo(dog);
		animal = cat;
		style.printInfo(animal);
	}
}