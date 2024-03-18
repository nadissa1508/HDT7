public class NodeBST<E> {
    private E data;
    private NodeBST<E> left;
    private NodeBST<E> right;

    public NodeBST(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    public E getData() {
        return data;
    }

    public NodeBST<E> getLeft() {
        return left;
    }

    public void setLeft(NodeBST<E> left) {
        this.left = left;
    }

    public NodeBST<E> getRight() {
        return right;
    }

    public void setRight(NodeBST<E> right) {
        this.right = right;
    }
}
