/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764 
 * @description Clase que modela los nodos que integran el árbol binario del sistema
 * @date última modificación 18/03/2024
 */

public class NodeBST<E> {
    private E data;
    private NodeBST<E> left;
    private NodeBST<E> right;

    public NodeBST(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    /** 
     * @return E
     */
    public E getData() {
        return data;
    }

    /** 
     * @return E
     */
    public NodeBST<E> getLeft() {
        return left;
    }


    /** 
     * @param left
     */
    public void setLeft(NodeBST<E> left) {
        this.left = left;
    }

    /** 
     * @return E
     */
    public NodeBST<E> getRight() {
        return right;
    }


    /** 
     * @param right
     */
    public void setRight(NodeBST<E> right) {
        this.right = right;
    }
}
