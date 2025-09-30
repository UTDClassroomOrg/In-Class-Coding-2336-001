import java.util.Arrays;

public class DriverMain001 {

	public static void main(String[] args)  {
		Animal a1 = new Dog();
		System.out.println(a1.getName());
		System.out.println(a1.getSpeed());
		System.out.println(Animal.getNumberOfAnimals());
		Animal a2 = new Dog("alex", -10);
		System.out.println(a2.getName());
		a2.setSpeed(-10);
		System.out.println(a2.getSpeed());
		
		System.out.println(Animal.KINGDOM);
		a1.setName("alex");

		Animal[] petStore = new Animal[4];
		petStore[0] = new Cat("kitty", 20);
		petStore[1] = a2;
		petStore[2] = new Cat("joe", 1000);
		petStore[3] = a1;

		System.out.println("before sort");
		for(Animal a: petStore) {
			System.out.println(a);
		}
		Arrays.sort(petStore);
		
		System.out.println("after sort");
		for(Animal a: petStore) {
			System.out.println(a);
		}
//		
//		System.out.println(a1.toString());
//		System.out.println(a1);

//		System.out.println(a1.equals(a2)); //true
//		System.out.println(a1.equals(petStore[2])); //false
		
		
		//Animal kitty = ;
		//System.out.println(kitty);
		//kitty.makeSound();
		
//		System.out.println(Animal.getNumberOfAnimals());
//		printAnimal(a2);
//		printAnimal(petStore[3]);
		
		Animal max = new Cat("max", 300);
		Animal luna = (Animal) max.clone();
		System.out.println(max.getName() + " - " + luna.getName());
		System.out.println(max == luna);
		
	}
	
	public static void printAnimal(Animal a) {
		if(a instanceof Cat) {
			((Cat)a).run();
		}
		else if (a instanceof Dog) {
			((Dog)a).jump();
		}else {
			System.out.println(a.toString());
		}
		
	}
}
