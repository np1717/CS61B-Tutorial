/** first part of project1A.
 * deque implemented by linked-list
 * @author np1717
 */
public class LinkedListDeque<T> {
    public class  Node {
        private T item;
        private Node pre;
        private Node next;

        public Node(T n, Node ppre, Node nnext) {
            item = n;
            pre = ppre;
            next = nnext;
        }

        public Node(Node ppre, Node nnext) {
            pre = ppre;
            next = nnext;
        }
    }

    private Node sentinel;

    private int size;


    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node newList = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = newList;
        sentinel.next = newList;
        size++;
    }

    public void addLast(T item) {
        Node newList = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newList;
        sentinel.pre = newList;
        size++;
    }

    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T n = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return n;
    }

    public T removeLast() {
        if (size == 0){
            return null;
        }
        T n = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return n;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node node = sentinel;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.item;
    }

    private T getRecursiveHelp(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelp(node.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

    public void printDeque() {
        Node node = sentinel;
        while (node != sentinel) {
            System.out.println(node.item + " ");
            node = node.next;
        }
    }
}

