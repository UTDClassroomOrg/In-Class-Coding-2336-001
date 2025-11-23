package hash;

public class DriverMain {

	public static void main(String[] args) {
		MyHashTable<Student, String> table = new MyHashTable<>(5, 0.5); // small table to show collisions

		table.print();

		Student s1 = new Student(1, "Alice");
		Student s2 = new Student(6, "Bob");    // collides with Alice (1 % 5 = 1, 6 % 5 = 1)
		table.put(s1, "A+");
		table.put(s2, "B");

		table.print();

		Student s3 = new Student(3, "Charlie");
		table.put(s3, "C");
		table.print();

		System.out.println("Alice's grade: " + table.get(s1));
		System.out.println("Bob's grade: " + table.get(s2));


		System.out.println("\n-----------This is a classic real-world example for hash tables:--------------------");


		MyHashTable<String, Integer> wordCount = new MyHashTable<>();

		String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};

		for (String word : words) {
			Integer count = wordCount.get(word);
			if (count == null) wordCount.put(word, 1); //duplicate not accepted, just update the value
			else wordCount.put(word, count + 1);
		}

		wordCount.print();
	}
}
