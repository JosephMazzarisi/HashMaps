package com.company;

import java.util.HashMap;

public class MyHashMap {
    Node[] buckets;

    public MyHashMap() {
        buckets = new Node[16];
    }

    public void empty() { //Empties out the existing HashMap

    }

    public boolean isEmpty() { //Returns true if all indexes are null
         return false;
    }

    public void put(Object key, Object value) {
        Node node = new Node(key,value);
        System.out.println("This item should go in index: " + calculateIndex(key));
        int index = calculateIndex(key);
        if(buckets[index] == null) {
            buckets[index] = node;
        }
    }

    public void putIfAbsent(Object key, Object value) { //It inserts the specified value with the specified key in the map only if it is not already specified.
        Node node = new Node(key,value);
    }

    public Object remove(Object key, Object value) { //Returns the key/value of item being removed
        return null;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public Object get(Object key) {
        return null;
    }


    public Object getOrDefault(Object key, Object value) { //It returns the value to which the specified key is mapped, or defaultValue if the map contains no mapping for the key.
        return null;
    }

    public int size() { //Number of Nodes in the Linked List
        return 0;
    }

    public Object replace(Object key, Object value) { //Return old value being replaced. Returns null if key does not exist already.
        return null;
    }

    public void display() { //Outputs all items in Hashmap (should include key and value)

    }

    public int calculateIndex(Object key) {
        //index = key.hashCode() & (n-1)  (where n is the size of the Array)
        int indexValue = key.hashCode() & (buckets.length-1);
        return indexValue;
    }




    public class Node {
        private Object key;
        private Object value;
        private int hash;
        private Node next;

        public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
        next = null;
        hash = key.hashCode();
        System.out.println("Node created. Hash value is: " + key.hashCode());
        }



    }
}
