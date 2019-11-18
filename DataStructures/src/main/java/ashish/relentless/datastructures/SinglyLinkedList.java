package ashish.relentless.datastructures;

class Node {

	public int data;
	public Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class SinglyLinkedList {

	private Node head;

	public SinglyLinkedList insert(SinglyLinkedList list, int data) {

		Node node = new Node(data);
		// if list is empty
		if (list.head == null) {
			list.head = node;
		}
		// list is not empty iterate to last and add the node as a link
		else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
		}
		this.displayList(list);
		return list;
	}

	public void displayList(SinglyLinkedList list) {
		Node currentNode = list.head;
		while (currentNode != null) {
			System.out.print(currentNode.data + "-->");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}

	public SinglyLinkedList deleteNodeByValue(SinglyLinkedList list, int key) {

		Node currentNode = list.head;
		Node previousNode = null;

		if (currentNode != null && currentNode.data == key) {
			list.head = currentNode.next;
			System.out.println("Deleted value " + key + " from list");
			return list;
		}

		while (currentNode != null && currentNode.data != key) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		if (currentNode != null) {
			previousNode.next = currentNode.next;
			System.out.println("Deleted value " + key + " from list");
		}

		if (currentNode == null) {
			System.out.println("Value " + key + " not found in list ");
		}

		return list;
	}

	public SinglyLinkedList deleteNodeByPosition(SinglyLinkedList list, int index) {

		Node currentNode = list.head;
		Node previousNode = null;
		int counter = 0;

		if (index == 0 && currentNode != null) {
			list.head = currentNode.next;
			System.out.println("Deleted index " + index + " from list");
			return list;
		}

		while (currentNode != null) {

			if (counter == index) {
				previousNode.next = currentNode.next;
				System.out.println("Deleted index " + index + " from list");
				break;
			} else {
				previousNode = currentNode;
				currentNode = currentNode.next;
				counter++;
			}
		}

		if (currentNode == null) {
			System.out.println("Index " + index + " not found in list");
		}

		return list;
	}

	public static void main(String args[]) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.insert(myList, 5);
		myList.insert(myList, 6);
		myList.insert(myList, 1);
		myList.insert(myList, 3);
		myList.insert(myList, 9);
		myList.displayList(myList);
		// delete
		myList.deleteNodeByValue(myList, 5);
		myList.displayList(myList);
		myList.deleteNodeByPosition(myList, 2);
		myList.displayList(myList);
		myList.deleteNodeByPosition(myList, 1);
		myList.displayList(myList);
		myList.deleteNodeByPosition(myList, 22);
		myList.displayList(myList);
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + "]";
	}
}