package hashtable;

import java.io.*;
import java.util.Scanner;


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class OrderedList {
    private Node head;

    public OrderedList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null || data < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && data > temp.next.data) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void remove(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        prev.next = curr.next;
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Node temp = head;
            while (temp != null) {
                writer.println(temp.data);
                temp = temp.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

 class OrderedListProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String filename = scanner.nextLine();

        OrderedList list = new OrderedList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                list.insert(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter a number to search: ");
        int searchNumber = scanner.nextInt();

        if (list.search(searchNumber)) {
            list.remove(searchNumber);
            System.out.println("Number found and removed from the list.");
        } else {
            list.insert(searchNumber);
            System.out.println("Number not found, added to the list.");
        }

        list.printList();

        System.out.print("Enter the output file name: ");
        String outputFile = scanner.next();
        list.saveToFile(outputFile);

        scanner.close();
    }
}