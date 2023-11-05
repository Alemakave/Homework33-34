package ru.alemakave.hw33;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import ru.alemakave.hw33.exceptions.NotFoundElementException;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private IntegerListImpl integerList = new IntegerListImpl();

    @RepeatedTest(100)
    public void add_Success() {
        int randomInt = new Random().nextInt();
        assertEquals(integerList.add(randomInt), randomInt);
    }

    @Test
    public void addByIndex_Success() {
        integerList = generateArray(10);

        assertEquals(integerList.add(1, 128), 128);

        assertEquals(integerList.toString(), Arrays.toString(new int[] {-397161316, 128, 813520027, 1045430627, 1683871746, 835619420, 1981148535, 1762207978, 917131253, -903940710, -2051032533}));
    }

    @Test
    public void addByIndex_IndexOutOfBoundsException() {
        integerList = generateArray(10);

        integerList.remove(0);
        integerList.remove(0);

        assertThrows(IndexOutOfBoundsException.class, () -> integerList.add(9, 12));
    }

    @Test
    public void set_Success() {
        integerList = generateArray(10);
        assertEquals(integerList.set(1, 128), 128);

        assertEquals(integerList.toString(), Arrays.toString(new int[] {-397161316, 128, 1045430627, 1683871746, 835619420, 1981148535, 1762207978, 917131253, -903940710, -2051032533}));
    }

    @Test
    public void set_IndexOutOfBoundsException() {
        integerList = generateArray(10);
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.set(10, 15));
    }

    @Test
    public void remove_Success() {
        integerList = generateArray(10);

        assertEquals(integerList.remove((Integer)813520027), 813520027);
        assertEquals(integerList.toString(), Arrays.toString(new int[] {-397161316, 1045430627, 1683871746, 835619420, 1981148535, 1762207978, 917131253, -903940710, -2051032533}));
    }

    @Test
    public void remove_NotFoundElementException() {
        integerList = generateArray(10);
        assertThrows(NotFoundElementException.class, () -> integerList.remove((Integer) 128));
    }

    @Test
    public void removeByIndex_Success() {
        integerList = generateArray(10);

        assertEquals(integerList.remove(3), 1683871746);
        assertEquals(integerList.remove(3), 835619420);
        assertEquals(integerList.remove(3), 1981148535);
        assertEquals(integerList.remove(4), 917131253);
        assertEquals(integerList.toString(), Arrays.toString(new int[] {-397161316, 813520027, 1045430627, 1762207978, -903940710, -2051032533}));
    }
    @Test
    public void removeByIndex_IndexOutOfBoundsException() {
        integerList = generateArray(10);

        integerList.remove(0);

        assertThrows(IndexOutOfBoundsException.class, () -> integerList.remove(9));
    }

    @Test
    public void contains() {
        integerList = generateArray(10);

        assertTrue(integerList.contains(813520027));
    }

    @Test
    public void indexOf() {
        integerList = generateArray(10);

        integerList.set(5, 128);
        integerList.set(9, 128);
        assertEquals(integerList.indexOf(128), 5);
        assertEquals(integerList.indexOf(512), -1);
    }

    @Test
    public void lastIndexOf() {
        integerList = generateArray(10);

        integerList.set(5, 128);
        integerList.set(9, 128);
        assertEquals(integerList.lastIndexOf(128), 9);
        assertEquals(integerList.lastIndexOf(512), -1);
    }

    @Test
    public void get_Success() {
        integerList = generateArray(10);

        assertEquals(integerList.get(5), 1981148535);
    }

    @Test
    public void get_IndexOutOfBoundsException() {
        integerList = generateArray(10);

        assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(10));
    }

    @Test
    public void equals_Success() {
        integerList = generateArray(10);
        IntegerList newStringList = generateArray(10);
        assertTrue(integerList.equals(newStringList));
    }

    @Test
    public void size() {
        integerList = generateArray(10);

        assertEquals(integerList.size(), 10);
    }

    @Test
    public void isEmpty() {
        integerList = generateArray(10);

        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void clear() {
        integerList = generateArray(10);
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void toArray() {
        integerList = generateArray(10);
        assertArrayEquals(integerList.toArray(), new Integer[] {-397161316, 813520027, 1045430627, 1683871746, 835619420, 1981148535, 1762207978, 917131253, -903940710, -2051032533});
    }

    @Test
    public void allMethodsThrowNullPointerExceptionIfTransferredNullItem() {
        integerList = generateArray(10);
        assertThrows(NullPointerException.class, () -> integerList.add(null));
        assertThrows(NullPointerException.class, () -> integerList.add(0, null));
        assertThrows(NullPointerException.class, () -> integerList.set(0, null));
        assertThrows(NullPointerException.class, () -> integerList.remove(null));
        assertThrows(NullPointerException.class, () -> integerList.contains(null));
        assertThrows(NullPointerException.class, () -> integerList.indexOf(null));
        assertThrows(NullPointerException.class, () -> integerList.lastIndexOf(null));
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