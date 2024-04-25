package binarysearchtree;
import java.io.FileWriter;
import java.io.IOException;

import node.Node;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    // New method to generate DOT file
    public void generateDotFile(Node root, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("digraph BST {\n");
            generateDotCode(root, writer);
            writer.write("}");
        }
    }

    private void generateDotCode(Node node, FileWriter writer) throws IOException {
        if (node == null) {
            return;
        }

        writer.write(String.format("%d [label=\"%d\"];\n", node.getValue(), node.getValue()));

        if (node.getLeft() != null) {
            writer.write(String.format("%d -> %d [label=\"left\"];\n", node.getValue(), node.getLeft().getValue()));
            generateDotCode(node.getLeft(), writer);
        }

        if (node.getRight() != null) {
            writer.write(String.format("%d -> %d [label=\"right\"];\n", node.getValue(), node.getRight().getValue()));
            generateDotCode(node.getRight(), writer);
        }
    }

    // Função para inserir um novo nodo na árvore
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.getValue()) {
            root.setLeft(insertNode(root.getLeft(), value)); // usa recursão para verificar as condições para adicionar o nó
        } else if (value > root.getValue()) {
            root.setRight(insertNode(root.getRight(), value)); // usa recursão para verificar as condições para adicionar o nó
        }

        return root;
    }

    // procura um valor na arvore
    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.getValue() == value) {
            return true;
        } else if (value < root.getValue()) {
            return searchNode(root.getLeft(), value);
        } else {
            return searchNode(root.getRight(), value);
        }
    }

    // caminhamento em ordem (in-order)
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrder(root.getRight());
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    // caminhamento post-order
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }

    // funcao para remover um nó
    public void remove(int value) {
        root = removeNode(root, value);
    }

    private Node removeNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.getValue()) {
            root.setLeft(removeNode(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(removeNode(root.getRight(), value));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            root.setValue(minValue(root.getRight()));

            root.setRight(removeNode(root.getRight(), root.getValue()));
        }

        return root;
    }

    private int minValue(Node root) {
        int minvalue = root.getValue();
        while (root.getLeft() != null) {
            minvalue = root.getLeft().getValue();
            root = root.getLeft();
        }
        return minvalue;
    }

    // Função para imprimir a árvore
    public void printTree() {
        print(root, 0);
    }

    private void print(Node root, int depth) {
        if (root != null) {
            print(root.getRight(), depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(root.getValue());
            print(root.getLeft(), depth + 1);
        }
    }
}