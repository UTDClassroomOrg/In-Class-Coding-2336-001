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
		
		bst.print();
	}
	
	
}
