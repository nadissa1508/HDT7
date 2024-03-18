public class BinarySearchTree {
    private NodeBST<Association> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(Association data) {
        root = insertRecursively(root, data);
    }

    private NodeBST<Association> insertRecursively(NodeBST<Association> node, Association data) {
        if (node == null) {
            return new NodeBST<>(data);
        }

        if (data.getKey().compareTo(node.getData().getKey()) < 0) {
            node.setLeft(insertRecursively(node.getLeft(), data));
        } else if (data.getKey().compareTo(node.getData().getKey()) > 0) {
            node.setRight(insertRecursively(node.getRight(), data));
        }

        return node;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(NodeBST<Association> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print("(" + node.getData().getKey() + ", " + node.getData().getValue() + ") ");
            inOrderTraversal(node.getRight());
        }
    }

    public Association search(Association target) {
        return searchRecursively(root, target);
    }

    private Association searchRecursively(NodeBST<Association> node, Association target) {
        if (node == null) {
            return null;
        }

        int comparison = target.getKey().compareTo(node.getData().getKey());
        if (comparison < 0) {
            return searchRecursively(node.getLeft(), target);
        } else if (comparison > 0) {
            return searchRecursively(node.getRight(), target);
        } else {
            return node.getData();
        }
    }
}
