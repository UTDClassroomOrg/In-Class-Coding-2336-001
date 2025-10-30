package list;

public class MyArrayList implements MyList {
	private String[] list;
	private int capacity = 4; //11
	private int size;

	public MyArrayList() {
		this.list = new String[this.capacity];
	}

	public MyArrayList(int capacity) { //TODO:
		if(capacity > 4)
			this.capacity = capacity;
		this.list = new String[this.capacity];
	}


	public void addLast(String s) { //O(1)
		if(size >= capacity) resize(this.capacity * 2);
		list[size] = s;
		size++;
	}
	
	public void addFirst(String s, int index) { //O(n)
		if(index >= 0 && index <= size) {
			if(size >= capacity) resize(this.capacity * 2);
			for(int k = size - 1; k >= index ; k-- ) {
				list[k+1] = list[k];
			}
			list[index] = s;
			size++;
		}else {
			System.out.println("index " + index + " in out of range!" );
		}
	}
	
	public void removeFirst(String s) { //O(n)
		int index = find(s);
		if(index!=-1) {
			for(int k = index + 1; k < size ; k++) {
				list[k-1] = list[k];
			}
			size--;
			list[size] = null;
			if(size> 0 && capacity/size >= 4) resize(this.capacity / 2);
			System.out.println(s + " removed!");
		}else {
			System.out.println(s + " is not in this list!");
		}
	}
	
	public void removeLast(){ //O(1)
		if(!isEmpty()) {
			size--;
			String temp = list[size];
			list[size] = null; 
			if(size> 0 && capacity/size >= 4) resize(this.capacity / 2);
			System.out.println(temp + " removed!");
		}else{
			System.out.println("List is empty!");
		}
	}
	
	public int find(String key) { // linear search O(n)
		for(int i = 0; i < size; i++ ) {
			if(list[i].equals(key)) return i;
		}
		return -1; // the key was not in the list
	}
	
	public boolean search(String key) { //O(n)
//		if(find(key) > -1 ) return true;
//		return false;
//		
		return find(key) > -1;
	}
	
	public String getElement(int index) { //O(1)
		if(index >= 0 && index < size)
			return list[index];
		return null;
	}

	public void addFirst(String s) {
		this.addFirst(s, 0);
	}
	
	public void removeFirst() {
		this.removeFirst(this.getElement(0));
	}

	private void resize(int capacity) { //TODO refactoring
		if(capacity > 2) {
			this.capacity = capacity;
			String[] temp = list;
			list = new String[this.capacity];
			for(int i = 0; i < size; i++) {
				list[i] = temp[i];
			}
		}
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void print() {
		System.out.print(" | ");
		for(int i = 0 ; i < capacity; i++) {
			System.out.print(list[i] + " | ");
		}
		System.out.println();
	}




}
