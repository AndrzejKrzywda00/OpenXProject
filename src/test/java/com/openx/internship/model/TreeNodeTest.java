package com.openx.internship.model;

import com.openx.internship.mapper.TreeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("supplyWithNonEqualTrees")
    void testEquals_forTheTree_shouldNotBeEqual(String file1, String file2) throws IOException {
        TreeNode head1 = TreeMapper.jsonToTree(path + file1).head();
        TreeNode head2 = TreeMapper.jsonToTree(path + file2).head();
        assertNotEquals(head1, head2);
    }

    private static Stream<Arguments> supplyWithNonEqualTrees() {
        return Stream.of(
          Arguments.of("simple_tree.json", "null_tree.json"),
          Arguments.of("adv_tree.json", "simple_tree.json"),
          Arguments.of("single_node.json", "adv_tree.json"),
          Arguments.of("null_tree.json", "single_node.json")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "adv_tree.json",
            "example_tree.json",
            "simple_tree.json",
            "single_node.json"})
    void testHashCode_forTheTree_shouldBeEqual(String file) throws IOException {
        TreeNode head1 = TreeMapper.jsonToTree(path + file).head();
        TreeNode head2 = TreeMapper.jsonToTree(path + file).head();
        assertEquals(head1.hashCode(), head2.hashCode());
    }
}
