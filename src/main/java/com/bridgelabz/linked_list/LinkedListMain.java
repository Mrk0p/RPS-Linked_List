package com.bridgelabz.linked_list;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();

        linkedList1.add(56);
        linkedList1.add(30);
        linkedList1.add(70);

        linkedList1.display();
        System.out.println();

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.append(56);
        linkedList2.append(30);
        linkedList2.append(70);

        linkedList2.display();
        System.out.println();

        System.out.println("Element popped from head => " + linkedList2.pop());
        linkedList2.display();
        System.out.println();

        linkedList2.add(56);
        linkedList2.display();
        System.out.println();

        System.out.println("Element popped from last => " + linkedList2.popLast());
        linkedList2.display();
        System.out.println();

        linkedList2.append(70);
        linkedList2.display();
        System.out.println();


        if (linkedList2.search(30) !=null) {
            System.out.println("data found");
        }
        else {
            System.out.println("data not found");
        }
        System.out.println();

        if (linkedList1.insertAfter(30,45)){
            System.out.println("Valid insertion ");
            linkedList1.display();
        }
        else {
            System.out.println("Invalid insertion ");
        }
        System.out.println();

        if (linkedList1.deleteValue(45)){
            System.out.println("Value can be deleted");
            linkedList1.display();
        }
        else {
            System.out.println("Cannot delete this value ");
        }


    }

    public static class LinkedList<E> {
        Node<E> head;

        Node<E> tail;

        public void add(E data) {
            Node<E> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head = newNode;
            }
        }

        public void display() {
            Node<E> temp = head;
            if (head == null) {
                System.out.println("Linked List is empty");
            }
            while (temp != null) {
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }

        }

        public void append(E data) {
            Node<E> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }
        public E pop() {
            E temp = head.getData();
            head = head.getNext();
            return temp;
        }
        public E popLast() {
            E temp = tail.getData();
            Node<E> secondLast = head;
            while(secondLast.getNext() != tail){
                secondLast = secondLast.getNext();
            }
            secondLast.setNext(null);
            tail = secondLast;
            return temp;
        }
        public Node<E> search(E searchData) {
            Node<E> temp = head;
            while (temp != null) {
                if (temp.getData().equals(searchData)) {
                    return temp;
                }
                temp = temp.getNext();
            }
            return null;
        }
        public boolean insertAfter(E searchData, E insertData) {
            if (search(searchData) != null){
                Node<E> nextNode = search(searchData).getNext();
                Node<E> newNode = new Node<>(insertData);
                search(searchData).setNext(newNode);
                newNode.setNext(nextNode);
                return true;
            }
            return false;
        }
        public boolean deleteValue(E searchData) {
            Node<E> deletingNode = search(searchData);
            Node<E> temp = head;
            if(search(searchData) != null) {
                while (temp != null) {
                    if (temp.getNext().equals(deletingNode)) {
                        temp.setNext(deletingNode.getNext());
                        deletingNode.setNext(null);
                        return true;
                    }
                    temp = temp.getNext();
                }
            }
            return false;
        }

        public static class Node<E> {
            private E data;

            private Node<E> next;

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
}
