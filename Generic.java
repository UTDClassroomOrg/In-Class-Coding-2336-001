import java.util.*;

class Box<T> {
	T value;
	Box(T value){
		this.value = value;
	}
	T get() {
		return value;
	}
}

class Calculator<T extends Number> {
	double add(T a, T b) {
		return a.doubleValue() + b.doubleValue();
	}

}


class Util{
	public static <T> void print(T item) {
		System.out.println(item);
	}	
	// Generic method, but always returns int
	public static <T> int countLength(T item) {
		return item.toString().length();
	}

	// Generic method that returns T
	public static <T> T echo(T item) {
		return item;  // just gives back the same object
	}

	//Generic method that returns T which is bounded
	// T must be a Number (Integer, Double, etc.)
    public static <T extends Number> T getFirst(T[] numbers) {
        return numbers[0];  // returns T
    }
    
    // you give a generic list and it will add two more integers into it. it can be list of Numbers or Object
	public static void addNumbers(List<? super Integer> list) {
		list.add(1);
		list.add(2);
	}	

	public static double sum(List<? extends Number> list) {
		double total = 0;
		for (Number n : list) {
			total += n.doubleValue();
		}
		return total;
	}
}
