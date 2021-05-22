public class StackList{
	Node tos;
	int size = -1;
	
	public void push(int value){
		if(size == -1)
			tos = new Node(value);
		else{
			Node node = new Node(value);
			node.previous = tos;
			tos = node;
		}
		size++;
	}
	
	public void peek(){
		if(size == -1 )
			System.out.println("no element in stack");
        else
            System.out.println("tos : "+tos.value); 			
	}
	
	public void pop(){
		if(size == -1)
			System.out.println("no element to pop");
        else{
			if(size == 0)
				tos = null;
			else
				tos = tos.previous;
			size--;
		}			
	}
	
	
	public static void main(String[] args) {
        StackList myStack = new StackList();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.peek();
        myStack.pop();
		myStack.peek();
		myStack.pop();
		myStack.peek();
		myStack.pop();
		myStack.peek();
		myStack.pop();
    }
}