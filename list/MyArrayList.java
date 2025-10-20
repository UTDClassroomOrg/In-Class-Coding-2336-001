package list;

public class MyArrayList {
	private String[] list;
	private int capacity = 4; //default in java 10
	private int size;

	public MyArrayList() {
		this.list = new String[this.capacity];
	}

	public MyArrayList(int capacity) {
		if(capacity > 4)
			this.capacity = capacity;
		this.list = new String[this.capacity];
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void addLast(String s) { //O(1)
		if(size >= capacity) resize(this.capacity * 2);
		list[size] = s;
		size++;
	}

	public void removeLast() { //O(1)
		if(!isEmpty()) {
			size--;
			String temp = list[size];
			list[size] = null;
			if(size > 0 && capacity/size >= 4) resize(this.capacity/2);
			System.out.println(temp + " removed!");
		}else {
			System.out.println("List is empty!");
		}
	}

	public void addFirst(String s, int index) { //O(n)
		if(index >= 0 && index <= size) {
			if(size >= capacity) resize(this.capacity * 2);
			for(int k = size-1; k >= index; k--) {
				list[k+1] = list[k];
			}
			list[index] = s;
			size++;
		}else {
			System.out.println("index " + index + " is out of range!");
		}
	}

	public void addFirst(String s) { // it always going to add to index 0
		this.addFirst(s, 0);

	}

	public void removeFirst(String s) { //O(n)
		int index = find(s);
		if(index!=-1) {
			for(int k = index + 1; k < size; k++) {
				list[k-1] = list[k];
			}
			size--;
			list[size] = null;
			if(size > 0 && capacity/size >= 4) resize(this.capacity/2);
			System.out.println(s + " removed!");
		}else {
			System.out.println(s + " is not in this list!");
		}
	}
	
	public void removeFirst() { //it always going to remove from index 0 
		this.removeFirst(getElement(0));
	}

	public int find(String key) { //O(n) linear search
		for(int i = 0; i < size; i++) {
			if(list[i].equals(key)) return i;
		}
		return -1;
	}

	public boolean search(String key) {  //O(n)
		//		if(find(key) > -1) return true;
		//		return false;

		return find(key) > -1;
	}

	public String getElement(int index) { //O(1)
		if(index >=0 && index < size)
			return list[index];
		return null;
	}

	private void resize(int capacity) { // TODO: refactoring
		if(capacity > 0) {
			this.capacity = capacity;
			String[] temp = list;
			list = new String[this.capacity];
			for(int i = 0; i < this.size; i++) {
				list[i] = temp[i];
			}
		}

	}

	public void print() {
		System.out.print("|");
		for(int i = 0; i < this.capacity; i++) {
			System.out.print(list[i] + " | ");
		}
		System.out.println();
	}






}
