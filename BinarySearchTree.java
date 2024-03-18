public class BinarySearchTree {
    private NodeBST<Association<String, String>> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(Association<String, String> data) {
        root = insert(root, data);
    }

    public NodeBST<Association<String,String>> insert(NodeBST<Association<String, String>> node, Association<String, String> data) {
        if (node == null) {
            return new NodeBST<>(data);
        }

        if (data.getKey().compareTo(node.getData().getKey()) < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data.getKey().compareTo(node.getData().getKey()) > 0) {
            node.setRight(insert(node.getRight(), data));
        }

        return node;
    }

    public void searchInOrder() {
        searchInOrder(root);
        System.out.println();
    }

    private void searchInOrder(NodeBST<Association<String, String>> node) {
        if (node != null) {
            searchInOrder(node.getLeft());
            System.out.print("(" + node.getData().getKey() + ", " + node.getData().getValue() + ") ");
            searchInOrder(node.getRight());
        }
    }

    public Association<String, String> search(Association<String, String> target) {
        return search(root, target);
    }

    private Association<String, String> search(NodeBST<Association<String, String>> node, Association<String, String> target) {
        if (node == null) {
            return null;
        }

        int comparison = target.getKey().compareTo(node.getData().getKey());
        if (comparison < 0) {
            return search(node.getLeft(), target);
        } else if (comparison > 0) {
            return search(node.getRight(), target);
        } else {
            return node.getData();
        }
    }
}
