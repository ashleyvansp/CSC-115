/*
* Name: Ashley Van Spankeren
* Date: Mar. 7/ 2017
* Filename: MazeSolver.java
* Details: \CSC115\ Assignment <3>
*/

public class StackRefBased<T> implements Stack<T> {
 private int count;
 private StackNode<T> head;
 private final int INIT_SIZE = 50;

// Default constructor; creates an empty stack
   public StackRefBased() {
   count = 0;
   head = null;
   }

// Returns the size of the stack
   public int size() {
       return count;
   }

// Returns true if stack is empty, false if otherwise
   public boolean isEmpty() {
   if (count == 0)
     return true;
   else
     return false;
   }

// Adds a StackNode to the top of the Stack containing the parameter, data
   public void push(T data) {
   StackNode<T> s = new StackNode<T>(data);
   s.next = head;
   head = s;
   count++;
       return;
   }

// Returns the top item of the Stack, then removes it
   public T pop() throws StackEmptyException {
   StackNode<T> s = null;
   if (count == 0){
     throw new StackEmptyException("Stack is empty.");
   }else{
     s = head;
     count--;
     head = s.next;
   }
       return s.data;
   }

// Returns the top item of the Stack
   public T peek() throws StackEmptyException {
   StackNode<T> s = null;
   if (count == 0)
     throw new StackEmptyException("Stack is empty.");
   else{
     s = head;
   }
       return s.data;
   }

// Makes the Stack empty
   public void makeEmpty() {
   head = null;
   count = 0;
   }

// Returns a string representation of the contents of the Stack
   public String toString() {
   StringBuffer sb = new StringBuffer(INIT_SIZE);
   if (count == 0)
     return "";
   else{
     StackNode<T> p = head;
     for (int i = 0; i < count-1; i++){
       sb.append(p.data + " ");
       p = p.next;
     }
     sb.append(p.data);
     return sb.toString();
   }
   }
}
