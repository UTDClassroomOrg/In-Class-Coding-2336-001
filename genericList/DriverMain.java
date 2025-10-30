package genericList;

public class DriverMain {

	public static void main(String[] args) {
//		MyLinkedList mylist = new MyLinkedList();
//		mylist.addLast("h");
//		mylist.print();
//		mylist.addLast("e");
//		mylist.print();
//		mylist.addLast("l");
//		mylist.print();
//		mylist.addLast("l");
//		mylist.print();
//		mylist.addLast("o");
//		mylist.print();	
//		mylist.addFirst("a");
//		mylist.addFirst("b");
//		mylist.addFirst("c");
//		mylist.addFirst("d");
//		mylist.print();	
//		System.out.println(mylist.getElement(4));
//		mylist.remove("d");
//		mylist.remove("l");
//		mylist.print();	
//		mylist.remove("e");
//		mylist.print();	
//		mylist.remove("b");
//		mylist.print();	
//		mylist.remove("h");
//		mylist.print();	
	
		//MyStackOfArrayList myStack = new MyStackOfArrayList();
//		MyStack myStack = new MyStack();
//
//		myStack.push("a");
//		myStack.print();
//		myStack.push("b");
//		myStack.print();
//		myStack.push("c");
//		myStack.print();
//		System.out.println(myStack.peek());
//		myStack.pop();
//		System.out.println(myStack.peek());
//		myStack.print();
//		myStack.pop();
//		System.out.println(myStack.peek());
//		myStack.print();
//		myStack.pop();
//		System.out.println(myStack.peek());
		
		MyQueue<String> myQueue = new MyQueue<>();

		myQueue.enqueue("a");
		myQueue.print();
		myQueue.enqueue("b");
		myQueue.print();
		myQueue.enqueue("c");
		myQueue.print();
		myQueue.dequeue();
		myQueue.print();
		myQueue.dequeue();
		myQueue.print();
		myQueue.dequeue();
		
		
	}

}
