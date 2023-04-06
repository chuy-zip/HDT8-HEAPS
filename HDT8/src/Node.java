
public class Node<T> {
	private Node<T> parent, left, right;
	T value;
	
	// This is a constructor for the Node class that takes in a value of type T and a parent node of type
	// Node<T>. It sets the value of the current node to the given value, sets the parent node to the
	// given parent, and initializes the left and right child nodes to null.
	public Node(T val, Node<T> par) {
		parent = par;
		value = val;
		left = null;
		right = null;
	}

	/**
	 * This function returns the parent node of a given node in a tree data structure.
	 * 
	 * @return The method is returning the parent node of the current node.
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * This function sets the parent node of a given node in a Java program.
	 * 
	 * @param parent The parameter "parent" is a reference to a Node object of type T that represents the
	 * parent node of the current node. This method sets the parent node of the current node to the
	 * specified parent node.
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * This function returns the left child node of a binary tree node.
	 * 
	 * @return The `getLeft()` method is returning a `Node` object of type `T`. Specifically, it is
	 * returning the `left` child node of the current node.
	 */
	public Node<T> getLeft() {
		return left;
	}

	/**
	 * This function sets the left child node of a given node in a binary tree.
	 * 
	 * @param left The parameter "left" is a reference to a Node object of type T that represents the left
	 * child of a binary tree node. This method sets the left child of the current node to the specified
	 * Node object.
	 */
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * This function returns the right child node of a binary tree node.
	 * 
	 * @return The `getRight()` method is returning a `Node` object of type `T`. Specifically, it is
	 * returning the `right` child node of the current node.
	 */
	public Node<T> getRight() {
		return right;
	}

	/**
	 * This is a Java function that sets the right child node of a binary tree node.
	 * 
	 * @param right The parameter "right" is a reference to a Node object of type T that represents the
	 * right child of a binary tree node. This method sets the right child of the current node to the
	 * specified Node object.
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}

	/**
	 * This function returns the value of a generic type T.
	 * 
	 * @return The method is returning the value of type T.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * This Java function sets the value of a variable of type T.
	 * 
	 * @param value The parameter "value" is of type T, which means it can be any data type (e.g. Integer,
	 * String, Object) depending on how the method is called. The method sets the value of the instance
	 * variable "value" to the value passed as the parameter.
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	

}
