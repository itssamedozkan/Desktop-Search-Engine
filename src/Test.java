
import java.io.File;


/**
 * @file
  * @description Mini Masaüstü Arama Uygulaması
 * @assignment 2 
 * @date   14.Nis.2019
 * @author İsmail Taha Samed ÖZKAN
 */
public class Test {

    public static void main(String[] args) {
       
        
        
        BinarySearchTree modelTree = new BinarySearchTree();
        modelTree = modelTree.createTreeFromFolder("src"+File.separator+"belgeler");
        modelTree.preorder();
        
        modelTree.preorderToFile("src"+File.separator+"output"+File.separator+"FileOut.txt");
        
    }

}
