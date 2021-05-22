import java.util.*;
public class StackArray{
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];
	
	Stack(){
		top = -1;
	}
	
	public void peek(){
		if(top <0)
			System.out.println("Stack underflow");
		else{
			System.out.println("Top value is : "+ a[top]);
		}
	}
	
	public void push(int value){
		if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
        }
		else{
			top++;
		}
		a[top] = value;
	}
	
	public void pop(){
		if(top <0){
			System.out.println("Stack underflow");
		}
		else{
			top--;
		}
	}
	
}
class StackMain{
    public static void main(String[] args){
		Stack stack = new Stack();
		int input;
	   do{
		   System.out.println("Hello Team 1. Peek 2. Push 3. Pop 0. Exit");
	       Scanner sc = new Scanner(System.in);
	       input = sc.nextInt();
		   if(input == 1)
			   stack.peek();
	       else if(input == 2){
			   System.out.println("Enter value:");
			   int value = sc.nextInt();
			   stack.push(value);
		   }
		   else if(input == 3){
			   stack.pop();
		   }
		   else if(input != 0){
			    System.out.println("Please enter correct option.");
		   }
	   }
	   while(input != 0);
	}
}