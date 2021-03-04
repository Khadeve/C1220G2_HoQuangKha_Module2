package _11_java_javaCollectionsFramework.practice.task4_bst_optional;

public class TreeNode<E> {
    protected E data;
    protected TreeNode<E> leftNode;
    protected TreeNode<E> rightNode;

    public TreeNode(E data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public E getData() {
        return data;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }
}
