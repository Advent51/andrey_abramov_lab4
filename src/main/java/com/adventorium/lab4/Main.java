package com.adventorium.lab4;

import java.util.*;

/**
 * Created by Андрей on 11.05.2016.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        mesuring(arrayList);
        mesuring(linkedList);
    }

    static void mesuring(AbstractList list){
        /**
         * Sequential Addition
         */
        long timeBefore = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        long timeAfter = System.nanoTime();
        System.out.println("Sequential Addition time for "+list.getClass().toString()+" is: "+(timeAfter-timeBefore));

        /**
         * Random addition
         */
        timeBefore = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomValue = random.nextInt();
            int randomIndex = random.nextInt(list.size()-1);
            list.add(randomIndex, randomValue);
        }
        timeAfter = System.nanoTime();
        System.out.println("Random addition time for "+list.getClass().toString()+" is: "+(timeAfter-timeBefore));

        /**
         * Random get
         */
        timeBefore = System.nanoTime();
        for(int i = 0; i<1000; i++){
            int randomIndex = random.nextInt(list.size()-1);
            list.get(randomIndex);
        }
        timeAfter = System.nanoTime();
        System.out.println("Random get time for "+list.getClass().toString()+" is: "+(timeAfter-timeBefore));

        /**
         * Iterator
         */
        timeBefore = System.nanoTime();
        for(Iterator<Integer> i=list.iterator(); i.hasNext();){
            i.next();
        }
        timeAfter = System.nanoTime();
        System.out.println("Iterator time for "+list.getClass().toString()+" is: "+(timeAfter-timeBefore));

        /**
         * Sort
         */
        timeBefore = System.nanoTime();
        list.sort(null);
        timeAfter = System.nanoTime();
        System.out.println("Sort time for "+list.getClass().toString()+" is: "+(timeAfter-timeBefore));

        /**
         * Random remove
         */
        timeBefore = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = random.nextInt(list.size()-1);
            list.remove(randomIndex);
        }
        timeAfter = System.nanoTime();
        System.out.println("Random remove time for "+list.getClass().toString()+" is: "+(timeAfter-timeBefore));
    }
}
