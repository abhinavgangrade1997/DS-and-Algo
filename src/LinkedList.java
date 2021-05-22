import java.util.*;


public class LinkedList{
	Node head ;
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
    }
	public static void main(String[] args){
		LinkedList list =  new LinkedList();
		int input;
		do{
		   System.out.println("Hello Team 1. Print 2. Insert 0. Exit");
	       Scanner sc = new Scanner(System.in);
	       input = sc.nextInt();
		   if(input == 1)
			   print(list);
	       else if(input == 2){
			   System.out.println("Enter value:");
			   int value = sc.nextInt();
			   list = insert(list, value);
		   }
		   else if(input != 0){
			    System.out.println("Please enter correct option.");
		   }
	   }
	   while(input != 0);
	}
	
	private static LinkedList insert(LinkedList list, int value){
		Node node = new Node(value);
		if(list.head == null){
			list.head = node;
		}
		else{
			Node last = list.head;
			while(last.next != null){
				last = last.next;
			}
			last.next = node;
		}
		return list;
	}
	
	private static void print(LinkedList list){
		if(list.head == null)
			System.out.println("EmptyList");
		else{
			Node current = list.head;
			while(current !=null){
				System.out.println("Data : "+ current.data);
				current = current.next;
			}
		}
	}
}