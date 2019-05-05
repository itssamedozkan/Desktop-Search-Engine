
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @param <T>
 * @file
 * @description Mini Masaüstü Arama Uygulaması
 * @assignment 2 
 * @date 14.Nis.2019
 * @author İsmail Taha Samed ÖZKAN
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    void insertRecursive(T newData) {
        root = insertRecursive(root, newData);
    }

    // recursive insert method
    private Node<T> insertRecursive(Node<T> node, T newData) {
        if (node == null) {
            return new Node<>(newData);
        } else {
            if (newData.compareTo(node.data) > 0) {
                node.right = insertRecursive(node.right, newData);
            } else if (newData.compareTo(node.data) < 0) {
                node.left = insertRecursive(node.left, newData);
            }

            return node;
        }
    }

    // iterative insert method
    void insert(T newData,String FileName) {
        Node<T> newNode = new Node<>(newData);

        if (root == null) {
            root = newNode;
           root.list.addLast((T)FileName, 1);
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        newNode.list.addLast((T)FileName, 1);
                        return;
                    }

                    temp = temp.right;
                } else if (newData.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        newNode.list.addLast((T)FileName, 1);
                        return;
                    }

                    temp = temp.left;
                } else {
                    
                    LNode<T,Integer> findNode = temp.list.FindNode((T) FileName);
                    
                    if(findNode != null){
                    findNode.data2 += 1;
                    }else{
                    temp.list.addLast((T)FileName, 1);
                    
                    }
                        
                    return;
                }
            }

        }
    }

    // iterative search method
    boolean search(T searchData) {
        if (root == null) {
            System.out.println("empty tree !!");
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.data) > 0) {
                    temp = temp.right;
                } else if (searchData.compareTo(temp.data) < 0) {
                    temp = temp.left;
                } else {
                    return true;
                }
            }

        }
        return false;
    }

    void preorder() {
        System.out.print("preorder : ");
        System.out.println("");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            
            node.list.print();
            System.out.println("");
            preorder(node.left);
            preorder(node.right);
        }
    }
    
       void preorderToFile(String Path) {
           
           try {
               BufferedWriter writer = new BufferedWriter(new FileWriter(Path));
               writer.write("preordered : ");
               writer.write("\r\n");
               writer.close();
               preorderToFile(root,Path);
        System.out.println();
           } catch (Exception e) {
           }
           
    
    
        
        
    }
    
    
        void preorderToFile(Node<T> node,String Path) {
            
            try {
                
            
         BufferedWriter writer = new BufferedWriter(new FileWriter(Path,true));
         String str = "";
         if (node != null) {
            str += node.data + " ";
            
            str += node.list.printFile();
            writer.write(str);
            writer.write("\r\n");
            
            writer.close();
            preorderToFile(node.left,Path);
            preorderToFile(node.right,Path);
        }
       } catch (Exception e) {
            }
        
    }
   

    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void postorder() {
        System.out.print("postorder : ");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
            System.out.println("");
        }
    }

    int sumRecursive() {
        return sumRecursive(root);
    }

    // recursive sum method
    private int sumRecursive(Node<T> node) {
        if (node != null) {
            if (node.data instanceof Number) {
                return ((Number) node.data).intValue() + sumRecursive(node.left) + sumRecursive(node.right);
            }
        }

        return 0;
    }

    int sizeRecursive() {
        return sizeRecursive(root);
    }

    // recursive size method
    private int sizeRecursive(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeRecursive(node.left) + sizeRecursive(node.right);
        }
    }

    int fullNodeCountRecursive() {
        return fullNodeCountRecursive(root);
    }

    // recursive full node (node that have both left and right child) count method
    private int fullNodeCountRecursive(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            if (node.left != null && node.right != null) {
                return 1 + fullNodeCountRecursive(node.left) + fullNodeCountRecursive(node.right);
            } else {
                return 0 + fullNodeCountRecursive(node.left) + fullNodeCountRecursive(node.right);
            }
        }
    }

    BinarySearchTree<T> createTreeFromFolder(String folderPath) {
        BinarySearchTree<T> modelTree = new BinarySearchTree<>();
        File ignoreList = null;
        File folder = new File(folderPath);
        SLinkedList<File> files = new SLinkedList();
        SLinkedList<String> ignoreİndex = new SLinkedList<>();

        for (File listFile : folder.listFiles()) {
            String name = listFile.getName();
            if (name.equals("ignoreList.txt")) {
                ignoreList = listFile;
                continue;
            }
            String extension = name.substring(name.lastIndexOf("."));
            if (extension.equals(".html")) {
                files.addLast(listFile);
            }
        }

        try {
            Scanner ignore = new Scanner(ignoreList);
            while (ignore.hasNext()) {
                String str = ignore.nextLine();
                ignoreİndex.addLast(str);
            }
        } catch (FileNotFoundException e) {
        }

        

        Scanner reader;

        SNode temp = files.head;
        int counter = 0;
        while (temp != null) {



            try {
                reader = new Scanner((File) temp.data);

                while (reader.hasNext()) {
                    String str = reader.next();
                    if (str.charAt(0) != '<' && !ignoreİndex.isContains(str) && !Pattern.matches("\\p{Punct}", str)) {
                        modelTree.insert((T)str,((File)temp.data).getName());
                    }

                }

            } catch (FileNotFoundException ex) {

            }
            temp = temp.next;
        }

        return modelTree;
    }
}
