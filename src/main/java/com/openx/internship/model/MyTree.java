package com.openx.internship.model;

import java.util.Objects;

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
        if (o == this) return true;
        if (!(o instanceof MyTree)) return false;
        return Objects.equals(((MyTree) o).head, this.head);
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 31 * result + (head == null ? 0 : head.hashCode());
        return result;
    }
}
