import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

public class testClass {
	private BTHeap heap;
	private PriorityQueue<Patient> PatientQueue;
	
	@Test
	public void testCompareTo() {
	    Patient p1 = new Patient("John", "Apendicitis", "A");
	    Patient p2 = new Patient("Jane", "Dolor leve" , "B");
	    Patient p3 = new Patient("Bob", "Hueso Roto", "C");
	    
	    assertTrue(p1.compareTo(p2) < 0); // p1 has lower priority than p2
	    assertTrue(p2.compareTo(p1) > 0); // p2 has higher priority than p1
	    assertEquals(0, p1.compareTo(p1)); // p1 has same priority as p1
	    assertTrue(p1.compareTo(p3) < 0); // p1 has lower priority than p3
	  }
	
	@Test
	public void testSetters() {
	    Patient p = new Patient("John", "Apendicitis", "A");
	    Node<Patient> node = new Node<>(p, null);
	    
	    Patient p2 = new Patient("Jane", "Dolor leve" , "C");
	    Node<Patient> node2 = new Node<>(p2, null);
	    
	    node.setLeft(node2);
	    assertEquals(node2, node.getLeft());
	    
	    Node<Patient> node3 = new Node<Patient>(new Patient("Bob", "Dolor de cabeza", "D"), null);
	    node.setRight(node3);
	    assertEquals(node3, node.getRight());
	    
	    Node<Patient> parent = new Node<Patient>(new Patient("Alice", "Hepatitis", "B"), null);
	    node.setParent(parent);
	    assertEquals(parent, node.getParent());
	  }
	
	@Before
	public void setUp() {
		Reader reader = new Reader();
		heap = reader.readTxtFileToPriorityQueue();
		PatientQueue = reader.readTxtFileToPriorityQueueJava();
	}
	
	@Test
	public void PriorityQueueInsertionOrderTest() {
		Patient p = new Patient("John", "Apendicitis", "A");	    
	    Patient p2 = new Patient("Jane", "Dolor leve" , "C");

	    PatientQueue.add(p);
	    PatientQueue.add(p2);
	    
	    assertEquals("Maria Ramirez", PatientQueue.peek().getName());
	}
	
	@Test
	public void BinaryTreePriorityQueueInsertionTest() {
		Patient p = new Patient("John", "Apendicitis", "A");	    
	    Patient p2 = new Patient("Jane", "Dolor leve" , "C");

	    heap.insert(p);
	    heap.insert(p2);
	    
	    String NameInPosition4 = "Juan Perez";
	    String p3 = ((Patient) heap.getRoot().getLeft().getLeft().getValue()).getName();
	    assertEquals(NameInPosition4, p3);
	}
	
	@Test
	public void BinaryTreePriorityQueueRemoveTest() {
		heap.remove();
		String newPatientWithHighestPriority = ((Patient) heap.getRoot().getValue()).getName();
		assertEquals("Carmen Sarmientos", newPatientWithHighestPriority);
	}
	
	@Test
	public void BinaryTreeQueueFollowsInvariantForm() {
		Patient p = new Patient("John", "Apendicitis", "Z");	    

	    heap.insert(p);
	    String NameInLasposition = p.getName();
	    String NameFoundInastPosition = ((Patient) heap.getRoot().getLeft().getRight().getValue()).getName();
	    
	    assertEquals(NameInLasposition, NameFoundInastPosition);
	}
	
	@Test
	public void BinaryTreeQueueIsOrderedByPriority() {
		Reader reader = new Reader();
		BTHeap heap2 = reader.readTxtFileToPriorityQueue();
		Patient p = new Patient("John", "Apendicitis", "A");	    
		
		heap2.insert(p);
	    //This person is in the second level on the second node, before the insertion
	    String NameInLasposition = "Carmen Sarmientos";
	    String NameFoundInastPosition = ((Patient) heap2.getRoot().getLeft().getRight().getValue()).getName();
	    
	    assertEquals(NameInLasposition, NameFoundInastPosition);
	}
	
}
