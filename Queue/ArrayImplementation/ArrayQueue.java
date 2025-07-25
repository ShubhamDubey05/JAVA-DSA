
public class ArrayQueue {
  public static void main(String[] args) {
    Aqueue q = new Aqueue(10);
    q.add(9);
    q.add(10);
    q.add(11);
    q.display();
  }

}

class Aqueue {
  int size;
  int[] arr;
  int front = -1;
  int rear = -1;

  Aqueue() {
    arr = new int[100];
  }

  Aqueue(int size) {
    this.size = size;
    arr = new int[size];
  }

  public void add(int val) {
    if (rear == size - 1) {
      System.out.println("Queue Overflow");
      return;
    }
    if (front == -1 && rear == -1) {
      front = rear = 0;
    } else {
      rear++;
    }
    arr[rear] = val;
  }

  public int remove() {
    if (front == -1 || front > rear)
      return -1;
    int x = arr[front];
    arr[front] = 0;
    front++;
    return x;
  }

  public int peek() {
    if (front == -1 || front > rear)
      return -1;
    int x = arr[front];
    return x;
  }

  public void display() {
    if (front == -1 || front > rear) {
      System.out.print("Queue is Empty !");
      return;
    }
    for (int i = front; i <= rear; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

}
