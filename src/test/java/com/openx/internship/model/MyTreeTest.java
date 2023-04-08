package com.openx.internship.model;

import com.openx.internship.mapper.TreeMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MyTreeTest {
    private final static String path = "src/test/resources/";

    // --- NUMBER OF LEAVES TESTS ---
    @Test
    void testGetNumberOfLeaves_WhenEmpty_ShouldBeZero() throws IOException {
        MyTree tree = TreeMapper.jsonToTree(path + "null_tree.json");
        int expectedNumberOfLeaves = 0;
        assertEquals(expectedNumberOfLeaves, tree.getNumberOfLeaves());
    }

    @Test
    void testGetNumberOfLeaves_WhenHeadOnly_shouldBeOne() throws IOException {
        MyTree tree = TreeMapper.jsonToTree(path + "single_node.json");
        int expectedNumberOfLeaves = 1;
        assertEquals(expectedNumberOfLeaves, tree.getNumberOfLeaves());
    }

    @Test
    void testGetNumberOfLeaves_WhenBiggerStructure_shouldBeOne() throws IOException {
        MyTree tree = TreeMapper.jsonToTree(path + "adv_tree.json");
        int expectedNumberOfLeaves = 1;
        assertEquals(expectedNumberOfLeaves, tree.getNumberOfLeaves());
    }

    @Test
    void testGetNumberOfLeaves_WhenExampleStructure_shouldBeFive() throws IOException {
        MyTree tree = TreeMapper.jsonToTree(path + "example_tree.json");
        int expectedNumberOfLeaves = 5;
        assertEquals(expectedNumberOfLeaves, tree.getNumberOfLeaves());
    }

    // --- LONGEST PATH FROM HEAD TO A LEAF TESTS ---
    @Test
    void testGetLongestPathFromTheHeadToALeaf_whenEmpty_shouldBeZero() throws IOException {
        MyTree tree = TreeMapper.jsonToTree(path + "null_tree.json");
        int expectedPathLength = 0;
        assertEquals(expectedPathLength, tree.getLongestPathFromHeadToALeaf());
    }

    @Test
    void testGetLongestPathFromHeadToALeaf_whenSimpleTree_shouldBeOne() throws IOException {
        MyTree tree = TreeMapper.jsonToTree(path + "simple_tree.json");
        int expectedPathLength = 1;
        assertEquals(expectedPathLength, tree.getLongestPathFromHeadToALeaf());
    }

    @Test
    void testGetLongestPathFromHeadToALeaf_whenExampleTree_shouldBeFour() throws IOException {
        MyTree tree = TreeMapper.jsonToTree(path + "example_tree.json");
        int expectedPathLength = 4;
        assertEquals(expectedPathLength, tree.getLongestPathFromHeadToALeaf());
    }

    @Test
    void testEquals_whenEmptyTree_shouldBeTrue() throws IOException {
        MyTree t1 = new MyTree(null);
        MyTree t2 = TreeMapper.jsonToTree(path + "null_tree.json");
        assertEquals(t1, t2);
    }

    @Test
    void testEquals_whenExampleTree_shouldBeTrue() throws IOException {
        MyTree t1 = TreeMapper.jsonToTree(path + "example_tree.json");
        MyTree t2 = TreeMapper.jsonToTree(path + "example_tree.json");
        assertEquals(t1, t2);
    }

    @Test
    void testEquals_whenSimpleTree_shouldBeTrue() throws IOException {
        MyTree t1 = TreeMapper.jsonToTree(path + "simple_tree.json");
        TreeNode head = new TreeNode(1);
        head.setRightChild(new TreeNode(3));
        head.setLeftChild(new TreeNode(2));
        MyTree t2 = new MyTree(head);
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
        assertEquals(t1, t2);
    }

    @Test
    void testEquals_whenSimpleTree_shouldBeFalse() throws IOException {
        MyTree t1 = TreeMapper.jsonToTree(path + "simple_tree.json");
        MyTree t2 = TreeMapper.jsonToTree(path + "single_node.json");
        assertNotEquals(t1, t2);
    }
}
