package hash;

import genericList.MyLinkedList;

public class MyHashTable<K, V> {

    // Node stored in linked lists
    private class HashNode {
        K key;
        V value;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public String toString() {
            return key + "=" + value; // prints like Alice=90 or apple=3
        }
    }

    private MyLinkedList<HashNode>[] table; // array of linked list buckets "for example table[0] is a bucket"
    private int capacity;                   // current array size
    private int size;                       // total number of entries
    private double loadFactorThreshold;     // default 0.5

    // Constructor with default size 11 and load factor 0.5
    public MyHashTable() {
        this.capacity = 11;
        this.loadFactorThreshold = 0.5;
        initializeTable();
    }

    // Constructor with custom capacity and load factor
    public MyHashTable(int capacity, double loadFactorThreshold) {
        this.capacity = capacity;
        this.loadFactorThreshold = loadFactorThreshold;
        initializeTable();
    }

    // Initialize array of linked lists
    @SuppressWarnings("unchecked")
    private void initializeTable() {
        table = new MyLinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new MyLinkedList<>();
        }
        size = 0;
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    private int hash(K key, int cap) {
        return Math.abs(key.hashCode()) % cap;  // use given capacity
    }

    // Add or update key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        MyLinkedList<HashNode> bucket = table[index];

        // Update the value if key exists
        for (int i = 0; i < bucket.getSize(); i++) {
            HashNode node = bucket.getElement(i);
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // Add new node if key not exists
        bucket.addLast(new HashNode(key, value));
        size++;

        // Check load factor
        if ((double) size / capacity > loadFactorThreshold) {
            resizeAndRehash();
        }
    }

    // Get value by key
    public V get(K key) {
        int index = hash(key);
        MyLinkedList<HashNode> bucket = table[index];

        for (int i = 0; i < bucket.getSize(); i++) {
            HashNode node = bucket.getElement(i);
            if (node.key.equals(key)) return node.value;
        }

        return null; // not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = hash(key);
        MyLinkedList<HashNode> bucket = table[index];

        for (int i = 0; i < bucket.getSize(); i++) {
            HashNode node = bucket.getElement(i);
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                System.out.println(key + " removed!");
                return;
            }
        }

        System.out.println(key + " not found!");
    }

    // Resize array and rehash all elements  - TODO :refactoring
    private void resizeAndRehash() {
        int newCapacity = capacity * 2;
        MyLinkedList<HashNode>[] newTable = new MyLinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new MyLinkedList<>();
        }

        // Rehash all existing nodes
        for (int i = 0; i < capacity; i++) {
            MyLinkedList<HashNode> bucket = table[i];
            for (int j = 0; j < bucket.getSize(); j++) {
                HashNode node = bucket.getElement(j);
                int newIndex = hash(node.key, newCapacity);
                newTable[newIndex].addLast(node);
            }
        }

        table = newTable;
        capacity = newCapacity;
        System.out.println("Resized and rehashed! New capacity: " + capacity);
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            table[i].print(); // each bucket prints its nodes
        }
        System.out.println();
    }
}
