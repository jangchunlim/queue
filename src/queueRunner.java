import java.util.NoSuchElementException;

public class queueRunner {

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}

class Queue<T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
    // 각 노드들은 앞뒤를 알고 있어야 한다.
    private Node<T> first;
    private Node<T> last;

    // queue 에 삽입
    public void add(T item){
        Node<T> t = new Node<T>(item);

        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null){
             first = last;
        }
    }

    // pop 후 제거
    public T remove(){
        if(first == null){
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if(first == null){
            last = null;
        }
        return data;
    }

    // 단순히 조회
    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    // 비었는지 확인
    public boolean isEmpty(){
        return first == null;
    }
}
