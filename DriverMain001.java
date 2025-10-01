import java.util.*;

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

		Animal[] petStore = new Animal[5]; //Generic
		petStore[0] = new Cat("kitty", 20);
		petStore[1] = a2;
		petStore[2] = new Cat("joe", 1000);
		petStore[3] = a1;
		petStore[4] = new Bird();

		System.out.println("before sort");
		for(Animal a: petStore) {
			System.out.println(a);
		}
		Arrays.sort(petStore);

		System.out.println("after sort");
		for(Animal a: petStore) {
			//System.out.println(a);
			printAnimalSound(a);
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

//		Animal max = new Cat("max", 300);
//		Animal luna = (Animal) max.clone();
//		System.out.println(max.getName() + " - " + luna.getName());
//		System.out.println(max == luna);
		
		
//		Animal[] list = new Object[2]; //Generic Motivation Example
//		list[0] = new Dog();
//		list[1] = new String("Java");
//		
//		Dog d1 = (Dog) list[1]; //Cast Error
		
		System.out.println();		
		System.out.println("started working on Generics: ");
		System.out.println("-------Generic Box Class (parameterized class)--------------");
		System.out.println();

		Box<String> box = new Box<String>("Hi");
		System.out.println(box.get());
		//Box<Integer> box = new Box<Integer>(12); //compile error
		
		System.out.println("-------Generic Calculator Class (Bounded Type Parameters )---------------");
		System.out.println();
		Calculator<Integer> c = new Calculator<Integer>();
		System.out.println(c.add(2, 3));
		//System.out.println(c.add(2, "s")); compile error - String is not Number
		//System.out.println(c.add(2, 3.3)); compile error - Double is not Integer
		
		System.out.println("-------Multiple Bounds (<T extends A & B>)---------------------");
		System.out.println();
		Athlete<Dog> d1 = new Athlete<>(new Dog());
		d1.perform();
		
		Athlete<Cat> c1 = new Athlete<>(new Cat());
		c1.perform();
		
//		Athlete<Bird> b1 = new Athlete<>(new Bird());
//		b1.perform();
		
		Dog trainedDog = Athlete.train(new Dog("trainedDog", 3));
        Athlete.train(new Cat("trainedCat", 3)); // Allowed
        //Athlete.train(new Bird("trainedBird", 3)); // Not allowed
		
		
		System.out.println("-------------Generic Methods---------------");
		System.out.println();
		Util.print("Hello");
		Util.print(345);
		System.out.println(Util.countLength("Hello"));
		System.out.println(Util.countLength(new Dog()));//print toString method of Dog
		
		Cat echoCat = Util.echo(new Cat("Kitten", 240));
		System.out.println(echoCat);

		Double echDouble = Util.echo(987.4);
		System.out.println(echDouble);
		
		
		
		System.out.println("---------------Raw Type-------------");
		System.out.println();
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("a string");
		//list2.add(123);
		
		ArrayList list3 = new ArrayList(); //Raw Type
		list3.add("a string");
		list3.add(123); //Never Use Raw Type
		
		printList(list2);
		
		System.out.println("-----? super Dog and ? extends Animal------");
		System.out.println();

		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(new Cat());
		animalList.add(new Bird());
		animalList.add(new Dog());
		
		//printAnimalList(list2); //List2 is String list , not allowed

		addDogs(animalList); //added a new Dog to the Animal list(? super Dog)
		printAnimalList(animalList); //Accept the Animal list only(? extends Animal)
		
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
	public static void printAnimalSound(Animal a) { //Generic method
		System.out.println(a.makeSound()); //Dynamic Binding
	}
	
	public static void printList(List<?> list){
		for(Object o : list)
			System.out.println(o);
	}
	
	public static void printAnimalList(List<? extends Animal> list){
		for(Animal o : list)
			System.out.println(o.makeSound());
	}
	
	static void addDogs(List<? super Dog> list) {
		list.add(new Dog("New Dog", 500)); // so you can add this dog to the list of Animals as Animal is the super class of Dog	
		//list.add(new Cat("New Dog", 500)); 
		
	}
}







