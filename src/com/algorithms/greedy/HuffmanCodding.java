package com.algorithms.greedy;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

import java.util.*;

public class HuffmanCodding {

    /**
     * OBJECTIVE
     * <p>
     * We are given set of items. Each item contains A[i] elements(assume that they are length of array)
     * Find minimal amount of action is required to merge items with each other
     */

    public static void main(String[] args) {
        if (true) {
            HuffmanCodding s = new HuffmanCodding();
            String str = "BCCABBDDAECCBBAEDDCC";
            EncodeResult encodeResult = s.encode(str);

            String encodedStr = encodeResult.encoded;
            TreeNode encodeTree = encodeResult.tree;
            System.out.println("Encoded str = " + encodedStr);


            String decoded = s.decode(encodedStr, encodeTree);
            System.out.println("Decoded str = " + decoded);

            System.out.println("Is correct = " + str.equals(decoded));
        }

        if (true) {
            HuffmanCodding s = new HuffmanCodding();
            String str = "Working with Huffman method is fun";
            EncodeResult encodeResult = s.encode(str);

            String encodedStr = encodeResult.encoded;
            TreeNode encodeTree = encodeResult.tree;
            System.out.println("Encoded str = " + encodedStr);


            String decoded = s.decode(encodedStr, encodeTree);
            System.out.println("Decoded str = " + decoded);

            System.out.println("Is correct = " + str.equals(decoded));
        }
    }

    //Main method to decode String using Huffman method
    private EncodeResult encode(String str) {
        TreeNode tree = buildTree(str);
        Map<Character, String> bits = getBits(tree, new HashMap<>(), new StringBuilder());

        StringBuilder encoded = new StringBuilder();
        for (char c : str.toCharArray()) {
            encoded.append(bits.get(c));
        }

        return new EncodeResult(encoded.toString(), tree);
    }

    //Main method to encode String using Huffman method
    private String decode(String encoded, TreeNode tree) {
        StringBuilder builder = new StringBuilder();
        TreeNode original = tree;

        for (char c : encoded.toCharArray()) {
            if (c == '0') tree = tree.left;
            else tree = tree.right;

            if (tree.left == null && tree.right == null) {
                builder.append(tree.charVal);
                tree = original;
            }
        }

        return builder.toString();
    }

    private TreeNode buildTree(String str) {
        //count character frequencies
        int[] frequencies = new int[122];
        for (char c : str.toCharArray()) {
            try {
                frequencies[c]++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //sort by frequencies each pair
        Queue<TreeNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                minHeap.add(new TreeNode(frequencies[i], (char) (i), null, null));
            }
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();

        while (!minHeap.isEmpty()) {
            TreeNode left = minHeap.poll();
            TreeNode right = minHeap.peek();

            TreeNode node = treeQueue.peek();
            if (node != null && (right == null || Math.abs(node.val - left.val) <= Math.abs(left.val - right.val))) {
                node = treeQueue.poll();

                TreeNode leftNode = node;
                TreeNode rightNode = left;
                treeQueue.add(new TreeNode(leftNode.val + rightNode.val, leftNode, rightNode));
            } else if (right != null) {
                right = minHeap.poll();
                treeQueue.add(new TreeNode(left.val + right.val, left, right));
            }
        }

        while (treeQueue.size() > 1) {
            TreeNode left = treeQueue.poll();
            TreeNode right = treeQueue.poll();
            TreeNode node = new TreeNode(left.val + right.val, left, right);
            treeQueue.add(node);
        }

        return treeQueue.poll();
    }

    private Map<Character, String> getBits(TreeNode node, Map<Character, String> map, StringBuilder builder) {
        if (node == null) return map;
        if (node.left == null && node.right == null) {
            map.put(node.charVal, builder.toString());
            return map;
        }

        getBits(node.left, map, builder.append("0"));
        builder.setLength(builder.length() - 1);
        getBits(node.right, map, builder.append("1"));
        builder.setLength(builder.length() - 1);

        return map;
    }

    //Objects

    class EncodeResult {
        String encoded;
        TreeNode tree;

        EncodeResult(String encoded, TreeNode tree) {
            this.encoded = encoded;
            this.tree = tree;
        }
    }

    class TreeNode {
        int val;
        char charVal;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int val, char charVal, TreeNode left, TreeNode right) {
            this.val = val;
            this.charVal = charVal;
            this.left = left;
            this.right = right;
        }
    }

}
