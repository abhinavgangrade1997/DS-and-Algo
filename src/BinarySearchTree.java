import java.util.ArrayList;

public class BinarySearchTree{
	TreeNode root = null;
	
	public void insert(int value){
        TreeNode newTreeNode = new TreeNode(value);
        if (this.root == null) {
            this.root = newTreeNode;
        } else {
            TreeNode current = this.root;
            while (true) {
                // right
                if (current.value < value) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newTreeNode;
                        break;
                    }
                    // left
                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newTreeNode;
                        break;
                    }
                }
            }
        }
    }
	
	public boolean lookup(int value) {
        TreeNode current = this.root;
        while (current != null) {
            if (current.value > value) {
                current = current.left;
            } else if (current.value < value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }
	
	public void remove(int value) {
        if (this.root == null) {
            return;
        }
        TreeNode current = this.root;
        TreeNode parentTreeNode = null;

        while (current != null) {
            if (value < current.value) {
                parentTreeNode = current;
                current = current.left;
            } else if (value > current.value) {
                parentTreeNode = current;
                current = current.right;
            }
            else {
                if (current.right == null) {
                    if (parentTreeNode == null) {
                        this.root = current.left;
                    } else {
                        if (current.value < parentTreeNode.value) {
                            parentTreeNode.left = current.left;
                        }
                        else if (current.value > parentTreeNode.value) {
                            parentTreeNode.right = current.left;
                        }
                    }
                }
                else if (current.right.left == null) {
                    if (parentTreeNode == null) {
                        this.root = current.right;
                    } else {
                        if (current.value < parentTreeNode.value) {
                            parentTreeNode.left = current.right;
                        }
                        else if (current.value > parentTreeNode.value) {
                            parentTreeNode.right = current.right;
                        }
                    }
                }
                else {
                    if (parentTreeNode == null) {
                        TreeNode leftTreeNode = this.root.left;
                        TreeNode rightTreeNode = this.root.right;
                        this.root = current.right.left;
                        rightTreeNode.left = rightTreeNode.left.right;
                        this.root.left = leftTreeNode;
                        this.root.right = rightTreeNode;
                    } else {
                        if (current.value < parentTreeNode.value) {
                            parentTreeNode.left = current.right.left;
                        } else if (current.value > parentTreeNode.value) {
                            parentTreeNode.right = current.right.left;
                        }
                    }
                }
                return;
            }
        }
    }
	
	public ArrayList<Integer> breadthFirstSearch() {
        TreeNode currentTreeNode = this.root;
        ArrayList<Integer> resultArray = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(currentTreeNode);

        while (queue.size() > 0) {
            currentTreeNode = queue.remove(0);
            resultArray.add(currentTreeNode.value);

            if (currentTreeNode.left != null) {
                queue.add(currentTreeNode.left);
            }
            if (currentTreeNode.right != null) {
                queue.add(currentTreeNode.right);
            }
        }
        return resultArray;
    }
	
	public ArrayList<Integer> breadthFirstSearchRecursive(ArrayList<TreeNode> queue, ArrayList<Integer> resultArray){
        if (queue.size() == 0) {
            return resultArray;
        }

        TreeNode currentTreeNode = queue.remove(0);
        resultArray.add(currentTreeNode.value);
        if (currentTreeNode.left != null) {
            queue.add(currentTreeNode.left);
        }
        if (currentTreeNode.right != null) {
            queue.add(currentTreeNode.right);
        }

        return breadthFirstSearchRecursive(queue, resultArray);
    }
	
	public ArrayList<Integer> traverseInOrder(TreeNode node, ArrayList<Integer> array) {
        if (node.left != null) {
            traverseInOrder(node.left, array);
        }
        array.add(node.value);
        if (node.right != null) {
            traverseInOrder(node.right, array);
        }
        return array;
    }

    public ArrayList<Integer> traversePreOrder(TreeNode node, ArrayList<Integer> array) {
        array.add(node.value);
        if (node.left != null) {
            traversePreOrder(node.left, array);
        }
        if (node.right != null) {
            traversePreOrder(node.right, array);
        }
        return array;
    }

    public ArrayList<Integer> traversePostOrder(TreeNode node, ArrayList<Integer> array) {
        if (node.left != null) {
            traversePostOrder(node.left, array);
        }
        if (node.right != null) {
            traversePostOrder(node.right, array);
        }
        array.add(node.value);
        return array;
    }
	
	public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        System.out.println("bfs: " + bst.breadthFirstSearch());
        System.out.println("look for 20: " + bst.lookup(20));

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(bst.root);
        System.out.println("bfs recursive: " + bst.breadthFirstSearchRecursive(queue, new ArrayList<>()));

        System.out.println("dfs inOrder: " + bst.traverseInOrder(bst.root, new ArrayList<>()));
        System.out.println("dfs preOrder: " + bst.traversePreOrder(bst.root, new ArrayList<>()));
        System.out.println("dfs postOrder: " + bst.traversePostOrder(bst.root, new ArrayList<>()));

        bst.remove(20);
        System.out.println("look for 20 after removing 20: " + bst.lookup(20));
    }
}