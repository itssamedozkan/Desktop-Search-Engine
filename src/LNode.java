
/**
 * @file
 * @description Mini Masaüstü Arama Uygulaması
 * @assignment 2 
 * @date   14.Nis.2019
 * @author İsmail Taha Samed ÖZKAN
 */
public class LNode<T extends Comparable<T>, K extends Comparable<K>> {

    T data;
    K data2;
    LNode<T, K> next;

    public LNode(T data, K data2) {
        this.data = data;
        this.data2 = data2;
    }

}
