package bst;

public class TestMyBST {

	public static void main(String[] args) {
		MyBST<Integer> bst = new MyBST<Integer>();
		bst.insert(5);
		bst.insert(27);
		bst.insert(2);
		bst.insert(3);
		bst.insert(67);
		bst.insert(16);
		bst.insert(17);
		bst.insert(13);
		bst.insert(10);
		bst.insert(15);
		bst.insert(9);
		bst.insert(45);
		bst.insert(82);
		bst.insert(0);
		bst.print();
		System.out.println(bst.delete(99)); //Not found
		bst.delete(9);
		bst.print();
		bst.delete(15);
		bst.print();
		bst.delete(16);
		bst.print();
		bst.insert(15);
		bst.print();
		bst.delete(27);
		bst.print();
		bst.delete(5);
		bst.print();
		bst.delete(3);
		bst.print();
		bst.delete(2);
		bst.print();
		bst.delete(0); //case 1 - C
		bst.print();
		
	}
	
	
}
