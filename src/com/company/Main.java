package com.company;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        System.out.println(arr.removeAll(1));

        System.out.println(arr);

    }
    //Method to swap two elements in an arraylist.

    private static void swap(ArrayList<Integer> arr, int el1, int el2) {
        int temp = arr.get(el1);
        arr.set(el1, arr.get(el2));
        arr.set(el2, temp);
    }

    //Method to revers an arraylist using recursion.
    private static void reverse(ArrayList<Integer> arr) {

        if (arr.size() > 1) {
            int val = arr.remove(0);
            reverse(arr);
            arr.add(val);
        }
    }

    /*Implement the rotate() method that rotates the elements in cyclic
    order following is the method signature:
    Static void rotate (com.company.MyArrayList list, int r)
    : Rotates the elements in the arraylist list by the specified distance r.*/
    static ArrayList rotate(ArrayList<Integer> list, int r) {
        ArrayList<Integer> copy = new ArrayList<>();

        int stop = Math.abs(list.size() - r) % list.size();
        for (int i = stop; i < list.size(); i++) {
            copy.add(list.get(i));
        }

        for (int i = 0; i < stop; i++) {
            copy.add(list.get(i));
        }
        return copy;
    }

    //Write a method to merge two sorted ArrayLists.
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                arr.add(arr1.get(i++));

            } else {
                arr.add(arr2.get(j++));
            }

        }
        while (j < arr2.size()) {
            arr.add(arr2.get(j++));
        }
        while (i < arr1.size()) {
            arr.add(arr2.get(j++));
        }
        return arr;
    }

}

