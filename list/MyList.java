package list;

public interface MyList {
	
	int getSize();
	
	boolean isEmpty();
	
	void addFirst(String s);
	
	void addLast(String s);
	
	void removeFirst();
	
	void removeLast();
	
	String getElement(int index);
	
	int find(String key);
	
	boolean search(String key);
	
	void print();
	
}
