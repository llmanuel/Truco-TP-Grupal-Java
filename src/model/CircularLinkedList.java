package model;

/**
 * Created by manuel on 19/11/15.
 */
/***************************************************************************
 * A Linked List class with a private static inner Node class.
 *
 *****************************************************************************/

import java.util.*;

public class CircularLinkedList<AnyType> implements Iterator<AnyType> {
    private Node<AnyType> head;
    private Node<AnyType> cursor;
    private int size;

    /**
     * Constructs an empty list
     */
    public CircularLinkedList() {
        head = null;
    }

    /**
     * Returns true if the list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Inserts a new node at the beginning of this list.
     */
    private void addFirst(AnyType item) {
        head = new Node<AnyType>(item);
        head.setNext(head);
        cursor = head;
        size = 1;
    }

    /**
     * Returns the first element in the list.
     */
    public AnyType getFirst() {
        if (head == null) throw new NoSuchElementException();

        return head.data;
    }

    public int getSize() {
        return size;
    }

    /**
     * Inserts a new node to the end of this list.
     */
    public void addLast(AnyType item) {
        if (head == null)
            addFirst(item);
        else {
            Node<AnyType> tmp = head;
            while (tmp.next != head) tmp = tmp.next;

            Node<AnyType> newOne = new Node<AnyType>(item);
            newOne.setNext(tmp.next);
            tmp.setNext(newOne);
            size = size +1;
        }
    }

    /**
     * Returns the last element in the list.
     */
    public AnyType getLast() {
        if (head == null) throw new NoSuchElementException();

        Node<AnyType> tmp = head;
        while (tmp.next != head) tmp = tmp.next;

        return tmp.data;
    }

    /**
     * Removes all nodes from the list.
     */
    public void clear() {
        head = null;
    }
    /**
     *  Returns true if this list contains the specified element.
     *
     */
//    public boolean contains(AnyType x)
//    {
//        for(AnyType tmp : this)
//            if(tmp.equals(x)) return true;
//
//        return false;
//    }

    /**
     * Returns the data at the specified position in the list.
     */
    public AnyType get(int pos) {
        if (head == null) throw new IndexOutOfBoundsException();

        Node<AnyType> tmp = head;
        for (int k = 1; k < pos; k++) tmp = tmp.next;

        return tmp.data;
    }

    /**
     * Inserts a new node after a node containing the key. Except when you have only one Node
     */
    public void insertAfter(AnyType key, AnyType toInsert) {
        Node<AnyType> tmp = head;
        Node<AnyType> theOneNextToTmp = tmp.next;
        while ((tmp != null && !tmp.data.equals(key)) && (tmp.next != head)) tmp = tmp.next;

        if (tmp != null)
            theOneNextToTmp = tmp.next;
        tmp.next = new Node<AnyType>(toInsert);
        tmp.next.setNext(theOneNextToTmp);
    }
    /**
     *  Inserts a new node before a node containing the key.
     *
     */
//    public void insertBefore(AnyType key, AnyType toInsert)
//    {
//        if(head == null) return;
//
//        if(head.data.equals(key))
//        {
//            addFirst(toInsert);
//            return;
//        }
//
//        Node<AnyType> prev = null;
//        Node<AnyType> cur = head;
//
//        while(cur != null && !cur.data.equals(key))
//        {
//            prev = cur;
//            cur = cur.next;
//        }
//        //insert between cur and prev
//        if(cur != null)
//            prev.next = new Node<AnyType>(toInsert, cur);
//    }

    /**
     * Removes the first occurrence of the specified element in this list.
     */
    public void remove(AnyType key) {
        if (head == null)
            throw new RuntimeException("cannot delete");

        if (head.data.equals(key)) {
            head = head.next;
            return;
        }

        Node<AnyType> cur = head;
        Node<AnyType> prev = null;

        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == null)
            throw new RuntimeException("cannot delete");

        //delete cur node
        prev.next = cur.next;
    }

    /**
     * Returns a deep copy of the list
     * Complexity: O(n^2)
     */
    public CircularLinkedList<AnyType> copy1() {
        CircularLinkedList<AnyType> twin = new CircularLinkedList<AnyType>();
        Node<AnyType> tmp = head;
        while ((tmp != null) && (tmp.next != head)) {
            twin.addLast(tmp.data);
            tmp = tmp.next;
        }

        return twin;
    }

    private void moveCursor(){
        cursor = cursor.next;
    }
    public void restartFromBegining() {
        cursor = head;
    }

    @Override
    public boolean hasNext() {
        return (cursor.next != head);
    }

    @Override
    public AnyType next() {
        Node<AnyType> tmp = cursor;
        this.moveCursor();
        return tmp.data;
    }


}


    /*******************************************************
     *
     *  The Node class
     *
     ********************************************************/
    class Node<AnyType>
    {
        public AnyType data;
        public Node<AnyType> next;

        public Node(AnyType data)
        {
            this.data = data;
        }

        public void setNext(Node<AnyType> next){
            this.next = next;
        }
    }


//    /*******************************************************
//     *
//     *  The Iterator class
//     *
//     ********************************************************/
//
//    public Iterator<AnyType> iterator()
//    {
//        return new CicularLinkedListIterator();
//    }
//
//    private class CicularLinkedListIterator  implements Iterator<AnyType>
//    {
//        private Node<AnyType> nextNode;
//
//        public CicularLinkedListIterator()
//        {
//            nextNode = head;
//        }
//
//        public boolean hasNext()
//        {
//            return nextNode != null;
//        }
//
//        public AnyType next()
//        {
//            if (!hasNext()) throw new NoSuchElementException();
//            AnyType res = nextNode.data;
//            nextNode = nextNode.next;
//            return res;
//        }
//
//        public void remove() { throw new UnsupportedOperationException(); }
//    }
