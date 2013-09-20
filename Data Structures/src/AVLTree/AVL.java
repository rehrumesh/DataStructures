/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLTree;

/**
 *
 * @author Rumesh
 */
class AVLNode {

    protected int element;
    protected AVLNode left;
    protected AVLNode right;

    public AVLNode() {
        this.element = 5;
    }

    public AVLNode(int element) {
        this.element = element;
    }

    public static AVLNode add(int i, AVLNode root) {
        if (root == null) {
            return new AVLNode(i);
        } else if (i < root.element) {
            root.left = add(i, root.left);
            return root;
        } else {
            root.right = add(i, root.right);
            return root;
        }

    }

    public static void printPre(AVLNode root) {

        System.out.println(root.element);

        if (root.left != null) {
            printPre(root.left);
        }

        if (root.right != null) {
            printPre(root.right);
        }
    }

    public static boolean search(int i, AVLNode root) {
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

    public static int getSize(AVLNode r) {
        if (r == null) {
            return 0;
        } else {
            return 1 + getSize(r.left) + getSize(r.right);
        }
    }

    public static int getHeight(AVLNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

    public static AVLNode delete(int i, AVLNode r) {
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
                AVLNode tmp = getLeftMostFromRight(r.right);
                if (tmp != r.right) {
                    tmp.right = r.right;
                }
                tmp.left = r.left;
                return tmp;
            }
        }
    }

    private static AVLNode getLeftMostFromRight(AVLNode r) {
        if (r.left == null) {
            return r;
        } else {
            AVLNode tmp = getLeftMostFromRight(r.left);
            if (tmp == r.left) {
                r.left = tmp.right;
            }
            return r;
        }
    }

    public void insert(int i, AVLNode r) {
        boolean tmp = AVLNode.search(i, this);
        if (!tmp) {
            r = (AVLNode) AVLNode.add(i, r);
        } else {
            System.out.println("Duplicate value : " + i);
        }

        if (!isBalanced(r)) {
        }
    }

    public int getBFactor(AVLNode r) {
        int hleft = getHeight(r.left);
        int hright = getHeight(r.right);

        return hleft - hright;
    }

    public static boolean isBalanced(AVLNode r) {
        int bf = r.getBFactor(r);
        if (bf < -1 || bf > 1) {
            return false;
        } else {
            return true;
        }
    }

    public AVLNode singleClockWise(AVLNode r) {
        /*
         *
         *
         *
         */
        AVLNode tmp = (AVLNode) r.left;
        AVLNode tmpright = (AVLNode) tmp.right;
        tmp.right = r;
        r.left = tmpright;
        return tmp;
    }

    public AVLNode singleAntiClock(AVLNode r) {
        /*
         *
         *
         *
         */
        AVLNode tmp = (AVLNode) r.right;
        AVLNode tmpleft = (AVLNode) tmp.left;
        tmp.left = r;
        r.right = tmpleft;
        return tmp;
    }

    public AVLNode doubleClockWise(AVLNode r) {
        AVLNode rLeft = (AVLNode) r.left;
        AVLNode rLeftRight = (AVLNode) rLeft.right;

        rLeft.right = rLeftRight.left;
        r.left = rLeftRight.right;

        rLeftRight.left = rLeft;
        rLeftRight.right = r;

        return rLeftRight;
    }

    public AVLNode doubleAntiClock(AVLNode r) {
        AVLNode rRight = (AVLNode) r.right;
        AVLNode rRightLeft = (AVLNode) rRight.right;

        r.right = rRightLeft.left;
        rRight.left = rRightLeft.right;

        rRightLeft.left = r;
        rRightLeft.right = rRight;

        return rRightLeft;
    }

    public static AVLNode getUnbalanceNode(AVLNode r) {
        if (!isBalanced(r)) {
            int i = r.getBFactor(r);
            if (i > 1) {
                if (isBalanced(r.left)) {
                    return r;
                }
                return getUnbalanceNode(r.left);
            } else {
                if (isBalanced(r.right)) {
                    return r;
                }
                return getUnbalanceNode(r.right);
            }
        } else {
            return null;
        }
    }

    public int getBalanceType(AVLNode r) {
        if (r == null) {
            return -1;
        } else if (r != null && r.left != null && r.left.left != null) {
            return 1;//single clock wise
        } else if (r != null && r.right != null && r.right.right != null) {
            return 2; // single anti clock    
        } else if (r != null && r.left != null && r.left.right != null) {
            return 3; // double clock wise
        } else if (r != null && r.right != null && r.right.left != null) {
            return 4; // double anti clock
        } else {
            return 0;
    
        }
    }
//    
//    public static AVLNode makeBalance(AVLNode r){
//        if(!isBalanced(r)){
//        
//        }else{
//            return r;
//        }
//    
//    }
}

class Test {

    public static void main(String[] args) {
        AVLNode r = new AVLNode(5);
        r.insert(3, r);
        r.insert(4, r);


        System.out.println("Balanced tree : " + r.isBalanced(r));
        r = r.doubleClockWise(r);
        System.out.println("Balanced tree : " + r.isBalanced(r));
        r.printPre(r);
    }
}
