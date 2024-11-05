package daamanual;

import java.util.Scanner;

public class BinarySearchTree {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static Node createTree(Node root, Scanner scanner) {
        System.out.println("Enter the data: ");
        int d = scanner.nextInt();
        root = insert(root, d);
        return root;
    }

    public static Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minVal(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    public static int minVal(Node root) {
        int mini = root.data;
        while (root.left != null) {
            mini = root.left.data;
            root = root.left;
        }
        return mini;
    }

    public static void printTree(Node root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements to insert:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            root = createTree(root, scanner);
        }

        System.out.println("BST in in-order traversal:");
        printTree(root);
        System.out.println();

        // Loop for multiple deletions
        while (true) {
            System.out.println("Enter the value you want to delete (-1 to stop):");
            int key = scanner.nextInt();
            
            // Exit condition for the deletion loop
            if (key == -1) {
                break;
            }

            root = delete(root, key);

            System.out.println("BST after deletion:");
            printTree(root);
            System.out.println();
        }

        scanner.close();
    }
}
