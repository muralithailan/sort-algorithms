
public class MergeSortLinkedList {

	public static void main(String[] args) {
		CustomLinkedList num = new CustomLinkedList();
		num.add(20);
		num.add(8);
		num.add(10);
		
		
		num.head = mergeSort(num.head);
		
		Node node = num.head;
		
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		
	}

	public static Node mergeSort(Node node) {
		
		if(node == null || node.next == null) {
			return node;
		}
		Node mid = getMiddleNode(node);
		Node nextOfMid = mid.next;
		mid.next = null;
		
		Node leftNode = mergeSort(node);
		Node rightNode = mergeSort(nextOfMid);
		
		return merge(leftNode,rightNode);
		
		
	}
	
	private static Node getMiddleNode(Node node) {
		if(node == null)
			return node;
		
		Node slowNode = node;
		Node fastNode = node.next;
		while(fastNode != null && fastNode.next!=null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return slowNode;
	}

	private static Node merge(Node leftNode, Node rightNode) {
		if(leftNode == null) {
			return rightNode;
		}
		if(rightNode == null)
			return leftNode;
		
		Node result;
		if(leftNode.data <= rightNode.data) {
			result = leftNode;
			result.next = merge(leftNode.next,rightNode);
		}else {
			result = rightNode;
			result.next = merge(leftNode,rightNode.next);
		}
		return result;
	}
	static class CustomLinkedList {
		Node head;
		Node tail;
		int size = 0;

		public void add(int data) {
			if (this.tail != null) {
				Node node = new Node(data);
				this.tail.next = node;
				this.tail = node;

			} else {
				Node node = new Node(data);
				this.head = node;
				this.tail = this.head;

			}
			this.size++;
		}

		public Integer get(int i) {
			Node node = this.head;
			if (node != null && i < size) {
				int k = 0;
				while (k < i) {
					node = node.next;
					k++;
				}
				return node.data;
			}
			return null;
		}

	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
