package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepths {
	public static void main(String args[]) {
		int nums[] = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		TreeNode<Integer> root = ArrayToBinaryTree.toTree(nums);
		ListOfDepths d = new ListOfDepths();
		ArrayList<TreeNode<Integer>> heads = d.toDLists(root);
		for(TreeNode<Integer> node: heads) {
			d.printList(node);
		}
	}
	public class Result{
		TreeNode<Integer> head;
		TreeNode<Integer> tail;
		Result(){
			head =null;
			tail = null;
		}
	}
	public void printList(TreeNode<Integer> head) {
		while(head != null) {
			System.out.print(head.data);
			head = head.right;
		}
		System.out.println();
		System.out.println("---------------------");
	}
	public ArrayList<TreeNode<Integer>> toDLists(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		TreeNode<Integer> nullNode = new TreeNode<Integer>(-1);
		queue.add(root);
		queue.add(nullNode);
		ArrayList<TreeNode<Integer>> heads = new ArrayList<TreeNode<Integer>>();
		Result res = new Result();
		while(queue.size() != 1) {
			TreeNode<Integer> node = queue.remove();
			if(node == nullNode) {
				queue.add(node);
				heads.add(res.head);
				res = new Result();
			}else {
				TreeNode<Integer> leftNode = node.left;
				TreeNode<Integer> rightNode = node.right;
				if(leftNode != null) {
					queue.add(leftNode);
				}
				if(rightNode != null) {
					queue.add(rightNode);
				}
				addToQueue(res,node);
 			}
		}
		heads.add(res.head);
		return heads;
	}
	
	public void addToQueue(Result res, TreeNode<Integer> node) {
		node.left = null;
		node.right = null;
		if(res.head == null) {
			res.head = node;
			res.tail = res.head;
			return;
		}
		res.tail.right = node;
		node.left = res.tail;
		res.tail = res.tail.right;
	}
	 
	
}
