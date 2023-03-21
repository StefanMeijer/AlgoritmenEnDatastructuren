import java.util.HashSet;
import java.util.List;

public class BinaryTree
{
    protected class Node
    {
        private int data;
        private Node leftBranch;
        private Node rightBranch;
        protected Node(int data)
        {
            this.data = data;
        }

        protected int peakBranches()
        {
            if (leftBranch == null)
            {
                return 0;
            }
            if (rightBranch == null)
            {
                return 1;
            }
            return 2;
        }

        protected int getData() {
            return data;
        }

        protected void setData(int data) {
            this.data = data;
        }

        protected Node getLeftBranch() {
            return leftBranch;
        }

        protected void setLeftBranch(Node leftBranch) {
            this.leftBranch = leftBranch;
        }

        protected Node getRightBranch() {
            return rightBranch;
        }

        protected void setRightBranch(Node rightBranch) {
            this.rightBranch = rightBranch;
        }
    }

    private Node root;

    public BinaryTree(int data)
    {
        this.root = new Node(data);
    }

    public void insert(int data)
    {
        if (root == null) // Ensure no nullPointerException happens
        {
            root = new Node(data);
            return;
        }
        Node focusNode = root; // Sets te root Node as first focus
        Node parent; // initiates parent Node
        while(true)
        {
            parent = focusNode; // sets the current focus to the parent
            if (data < focusNode.getData()) // checks if the entered data is lower than the focus data
            {
                focusNode = focusNode.getLeftBranch(); // gets the left branch as new focus
                if (focusNode == null) // checks if current focus exists
                {
                    parent.setLeftBranch(new Node(data)); // makes a new Node
                    return;
                }
            }
            else
            {
                focusNode = focusNode.getRightBranch();
                if (focusNode == null)
                {
                    parent.setRightBranch(new Node(data));
                    return;
                }
            }

        }
    }

    public void listTreeItems(Node focusNode)
    {
        if (focusNode != null)
        {
            System.out.print(focusNode.getData()+" ");
            listTreeItems(focusNode.getLeftBranch());
            listTreeItems(focusNode.getRightBranch());
        }
    }

    public void listTreeItemsLeftFavour(Node focusNode)
    {
        if (focusNode != null)
        {
            listTreeItemsLeftFavour(focusNode.getLeftBranch());
            System.out.print(focusNode.getData()+" ");
            listTreeItemsLeftFavour(focusNode.getRightBranch());
        }
    }

    public void listTreeItemsRightFavour(Node focusNode)
    {
        if (focusNode != null)
        {
            listTreeItemsRightFavour(focusNode.getRightBranch());
            System.out.print(focusNode.getData()+" ");
            listTreeItemsRightFavour(focusNode.getLeftBranch());
        }
    }

    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
        {
            printCurrentLevel(root, i);
        }
    }

    int height(Node focusNode)
    {
        if (focusNode == null)
            return 0;
        else {
            int lheight = height(focusNode.getLeftBranch());
            int rheight = height(focusNode.getRightBranch());

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void printCurrentLevel(Node focusNode, int level)
    {
        if (focusNode == null)
            return;
        if (level == 1)
            System.out.print(focusNode.data+" ");
        else if (level > 1) {
            printCurrentLevel(focusNode.getLeftBranch(), level - 1);
            printCurrentLevel(focusNode.getRightBranch(), level - 1);
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
