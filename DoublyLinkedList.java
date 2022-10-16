public class DoublyLinkedList<E> {

    protected NodeDLL<Numerology> header;
    protected NodeDLL<Numerology> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new NodeDLL<Numerology>(null, null, null);
        trailer = new NodeDLL<Numerology>(null, header, null);
        header.setNext(trailer);
    }
    
    public int size(){return size;}
    //tests whether the linked list is empty
    public boolean isEmpty(){return size == 0;}
    //returns first element
    public Numerology first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    //return last element
    public Numerology last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    public void addFirst(Numerology e){
        addBetween(e, trailer.getPrev(), trailer);
    }
    public void addLast(Numerology e){
        addBetween(e, trailer.getPrev(), trailer);
    }
    public Numerology removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    public Numerology removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
    private void addBetween(Numerology e, NodeDLL<Numerology> predecessor, NodeDLL<Numerology> successor){
        NodeDLL<Numerology> newest = new NodeDLL<Numerology>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;     
    }
    private Numerology remove(NodeDLL<Numerology> node){
        NodeDLL<Numerology> predecessor = node.getPrev();
        NodeDLL<Numerology> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}
