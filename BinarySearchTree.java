/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764 
 * @description Clase para crear el árbol binario donde se guardan las palabras
 * del diccionario en orden alfabético
 * @date última modificación 18/03/2024
 */

public class BinarySearchTree {

    //nodo raiz del árbol
    private NodeBST<Association<String, String>> root;

    //creamos la raiz
    public BinarySearchTree() {
        root = null;
    }

    
    /** 
     * @param data
     * Método insertar que sirve para llamar a la inserción que utiliza recursividad
     */
    public void insert(Association<String, String> data) {
        root = insert(root, data);
    }
    
    /** 
     * @param NodeBST<Association<String
     * @param node
     * @param Association<String
     * @param data
     * @return NodeBST<Association<String, String>>
     * Método de inserción que utiliza recursividad para agregar nuevos nodos al árbol.
     * Se verifica el orden alfabetico por medio del método compareTo de las Keys, ya que estas variables
     * al ser declaradas String heredan el método compareTo de dicha clase
     */
    public NodeBST<Association<String,String>> insert(NodeBST<Association<String, String>> currentNode, Association<String, String> dataNewNode) {
        if (currentNode == null) {
            //si el nodo es nulo entonces lo creamos
            return new NodeBST<>(dataNewNode);
        }
        //se realiza la inserción por orden alfabetico por medio del compareTo
        if (dataNewNode.getKey().compareTo(currentNode.getData().getKey()) < 0) {
            //si la clave del nuevo nodo es menor a la clave del nodo actual insertamos a la izquierda
            currentNode.setLeft(insert(currentNode.getLeft(), dataNewNode));

        } else if (dataNewNode.getKey().compareTo(currentNode.getData().getKey()) > 0) {
            //si la clave del nuevo nodo es mayor a la clave del nodo actual insertamos a la derecha
            currentNode.setRight(insert(currentNode.getRight(), dataNewNode));
        }

        return currentNode;
    }

    /** 
     * Método para llamar a la busqueda que utiliza recursividad
     */
    public void searchInOrder() {
        searchInOrder(root);
    }

    //funciones para imprimir las asociaciones de palabras en orden alfabetico
    
    /** 
     * @param node
     */
    private void searchInOrder(NodeBST<Association<String, String>> node) {
        if (node != null) {
            //recorrer subárbol izquierdo
            searchInOrder(node.getLeft());

            //se imprime la palabra en ingles y el significado en español
            System.out.print("(" + node.getData().getKey() + ", " + node.getData().getValue() + ") ");

            //recorrer subárbol derecho
            searchInOrder(node.getRight());
        }
    }

    
    /** 
     * @param target
     * @return Association<String, String>
     * Funcion de búsqueda que devuelve una instancia de Association y llama
     * a la función search que utiliza recursividad
     */
    public Association<String, String> search(Association<String, String> target) {
        return search(root, target);
    }

    
    //funciones para buscar una asociación específica en el árbol binario

    /** 
     * @param node
     * @param Association<String
     * @param target
     * @return Association<String, String>
     * método que devuelve la asociacion de una palabra del arbol binario
     */
    private Association<String, String> search(NodeBST<Association<String, String>> node, Association<String, String> target) {
        //verificamos si es nulo
        if (node == null) {
            return null;
        }

        int comparacion = target.getKey().compareTo(node.getData().getKey());

        //continuar la busqueda en el subárbol izquierdo
        if (comparacion < 0) {
            return search(node.getLeft(), target);
        } else if (comparacion > 0) {
            //continuar la busqueda en el subárbol derecho
            return search(node.getRight(), target);
        } else {
            //si la llave de un nodo del arbol y la llave del nodo a buscar son iguales
            //entonces se devuelve la informacion del nodo donde se encuentra el significado de la palabra en español
            return node.getData();
        }
    }
}
