package _11_java_javaCollectionsFramework.practice.task4_bst_optional;

public interface Tree<E> {

    /**
     * Insert a new node into the tree.
     *
     * @return true - if new node is inserted successfully.
     */
    boolean insert(E e);

    /**
     * Inorder traversal.
     */
    void inorderTraversal();

    /**
     * Get the number of node in tree.
     */
    int getSize();
}
