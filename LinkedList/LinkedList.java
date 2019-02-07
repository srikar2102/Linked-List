package LinkedList;

public class LinkedList {
	Node head;
	/*Inner class for the Node type */
	class Node{
		int data;
		Node next;
		/*Node with zero*/
		Node(){
			data = 0;
			next = null;
		}
		/*Node with given value*/
		Node(int d){
			data = d;
			next = null;
		}
	}
	/*creates an empty linked list*/
	public LinkedList(){
		head = null;
	}
	/*Creates a linked list with one element with given value*/
	public LinkedList(int _data){
		head.data = _data;
		head.next = null;
	}
	
	public void printLinkedList(){
		printLinkedList(this.head);
	}
	/* Prints the linked list iterative approach */
	private void printLinkedList(Node head){
		Node curr = head;
		while(curr!=null){
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.println("NULL");
		return;
	}
	/*Inserts an element at the end of the list */
	public void addElement(int data){
		
		if(head == null){
			head = new Node(data);
			return;
		}
		Node curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = new Node(data);
	}
	/* Delete a node with given value*/
	public void deleteNode(int val){
		if(head == null){
			return;
		}
		if(head.data == val){
			head = head.next;
			head.next = head.next.next;
		}
		Node curr = head;
		while(curr.next.data != val){
			curr = curr.next;
		}
		Node temp = curr.next;
		curr.next = curr.next.next;
		temp.next =null;
	}
	/* Search a value in a linked list Recursuve approach*/
	public boolean searchNodeRec(Node head, int val){
		if(head == null)
			return false;
		if(head.data == val)
			return true;
		return searchNodeRec(head.next, val);
	}
	/*Searched a value in the linked list Iterative Approach*/
	public boolean searchNode(int val){
		Node curr = head;
		while(curr != null){
			if(curr.data == val)
				return true;
			curr = curr.next;
		}
		return false;		
	}
	/*Reverses the linked list Iterative approach*/
	public void reverseList(){
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	public void reverseListRec(){
		this.head = reverseListRec(head);
	}
	/*Reverses the linked list recursively*/
	private Node reverseListRec(Node head){
		if(head == null || head.next == null)
			return head;
		Node next = head.next;
		head.next = null;
		Node result = reverseListRec(next);
		next.next = head;
		return result;
	}
	
	/*prints the middle element of the LinkedList*/
	public void printMiddle(){
		Node fastPointer = this.head;
		Node slowPointer = this.head;
		while(fastPointer.next != null && fastPointer.next.next != null){
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		
		System.out.println(slowPointer.data);
	}
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addElement(1);
		linkedList.addElement(2);
		linkedList.addElement(3);
		linkedList.addElement(4);
		linkedList.addElement(5);
		linkedList.printLinkedList();
		linkedList.deleteMiddle();
		linkedList.printLinkedList();
	}
}
