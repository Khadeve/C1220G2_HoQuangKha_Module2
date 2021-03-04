package _11_java_javaCollectionsFramework.practice.task4_bst_optional;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> numberTree = new BinarySearchTree<>();

        numberTree.insert(5);
        numberTree.insert(6);
        numberTree.insert(3);
        numberTree.insert(8);
        numberTree.insert(4);

        /*----------------------inorder traversal-------------------------*/
        System.out.println("Inorder traversal:");
        numberTree.inorderTraversal();

        System.out.println("Number of nodes: " + numberTree.getSize());

        /*-------------------search---------------------*/
        System.out.println("is 3 in the binary search tree? " + numberTree.search(3));
        System.out.println("is 4 in the binary search tree? " + numberTree.search(4));

        /*------------------remove---------------------*/
        System.out.println("--------------------------------------");
        numberTree.deleteKey(6);
        System.out.println("Inorder traversal:");
        numberTree.inorderTraversal();
    }
}
