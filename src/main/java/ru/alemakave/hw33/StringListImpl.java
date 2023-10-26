package ru.alemakave.hw33;

import ru.alemakave.hw33.exceptions.NotFoundElement;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] items = new String[0];
    private int countItems = 0;

    public StringListImpl() {}

    public StringListImpl(String... items) {
        this.items = items;
        countItems = items.length;
    }

    @Override
    public String add(String item) {
        if (items.length == countItems) {
            String[] newItemsArray = new String[countItems + 1];
            System.arraycopy(items, 0, newItemsArray, 0, items.length);
            items = newItemsArray;
        }
        items[countItems] = item;
        countItems++;

        return item;
    }

    // Если index == 0, то вставляется самым первым элемент item
    @Override
    public String add(int index, String item) {
        if (index < 0 || index >= countItems + 1) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }

        //Создание нового массива
        String[] newItemsArray;
        if (items.length == countItems) {
            newItemsArray = new String[items.length + 1];
        } else {
            newItemsArray = new String[items.length];
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
    public String set(int index, String item) {
        if (index >= countItems) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }
        items[index] = item;

        return item;
    }

    @Override
    public String remove(String item) {
        boolean isFounded = false;
        for (int i = 0; i < countItems; i++) {
            if (items[i].equals(item)) {
                items[i] = null;
                countItems--;
                isFounded = true;
            }
        }
        if (!isFounded) {
            throw new NotFoundElement(String.format("Элемент %s не найден.", item));
        }
        compress();

        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= countItems) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }
        String result = items[index];
        items[index] = null;
        countItems--;
        compress();

        return result;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < countItems; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = countItems - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= countItems) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы фактического количества элементов.", index));
        }
        return items[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        items = new String[0];
    }

    @Override
    public String[] toArray() {
        String[] result = new String[size()];
        System.arraycopy(items, 0, result, 0, result.length);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    /**
     * Перенести все "null" элементы в конец массива
     */
    private void compress() {
        int lastEmptyIndex = -1;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && lastEmptyIndex > 0) {
                items[lastEmptyIndex] = items[i];
                items[i] = null;
                lastEmptyIndex++;
            } else if (items[i] == null && lastEmptyIndex == -1) {
                lastEmptyIndex = i;
            }
        }
    }
}
