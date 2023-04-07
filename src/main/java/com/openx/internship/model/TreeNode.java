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
}
