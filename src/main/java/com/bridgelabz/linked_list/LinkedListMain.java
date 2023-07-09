package com.bridgelabz.linked_list;

public class LinkedListMain {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList1 = new LinkedList<>();

        linkedList1.add(56);
        linkedList1.add(30);
        linkedList1.add(70);

        linkedList1.display();
    }

    public static class LinkedList<E> {
        Node<E> head ;

        Node<E> tail ;

        public void add(E data){
            Node<E> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.setNext(head);
                head = newNode;
            }
        }

        public void display() {
            Node<E> temp = head;
            if(head == null){
                System.out.println("Linked List is empty");
            }
            while(temp != null){
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }
        }
    }

    public static class Node<E> {
        private E data ;

        private Node<E> next ;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
