package genericList;

public interface MyList<E> {
	
	int getSize();
	
	boolean isEmpty();
	
	void addFirst(E s);
	
	void addLast(E s);
	
	void removeFirst();
	
	void removeLast();
	
	E getElement(int index);
	
	int find(E key);
	
	boolean search(E key);
	
	void print();
	
}
