
/**
 * @file
 * @description Mini Masaüstü Arama Uygulaması
 * @assignment 2 
 * @date   14.Nis.2019
 * @author İsmail Taha Samed ÖZKAN
 */
public class SNode<T> {

    T data;
    SNode<T> next;

    public SNode(T data) {
        this.data = data;
        this.next = null;
    }

}
