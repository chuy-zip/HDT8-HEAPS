
public class BTHeap<T> {
	private int TreeSize;
	private Node<T> root;
	
	private void swap(Node a, Node b) {	
		T temp = (T) a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);	
	}
	
	private String route(T value) {
		var size = TreeSize;
		var position = size + 1;
		var binary = Integer.toBinaryString(position);
		var branchRoute = binary.substring(1);
		
		return branchRoute;
	}
	
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

	public int getTreeSize() {
		return TreeSize;
	}

	public void setTreeSize(int treeSize) {
		TreeSize = treeSize;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	

}
