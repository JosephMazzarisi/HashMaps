package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyHashMap myHashMap = new MyHashMap();
        System.out.println(myHashMap.isEmpty());
        myHashMap.put("Dog", "Woof woof");
        myHashMap.put("Dogg","Bow wow");
        System.out.println(myHashMap.size());
      //  System.out.println(myHashMap.get("Dog"));
        myHashMap.display();
       // System.out.println("HashMap is emptied");
      //  myHashMap.empty();
      //  myHashMap.display();


    }
}

