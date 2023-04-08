package com.openx.internship.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class TreeNode {
    @Getter
    private int value;

    @Getter
    @Setter
    private TreeNode rightChild;

    @Getter
    @Setter
    private TreeNode leftChild;

    public TreeNode(int value) {
        this.value = value;
    }

    /***
     * Determines equality between two TreeNode objects
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof TreeNode)) return false;
        return areTreesEqual(this, (TreeNode) o);
    }

    private boolean areTreesEqual(TreeNode t1, TreeNode t2) {
        if (t1 == t2) return true;
        return t1.getValue() == t2.getValue()
                && areTreesEqual(t1.leftChild, t2.leftChild)
                && areTreesEqual(t1.rightChild, t2.leftChild);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + value;
        result = 31 * result + (leftChild == null ? 0 : leftChild.hashCode());
        result = 31 * result + (rightChild == null ? 0 : rightChild.hashCode());
        return result;
    }
}
