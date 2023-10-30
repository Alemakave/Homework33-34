package ru.alemakave.hw33;

import org.junit.jupiter.api.Test;
import ru.alemakave.hw33.exceptions.NotFoundElementException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {
    private final StringList stringList = new StringListImpl();

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
    public void addByIndex_Success() {
        setupZstring();

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
    public void addByIndex_IndexOutOfBoundsException() {
        setup();

        stringList.remove(0);
        stringList.remove(0);

        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(9, "t"));
    }

    @Test
    public void set_Success() {
        setup();
        assertEquals(stringList.set(2, "K"), "K");
    }

    @Test
    public void set_IndexOutOfBoundsException() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(10, "K"));
    }

    @Test
    public void remove_Success() {
        setupZstring();
        setup();
        setupZstring();
        assertEquals(stringList.remove("z"), "z");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"Q", "w", "e", "r", "t", "y", "U", "i", "o", "p"}));
    }

    @Test
    public void remove_NotFoundElementException() {
        setupZstring();
        setup();
        setupZstring();
        assertThrows(NotFoundElementException.class, () -> stringList.remove("j"));
    }

    @Test
    public void removeByIndex_Success() {
        setupZstring();
        setup();
        setupZstring();

        assertEquals(stringList.remove(3), "z");
        assertEquals(stringList.remove(3), "z");
        assertEquals(stringList.remove(3), "z");
        assertEquals(stringList.remove(4), "z");
        assertEquals(stringList.remove(9), "r");
        assertEquals(stringList.toString(), Arrays.toString(new String[]{"z", "z", "z", "z", "z", "z", "Q", "w", "e", "t", "y", "U", "i", "o", "p", "z", "z", "z", "z", "z", "z", "z", "z", "z", "z"}));
    }

    @Test
    public void removeByIndex_IndexOutOfBoundsException() {
        setupZstring();

        stringList.remove(0);

        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(9));
    }

    @Test
    public void contains() {
        setup();

        assertTrue(stringList.contains("y"));
    }

    @Test
    public void indexOf() {
        setupZstring();
        setup();
        setupZstring();

        stringList.set(5, "g");
        stringList.set(16, "g");

        assertEquals(stringList.indexOf("g"), 5);
        assertEquals(stringList.indexOf("l"), -1);
    }

    @Test
    public void lastIndexOf() {
        setupZstring();
        setup();
        setupZstring();

        stringList.set(5, "g");
        stringList.set(16, "g");
        assertEquals(stringList.lastIndexOf("g"), 16);
        assertEquals(stringList.lastIndexOf("l"), -1);
    }

    @Test
    public void get_Success() {
        setupZstring();
        setup();
        setupZstring();

        assertEquals(stringList.get(16), "U");
    }

    @Test
    public void get_IndexOutOfBoundsException() {
        setupZstring();
        setup();
        setupZstring();

        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(30));
    }

    @Test
    public void equals_Success() {
        setup();
        StringListImpl newStringList = new StringListImpl("Q", "w", "e", "r", "t", "y", "U", "i", "o", "p");
        assertTrue(stringList.equals(newStringList));
    }

    @Test
    public void size() {
        setupZstring();
        setup();
        setupZstring();

        stringList.remove("z");
        assertEquals(stringList.size(), 10);
    }

    @Test
    public void isEmpty() {
        setupZstring();
        setupZstring();

        stringList.remove("z");
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void clear() {
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void toArray() {
        setup();
        assertArrayEquals(stringList.toArray(), new String[]{"Q", "w", "e", "r", "t", "y", "U", "i", "o", "p"});
    }

    @Test
    public void allMethodsThrowNullPointerExceptionIfTransferredNullItem() {
        setup();
        assertThrows(NullPointerException.class, () -> stringList.add(null));
        assertThrows(NullPointerException.class, () -> stringList.add(0, null));
        assertThrows(NullPointerException.class, () -> stringList.set(0, null));
        assertThrows(NullPointerException.class, () -> stringList.remove(null));
        assertThrows(NullPointerException.class, () -> stringList.contains(null));
        assertThrows(NullPointerException.class, () -> stringList.indexOf(null));
        assertThrows(NullPointerException.class, () -> stringList.lastIndexOf(null));
    }

    private void setup() {
        stringList.add("Q");
        stringList.add("w");
        stringList.add("e");
        stringList.add("r");
        stringList.add("t");
        stringList.add("y");
        stringList.add("U");
        stringList.add("i");
        stringList.add("o");
        stringList.add("p");
    }

    private void setupZstring() {
        int countItems = 10;
        for (int i = 0; i < countItems; i++) {
            stringList.add("z");
        }
    }
}