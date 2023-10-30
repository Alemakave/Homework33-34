package ru.alemakave.hw33;

import ru.alemakave.hw33.utils.SortUtils;

import java.util.Arrays;
import java.util.Collections;

public class SortedIntegerListImpl extends IntegerListImpl {
    public SortedIntegerListImpl() {
        super();

        sort();
    }

    @Override
    public Integer add(Integer item) {
        super.add(item);

        sort();

        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        super.add(index, item);

        sort();

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        super.set(index, item);

        sort();

        return item;
    }

    @Override
    public Integer remove(Integer item) {
        super.remove(item);

        sort();

        return item;
    }

    @Override
    public Integer remove(int index) {
        Integer result = super.remove(index);

        sort();

        return result;
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }
        sort();

        int resultIndex = Collections.binarySearch(Arrays.asList(items), item);

        if (resultIndex < 0) {
            return -1;
        } else {
            return resultIndex;
        }
    }

    private void sort() {
        SortUtils.selectionSort(items);
    }

    @Override
    protected void compress() {
        Integer[] newArray = new Integer[size()];

        int j = 0;

        for (Integer item : items) {
            if (item != null) {
                newArray[j] = item;
                j++;
            }
        }

        items = newArray;
        sort();
    }
}
