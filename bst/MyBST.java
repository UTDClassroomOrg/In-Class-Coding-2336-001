package bst;

import java.util.*;

public class MyBST<E extends Comparable<E>> {

	private MyTreeNode<E> root;

	public boolean isEmpty() {
		return root == null;
	}

	public boolean search(E element) {// if the BST is balanced O(lgn)
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

	public boolean insert(E element) { // if the BST is balanced O(lgn)
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
	private void bfs() { //O(n)
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

	//	inorder :  LMR
	//	pre-Order: MLR
	//	pre-Order: LRM
	
	private void dfs() { //O(n)
		dfs(root);
	}
	private void dfs(MyTreeNode<E> current) { //in-order
		if(current != null) {
			dfs(current.left); //L
			System.out.print(current.element + " "); //M
			dfs(current.right); //R
	}
	}

	public void print() {
		dfs();
		System.out.println();
		//bfs();
	}

	 public boolean delete(E element) { // if the BST is balanced O(lgn)
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
			
			if(current == null) return false; //The element is not in the BST
			
			else if(current.left == null) { //case 1
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
			else{ //case 2
				MyTreeNode<E> rightMost = current.left;
				MyTreeNode<E> parentOfRightMost = current;
				
				while(rightMost.right != null) {
					parentOfRightMost = rightMost;
					rightMost = rightMost.right;
				}
				
				current.element = rightMost.element; //removed the current
				
				if(rightMost.equals(current.left)) {
					parentOfRightMost.left = rightMost.left; //b
				}else {
					parentOfRightMost.right = rightMost.left; //a
				}
			}// end of the case 2
			return true;
		}
		return false; // the BST is empty
	}

	




}
class MyTreeNode<E>{
	E element;
	MyTreeNode<E> left;
	MyTreeNode<E> right;

	MyTreeNode(E element){
		this.element = element;
	}
}