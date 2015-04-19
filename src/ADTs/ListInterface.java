package ADTs;

//ListInterface start
public interface ListInterface {
	
	
	public boolean isEmpty();
	
	public int size();
	
	public void removeAtIndex(int index);
	
	public void removeAll();
	
	public void add(int index, Object item) throws IndexOutOfBoundsException;
	
	public Object get(int index) throws IndexOutOfBoundsException;

	
}
//ListInterface ends
