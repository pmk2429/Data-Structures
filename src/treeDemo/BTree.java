package treeDemo;

public class BTree {

	public static TreeNode root;

	// Nested Node class
	private static class TreeNode {
		TreeNode leftChild;
		TreeNode rightChild;
		int data;

		public TreeNode(int data) {
			leftChild = null;
			rightChild = null;
			this.data = data;
		}
	}

	public BTree() {
		root = null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	// insert node in to TREE
	public TreeNode insert(TreeNode node, int data) {
		// if the node is null
		if (node == null) {
			// create new node.
			node = new TreeNode(data);
		} else {
			// if the data to be inserted is less than
			// the current node's data, and if
			// node's leftChild is not null then insert
			// to the node's leftChild.
			if (data <= node.data) {
				if (node.leftChild != null) {
					insert(node.leftChild, data);
				} else {
					// if the leftChild is null then
					// create the new leftNode with the
					// new data.
					node.leftChild = new TreeNode(data);
				}
				// else if data is greater than the node's rightChild
				// and if node's rightChild is not null
				// then insert the data to node's right child.
			} else if (data > node.data) {
				if (node.rightChild != null) {
					insert(node.rightChild, data);
				} else {
					// if rightNode is null then create the new
					// right node with the new data.
					node.rightChild = new TreeNode(data);
				}
			}
		}
		// finally return the node.
		return node;
	}

	// recursive Overloaded method for implementing Search in tree
	public boolean search(int data) {
		boolean a = (search(root, data));
		return a;
	}

	public boolean search(TreeNode node, int data) {
		boolean isNode = false;
		if (node == null) {
			return isNode;
		}
		if (data < node.data) {
			return (search(node.leftChild, data));
		} else if (data > node.data) {
			return (search(node.rightChild, data));
		}
		return true;
	}

	// Delete specific node from tree
	public TreeNode delete(TreeNode node, int data) {
		try {
			if (node == null) {
				// if node is null, then print the appropriate error message.
				System.out.println("Node : " + data + " not found!!!");
			} else if (compare(node.data, data) < 0) {
				// if data is less than current node's data
				// then delete the leftChild
				node.leftChild = delete(node.leftChild, data);
			} else if (compare(node.data, data) > 0) {
				// if data is greater than current node's data
				// delete the rightChild.
				node.rightChild = delete(node.rightChild, data);
			} else {
				// else if rightChild is null then return the leftChild.
				if (node.rightChild == null) {
					System.out.println("Node deleted: " + data);
					return node.leftChild;
				} else if (node.leftChild == null) {
					// if leftChild is null then return rightChild.
					System.out.println("Node deleted: " + data);
					return node.rightChild;
				} else {
					// this condition is used to delete the minimum node
					// in the right subTree or the max node in the
					// left subtree.
					// In other words this condition is used to delete
					// predecessor or the successor of the current node.
					TreeNode dNode = node;
					node = min(dNode.rightChild);
					// OR we can also get max(dNode.rightChild);
					/**
					 * These scenarios are use to handle an uneven BST For such
					 * a tree, see example in the BST doc attached to the
					 * folder.
					 */
					node.rightChild = deleteMin(dNode.rightChild);
					node.leftChild = dNode.leftChild;
					System.out.println("Node deleted: " + data);
				}
			}
		} catch (Exception e) {
			System.out.println("Node does not exist!!!");
			System.out.println(e.getMessage());
		}
		return node;
	}

	private TreeNode deleteMin(TreeNode node) {
		if (node.leftChild == null) {
			return node.rightChild;
		}
		node.leftChild = deleteMin(node.leftChild);
		return node;
	}

	private TreeNode min(TreeNode node) {
		/**
		 * if leftChild is null then simply return node else keep going left to
		 * node.
		 */
		if (node.leftChild == null) {
			return node;
		} else {
			return min(node.leftChild);
		}
	}

	public void printTree() {
		System.out.print("Inorder Traversal: ");
		printInorderTree(root);
		System.out.println();
		System.out.print("Preorder Traversal: ");
		printPreorderTree(root);
		System.out.println();
		System.out.print("Postorder Traversal: ");
		printPostorderTree(root);
		System.out.println();
	}

	private void printInorderTree(TreeNode node) {
		if (node == null)
			return;
		printInorderTree(node.leftChild);
		System.out.print(node.data + "  ");
		printInorderTree(node.rightChild);
	}

	private void printPreorderTree(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.data + "  ");
		printPreorderTree(node.leftChild);
		printPreorderTree(node.rightChild);
	}

	private void printPostorderTree(TreeNode node) {
		if (node == null)
			return;
		printPostorderTree(node.leftChild);
		printPostorderTree(node.rightChild);
		System.out.print(node.data + "  ");
	}

	private TreeNode findMinNode(TreeNode node, int data) {
		TreeNode minNode = null, temp = null;
		if (node == null) {
			return node;
		}
		temp = node.leftChild;
		while (temp.leftChild != null) {
			temp = temp.leftChild;
		}
		minNode = temp;
		return minNode;
	}

	private TreeNode findMaxNode(TreeNode node, int data) {
		TreeNode maxNode = null, temp = null;
		if (node == null) {
			return node;
		}
		temp = node.rightChild;
		while (temp.rightChild != null) {
			temp = temp.rightChild;
		}
		maxNode = temp;
		return maxNode;
	}

	private TreeNode findPredecessor(int data) {
		return findPredecessor(root, data);
	}

	private TreeNode findPredecessor(TreeNode root, int data) {
		TreeNode predecessor = null;
		if (root == null) {
			return root;
		}
		if (root.data == data) {
			if (root.leftChild != null) {
				TreeNode temp = root.leftChild;
				while (temp.rightChild != null) {
					temp = temp.rightChild;
				}
				predecessor = temp;
			}

		}
		if (root.data < data) {
			predecessor = root;
			findPredecessor(predecessor, data);
		} else {
			System.out.println("Sorry! No predecessor in this part of TREE!!!");
		}
		return predecessor;

	}

	private TreeNode findSuccessor(int data) {
		return findSuccessor(root, data);
	}

	private TreeNode findSuccessor(TreeNode root, int data) {
		TreeNode successor = null;
		if (root == null) {
			return root;
		}
		if (root.data == data) {
			if (root.rightChild != null) {
				TreeNode temp = root.rightChild;
				while (temp.leftChild != null) {
					temp = temp.leftChild;
				}
				successor = temp;
			}
		}
		if (root.data > data) {
			successor = root;
			findSuccessor(successor, data);
		} else {
			System.out.println("Sorry! No successor in this part of TREE");
		}
		return successor;
	}

	public int compare(int data, int data2) {

		return data2 - data;
	}

	public static void main(String[] args) {
		BTree tree = new BTree();
		tree.insert(11);
		tree.insert(8);
		tree.insert(12);
		tree.insert(4);
		tree.insert(9);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		tree.insert(13);
		System.out.println();
		tree.printTree();

		System.out.println();
		TreeNode predecessor = tree.findPredecessor(11);
		System.out.println("Predecessor of 11: " + predecessor.data);

		System.out.println();
		TreeNode successor = tree.findSuccessor(11);
		System.out.println("Successor of 11: " + successor.data);

		System.out.println();
		TreeNode largest = tree.findMaxNode(root, 11);
		System.out.println("Largest node in Tree: " + largest.data);

		System.out.println();
		TreeNode smallest = tree.findMinNode(root, 11);
		System.out.println("Smallest node in Tree: " + smallest.data);

	}
}
