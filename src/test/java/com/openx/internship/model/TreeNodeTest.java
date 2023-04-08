package com.openx.internship.model;

import com.openx.internship.mapper.TreeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TreeNodeTest {
    private final static String path = "src/test/resources/";

    @Test
    void testEquals_whenNullTree_shouldBeNotEqual() {
        TreeNode head = new TreeNode(0);
        assertNotEquals(head, null);
    }

    @Test
    void testEquals_whenSingleNode_shouldBeEqual() {
        TreeNode head1 = new TreeNode(0);
        TreeNode head2 = new TreeNode(0);
        assertEquals(head1, head2);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "adv_tree.json",
            "example_tree.json",
            "null_tree.json",
            "simple_tree.json",
            "single_node.json"})
    void testEquals_forTheTree_shouldBeEqual(String file) throws IOException {
        TreeNode head1 = TreeMapper.jsonToTree(path + file).head();
        TreeNode head2 = TreeMapper.jsonToTree(path + file).head();
        assertEquals(head1, head2);
    }
}
