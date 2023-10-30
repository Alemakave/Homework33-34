package ru.alemakave.hw33;

public class Main {
    public static void main(String[] args) {
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
}
