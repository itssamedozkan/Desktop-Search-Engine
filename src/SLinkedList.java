
/**
 * @file
 * @description Mini Masaüstü Arama Uygulaması
 * @assignment 2 
 * @date   14.Nis.2019
 * @author İsmail Taha Samed ÖZKAN
 */
public class SLinkedList<T> {

    protected SNode<T> head;

    void addFirst(SNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addFirst(T data) {
        addFirst(new SNode<>(data));
    }

    void addLast(T data) {
        SNode<T> newNode = new SNode<>(data);

        if (head == null) {
            head = newNode;
        } else {
            SNode<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    void insertAfter(T data, T search) {
        SNode<T> temp = head;

        while (temp != null && temp.data != search) {
            temp = temp.next;
        }

        if (temp != null) {
            SNode<T> newNode = new SNode<>(data);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            addLast(data);
        }
    }

    boolean remove(T data) {
        if (head == null) {
            System.out.println("empty list !");
        } else {
            if (head.data.equals(data)) {
                head = head.next;
                return true;
            } else {
                SNode<T> temp = head.next;
                SNode<T> prev = head;

                while (temp != null && !temp.data.equals(data)) {
                    prev = temp;
                    temp = temp.next;
                }

                if (temp != null) {
                    prev.next = temp.next;
                    return true;
                } else {
                    System.out.println(data + " not found !");
                }
            }
        }
        return false;
    }

    void print() {
        SNode<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    int size() {
        SNode<T> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
    
    boolean isContains(T data){
    SNode<T> temp = head;
        

        while (temp != null) {
            if(temp.data.equals(data))
                return true;
            temp = temp.next;
        }
        
        return false;
       
    }
}
