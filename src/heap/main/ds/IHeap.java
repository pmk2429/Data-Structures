package heap.main.ds;

public interface IHeap<T> {
	public void insert(T x);

	public T remove(int index) throws RuntimeException;

	public T deleteMin() throws RuntimeException;

	public T findMin();

	public T peek();

	public boolean isEmpty();

	public boolean hasLeftChild(int index);

	public boolean hasRightChild(int index);

	public T parent(int index);

}
