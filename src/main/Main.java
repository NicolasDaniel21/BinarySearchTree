package Main;

import java.io.IOException;

import binarysearchtree.BinarySearchTree;

public class Main {
    public static void main(String[] args) throws IOException{
        BinarySearchTree tree = new BinarySearchTree();

        // Inserindo elementos na árvore
        tree.insert(55);
        tree.insert(25);
        tree.insert(85);
        tree.insert(15);
        tree.insert(35);
        tree.insert(65);
        tree.insert(95);

        // Imprimindo a árvore em ordem
        System.out.println("Arvore em ordem:");
        tree.inOrder();
        System.out.println();

        // Buscando um valor específico
        int searchValue = 40;
        System.out.println("Buscando o valor " + searchValue + ": " + tree.search(searchValue));

        // Removendo um nodo
        int removevalue = 25;
        tree.remove(removevalue);
        System.out.println("Após tentar remover " + removevalue + ":");
        tree.printTree();

        removevalue = 60;
        tree.remove(removevalue);
        System.out.println("Após tentar remover " + removevalue + ":");
        tree.printTree();
        
        removevalue = 55;
        tree.remove(removevalue);
        System.out.println("Após tentar remover " + removevalue + ":");
        tree.printTree();

        int insertValue = 80;
        tree.insert(insertValue);
        System.out.println("Após tentar inserir " + insertValue + ":");
        tree.printTree();

        System.out.println("Em ordem novamente: ");
        tree.inOrder();

        tree.generateDotFile(tree.getRoot(), "bst_pre_order.dot");

    }
}
