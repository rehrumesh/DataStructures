/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author Rumesh
 */
public class BTNode {

    protected int element;
    protected BTNode left;
    protected BTNode right;

    public BTNode(int element) {
        this.element = element;
    }

    public BTNode() {
        this.element = 0;
    }

    public static BTNode add(int i, BTNode root) {
        if (root == null) {
            return new BTNode(i);
        } else if (i < root.element) {
            root.left = add(i, root.left);
            return root;
        } else {
            root.right = add(i, root.right);
            return root;
        }

    }

    public static void printPre(BTNode root) {

        System.out.println(root.element);

        if (root.left != null) {
            printPre(root.left);
        }

        if (root.right != null) {
            printPre(root.right);
        }
    }

    public static boolean search(int i, BTNode root) {
        if (root.element == i) {
            return true;
        } else {
            boolean temp = false;
            if (i < root.element) {
                if (root.left != null) {
                    return false || search(i, root.left);
                } else {
                    temp = false;
                    return temp;
                }
            }

            if (i >= root.element) {
                if (root.right != null) {
                    return false || search(i, root.right);
                } else {
                    return false;
                }
            }
            return temp;

        }
    }

    public static int getSize(BTNode r) {
        if (r == null) {
            return 0;
        } else {
            return 1 + getSize(r.left) + getSize(r.right);
        }
    }

    public static int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

    public static BTNode delete(int i, BTNode r) {
        if (r == null) {
            System.out.println("Value not found;");
            return null;
        } else if (i < r.element) {
            r.left = delete(i, r.left);
            return r;
        } else if (i > r.element) {
            r.right = delete(i, r.right);
            return r;
        } else {
            if (r.left == null && r.right == null) {
                return null;
            } else if (r.left != null && r.right == null) {
                return r.left;
            } else if (r.left == null && r.right != null) {
                return r.right;
            } else {
                BTNode tmp = getLeftMostFromRight(r.right);
                if (tmp != r.right) {
                    tmp.right = r.right;
                }
                tmp.left = r.left;
                return tmp;
            }
        }
    }

    private static BTNode getLeftMostFromRight(BTNode r) {
        if (r.left == null) {
            return r;
        } else {
            BTNode tmp = getLeftMostFromRight(r.left);
            if (tmp == r.left) {
                r.left = tmp.right;
            }
            return r;
        }
    }
}

class Test {

    public static void main(String[] args) {
        BTNode r = new BTNode(5);

        r = BTNode.add(3, r);
        r = BTNode.add(9, r);
        r = BTNode.add(1, r);
        r = BTNode.add(6, r);
        r = BTNode.add(7, r);
        BTNode.printPre(r);

        System.out.println("There is 5" + BTNode.search(5, r));
        System.out.println("There is 1" + BTNode.search(7, r));

        System.out.println("Size : " + BTNode.getSize(r));
        System.out.println("Height is " + BTNode.getHeight(r));


    }
}
