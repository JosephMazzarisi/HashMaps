package com.company;

import java.util.HashMap;

public class MyHashMap {
    Node[] buckets;

    public MyHashMap() {
        buckets = new Node[16];
    }

    public void empty() { //Empties out the existing HashMap
        for(int i =0; i<size(); i++) {
            buckets[i] = null;
        }
    }

    public boolean isEmpty() { //Returns true if all indexes are null
        boolean b = true;
        for(int i =0; i<size(); i++) {
            if(buckets[i] != null)
                b = false;
        }
        return b;
    }

    public void put(Object key, Object value) {
        Node node = new Node(value, key);
        int index = calculateIndex(key);
        Node x = buckets[index];
        if (buckets[index].getKey() == null) {
            buckets[index] = node;
        }
        else if (containsKey(key)) {
            System.out.println("Stop for you have reached the point of no return");
        }
        else
            {
            while (x.getNext() != null) {
                x = x.getNext();
            }
            x.setNext(node);
        }
    }

    public void putIfAbsent(Object key, Object value) { //It inserts the specified value with the specified key in the map only if it is not already specified.

        Node node = new Node(key,value);
        boolean key = containsKey(key);
        boolean val = containsValue(value);
        if((key && val) == true) {
            System.out.println("Nice"); //prints if it's not absent
        }
        else{
            System.out.println("Not Nice"); //prints if it's absent
            Node node = new Node(value, key);
            int index = calculateIndex(key);
            Node x = buckets[index];
            if (buckets[index].getKey() == null) {
                buckets[index] = node;
            }
            else if (containsKey(key)) {
                System.out.println("Stop for you have reached the point of no return");
            }
            else
            {
                while (x.getNext() != null) {
                    x = x.getNext();
                }
                x.setNext(node);
            }
        }
    }

    public Object remove(Object key, Object value) { //Returns the key/value of item being removed

       if(calculateIndex(key) != 0)
           for(int i =0; i<calculateIndex(key) - 1; i++) {
               Node node = new Node(key, value);
               Node x = node;
               node.setNext(null);
               return x;
           }
       Node node = new Node(null,null);
           return node;
    }


    public boolean containsValue(Object value) {
        return false;
    }

    public boolean containsKey(Object key) {
        Node node = buckets[calculateIndex(key)];
        if(node.getKey().equals(key))
            return true;
        while (node.getNext()!=null){
            if(node.getKey().equals(key))
                return true;
            node = node.getNext();
        }
        return false;
    }

    public Object get(Object key) {
        Node curr = buckets[calculateIndex(key)];
        if(curr.getKey() == key)
            return curr.getData();
        while (curr.getNext() != null) {
            if (curr.getKey() == key) {
                return curr.getData();
            }
        }
        return null;
    }
    }


    public Object getOrDefault(Object key, Object value) { //It returns the value to which the specified key is mapped, or defaultValue if the map contains no mapping for the key.
        Object obj = value;
        Node node = buckets[calculateIndex(key)];
        if(node.getKey() == key)
            return node.getData();
        while(node.getNext() != null){
            if(node.getKey()==key)
                obj = node.getData();
        }
        return obj;
    }

    public int size() { //Number of Nodes in the Linked List

        int i = 0;
        for(int x = 0; x < buckets.length; x++){//fix loop(null point)
            Node x = buckets[x];
            if(x.getData() != null)
                i++;
            while(x.getNext()!=null){
                i++;
                x = x.getNext();
            }
        }
        return i;
    }

    public Object replace(Object key, Object value) { //Return old value being replaced. Returns null if key does not exist already.
        Object obj = null;
        Node node = buckets[calculateIndex(key)];
        if(buckets[calculateIndex(key)].getKey() == key){
            obj = node.getData();
            node.setData(value);
        }
        else {
            while (node.getNext() != null) {
                if (node.getKey().equals(key)) {
                    obj = node.getData();
                    node.setData(value);
                }
                node = node.getNext();
            }
        }
        return obj;
    }

    public void display() { //Outputs all items in Hashmap (should include key and value)
        for(int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket "+ i + ":");
            Node node = buckets[i];

            while (node.getNext() != null) {
                System.out.print("Data "+node.getData()+" Key "+node.getKey());
                node = node.getNext();
            }
            System.out.print("Data "+node.getData()+" Key "+node.getKey());
            System.out.println(" ");
        }
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
        public Node getNext() {
            return next;
        }
        public Object getData() {
            return value;
        }
        public int getHash() { return hash;}
        public Object getKey() {return key;}
        public void setNext(Node next) {this.next = next;}
        public void setData(Object value){
            this.value = value;
        }




    }
}
