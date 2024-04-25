package Main;

import binarysearchtree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserindo elementos na árvore
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Imprimindo a árvore em ordem
        System.out.println("Arvore em ordem:");
        tree.inOrder();
        System.out.println();

        // Buscando um valueor específico
        int searchValue = 40;
        System.out.println("Buscando o valor " + searchValue + ": " + tree.search(searchValue));

        // Removendo um nodo
        int removevalue = 30;
        tree.remove(removevalue);
        System.out.println("Após remover " + removevalue + ":");
        tree.printTree();

        System.out.println("Em ordem novamente: ");
        tree.inOrder();


    }
}
