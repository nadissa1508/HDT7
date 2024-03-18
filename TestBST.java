import static org.junit.Assert.*;
import org.junit.Test;

public class TestBST {
    @Test
    public void testInsert() {
        BinarySearchTree tree = new BinarySearchTree();

        // Insertar algunas asociaciones en el árbol
        tree.insert(new Association<>("apple", "manzana"));
        tree.insert(new Association<>("banana", "plátano"));
        tree.insert(new Association<>("orange", "naranja"));

        // Verificar que las asociaciones se insertaron correctamente
        assertEquals("manzana", tree.search(new Association<>("apple", "")).getValue());
        assertEquals("plátano", tree.search(new Association<>("banana", "")).getValue());
        assertEquals("naranja", tree.search(new Association<>("orange", "")).getValue());
    }

    @Test
    public void testSearch() {
        BinarySearchTree tree = new BinarySearchTree();

        // Insertar algunas asociaciones en el árbol
        tree.insert(new Association<>("apple", "manzana"));
        tree.insert(new Association<>("banana", "plátano"));
        tree.insert(new Association<>("orange", "naranja"));

        // Buscar asociaciones existentes en el árbol
        assertEquals("manzana", tree.search(new Association<>("apple", "")).getValue());
        assertEquals("plátano", tree.search(new Association<>("banana", "")).getValue());
        assertEquals("naranja", tree.search(new Association<>("orange", "")).getValue());

        // Buscar una asociación que no existe en el árbol
        assertNull(tree.search(new Association<>("grape", "")));
    }
}
