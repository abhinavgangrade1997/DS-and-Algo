import java.util.*;
public class QueueArray{
	int [] a = new int[5];
	int start;
	int end;
	
	Queue(){
		start = end = -1;
	}
	
	public void peek(){
		if(end <start || (end == start && start == -1))
			System.out.println("Queue underflow");
		else{
			System.out.println("Start value is : "+ a[start]);
		}
	}
	
	public void add(int value){
		if(start == end && start <0){
			start++;
			end++;
			a[end] = value;
		}
		else if(end < a.length-1 && start<a.length){
			end++;
			a[end] = value;
		}else{
			System.out.println("Queue overflow");
		}
		
	}
	
	public void dequeue(){
		if((start == end && start <0) || start == a.length)
			System.out.println("Queue underflow");
	    else{
			start++;
		}
	}
	
}
class QueueMain{
    public static void main(String[] args){
		Queue queue = new Queue();
		int input;
	   do{
		   System.out.println("Hello Team 1. Peek 2. Push 3. dequeue 0. Exit");
	       Scanner sc = new Scanner(System.in);
	       input = sc.nextInt();
		   if(input == 1)
			   queue.peek();
	       else if(input == 2){
			   System.out.println("Enter value:");
			   int value = sc.nextInt();
			   queue.add(value);
		   }
		   else if(input == 3){
			   queue.dequeue();
		   }
		   else if(input != 0){
			    System.out.println("Please enter correct option.");
		   }
	   }
	   while(input != 0);
	}
}
