package ru.alemakave.hw33;

public interface StringList {
    /**
     * Добавление элемента.
     * @param item элемент.
     * @return добавленный элемент в качестве результата выполнения.
     */
    String add(String item);

    /**
     * Добавление элемента на определенную позицию списка.
     * @param index позиция из списка.
     * @param item элемент.
     * @exception IndexOutOfBoundsException {@code index} выходит за пределы фактического количества элементов или массива.
     * @return добавленный элемент.
     */
    String add(int index, String item);

    /**
     * Установить элемент на определенную позицию, затерев существующий.
     * @param index позиция из списка.
     * @param item элемент.
     * @exception IndexOutOfBoundsException {@code index} выходит за пределы фактического количества элементов или массива.
     * @return добавленный элемент.
     */
    String set(int index, String item);

    /**
     * Удаление элемента.
     * @param item элемент.
     * @exception ru.alemakave.hw33.exceptions.NotFoundElement элемент {@code item} отсутствует в списке.
     * @return удаленный элемент
     */
    String remove(String item);

    /**
     * Удаление элемента по индексу.
     * @param index индекс элемента.
     * @exception IndexOutOfBoundsException {@code index} выходит за пределы фактического количества элементов или массива.
     * @return удаленный элемент
     */
    String remove(int index);

    /**
     * Проверка на существование элемента.
     * @param item проверяемый элемент.
     * @return {@code true} если элемент есть в списке. {@code false} если элемента в списке нет.
     */
    boolean contains(String item);

    /**
     * Поиск индекса элемента.
     * @param item искомый элемент.
     * @return индекс элемента или -1 в случае отсутствия.
     */
    int indexOf(String item);

    /**
     * Поиск индекса элемента с конца.
     * @param item искомый элемент.
     * @return индекс элемента или -1 в случае отсутствия.
     */
    int lastIndexOf(String item);

    /**
     * Получить элемент по индексу.
     * @param index индекс элемента.
     * @exception IndexOutOfBoundsException {@code index} выходит за пределы фактического количества элементов или массива.
     * @return найденный элемент
     */
    String get(int index);

    /**
     * Сравнить текущий список с другим.
     * @exception NullPointerException передан в {@code otherList} null
     * @return {@code true} текущий список равен переданному. {@code false} текущий список не равен переданному.
     */
    boolean equals(StringList otherList);

    /**
     * @return фактическое количество элементов.
     */
    int size();

    /**
     * @return {@code true} если элементов в списке нет, иначе {@code false}.
     */
    boolean isEmpty();

    /**
     * Удалить все элементы из списка.
     */
    void clear();

    /**
     * Создать новый массив из строк в списке и вернуть его.
     */
    String[] toArray();
}
