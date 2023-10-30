package ru.alemakave.hw33;

import ru.alemakave.hw33.utils.SortUtils;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        homework34();
    }

    private static void homework33() {
        StringListImpl list = new StringListImpl("QWE");
        System.out.println(list.set(0, "Q"));
        System.out.println(list.add("w"));
        System.out.println(list.add("e"));
        System.out.println(list.add("r"));
        System.out.println(list.add("t"));
        System.out.println(list.add("y"));
        System.out.println(list.add("U"));
        System.out.println(list.add("i"));
        System.out.println(list.add("o"));
        System.out.println(list.add("p"));
        System.out.println(list);
        System.out.println(list.size());
        list.remove(4);
        list.remove(5);
        System.out.println(list);
        System.out.println(list);
        System.out.println(list.size());
        list.add("q");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.indexOf("q"));
        System.out.println(list);
        list.add(0, "W");
        System.out.println(list.lastIndexOf("W"));
        System.out.println(list);
        list.add(5, "Y");
        System.out.println(list);
    }

    private static void homework34() {
//        findFastedSortMethod();
        Random random = new Random(20231028);
        SortedIntegerListImpl sortedIntegerList = new SortedIntegerListImpl();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            sortedIntegerList.add(random.nextInt(100));
            System.out.printf("\r%d", i);
        }
        System.out.println(System.currentTimeMillis() - start + " ms.");

        start = System.currentTimeMillis();
        sortedIntegerList.contains(1280);
        System.out.println(System.currentTimeMillis() - start + " ms.");
    }

    private static void findFastedSortMethod() {
        Integer[] integers = generateArray(100_000).toArray();

        System.out.println("Bubble sort");
        long start = System.currentTimeMillis();
        SortUtils.bubbleSort(Arrays.copyOf(integers, integers.length));
        System.out.println(System.currentTimeMillis() - start + " ms.");

        System.out.println("Selection sort");
        start = System.currentTimeMillis();
        SortUtils.selectionSort(Arrays.copyOf(integers, integers.length));
        System.out.println(System.currentTimeMillis() - start + " ms.");

        System.out.println("Insertion sort");
        start = System.currentTimeMillis();
        SortUtils.insertionSort(Arrays.copyOf(integers, integers.length));
        System.out.println(System.currentTimeMillis() - start + " ms.");
    }

    private static IntegerListImpl generateArray(int size) {
        Random random = new Random(20231028);
        IntegerListImpl integerList = new IntegerListImpl();

        for (int i = 0; i < size; i++) {
            integerList.add(random.nextInt());
        }

        return integerList;
    }
}
