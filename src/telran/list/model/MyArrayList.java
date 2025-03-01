package telran.list.model;

import telran.list.intefaces.IList;

import java.util.Arrays;
import java.util.Iterator;


public class MyArrayList<E> implements IList<E> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elements;
    private int size;


    public MyArrayList() {
//        elements = new Object[10];
        this(10);
    }

    //O(1)
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);
        }
        if (initialCapacity > MAX_ARRAY_SIZE) {
            initialCapacity = MAX_ARRAY_SIZE;
        }

        elements = new Object[initialCapacity];
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(n), add to end O(1)
    @Override
    public boolean add(int index, E element) {
        ensureCapacity();
        if (index == size) {
            elements[size++] = element;
            return true;
        }
        checkIndex(index);
        System.arraycopy(elements, index, elements, index + 1, size++ - index);
        elements[index] = element;
        return true;
    }

    //O(1), O(n)Arrays.copyOf(elements, newCapacity);
    private void ensureCapacity() {
        if (size == MAX_ARRAY_SIZE) {
            throw new OutOfMemoryError();
        }
        if (size == elements.length) {
            int newCapacity = elements.length + elements.length / 2 + 1;
            if (newCapacity > MAX_ARRAY_SIZE || newCapacity < 0) {
                newCapacity = MAX_ARRAY_SIZE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    //O(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

     // O(1)
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    //O(n)
    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (null == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    //O(n)
    @Override
    public int lastIndexOf(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (null == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    //O(n)
    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        E prevValue = (E) elements[index];
        int removedNumber = size - index - 1;
        if (removedNumber > 0) {
            System.arraycopy(elements, index + 1, elements, index, removedNumber);
        }
        elements[--size] = null;
        return prevValue;
    }

    //O(1)
    @Override
    @SuppressWarnings("unchecked")
    public E set(int index,E element){
        checkIndex(index);
        E prevValue = (E) elements[index];
        elements[index] = element;
        return prevValue;
    }


    //O(n)
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size && elements[index] != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) elements[index++];
            }

        };
    }
}