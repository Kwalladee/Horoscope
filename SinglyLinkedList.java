public class SinglyLinkedList<E> {
    //nested node class

    //accesor methods
    public Node<Numerology> head = null;
    public Node<Numerology> tail = null;
    private int size = 0;
    public SinglyLinkedList(){}
    public int size(){return size;}
    public boolean isEmpty(){return size ==0;}
    public Numerology first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    public Numerology last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    //add methods
    public void addFirst(Numerology e){
        head = new Node<>(e, head);
        if(size == 0)  
            tail = head;
        size++;
    }
    public void addLast(Numerology e) {
        Node<Numerology> newest = new Node<Numerology>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++; 
    }
    //remove method
    public Numerology removeFirst(){
        if(isEmpty()) return null;
        Numerology answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0)
            tail = null;
        return answer; 
    }


}
