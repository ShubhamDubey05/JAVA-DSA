package Stack.LinkedList;

public class Solution {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  static class CustomStack {
    Node head = null;
    int size = 0;

    void push(int data) {
      Node temp = new Node(data);
      temp.next = head;
      size++;
      head = temp;
    }

    int peek() {
      if (head == null) {
        return -1;
      }
      return head.data;

    }

    int size() {
      return size;
    }

    void display() {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
    }

    int pop() {
      if (head == null) {
        System.out.println("Stack is Empty !");
        return -1;
      }
      int val = head.data;
      head = head.next;
      size--;
      return val;
    }

  }

  public static void main(String[] args) {
    CustomStack st = new CustomStack();
    st.push(8);
    st.peek();
  }
}
