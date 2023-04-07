package com.openx.internship.model;

/***
 * Represents a binary tree
 */
public record MyTree(TreeNode head) {

    /***
     * Calculates number of leaves in the tree
     */
    public int getNumberOfLeaves() {
        return numberOfLeaves(head);
    }

    private int numberOfLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.getLeftChild() == null && node.getRightChild() == null) return 1;
        return numberOfLeaves(node.getLeftChild()) + numberOfLeaves(node.getRightChild());
    }

    /***
     * Calculates the longest path from the head to a leaf.
     */
    public int getLongestPathFromHeadToALeaf() {
        return longestPathFromHeadToALeaf(head);
    }

    private int longestPathFromHeadToALeaf(TreeNode node) {
        if (node == null) return 0;
        if (node.getLeftChild() == null && node.getRightChild() == null) return 0;
        return Math.max(longestPathFromHeadToALeaf(node.getRightChild()), longestPathFromHeadToALeaf(node.getLeftChild())) + 1;
    }

    /***
     * Custom implementation of equals method for MyTree class.
     * Two trees are equal if all nodes have the same values and are assigned in the same order.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof MyTree && isEqualToTree((MyTree) o, this);
    }

    private boolean isEqualToTree(MyTree t1, MyTree t2) {
        if (t1 == t2) return true;
        return checkEquality(t1.head(), t2.head());
    }

    private boolean checkEquality(TreeNode n1, TreeNode n2) {
        if (n1 == n2) return true;
        return n1.getValue() == n2.getValue()
                && checkEquality(n1.getLeftChild(), n2.getLeftChild())
                && checkEquality(n1.getRightChild(), n2.getRightChild());
    }
}
