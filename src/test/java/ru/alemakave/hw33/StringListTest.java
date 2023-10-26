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
        assertEquals(stringList.add(4, "t"), "t");
        assertEquals(stringList.add(6, "U"), "U");
        assertEquals(stringList.add(9, "p"), "p");
        assertEquals(stringList.add(5, "y"), "y");
        assertEquals(stringList.add(3, "r"), "r");
        assertEquals(stringList.add(2, "e"), "e");
        assertEquals(stringList.add(0, "Q"), "Q");
        assertEquals(stringList.add(7, "i"), "i");
        assertEquals(stringList.add(1, "w"), "w");
        assertEquals(stringList.add(8, "o"), "o");

        assertEquals(stringList.toString(), Arrays.toString(new String[]{"Q", "w", "e", "r", "t", "y", "U", "i", "o", "p"}));
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