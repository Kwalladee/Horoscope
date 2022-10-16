public class Node<E> {
    public Numerology element;
    public Node<Numerology> next;
    public Node(Numerology e, Node<Numerology> n){
        element = e;
        next = n;
    }
    public Numerology getElement(){return element;}
    public Node<Numerology> getNext(){return next;}
    public void setNext(Node<Numerology> n){next = n;}
}

