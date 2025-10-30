package genericList;

public class MyLinkedList<E> implements MyList<E> {
	private MyNode<E> first;
	private MyNode<E> last;
	private int size;

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		//return this.size == 0 ;
		return first == null;
	}

	public void addFirst(E s) { // O(1)
		MyNode<E> newNode = new MyNode<>(s);
		if(isEmpty()) {
			last = newNode;
		}else {
			newNode.next = first;
		}
		first = newNode;
		size++;
	}

	public void addLast(E s) { //O(1)
		MyNode<E> newNode = new MyNode<>(s);
		if(isEmpty()) {
			first = newNode;
		}else {
			last.next = newNode;
		}
		last = newNode;
		size++;
	}

	public void removeFirst() { //O(1)
		if(!isEmpty()) {
			E temp = first.element;
			if(first == last) { //only one element in this list
				//				first = first.next;
				//				last = null;
				first = last = null;
			}else {
				first = first.next;
			}
			size--;
			System.out.println(temp + " is removed!");
		}else {
			System.out.println("List is empty!");
		}
	}

	public void removeLast() { //O(n)
		if(!isEmpty()) {
			E temp = last.element;
			if(first == last) { //only one element in this list
				first = last = null;
			}else {
				MyNode<E> prev = first;
				while(prev.next != last) {
					prev = prev.next;
				}
				prev.next = null;
				last = prev;
			}
			size--;
			System.out.println(temp + " is removed!");
		}else {
			System.out.println("List is empty!");
		}
	}
	
	public void remove(E key) { //O(n)
		if(search(key)) {
			MyNode<E> curr = first;
			MyNode<E> prev = first;
			while(curr!=null && !curr.element.equals(key)) {
				prev = curr;
				curr = curr.next;
			}
			if(curr == first) removeFirst();
			else if(curr == last) removeLast();
			else {
				prev.next = curr.next;
				size--;
				System.out.println(key + " is removed!");
			}
		}else {
			System.out.println(key + " is not in the list!");
		}
	}
	
	
	public boolean search(E key) { //O(n)
		MyNode<E> pointer = first;
		while(pointer!=null && !pointer.element.equals(key)) {
			pointer = pointer.next;
		}
		return pointer!=null;
	}
	
	public int find(E key) { //O(n)
		int counter = -1;
		if(search(key)) {
			counter++;
			MyNode<E> pointer = first;
			while(pointer!=null && !pointer.element.equals(key)) {
				counter++;
				pointer = pointer.next;
			}
		}
		return counter;
	
	}
	
	public E getElement(int index) { //O(n)
		if(index >= 0 && index < size) {
			if(index == 0) return (E) getFirstElement();
			else if (index == size - 1) return (E) getLastElement();
			else {
				int counter = 0;
				MyNode<E> pointer = first;
				while(counter != index) {
					counter++;
					pointer = pointer.next;
				}
				return pointer.element;
			}
		}else {
			return null;
		}
	}
	
	private E getFirstElement() {
		if(!isEmpty()) return first.element;
		return null;
	}
	
	private E getLastElement() {
		if(!isEmpty()) return last.element;
		return null;
	}

	public void print() {
		MyNode<E> pointer = first;
		while(pointer!=null) {
			System.out.print(pointer.element + " | ");
			pointer = pointer.next;
		}
		System.out.println();
	}
	


}

class MyNode<E>{
	E element;
	MyNode<E> next;

	MyNode(E element){
		this.element = element;
	}
}
