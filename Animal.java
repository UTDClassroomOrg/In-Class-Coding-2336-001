
public abstract class Animal implements Comparable<Animal>, Cloneable {

	private String name = "def";
	private int weight;
	private int age;
	private boolean hasOwner;
	private double speed; //requirement default speed is 1

	private static int numberOfAnimals;

	public static final String KINGDOM ="Animalia"; //Constant

	public Animal() {
		//		this.setSpeed(1);
		//		numberOfAnimals++;
		this(1);
		//System.out.println("(1) constructor");

	}
	public Animal(double speed) { //custom
		//		this.setSpeed(speed);
		//		numberOfAnimals++;
		this("def", speed);
		//System.out.println("(2) constructor");
	}
	public Animal(String name, double speed) { //custom
		//this.name = name;
		this.setName(name);
		this.setSpeed(speed);
		Animal.setNumberOfAnimals();
		//System.out.println("(3) constructor");

		//Animal.numberOfAnimals++;
	}

	String getName() {
		return this.name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getSpeed() {
		return speed;
	}

	void setSpeed(double speed) {
		if(speed > 0)
			this.speed = speed;
		else {
			this.speed = 1;
			System.out.println("speed must be more than 1 and can not be " + speed);
		}
	}

	public static int getNumberOfAnimals() {
		return numberOfAnimals;
	}

	public static void setNumberOfAnimals() {
		numberOfAnimals++;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(!(obj instanceof Animal)) return false;
		Animal other = (Animal) obj;
		return this.name.equals(other.name) && this.speed == other.speed;
	}

	@Override
	public int compareTo(Animal o) { //same name 
		//return this.name.compareTo(o.name);
		if(this.speed == o.speed) return 0;
		else if (this.speed > o.speed) return 1;
		else
			return -1;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public String toString() {
		return "[name: " + this.getName() + " ,speed: "+ this.getSpeed() +"]";
		//return "[name: " + this.name + " ,speed: "+ this.speed +"]";
	}

	void eat() {
		System.out.println("Animal eats"); //dummy
	}


	abstract String makeSound();// {
	//		System.out.println("Animal sounds");//dummy
	//	}

}

class Cat extends Animal implements Jumper, Runner{

	Cat(){
		//super(); automatic
	}
	Cat(String name, double speed){
		super(name, speed);
	}

	@Override
	String makeSound() {
		return "meuww";
	}

	@Override
	public String toString() {
		return this.makeSound() + "-" + super.toString();
	}
	@Override
	public void jump() {
		System.out.println("Cat jumps");		
	}
	@Override
	public void run() {
		System.out.println("Cat runs");		
	}



}

class Dog extends Animal implements Jumper, Runner{
	Dog(){

	}
	Dog(String name, double speed){
		super(name,speed);
		//super.setSpeed(speed);
	}

	@Override
	String makeSound() {
		return "Wolfff!";
	}

	@Override
	public String toString() {
		return this.makeSound() + "- " + super.toString();
	}

	@Override
	public void jump() {
		System.out.println("Dog jumps");		
	}
	@Override
	public void run() {
		System.out.println("Dog runs");		
	}

}
class Bird extends Animal{
	Bird(){

	}
	
	
	Bird(String name, double speed){
		super(name,speed);
	}

	@Override
	String makeSound() {
		return "CAW!";
	}

	@Override
	public String toString() {
		return this.makeSound() + "-" +super.toString();
	}


}



interface Jumper {

	void jump();
}


interface Runner {

	public abstract void run();

}

class Athlete<T extends Runner & Jumper>{ // Example of Multiple Bounds (<T extends A & B>)
	private T participant;
	
	Athlete(T participant){
		this.participant = participant;
	}
	
	public void perform() {
		participant.run();
		participant.jump();
	}
	
	// T must implement both Runner and Jumper
    public static <T extends Runner & Jumper> T train(T animal) {
        System.out.println("Training...");
        animal.run();
        animal.jump();
        return animal; // returning T
    }
}



