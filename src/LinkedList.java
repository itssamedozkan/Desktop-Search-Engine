
/**
 * @file
 * @description Mini Masaüstü Arama Uygulaması
 * @assignment 2 
 * @date   14.Nis.2019
 * @author İsmail Taha Samed ÖZKAN
 */
public class LinkedList<T extends Comparable<T>, K extends Comparable<K>> {

    protected LNode<T, K> head;

    LNode<T,K> FindNode(T searchData){
        LNode<T, K> temp = head;
        int count = 0;

        while (temp != null) {
            if (temp.data.equals(searchData)) return temp;
            temp = temp.next;
        }
        return null;
    }
    void addFirst(LNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addFirst(T data, K data2) {
        addFirst(new LNode<>(data, data2));
    }

    void addLast(T data, K data2) {
        LNode<T, K> newNode = new LNode<>(data, data2);

        if (head == null) {
            head = newNode;
        } else {
            LNode<T, K> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    void insertAfter(T data, K data2, T search) {
        LNode<T, K> temp = head;

        while (temp != null && temp.data != search) {
            temp = temp.next;
        }

        if (temp != null) {
            LNode<T, K> newNode = new LNode<>(data, data2);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            addLast(data, data2);
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
                LNode<T, K> temp = head.next;
                LNode<T, K> prev = head;

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
        LNode<T, K> temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.data +" , "+ temp.data2+ " -> ");
            temp = temp.next;
        }

        System.out.print("null" + " ]");
    }
    String printFile(){
    LNode<T, K> temp = head;
    String str = "[";
    while (temp != null) {
            str += temp.data +" , "+ temp.data2+ " -> ";
            temp = temp.next;
        }
    str += "null" + " ]";
    return str;
    }

    int size() {
        LNode<T, K> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
