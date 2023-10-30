package ru.alemakave.hw33;

import ru.alemakave.hw33.exceptions.NotFoundElementException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    Integer[] items = new Integer[0];
    private int countItems = 0;

    public IntegerListImpl() {}

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        if (items.length == countItems) {
            Integer[] newItemsArray = new Integer[countItems + 1];
            System.arraycopy(items, 0, newItemsArray, 0, items.length);
            items = newItemsArray;
        }
        items[countItems] = item;
        countItems++;

        return item;
    }

    // Если index == 0, то вставляется самым первым элемент item
    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index >= countItems + 1) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }

        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        //Создание нового массива
        Integer[] newItemsArray;
        if (items.length == countItems) {
            newItemsArray = new Integer[items.length + 1];
        } else {
            newItemsArray = new Integer[items.length];
        }

        //Перенос старых значений в новый массив
        System.arraycopy(items, 0, newItemsArray, 0, index);
        if (newItemsArray.length - (index + 1) >= 0) {
            System.arraycopy(items, index + 1 - 1, newItemsArray, index + 1, newItemsArray.length - (index + 1));
        }

        //Перенос временных значений в новый массив
        items = newItemsArray;
        items[index] = item;
        countItems++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= countItems) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }

        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        items[index] = item;

        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        int foundedCount = 0;
        for (int i = 0; i < countItems; i++) {
            if (items[i].equals(item)) {
                items[i] = null;
                foundedCount++;
            }
        }
        if (foundedCount == 0) {
            throw new NotFoundElementException(String.format("Элемент %s не найден.", item));
        }
        countItems -= foundedCount;
        compress();

        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index >= countItems) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }
        Integer result = items[index];
        items[index] = null;
        countItems--;
        compress();

        return result;
    }

    @Override
    public boolean contains(Integer item) {
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        for (int i = 0; i < countItems; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        for (int i = countItems - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= countItems) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }
        return items[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return countItems;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        items = new Integer[0];
        countItems = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size()];
        System.arraycopy(items, 0, result, 0, result.length);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    /**
     * Перенести все "null" элементы в конец массива
     */
    protected void compress() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                continue;
            }

            for (int j = i; j < items.length; j++) {
                if (items[j] != null) {
                    items[i] = items[j];
                    items[j] = null;
                    break;
                }
            }
        }
    }
}
