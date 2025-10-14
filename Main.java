import java.util.Scanner;

// Clase que representa un nodo del árbol binario
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Clase que representa el Árbol Binario de Búsqueda
class Tree {
    Node root;

    Tree() {
        root = null;
    }

    // Inserta una clave en el árbol
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Inserción de nosdos recursiva
    Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Búsqueda pública
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Búsqueda recursiva
    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Recorrido inorden público
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Recorrido inorden recursivo
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Contar nodos del árbol
    int contarNodos() {
        return contarNodosRec(root);
    }

    int contarNodosRec(Node nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodosRec(nodo.left) + contarNodosRec(nodo.right);
    }

    // Mostrar el árbol gráficamente
    void mostrarArbol() {
        mostrarArbolRec(root, "", false);
    }

    void mostrarArbolRec(Node nodo, String prefijo, boolean esIzquierda) {
        if (nodo != null) {
            System.out.println(prefijo + (esIzquierda ? "├── " : "└── ") + nodo.key);
            mostrarArbolRec(nodo.left, prefijo + (esIzquierda ? "│   " : "    "), true);
            mostrarArbolRec(nodo.right, prefijo + (esIzquierda ? "│   " : "    "), false);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Árbol Binario ---");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar recorrido inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Mostrar cantidad de nodos");
            System.out.println("5. Mostrar árbol gráficamente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número a insertar: ");
                    int valor = scanner.nextInt();
                    tree.insert(valor);
                    System.out.println("Número insertado.");
                    break;
                case 2:
                    System.out.println("Recorrido inorden del árbol:");
                    tree.inorder();
                    break;
                case 3:
                    System.out.print("Ingrese número a buscar: ");
                    int clave = scanner.nextInt();
                    if (tree.search(clave)) {
                        System.out.println("El número " + clave + " SÍ se encuentra en el árbol.");
                    } else {
                        System.out.println("El número " + clave + " NO se encuentra en el árbol.");
                    }
                    break;
                case 4:
                    System.out.println("Cantidad total de nodos en el árbol: " + tree.contarNodos());
                    break;
                case 5:
                    System.out.println("Representación gráfica del árbol:");
                    tree.mostrarArbol();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
