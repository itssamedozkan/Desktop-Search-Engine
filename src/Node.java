
/**
 * @file
 * @description Mini Masaüstü Arama Uygulaması
 * @assignment 2 
 * @date   14.Nis.2019
 * @author İsmail Taha Samed ÖZKAN
 */
public class Node<T extends Comparable<T>> {

    T data;
    LinkedList<T, Integer> list;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        list = new LinkedList<T,Integer>();
        this.data = data;
    }
}
