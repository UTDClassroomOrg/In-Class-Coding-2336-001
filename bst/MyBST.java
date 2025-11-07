package bst;

import java.util.*;

public class MyBST<E extends Comparable<E>> {

	private MyTreeNode<E> root;

	public boolean isEmpty() {
		return root == null;
	}

	public boolean search(E element) {
		MyTreeNode<E> current = root;
		while(current != null) {
			if(element.compareTo(current.element) < 0) {
				current = current.left;
			}else if(element.compareTo(current.element) > 0) {
				current = current.right;
			}else {
				return true; //found
			}
		}
		return false;
	}

	public boolean insert(E element) {
		MyTreeNode<E> newTreeNode = new MyTreeNode<E>(element);

		if(!isEmpty()) {
			MyTreeNode<E> current = root;
			MyTreeNode<E> parent = root;

			while(current != null) {
				if(element.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}else if(element.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}else {
					return false; //duplication
				}
			}
			if(element.compareTo(parent.element) < 0) {
				parent.left = newTreeNode;
			}else {
				parent.right = newTreeNode;
			}

		}else { // first element in the tree
			root = newTreeNode;
		}

		return true;
	}
	private void bfs() {
		if(!isEmpty()) {
			Queue<MyTreeNode<E>> queue = new LinkedList<MyTreeNode<E>>();
			queue.add(root);
			while(!queue.isEmpty()) {
				MyTreeNode<E> tempNode = queue.poll();
				System.out.print(tempNode.element + " ");

				if(tempNode.left != null) {
					queue.add(tempNode.left);
				}

				if(tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
		}
	}


	private void dfs() {
		dfs(root);
	}
	private void dfs(MyTreeNode<E> current) {
		if(current != null) {
			dfs(current.left);
			System.out.print(current.element + " ");
			dfs(current.right);
		}
	}

	public void print() {
		dfs();
		//bfs();
	}

	/*Will be completed on Mon Nov 10th
	 * public boolean delete(E element) {
		if(!isEmpty()) {
			MyTreeNode<E> current = root;
			MyTreeNode<E> parent = root;

			while(current != null) {
				if(element.compareTo(current.element) < 0 ) {
					parent = current;
					current = current.left;
				}else if(element.compareTo(current.element) > 0 ) {
					parent = current;
					current = current.right;
				}else {
					break;
				}
			}

			if(current.left == null) { //case 1
				if (current == root) { //c
					root = root.right;
				}else {
					if(element.compareTo(parent.element) < 0) {
						parent.left = current.right; //a
					}else {
						parent.right = current.right; //b
					}
				}
			} // end of case 1
		} 
	}*/

	


	//	inorder :  LMR
	//	pre-Order: MLR
	//	pre-Order: LRM

}
class MyTreeNode<E>{
	E element;
	MyTreeNode<E> left;
	MyTreeNode<E> right;

	MyTreeNode(E element){
		this.element = element;
	}
}
