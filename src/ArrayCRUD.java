import java.util.*;

public class ArrayCRUD{
   public static void main(String[] args)
    {
	   int[] array = {0,1,2,3};
 	   int input;
	   do{
		   System.out.println("Hello Team 1. Print 2. Insert 3. Delete 0. Exit");
	       Scanner sc = new Scanner(System.in);
	       input = sc.nextInt();
		   if(input == 1)
			   print(array);
	       else if(input == 2){
			   System.out.println("Enter index:");
			   int index = sc.nextInt();
			   System.out.println("Enter value:");
			   int value = sc.nextInt();
			   array = insert(array, index, value);
		   }
		   else if(input == 3){
			   System.out.println("Enter index:");
			   int index = sc.nextInt();
			   array = delete(array, index);
		   }
		   else if(input != 0){
			    System.out.println("Please enter correct option.");
		   }
	   }
	   while(input != 0);
	}
	
	private static int[] delete(int[] array , int index){
		int[] a = new int[array.length-1]; 
		for(int i=0, k=0 ; i< array.length; i++){
			if(i == index)
				continue;
			a[k] = array[i];
			k++;
		}
		return a;
	}
	
	private static int[] insert(int[] array, int index, int value){
		int[] a  = new int[array.length+1];
		for(int i=0; i< a.length; i++){
			if(i == index){
				a[i] = value;
			}
			else if(i<index){
				a[i] = array[i];
			}
			else{
				a[i] = array[i-1];
			}
		}
		return a;
	}
	
	private static void print(int[] a){
		for(int i=0; i< a.length; i++){
			System.out.println("Array : "+a[i]);
	   }
	}
}   