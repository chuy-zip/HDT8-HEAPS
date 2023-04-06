
public class BTHeap<T> {
	private int TreeSize;
	private Node<T> root;
	
	/**
	 * The function swaps the values of two nodes.
	 * 
	 * @param a a is a parameter of type Node, which represents one of the nodes in a linked list.
	 * @param b The parameter "b" is a Node object.
	 */
	private void swap(Node a, Node b) {	
		T temp = (T) a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);	
	}
	
	/**
	 * This Java function returns the binary representation of the position of a value in a tree as a
	 * string.
	 * 
	 * @param value The parameter "value" is of type T, which means it can be any data type (e.g. Integer,
	 * String, Object) depending on how the method is called. However, it is not used in the
	 * implementation of the method.
	 * @return The method `route` returns a `String` representing the route to a node with the given value
	 * in a binary tree.
	 */
	private String route(T value) {
		var size = TreeSize;
		var position = size + 1;
		var binary = Integer.toBinaryString(position);
		var branchRoute = binary.substring(1);
		
		return branchRoute;
	}
	
	/**
	 * This function inserts a new node with a given value into a binary tree.
	 * 
	 * @param value The value to be inserted into the binary tree.
	 */
	public void insert(T value) {
	    if (root == null) {
	        root = new Node<T>(value, null);
	        TreeSize = 1;
	    } else {
	        var branchRoute = route(value);
	        var newNode = insert(root, branchRoute, value);
	        shiftUp(newNode);
	    }
	}

	/**
	 * This function inserts a new node with a given value into a binary tree based on a given branch
	 * route.
	 * 
	 * @param root The root node of the binary tree where the new node will be inserted.
	 * @param branchRoute A string representing the path to the node where the new value will be inserted.
	 * Each character in the string represents a left or right turn in the tree traversal. For example,
	 * "001" would mean to take a left turn at the root node, then another left turn at the next node, and
	 * @param value The value to be inserted into the binary tree.
	 * @return The method returns a Node<T> object, which is the newly inserted node in the binary tree.
	 */
	private Node<T> insert(Node<T> root, String branchRoute, T value){

	    var nextNode = "" + branchRoute.charAt(0);
	    if(branchRoute.length() > 1) {
	        var node = (nextNode.equals("0")) ? root.getLeft() : root.getRight();
	        return insert(node, branchRoute.substring(1), value);
	    }

	    TreeSize = TreeSize + 1;

	    var newNode = new Node<T>(value, root);

	    Node<T> node = null;
	    if (nextNode.equals("0")) {    
	        node = root.getLeft();
	        newNode.setParent(root);
	        root.setLeft(newNode);

	    } else {
	        node = root.getRight();
	        newNode.setParent(root);
	        root.setRight(newNode);
	    }

	    return newNode;
	}
	
	/**
	 * This function shifts a node up in a binary heap data structure until it satisfies the heap
	 * property.
	 * 
	 * @param current The current node being shifted up in a binary heap.
	 */
	private void shiftUp(Node<T> current) {
	    Patient currentVal = (Patient) current.getValue();

	    while (current != root) {
	        Node<T> parent = current.getParent();
	        Patient parentVal = (Patient) parent.getValue();

	        if (currentVal.compareTo(parentVal) < 0) {
	            swap(parent, current);
	            current = parent;
	        } else {
	            break;
	        }
	    }
	}

	/**
	 * The function prints the values of all nodes in a binary tree in a specific order.
	 */
	public void printTree() {
	    for (int i = 1; i <= TreeSize; i++) {
	        var binary = Integer.toBinaryString(i);
	        var branchRoute = binary.substring(1);
	        var node = getNodeToPrint(root, branchRoute);
	        if (node != null) {
	            System.out.println(node.getValue().toString());
	        }
	    }
	}

	/**
	 * This function returns the node to print based on the given branch route.
	 * 
	 * @param root The root node of a binary tree.
	 * @param branchRoute branchRoute is a string that represents the path to a specific node in a binary
	 * tree. It consists of a sequence of 0s and 1s, where each 0 represents a left branch and each 1
	 * represents a right branch. The method uses this parameter to traverse the tree and return
	 * @return The method is returning a Node<T> object.
	 */
	private Node<T> getNodeToPrint(Node<T> root, String branchRoute) {
	    if (branchRoute.isEmpty()) {
	        return root;
	    }
	    var node = (branchRoute.charAt(0) == '0') ? root.getLeft() : root.getRight();
	    if (node == null) {
	        return null;
	    }
	    return getNodeToPrint(node, branchRoute.substring(1));
	}
	
	/**
	 * This function removes the root node from a binary tree and returns its value.
	 * 
	 * @return The method is returning the value of the root node that was removed from the binary heap.
	 */
	public T remove() {
	    if (root == null) {
	        System.out.println("La cola ahora esta vacia");
	        return null;
	    }
	    
	    T rootValue = root.getValue();
	    Node<T> lastNode = getLastNode();
	    
	    if (lastNode == root) {
	        root = null;
	    } else {
	        root.setValue(lastNode.getValue());
	        if (lastNode.getParent().getLeft() == lastNode) {
	            lastNode.getParent().setLeft(null);
	        } else {
	            lastNode.getParent().setRight(null);
	        }
	        shiftDown(root);
	    }
	    
	    TreeSize--;
	    return rootValue;
	}

	/**
	 * This function returns the last node in a binary tree by iterating through the binary representation
	 * of the tree size.
	 * 
	 * @return The method is returning the last node in the binary tree.
	 */
	private Node<T> getLastNode() {
	    if (root == null) {
	        return null;
	    }
	    
	    int binarySize = Integer.toBinaryString(TreeSize).length() - 1;
	    String binaryString = Integer.toBinaryString(TreeSize);
	    
	    Node<T> current = root;
	    for (int i = 1; i <= binarySize; i++) { // iterate to binarySize instead of binarySize - 1
	        if (binaryString.charAt(i) == '0') {
	            current = current.getLeft();
	        } else {
	            current = current.getRight();
	        }
	    }
	    return current;
	}

	/**
	 * This function shifts down a node in a binary tree until it reaches its correct position based on
	 * the value of its children.
	 * 
	 * @param current The current node being evaluated and potentially shifted down in a binary heap data
	 * structure.
	 */
	private void shiftDown(Node<T> current) {
	    while (current.getLeft() != null) {
	        Node<T> minChild = current.getLeft();
	        if (current.getRight() != null && ((Patient) current.getRight().getValue()).compareTo((Patient) minChild.getValue()) < 0) {
	            minChild = current.getRight();
	        }
	        if (((Patient) current.getValue()).compareTo((Patient) minChild.getValue()) <= 0) {
	            break;
	        }
	        swap(current, minChild);
	        current = minChild;
	    }
	}

	/**
	 * The function returns the size of a tree.
	 * 
	 * @return The method is returning an integer value which represents the size of a tree.
	 */
	public int getTreeSize() {
		return TreeSize;
	}

	/**
	 * This function sets the size of a tree.
	 * 
	 * @param treeSize The parameter `treeSize` is an integer value that represents the size of a tree.
	 * The `setTreeSize` method is used to set the value of the `TreeSize` variable to the value passed as
	 * the `treeSize` parameter.
	 */
	public void setTreeSize(int treeSize) {
		TreeSize = treeSize;
	}

	/**
	 * This function returns the root node of a generic type in a Java program.
	 * 
	 * @return The method `getRoot()` is returning a `Node` object which is the root of a tree. The type
	 * parameter `T` specifies the type of data stored in the nodes of the tree.
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * This function sets the root node of a tree data structure.
	 * 
	 * @param root The parameter "root" is a Node object of type T that represents the root node of a tree
	 * data structure. The method "setRoot" sets the value of the instance variable "root" to the value of
	 * the parameter "root".
	 */
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	

}
