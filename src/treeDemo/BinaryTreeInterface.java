package treeDemo;

public interface BinaryTreeInterface {
	public Node addNode(int key, String name);
	public void deleteNode();
	public void search();
	public int height();
	public int depth();
	public int maximum();
	public Node findMaximum();
	public Node findMinimum();
	
}
