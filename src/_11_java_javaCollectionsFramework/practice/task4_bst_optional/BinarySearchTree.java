package _11_java_javaCollectionsFramework.practice.task4_bst_optional;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BinarySearchTree(){}

    public BinarySearchTree(E[] objects) {
        for (E object : objects) {
            insert(object);
        }
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    /**
     * get the number of nodes in tree.
     */
    public int getSize() {
        return size;
    }

    /**
     * insert new node into the binary tree.
     *
     * @param newData - the data of new node.
     * @return true if inserting successfully, otherwise false.
     */
    @Override
    public boolean insert(E newData) {
        if (size == 0) {
            root = new TreeNode<>(newData);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            //locate the parent node.
            while(current != null) {
                if (newData.compareTo(current.data) < 0) {  //add new node on left branch.
                    parent = current;
                    current = current.leftNode;
                } else if (newData.compareTo(current.data) > 0) {   //add new node on right branch.
                    parent = current;
                    current = current.rightNode;
                } else {
                    return false;   //duplicate node is not inserted.
                }
            }
            //add new node after found the parent node.
            assert parent != null;
            if (newData.compareTo(parent.data) < 0) {
                parent.leftNode = new TreeNode<>(newData);
            } else {
                parent.rightNode = new TreeNode<>(newData);
            }
        }
        size++;
        return true;    //insert new node successfully.
    }

    /**
     * Checks whether a node is in the binary search tree based on the data.
     *
     * @return the located tree node.
     */
    public boolean search(E data) {
        return search(data, root);
    }

    private boolean search(E data, TreeNode<E> node) {
        //uses preorder traversal.

        if (node == null) return false;

        if (node.data.compareTo(data) == 0) return true;

        //then recur on the left subtree.
        boolean res1 = search(data, node.leftNode);
        if (res1) return res1;

        //if data is not found on left subtree, recur on the right subtree.
        return search(data, node.rightNode);
    }

    @Override
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode<E> root) {
        if (root == null) return;
        inorderTraversal(root.leftNode);
        System.out.print(root.data + " ");
        inorderTraversal(root.rightNode);
    }

    /*
     * Postorder traversal on a binary tree.
     */
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(TreeNode<E> root) {
        if (root == null) return;
        postorderTraversal(root.getLeftNode());
        postorderTraversal(root.getRightNode());
        System.out.print(root.getData() + " ");
    }


    /**
     * remove a node with data of key in the binary search tree.
     */
    public void deleteKey(E key) {
        root = deleteNode(root, key);
    }

    /**
     * Remove a node with data of key from the binary search tree using recursion.
     */
    private TreeNode<E> deleteNode(TreeNode<E> root, E key) {
        //if BST is empty.
        if (root == null) {
            return null;
        }

        //otherwise, recur down the tree.
        if (key.compareTo(root.data) < 0) {
            root.leftNode = deleteNode(root.leftNode, key);
        } else if (key.compareTo(root.data) > 0) {
            root.rightNode = deleteNode(root.rightNode, key);
        } else {    //if the key is the same as root's data.
            //in case, root has one child.
            if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null) {
                return root.leftNode;
            }
            //node with two children: get the smallest value in the right subtree (inorder successor).
            root.data = minValue(root);

            //delete inorder successor.
            root.rightNode = deleteNode(root.rightNode, root.data);
        }
        return root;
    }

    /**
     * Find the smallest value in the binary search tree.
     */
    E minValue(TreeNode<E> root) {
        TreeNode<E> current = root;
        E minv = current.data;
        while(current != null) {
            minv = current.data;
            current = current.leftNode;
        }
        return minv;
    }
}
