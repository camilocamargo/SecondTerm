package classes;

/*
 * class Tree
 */

/**
 *
 * @author Camilo Camargo
 */

public class Tree {

    public Node root = null;
    public static int numberOfLeaf;
    public static int index = 0; 
    public static int level = 1;
    
    public boolean isEmpty() {
        return root == null ? true : false;
    }
    
    public int heightOfTheTree(){
        Node temp = root;
        int height = 0;
        while (temp.left != null){
            temp = temp.left;
            height++;
        }
        return height;
    }
    
    public static int numberOfLeaf(Node node){
        if (node != null) {
            if (node.left == null && node.right == null) {
                numberOfLeaf++;
            }
            numberOfLeaf(node.left);
            numberOfLeaf(node.right);
        }
        return numberOfLeaf;
    }
    
    public static void flushNumberOfLeaf(){
        numberOfLeaf = 0;
    }
    
    public static void flushIndex(){
        index = 0;
    }
    
    public static void flushLevel(){
        level = 1;
    }
    public void addLevelToTheTree(Node node) {
        if (node != null) {
            if (isLeaf(node)) {
                node.left = new Node(0,level);
                node.right = new Node(0,level);
            } else {
                addLevelToTheTree(node.left);
                addLevelToTheTree(node.right);
            }
        }
    }
    
    public void createTree(int numberOfLeaftoCreate){
        Node temp = root;
        addLevelToTheTree(temp);
        level++;
        while(numberOfLeaf(temp) < numberOfLeaftoCreate){
            addLevelToTheTree(temp);
            level++;
            flushNumberOfLeaf();
        }
        flushNumberOfLeaf();
    }
    
    public void fillLeafs(Node node,int[] numbers){
        if (node != null) {
            if (node.left == null && node.right == null && index < numbers.length) {
                node.value = numbers[index++];
            }
            fillLeafs(node.left, numbers);
            fillLeafs(node.right, numbers);
        }
    }
    
    public int operate(Node node){
        if (node != null) {
            if (((heightOfTheTree() % 2 != 0 && node.level % 2 == 0) || (heightOfTheTree() % 2 == 0 && node.level % 2 != 0)) && node.left != null & node.right != null) {
                node.value = operate(node.left) + operate(node.right);
            } else if (node.left != null & node.right != null){
                node.value = operate(node.left) - operate(node.right);
            }
            return node.value;
        }
        return 0;
    }
    
    public Node binarySearch(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.value == value) {
                break;
            }
            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return temp;
    }
    
    public Node binarySearch(char character){
        Node temp = root;
        while(temp != null && temp.character != character){
            if(temp.character == character)
                return temp;
            else{
                if(character < temp.character){
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }
        return temp;
    }

    public Node parent(Node node) {
        Node temp = root;
        Node parent = null;
        if(node == root){
            return parent;
        }
        if (!isEmpty()) {
            /**
             * While doesn't found the node, and temp diferent of null*
             */
            while (temp != null && temp.value != node.value) {
                parent = temp;
                if (node.value < temp.value) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            /**
             * The node wasn't found.*
             */
            if (temp == null) {
                parent.value = -1;
            }
        }
        return parent;
    }

    public int balanceFactor(Node node) { //falta terminar
        int balanceFactor = 0;
        Node temp = binarySearch(node.value);
        Node left = temp, right = temp;
        while (left != null) {

        }
        return balanceFactor;
    }

    public void rightSimpleRotation(Node node1) {
        Node parent = parent(node1);
        Node node2 = node1.left;
        node2.right = node1;
        node1.left = null;
        if (parent != null) {
            if (node2.value < parent.value) {
                parent.left = node2;
            } else {
                parent.right = node2;
            }
        } else {
            root = node2;
        }
    }

    public void rightDoubleRotation(Node node1){
        Node node2 = node1.right;
        Node node3 = node2.left;
        rightSimpleRotation(node2);
        leftSimpleRotation(node1);
    }
    
    public void leftSimpleRotation(Node node1) {
        Node parent = parent(node1);
        Node node2 = node1.right;
        node2.left = node1;
        node1.right = null;
        if (parent != null) {
            if (node2.value < parent.value) {
                parent.left = node2;
            } else {
                parent.right = node2;
            }
        } else {
            root = node2;
        }
    }
    
    public void leftDoubleRotation(Node node1){
        Node node2 = node1.left;
        Node node3 = node2.right;
        leftSimpleRotation(node2);
        rightSimpleRotation(node1);
    }

    public boolean isLeaf(Node node) {
        return (node.left == null && node.right == null) ? true : false;
    }

    public boolean oneChild(Node node) {
        return (node.left != null && node.right != null) ? false : true;
    }

    public void insert(int value) {
        if (isEmpty()) {
            root = new Node(value);
        } else {
            Node temp = root; //only to find the space for insertion
            Node parent = root;
            while (temp != null) {
                parent = temp;
                if (temp.value > value) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if (parent.value < value) {
                parent.right = new Node(value);
            } else {
                parent.left = new Node(value);
            }
        }
    }

    public void insert(char character) {
        if (isEmpty()) {
            root = new Node(character);
        } else {
            Node temp = root;
            Node parent = temp;
            while (temp != null) {
                parent = temp;
                if (character < temp.character) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if (character < parent.character) {
                parent.left = new Node(character);
            } else {
                parent.right = new Node(character);
            }
        }
    }
    
    public void insertLeft(Node insert, Node node){
        node.left = insert;
    }
    
    public void insertRight(Node insert, Node node){
        node.right = insert;
    }
    
    public static Node recoveryTree(String preOrder, String inOrder){
        if(!preOrder.equals("") && !inOrder.equals("")){
            char root = preOrder.charAt(0);
            String leftPreorder = "", leftInorder = "", rightPreorder = "", rightInorder = "";
            int i = 0, j = 1, k, counterLeft = 0, counterRight = 0;
            while (inOrder.charAt(i) != root) {
                leftInorder += inOrder.charAt(i);
                counterLeft++;
                i++;
            }
            i++;
            while (i < inOrder.length()) {
                rightInorder += inOrder.charAt(i);
                counterRight++;
                i++;
            }
            while(counterLeft > 0){
                leftPreorder += preOrder.charAt(j++);
                counterLeft--;
            }
            while(counterRight > 0){
                rightPreorder += preOrder.charAt(j++);
                counterRight--;
            }
            Tree tree = new Tree();
            tree.insert(root);
            tree.insertLeft(recoveryTree(leftPreorder, leftInorder), tree.root);
            tree.insertRight(recoveryTree(rightPreorder, rightInorder), tree.root);
            return tree.root;
        }
        return null;
    }
    
    public void delete(int value) {
        Node toDelete = root;
        Node parentToDelete = toDelete;
        /**
         * Fisrt find the node*
         */
        while (toDelete != null) {
            if (toDelete.value == value) {
                break;
            }
            parentToDelete = toDelete;
            if (value < toDelete.value) {
                toDelete = toDelete.left;
            } else {
                toDelete = toDelete.right;
            }
        }
        /**
         * The node was or wasn´t found at this point.*
         */
        if (toDelete == null) {
            System.out.println("No existe");
            /**
             * If is a leaf.*
             */
        } else if (isLeaf(toDelete)) {
            toDelete = null;
            if (value < parentToDelete.value) {
                parentToDelete.left = null;
            } else {
                parentToDelete.right = null;
            }
            /**
             * If has one child*
             */
        } else if (oneChild(toDelete)) {
            /**
             * If has one child for the left*
             */
            if (toDelete.left != null) {
                if (value < parentToDelete.value) {
                    parentToDelete.left = toDelete.left;
                } else {
                    parentToDelete.right = toDelete.left;
                }
                /**
                 * If has one child for the right.*
                 */
            } else if (value < parentToDelete.value) {
                parentToDelete.left = toDelete.right;
            } else {
                parentToDelete.right = toDelete.right;
            }
        } else {
            /**
             * If have two children.*
             */
            Node succesor = toDelete.right;
            Node parentSuccesor = succesor;
            if (succesor.left == null) {
                succesor.left = toDelete.left;
                if (value < parentToDelete.value) {
                    parentToDelete.left = succesor;
                } else {
                    parentToDelete.right = succesor;
                }
            } else {
                while (succesor.left != null) {
                    parentSuccesor = succesor;
                    succesor = succesor.left;
                }
                /**
                 * At this point the succesor was found.* If is a leaf.*
                 */
                if (isLeaf(succesor)) {
                    succesor.left = toDelete.left;
                    succesor.right = toDelete.right;
                } else {
                    parentSuccesor.left = succesor.right;
                    succesor.left = toDelete.left;
                    succesor.right = toDelete.right;
                }
                if (value < parentToDelete.value) {
                    parentToDelete.left = succesor;
                } else {
                    parentToDelete.right = succesor;
                }
                toDelete = null;
                System.gc();
            }
        }
    }

    public void remove(int value) {
        //first find the value
        if (!isEmpty()) {
            Node toDelete = root;
            Node preToDelete = toDelete;
            boolean direction = false; //false for left true for right
            while (toDelete != null) {
                if (value < toDelete.value) {
                    direction = false;
                    preToDelete = toDelete;
                    toDelete = toDelete.left;
                } else {
                    direction = true;
                    preToDelete = toDelete;
                    toDelete = toDelete.right;
                }
                if (toDelete.value == value) {
                    break;
                }
            }
            //at this point the node with the value was found.
            if (toDelete != null) { //if was found 
                if (toDelete.right == null && toDelete.left == null) {//if the Node is a leaf
                    if (!direction)//for the left
                    {
                        preToDelete.left = null;
                    } else {
                        preToDelete.right = null;
                    }
                    toDelete = null;
                    System.gc();
                } else if (toDelete.left != null && toDelete.right == null) { //if only have child for the left
                    if (!direction) {
                        preToDelete.left = toDelete.left; // point the left of preToDelete to the left of toDelete
                    } else {
                        preToDelete.right = toDelete.left;// point the right of preToDelete to the left of toDelete
                    }
                    toDelete = null;
                    System.gc();
                } else if (toDelete.right != null && toDelete.left == null) { //if only have child for the right
                    if (!direction) {
                        preToDelete.left = toDelete.right; // point the left of preToDelete to the right of toDelete
                    } else {
                        preToDelete.right = toDelete.right;// point the right of preToDelete to the right of toDelete
                    }
                    toDelete = null;
                    System.gc();
                } else {
                    Node succesor = toDelete;
                    Node preSuccesor = succesor;

                    succesor = toDelete.right; //find the smaller value among the biggers
                    while (succesor.left != null) {
                        preSuccesor = succesor;
                        succesor = succesor.left;
                    }

                    if (!direction) {//for the left
                        if (succesor.right != null) {
                            preSuccesor.left = succesor.right;
                        }
                        succesor.left = toDelete.left;
                        succesor.right = toDelete.right;
                        preToDelete.left = succesor;
                    } else {
                        if (succesor.right != null) {
                            preSuccesor.left = succesor.right;
                        }
                        succesor.left = toDelete.left;
                        succesor.right = toDelete.right;
                        preToDelete.right = succesor;
                    }
                    toDelete = null;
                    System.gc();
                }
            }
        }
    }

    public void traversalPreOrder(Node node) {
        if (node != null) {
            System.out.println(node.toString());
            traversalPreOrder(node.left);
            traversalPreOrder(node.right);
        }
    }
    
    public void traversalPreOrderCharacter(Node node) {
        if (node != null) {
            System.out.print(node.getCharacter() + " ");
            traversalPreOrderCharacter(node.left);
            traversalPreOrderCharacter(node.right);
        }
    }

    public void traversalInOrder(Node node) {
        if (node != null) {
            traversalInOrder(node.left);
            System.out.println(node.toString());
            traversalInOrder(node.right);
        }
    }
    
    public void traversalInOrderCharacter(Node node) {
        if (node != null) {
            traversalInOrderCharacter(node.left);
            System.out.print(node.getCharacter() + " ");
            traversalInOrderCharacter(node.right);
        }
    }

    public void traversalPostOrder(Node node) {
        if (node != null) {
            traversalPostOrder(node.left);
            traversalPostOrder(node.right);
            System.out.println(node.toString());
        }
    }
    
    public void traversalPostOrderCharacter(Node node) {
        if (node != null) {
            traversalPostOrderCharacter(node.left);
            traversalPostOrderCharacter(node.right);
            System.out.print(node.getCharacter() + " ");
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
//        tree.insert(20);
//        tree.insert(8);
//        tree.insert(4);
//        tree.insert(5);
//        tree.insert(15);
//        tree.insert(10);
//        tree.insert(12);
//        tree.insert(13);
//        tree.insert(14);
//        tree.insert(25);
//        tree.insert(21);
//        tree.insert(50);
//        tree.insert(40);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(7);
//        tree.insert(4);
//        tree.delete(8);
        tree.insert(10);
//        tree.insert(4);//
//        tree.insert(5);//
//        tree.insert(3);//
        tree.insert(11);
        tree.insert(15);
        tree.insert(12);
        tree.rightDoubleRotation(tree.binarySearch(11));
        System.out.println("<<<-----Preorder------>>>");
        tree.traversalPreOrder(tree.root);
        System.out.println("<<<------Inorder------>>>");
        tree.traversalInOrder(tree.root);
        System.out.println("<<<-----Postorder---->>>");
        tree.traversalPostOrder(tree.root);
        Tree tree2 = new Tree();
        tree2.insert(1);
        tree2.createTree(9);
        System.out.println(numberOfLeaf(tree2.root));
    }
}
