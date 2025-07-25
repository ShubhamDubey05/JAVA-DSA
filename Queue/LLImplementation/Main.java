package Queue.LLImplementation;

public class Main {
  public static void main(String[] args) {
     LLQueue lq = new LLQueue();
     lq.add(7);
      lq.add(9);
       lq.add(11);
        lq.add(34);
        lq.display();

  }
}

class Node {
  int val;
  Node next;
  
  Node (int val){
    this.val  = val;
  }
}

class LLQueue{
  int size = 0;
  Node front = null;
  Node rear  = null;

  public void add(int val) {
    Node newNode = new Node(val);
    if (rear == null) {
        rear = front = newNode;
        size++;
    } else {
        rear.next = newNode;
        rear = newNode;
        size++;
    }
}

  public void display(){
    if(front == null){
      System.out.println("Queue is Empty");
      return;
    }
    Node temp = front;
    while(temp!=null){
        System.out.print(temp.val+ " ");
        temp = temp.next;
    }
  }
  public int remove(){
    if(front == null){
      return -1;
    }
    int x = front.val;
    front = front.next;
    size--;
    return x;
  }
  public int  peek(){
    if(front == null) return -1;
    return front.val;
  }



}
