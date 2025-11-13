package heap;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {
	private ArrayList<E> list = new ArrayList<>(); //has relation composition
	
	public MaxHeap() {
	}
	
	public MaxHeap(E[] Object) {
		//for loop call the add
	}
	
	public void add(E element) {
		list.add(element);
		int currentIndex = list.size() - 1;
		while(currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2; 
			//swap if the current element is greater than its parent
			if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}else break; //this tree is a heap now
			
			currentIndex = parentIndex;
		}
	}

}
