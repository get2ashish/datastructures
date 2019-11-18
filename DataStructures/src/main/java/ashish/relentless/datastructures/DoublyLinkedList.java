package ashish.relentless.datastructures;

public class DoublyLinkedList {

	Node head, tail = null;

	class Node {

		public int data;
		public Node next;
		public Node previous;

		Node(int data) {
			this.data = data;
		}
	}

	public DoublyLinkedList insert(DoublyLinkedList list, int data) {

		Node newNode = new Node(data);

		if (list.head == null) {
			head = tail = newNode;
			return list;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			tail.next = null;
		}
		return list;
	}

	public void displayList(DoublyLinkedList list) {
		Node currentNode = list.head;
		while (currentNode != null) {
			System.out.print(currentNode.data + "-->");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}

	public static void main(String args[]) {
		DoublyLinkedList myList = new DoublyLinkedList();
		myList.insert(myList, 2);
		myList.insert(myList, 8);
		myList.insert(myList, 5);
		myList.insert(myList, 0);
		myList.displayList(myList);
		myList.insert(myList, 44);
		myList.displayList(myList);

	}

}
