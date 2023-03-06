public class Main {
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(1);
        tree.insert(4);
        tree.printLevelOrder();
        System.out.println();
        tree.listTreeItems(tree.getRoot());
        System.out.println();
        tree.listTreeItemsLeftFavour(tree.getRoot());
    }
}
