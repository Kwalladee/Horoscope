public class NodeDLL<E> {
    public Numerology element;
    public NodeDLL<Numerology> prev;
    private NodeDLL<Numerology> next;
    public NodeDLL(Numerology e, NodeDLL<Numerology> p, NodeDLL<Numerology> n){
        element = e;
        prev = p;
        next = n;
    }
    public Numerology getElement(){return element;}
    public NodeDLL<Numerology> getPrev(){return prev;}
    public NodeDLL<Numerology> getNext(){return next;}
    public void setPrev(NodeDLL<Numerology> p){prev = p;}
    public void setNext(NodeDLL<Numerology> n){next =n;}
}
