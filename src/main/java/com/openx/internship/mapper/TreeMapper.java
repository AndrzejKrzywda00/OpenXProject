package com.openx.internship.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.internship.model.MyTree;
import com.openx.internship.model.TreeNode;

import java.io.File;
import java.io.IOException;

/***
 * Maps json representation of the tree structure to MyTree class instance.
 */
public class TreeMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static MyTree jsonToTree(String path) throws IOException {
        TreeNode head = mapper.readValue(new File(path), TreeNode.class);
        return new MyTree(head);
    }
}
