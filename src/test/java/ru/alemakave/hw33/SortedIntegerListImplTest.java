package ru.alemakave.hw33;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortedIntegerListImplTest {
    private SortedIntegerListImpl integerList = new SortedIntegerListImpl();

    @Test
    public void indexOf() {
        integerList = generateArray(10);

        integerList.set(5, 128);
        integerList.set(8, 128);
        assertEquals(integerList.indexOf(128), 4);
    }

    @RepeatedTest(1000)
    public void indexOf_NotFound() {
        assertEquals(integerList.indexOf(new Random().nextInt(1000)), -1);
    }

    private static SortedIntegerListImpl generateArray(int size) {
        Random random = new Random(20231028);
        SortedIntegerListImpl integerList = new SortedIntegerListImpl();

        for (int i = 0; i < size; i++) {
            integerList.add(random.nextInt());
        }

        return integerList;
    }
}