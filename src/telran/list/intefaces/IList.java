package telran.list.intefaces;

public interface IList<E> extends Iterable<E> {

    // O(1)
    default boolean add(E element) {
        return add(size(), element);
    }

    //O(n2)
    default void clear() {
        while (!isEmpty()) {
            remove(0);
        }
    }

    //O(n)
    default boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    //O(1)
    default boolean isEmpty() {
        return size() == 0;
    }

    //O(n)
    default boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }
    //O(1)
    int size();

    //O(n)  //O(1)
    boolean add(int index, E element);

    //O(1)
    E get(int index);

    //O(n)
    int indexOf(Object o);

    //O(n)
    int lastIndexOf(Object o);

    //O(n)
    E remove(int index);

    //O(1)
    E set(int index, E element);


}
