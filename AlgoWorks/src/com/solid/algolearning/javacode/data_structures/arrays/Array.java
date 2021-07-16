package com.solid.algolearning.javacode.data_structures.arrays;


import java.util.ArrayList;

public class Array {
    private int length;
    private ArrayList<Object> data;

    public Array() {
        length = 0;
        data = new ArrayList<>();
    }

    public Object get(int index){
        return data.get(0);
    }

    public void push(Object item){
        this.data.set(this.length, item);
        data.ensureCapacity(length++);
        this.length++;

    }

//    Implement pop()
//    Implement delete()
//    Implement shiftItems()

    @Override
    public String toString() {
        return "[length, " + length + ", data, " + data + "]";
    }

    public static void main(String[] args) {
        Array myArray = new Array();
        System.out.println(myArray.toString());
//        System.out.println(myArray.get(0));

        myArray.push("hi");
        myArray.push("you");
        myArray.push("are");
        myArray.push("cute");
//        System.out.println(myArray.push("hi2"));

    }
}
