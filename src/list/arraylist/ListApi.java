package list.arraylist;

/**
 * Api for creating, initializing and manipulating a List.
 */
public interface ListApi<E> {

	void add(int index, E e) throws IndexOutOfBoundsException;

	void add(E e) throws IndexOutOfBoundsException;

	E get(int index) throws IndexOutOfBoundsException;

	boolean isEmpty();

	int size();

	int indexOf(E e);

	boolean remove(E e);

	boolean removeAtIndex(int index);

	void removeAll();

	boolean contains(E e);

	boolean replace(E e);

	E set(int index, E e);
}