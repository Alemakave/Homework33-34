package ru.alemakave.hw33;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {
    private StringList stringList = new StringListImpl();

    @Test
    public void add_Success() {
        assertEquals(stringList.add("Q"), "Q");
        assertEquals(stringList.add("w"), "w");
        assertEquals(stringList.add("e"), "e");
        assertEquals(stringList.add("r"), "r");
        assertEquals(stringList.add("t"), "t");
        assertEquals(stringList.add("y"), "y");
        assertEquals(stringList.add("U"), "U");
        assertEquals(stringList.add("i"), "i");
        assertEquals(stringList.add("o"), "o");
        assertEquals(stringList.add("p"), "p");

        assertEquals(stringList.toString(), Arrays.toString(new String[]{"Q", "w", "e", "r", "t", "y", "U", "i", "o", "p"}));
    }

    @Test
    public void addByIndex() {
        int countItems = 10;
        for (int i = 0; i < countItems; i++) {
            stringList.add("z");
        }

        assertEquals(stringList.add(4, "t"), "t");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"z", "z", "z", "z", "t", "z", "z", "z", "z", "z", "z"}));
        assertEquals(stringList.add(6, "U"), "U");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"z", "z", "z", "z", "t", "z", "U", "z", "z", "z", "z", "z"}));
        assertEquals(stringList.add(9, "p"), "p");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"z", "z", "z", "z", "t", "z", "U", "z", "z", "p", "z", "z", "z"}));
        assertEquals(stringList.add(5, "y"), "y");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"z", "z", "z", "z", "t", "y", "z", "U", "z", "z", "p", "z", "z", "z"}));
        assertEquals(stringList.add(3, "r"), "r");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"z", "z", "z", "r", "z", "t", "y", "z", "U", "z", "z", "p", "z", "z", "z"}));
        assertEquals(stringList.add(2, "e"), "e");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"z", "z", "e", "z", "r", "z", "t", "y", "z", "U", "z", "z", "p", "z", "z", "z"}));
        assertEquals(stringList.add(0, "Q"), "Q");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"Q", "z", "z", "e", "z", "r", "z", "t", "y", "z", "U", "z", "z", "p", "z", "z", "z"}));
        assertEquals(stringList.add(7, "i"), "i");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"Q", "z", "z", "e", "z", "r", "z", "i", "t", "y", "z", "U", "z", "z", "p", "z", "z", "z"}));
        assertEquals(stringList.add(1, "w"), "w");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"Q", "w", "z", "z", "e", "z", "r", "z", "i", "t", "y", "z", "U", "z", "z", "p", "z", "z", "z"}));
        assertEquals(stringList.add(8, "o"), "o");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"Q", "w", "z", "z", "e", "z", "r", "z", "o", "i", "t", "y", "z", "U", "z", "z", "p", "z", "z", "z"}));
    }

    @Test
    public void set() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void lastIndexOf() {
    }

    @Test
    public void get() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void toArray() {
    }
}