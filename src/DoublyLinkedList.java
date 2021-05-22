public class DoublyLinkedList {
	Node head;
	Node tail;
	int length= -1;
	
	public void append(int value){
		if(length == -1){
			head = new Node(value);
			tail = head;
		}
		else{
			Node node = new Node(value);
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		length++;
	}
	
	public void prepend(int value){
		if(length == -1){
			head = new Node(value);
			tail = head;
		}
		else{
			Node node = new Node(value);
			head.previous = node;
			node.next = head;
			head = node;
		}
		length++;
	}
	
	public void print(){
		System.out.println("Total elements " + (length+1));
		Node current = this.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
	}
	
	public void insert(int index, int value){
		if(index < 0 || index > length)
            System.err.println("Index Out Of Bounds For Length " + length);
		else if(index == 0)
            prepend(value);
		else if(index == length)
            append(value);
		else{
			Node node = new Node(value);
			Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
			current.previous.next = node;
			node.previous = current.previous;
			node.next = current;
			current.previous = node;
			length++;
		}
	}
	
	public void remove(int index){
		if(index < 0 || index > length)
            System.err.println("Index Out Of Bounds For Length " + length);
		else if(index == 0){
			head = head.next;
			head.previous = null;
			length--;
		}
		else{
			Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
	}
	
	public static void main(String[] args){
		DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.prepend(2);
        myDoublyLinkedList.prepend(1);
        myDoublyLinkedList.insert(2, 200);
		myDoublyLinkedList.remove(1);
		myDoublyLinkedList.print();
	}
}