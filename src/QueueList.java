public class QueueList{
	Node head;
	Node tail;
	int length = -1;
	
	public void enqueue(int value){
		if(length == -1){
			head = new Node(value);
			tail = head;
		}
		else{
			Node node = new Node(value);
			tail.next = node;
			tail = node;
		}
		length++;
	}
	
	public void dequeue(){
		if(length == -1){
			System.out.println("no element to remove");
		}
		else{
			head = head.next;
			length--;
		}
	}
	
	public void peek(){
		if(length == -1)
			System.out.println("no element in queue");
		else{
			System.out.println("Head : " + head.value);
		}
	}
	
	public static void main(String[] args) {
        QueueList myQueue = new QueueList();
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
		myQueue.dequeue();
        myQueue.peek();
		myQueue.dequeue();
        myQueue.peek();
		myQueue.dequeue();
        myQueue.peek();
		myQueue.dequeue();
        myQueue.peek();
    }
}