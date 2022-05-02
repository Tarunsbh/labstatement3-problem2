package com.greatlearning;

import java.util.HashSet;

public class BalancingTree {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static boolean traversel(Node node, int sum, HashSet<Integer> set) {
		if (node == null) {
			return false;
		}
		if (traversel(node.left, sum, set)) {
			return true;
		}
		if (set.contains(sum - node.data)) {
			System.out.println("Sum = " + sum);
			System.out.println("Pair exists (" + (sum - node.data) + "," + node.data + ")");
			return true;
		} else {
			set.add(node.data);
			if (traversel(node.right, sum, set)) {
				return true;
			}
			return false;
		}
	}

	public static void main(String args[]) {
		HashSet<Integer> iteration = new HashSet<Integer>();
		int sum = 130;
		Node root = new Node(40);
		Node first = new Node(20);
		Node second = new Node(10);
		Node third = new Node(30);
		Node fourth = new Node(50);
		Node fifth = new Node(60);
		Node sixth = new Node(70);
		root.left = first;
		root.left.left = second;
		root.left.right = third;
		root.right = fifth;
		root.right.left = fourth;
		root.right.right = sixth;
		
		boolean binarySearch = traversel(root, sum, iteration);
		if (binarySearch == false) {
			System.out.println("Pair does not exists");
		}
	}

}
